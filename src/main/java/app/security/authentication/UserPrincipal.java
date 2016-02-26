package app.security.authentication;

import app.dto.UserInfoDTO;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by Vladislav on 2/25/2016.
 */
public class UserPrincipal extends org.springframework.security.core.userdetails.User {
    private UserInfoDTO userInfo;

    public UserPrincipal(String username,
                         String password,
                         Collection<? extends GrantedAuthority> authorities,
                         UserInfoDTO userInfo) {
        super(username, password, authorities);
        this.userInfo = userInfo;
    }

    public UserPrincipal(String username,
                         String password,
                         boolean enabled,
                         boolean accountNonExpired,
                         boolean credentialsNonExpired,
                         boolean accountNonLocked,
                         Collection<? extends GrantedAuthority> authorities,
                         UserInfoDTO userInfo) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userInfo = userInfo;
    }

    public UserInfoDTO getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoDTO userInfo) {
        this.userInfo = userInfo;
    }
}

