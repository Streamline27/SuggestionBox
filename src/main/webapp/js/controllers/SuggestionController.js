/**
 * Created by Vladislav on 12/14/2015.
 */
app.controller('SuggestionController',
    ['$scope', '$routeParams', 'AuthenticationService','SuggestionModel', 'UpVoteService',
    function($scope, $routeParams, AuthenticationService, SuggestionModel, UpVoteService){

    fetchSuggestionData($routeParams.Id);
    $scope.IsLoggedIn = AuthenticationService.IsUserAuthenticated();

    /* Event handlers */
    $scope.addComment = function(){

        if(isCommentTextEmpty()) return;
        /* Creating new comment */
        var comment = {
            text: $scope.commentText,
            author: AuthenticationService.GetUserCredentials().username,
            date: Date.now()
        };
        /* Clearing commentText line */
        $scope.commentText = "";
        /* Putting data to backend */
        alert(comment.author);
        SuggestionModel.createComment($scope.post.id, comment).success(function(data){
            $scope.comments.push(data);
        });
    }; 

    $scope.upVote = UpVoteService.upVote;

    /* Private helper methods */
    function fetchSuggestionData(suggestionId){
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