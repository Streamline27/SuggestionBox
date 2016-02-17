/**
 * Created by Vladislav on 12/14/2015.
 */
app.controller('HomeController', ['$scope', 'SuggestionModel', 'AuthenticationService', '$location',
    function($scope,  SuggestionModel, AuthenticationService, $location){

    /* Initializing variables */
    getSuggestions();
    $scope.isLoggedIn = AuthenticationService.IsUserAuthenticated();

    /* Setting View behavior */
    $scope.addSuggestion = function(){
        if(isSuggestionTitleEmpty()) return;

        var suggestion = getNewSuggestion();
        $scope.title = "";
        SuggestionModel.create(suggestion).success(function(data){
            $scope.suggestions.push(data);
        });

        /* Private helper functions */
        function isSuggestionTitleEmpty(){
            return (!$scope.title || $scope.title === "");
        }
        function getNewSuggestion(){
            return {
                title: $scope.title,
                upvotes: 0,
                id: null
            };
        }
    };

    $scope.upVote = function(post){
        if (!$scope.isLoggedIn){
            $location.path('/login');
            return;
        }
        post.upvotes++;
        SuggestionModel.update(post);
    };

    /* Private helper functions */
    function getSuggestions(){
        SuggestionModel.getAll().success(function(data){
            $scope.suggestions = data;
        });
    }

}]);