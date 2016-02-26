package app.security.authentication;

import app.core.database.UserDAO;
import app.core.domain.User;
import app.core.services.converters.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav on 2/25/2016.
 */
@Service("userDetailsService")
public class CustomizedUserDetailService implements UserDetailsService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    UserConverter converter;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDAO.getByLogin(s);

        List<GrantedAuthority> authorities = buildUserAuthority();
        return buildUserForAuthentication(user, authorities);
    }

    private UserPrincipal buildUserForAuthentication(User user,
                                                     List<GrantedAuthority> authorities) {
        return new UserPrincipal(
                user.getLogin(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                authorities,
                converter.toUserInfoDTO(user)
        );
    }

    private List<GrantedAuthority> buildUserAuthority() {
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
        result.add(new SimpleGrantedAuthority("LOGINNED_USER"));
        return result;
    }
}
