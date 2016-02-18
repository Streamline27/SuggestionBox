/**
 * Created by Vladislav on 2/18/2016.
 */
app.service('UpVoteService', ['AuthenticationService', '$location', 'SuggestionModel',
function(AuthenticationService, $location, SuggestionModel){

    this.upVote = function(post){
        if (!AuthenticationService.IsUserAuthenticated()){
            $location.path('/login');
            return;
        }
        post.upvotes++;
        SuggestionModel.update(post);
    };


}]);