/**
 * Created by Vladislav on 12/14/2015.
 */
app.controller('HomeController', ['$scope', 'suggestions', function($scope, suggestions){
    $scope.helloWorld  = "HelloWorld";
    $scope.suggestions = suggestions;
    $scope.addSuggestion = function(){

        if(!$scope.title || $scope.title === "") return;


        var suggestion = {
          title: $scope.title,
          upvotes: 0,
          id: suggestions.posts.length,
          comments: []
        };

        suggestions.posts.push(suggestion);
        $scope.title = "";
    };

    $scope.upVote = function(post){
        post.upvotes++;
    }
}]);