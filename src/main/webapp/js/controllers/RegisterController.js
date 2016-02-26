/**
 * Created by Vladislav on 2/6/2016.
 */
app.controller('RegisterController', ['$scope', 'UserModel', '$location', function($scope, UserModel, $location){
    $scope.user = {};
    $scope.needWarning = false;

    $scope.register = function(){
        $scope.dataLoading = true;
        UserModel.create($scope.user).success(function(data){
            $location.path('/login');
        }).error(function(){
            $scope.needWarning = true;
            $scope.dataLoading = false;
        });
    }
}]);