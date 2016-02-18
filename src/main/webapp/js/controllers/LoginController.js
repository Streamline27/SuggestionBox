/**
 * Created by Vladislav on 2/6/2016.
 */
app.controller('LoginController',
    ['$location', 'AuthenticationService', '$scope',
        function($location, AuthenticationService, $scope){

    $scope.needWarning = false;

    (function initController() {
        // reset login status
        AuthenticationService.ClearCredentials();
    })();

    $scope.login = function login() {
        $scope.dataLoading = true;

        AuthenticationService.Login($scope.username, $scope.password)
        .then(
            function (response) {
                AuthenticationService.SetCredentials(response.data);
                $location.path('/');
            },
            function (response) {
                $scope.dataLoading = false;
                $scope.needWarning = true;
            }
        );
    }
            
}]);