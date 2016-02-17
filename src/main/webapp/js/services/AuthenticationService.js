/**
 * Created by Vladislav on 2/16/2016.
 */
app.factory('AuthenticationService', AuthenticationService);

function AuthenticationService($http, $cookieStore, ENDPOINT_URL, $rootScope, UserModel) {
AuthenticationService.$inject = ['$http', '$cookieStore', 'ENDPOINT_URL', '$rootScope', 'UserModel'];
    var service = {};

    service.Login = Login;
    service.SetCredentials = SetCredentials;
    service.ClearCredentials = ClearCredentials;
    service.IsUserAuthenticated = IsUserAuthenticated;
    service.OnAuthenticationStatusChanged = OnAuthenticationStatusChanged;
    service.GetUserCredentials = GetUserCredentials;

    return service;

    function Login(username, pass) {
        user ={
            login: username,
            password: pass
        };

        return $http.post(ENDPOINT_URL+'login/', user);
    }

    function SetCredentials(user) {
        $rootScope.globals = {};
        $rootScope.globals.currentUser = user;
        $cookieStore.put('globals', $rootScope.globals);
    }

    function ClearCredentials() {
        $rootScope.globals = {};
        $cookieStore.remove('globals');
    }

    function IsUserAuthenticated(){
        if ($rootScope.hasOwnProperty('globals')){
            return ($rootScope.globals.currentUser!=null);
        }
        else return false;
    }

    function OnAuthenticationStatusChanged(callback){
        $rootScope.$watch('globals', callback);
    }

    function GetUserCredentials(){
        return $rootScope.globals.currentUser;
    }
}
