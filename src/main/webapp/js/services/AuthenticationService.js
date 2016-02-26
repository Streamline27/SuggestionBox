/**
 * Created by Vladislav on 2/16/2016.
 */
app.factory('AuthenticationService', AuthenticationService);

function AuthenticationService($http, $cookieStore, ENDPOINT_URL, $rootScope, UserModel, $interval) {
AuthenticationService.$inject = ['$http', '$cookieStore', 'ENDPOINT_URL', '$rootScope', 'UserModel', '$interval'];
    $rootScope.globals = {};
    var service = {};

    service.Login = Login;
    service.IsUserAuthenticated = IsUserAuthenticated;
    service.OnAuthenticationStatusChanged = OnAuthenticationStatusChanged;
    service.AuthentifyFromCookies = AuthentifyFromCookies;
    service.GetUserCredentials = GetUserCredentials;
    service.Logout = Logout;
            //startWatching();

    return service;

    function Login(username, pass, callback) {

        $http({

            method: 'GET',
            url: ENDPOINT_URL+'user',
            headers: getAuthHeader(username, pass)

        }).success(function (data) {
            setCredentials(constructUser(data, pass));
            callback && callback(true); //Pass true if fetching succeeded
        }).error(function(){
            callback && callback(false);//Pass false if fetching failed
        })


    }

    function Logout() {
        $rootScope.globals = {}; // Clear globals
        $cookieStore.remove('globals'); // Clear cookies
        delete $http.defaults.headers.common['Authorization']; //Clear headers
    }

    function IsUserAuthenticated(){
        if ($rootScope.globals.currentUser) return true;
        else return false;
    }

    function OnAuthenticationStatusChanged(callback){
        $rootScope.$watch('globals', callback);
    }

    function GetUserCredentials(){
        return $rootScope.globals.currentUser;
    }


    function AuthentifyFromCookies(){
        cookieGlobals = $cookieStore.get('globals') || {};
        if (cookieGlobals.currentUser) {
            var username = cookieGlobals.currentUser.username;
            var pass = cookieGlobals.currentUser.password;
            Login(username, pass);
        }

        //if ($rootScope.globals.currentUser) {
        //    var pass = getCurrentUserPassword();
        //    var username = getCurrentUserUsername();
        //    setDefaultHttpAuthenticationHeader(username, pass);
        //}
    }

    /* ******* Private helper functions * *******/
    function setCredentials(user) {
        $rootScope.globals = {};
        $rootScope.globals.currentUser = user;
        $cookieStore.put('globals', $rootScope.globals);
        setDefaultHttpAuthenticationHeader(user.username, user.password);
    }

    function constructUser(data, pass) {
        return {
            username: data.login,
            firstName: data.firstName,
            lastName: data.lastName,
            password: pass
        }
    }

    // Headers
    function setDefaultHttpAuthenticationHeader(username, pass){
        $http.defaults.headers.common['Authorization'] = getAuthHeaderString(username, pass);
    }

    function getAuthHeader(username, pass){
        return { authorization : getAuthHeaderString(username, pass)};
    }

    function getAuthHeaderString(username, pass){
        return "Basic "+ btoa(username + ":" + pass);
    }

    // RootScope

    function getCurrentUserPassword(){
        return $rootScope.globals.currentUser.password;
    }

    function getCurrentUserUsername(){
        return $rootScope.globals.currentUser.username;
    }
}
