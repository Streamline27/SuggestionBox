/**
 * Created by Vladislav on 2/6/2016.
 */
app.directive('loginBar', ['AuthenticationService', function(AuthenticationService){
    return{
        restrict: 'E',
        scope:{
        },
        templateUrl: 'js/directives/loginBar.html',

        link: function(scope, element, attr){
            IsUserAuthenticated = AuthenticationService.IsUserAuthenticated;
            GetUserCredentials = AuthenticationService.GetUserCredentials;

            scope.loggedIn = IsUserAuthenticated();

            AuthenticationService.OnAuthenticationStatusChanged(function(){
                if(IsUserAuthenticated()){
                    scope.loggedIn = true;
                    scope.user = GetUserCredentials();
                }
                else {
                    scope.loggedIn = false;
                    scope.user = null;
                }
            });

        }
    }
}]);