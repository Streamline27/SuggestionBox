/**
 * Created by Vladislav on 2/6/2016.
 */
app.controller('LoginController',
    ['$location', 'AuthenticationService', '$scope',
        function($location, AuthenticationService, $scope){

    $scope.needWarning = false;

    (function initController() {
        // reset login status
        AuthenticationService.Logout();
    })();

    $scope.login = function login() {
        $scope.dataLoading = true;

        AuthenticationService.Login($scope.username, $scope.password, function(authSucceeded){
            if (authSucceeded){
                $location.path('/');
            }
            else{
                $scope.dataLoading = false;
                $scope.needWarning = true;
            }
        });
    }
            
}]);