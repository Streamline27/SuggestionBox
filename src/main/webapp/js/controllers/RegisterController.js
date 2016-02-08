/**
 * Created by Vladislav on 2/6/2016.
 */
app.controller('RegisterController', ['$scope', 'UserModel', '$location', function($scope, UserModel, $location){
    $scope.user = {};


    $scope.register = function(){
        $scope.loading = true;
        UserModel.create($scope.user).then(function(response){
            $location.path('/login');
        });
    }
}]);