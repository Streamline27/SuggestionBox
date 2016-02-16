/**
 * Created by Vladislav on 2/6/2016.
 */
app.directive('loginBar', ['$rootScope', function($rootScope){
    return{
        restrict: 'E',
        scope:{
        },
        templateUrl: 'js/directives/loginBar.html',

        link: function(scope, element, attr){
            scope.loggedIn = rootScopeContainsUser();

            $rootScope.$watch('globals', function(){
                if(rootScopeContainsUser()){

                    scope.loggedIn = true;
                    scope.user = $rootScope.globals.currentUser;
                }
                else {
                    scope.loggedIn = false;
                    scope.user = null;
                }
            });

            function  rootScopeContainsUser(){
                if ($rootScope.hasOwnProperty('globals')){
                    if ($rootScope.globals.currentUser!=null) return true;
                    else return false;
                }
                else return false;
            }

        }
    }
}]);