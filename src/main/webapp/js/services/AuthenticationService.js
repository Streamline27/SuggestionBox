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

    return service;

    function Login(username, pass) {
        user ={
            login: username,
            password: pass
        };

        /* Use this for real authentication
         ----------------------------------------------*/
        return $http.post(ENDPOINT_URL+'login/', user);
            //.success(function (response) {
            //    alert(response)
            //    callback(response);
            //});


    }

    function SetCredentials(user) {

        $rootScope.globals = {
            currentUser: user
        };

        //$http.defaults.headers.common['Authorization'] = 'Basic ' + authdata; // jshint ignore:line
        $cookieStore.put('globals', $rootScope.globals);
    }

    function ClearCredentials() {
        $rootScope.globals = {};
        $cookieStore.remove('globals');
        //$http.defaults.headers.common.Authorization = 'Basic';
    }
}
