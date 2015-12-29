/**
 * Created by Vladislav on 12/14/2015.
 */
app.controller('HomeController', ['$scope', 'SuggestionModel', function($scope, SuggestionModel){
    $scope.helloWorld  = "HelloWorld";

    getSuggestions();

    $scope.addSuggestion = function(){
        if(!$scope.title || $scope.title === "") return;

        var suggestion = {
          title: $scope.title,
          upvotes: 0,
          id: null
        };
        $scope.title = "";

        SuggestionModel.create(suggestion).success(function(data){
            $scope.suggestions.push(data);
        });
    };

    $scope.upVote = function(post){
        post.upvotes++;
        SuggestionModel.update(post);
    };

    function getSuggestions(){
        SuggestionModel.getAll().success(function(data){
            $scope.suggestions = data;
        });
    }

}]);