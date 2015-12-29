/**
 * Created by Vladislav on 12/14/2015.
 */
app.controller('SuggestionController', ['$scope', '$routeParams', 'SuggestionModel', function($scope, $routeParams, SuggestionModel){

    getPost($routeParams.Id);

    /* Event handlers */
    $scope.addComment = function(){
        var comment = {
            text: $scope.commentText,
            author: "Anonymus",
            date: Date.now()
        };
        $scope.commentText = "";
        SuggestionModel.createComment($scope.post.id, comment).success(function(data){
            $scope.comments.push(data);
        });
    };

    $scope.upVote = function(post){
        post.upvotes++;
        SuggestionModel.update(post);
    };

    /* Private helper methods */
    function getPost(suggestionId){
        SuggestionModel.get(suggestionId).success(function(data){
            $scope.post = data;
        });
        SuggestionModel.getComments(suggestionId).success(function(data){
            $scope.comments = data;
        });
    }

}]);