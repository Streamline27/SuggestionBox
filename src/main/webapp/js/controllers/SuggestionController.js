/**
 * Created by Vladislav on 12/14/2015.
 */
app.controller('SuggestionController', ['$scope', '$routeParams', 'suggestions', function($scope, $routeParams, suggestions){


    $scope.post = suggestions.posts[$routeParams.Id];

    $scope.addComment = function(){
        var comment = {
            text: $scope.commentText,
            author: "Anonymus",
            date: Date.now()
        };
        $scope.post.comments.push(comment);
    };

    $scope.upVote = function(post){
        post.upvotes++;
    };

}]);