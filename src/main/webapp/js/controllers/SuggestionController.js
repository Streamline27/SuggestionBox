/**
 * Created by Vladislav on 12/14/2015.
 */
app.controller('SuggestionController', ['$scope', '$routeParams', 'suggestions', function($scope, $routeParams, suggestions){

    $scope.post =  suggestions.posts[$routeParams.Id];

    /* Event handlers */
    $scope.addComment = function(){
        if(!$scope.commentText || $scope.commentText === "") {
            return;
        }

        var comment = {
            text: $scope.commentText,
            author: "Anonymus",
            date: Date.now()
        };
        $scope.commentText = "";
        $scope.post.comments.push(comment);
    };

    $scope.upVote = function(post){
        post.upvotes++;
    };


}]);