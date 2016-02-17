/**
 * Created by Vladislav on 12/14/2015.
 */
app.controller('SuggestionController', ['$scope', '$routeParams', 'AuthenticationService','SuggestionModel',
    function($scope, $routeParams, AuthenticationService, SuggestionModel){

    getPost($routeParams.Id);
    $scope.IsLoggedIn = AuthenticationService.IsUserAuthenticated();

    /* Event handlers */
    $scope.addComment = function(){

        if(isCommentTextEmpty()) return;
        /* Creating new comment */
        var comment = {
            text: $scope.commentText,
            author: AuthenticationService.GetUserCredentials().login,
            date: Date.now()
        };
        /* Clearing commentText line */
        $scope.commentText = "";
        /* Putting data to backend */
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
    function isCommentTextEmpty(){
        return (!$scope.commentText || $scope.commentText === "");
    }
}]);