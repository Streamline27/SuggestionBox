/**
 * Created by Vladislav on 12/29/2015.
 */
app.service('SuggestionModel', ['$http', 'ENDPOINT_URL', function($http, ENDPOINT_URL){
    var path = "suggestions/";
    var commentPath = "comments/";

    /* Private helper methods */
    function getUrl(){
        return ENDPOINT_URL+path;
    }

    function getCommentUrl(suggestionId){
        return getUrl()+suggestionId+"/"+commentPath;
    }

    this.get = function(suggestionId){
        return $http.get(getUrl()+suggestionId);
    };

    /* Public interface methods */

    /* CRUD for suggestions */
    this.getAll = function () {
        return $http.get(getUrl());
    };


    this.create = function (suggestion) {
        return $http.post(getUrl(), suggestion);
    };

    this.update = function (suggestion) {
        return $http.put(getUrl(), suggestion);
    };


    /* CRUD for comments */
    this.createComment = function(suggestionId, comment){
        return $http.post(getCommentUrl(suggestionId), comment);
    };

    this.getComments = function (suggestionId) {
        return $http.get(getCommentUrl(suggestionId));
    };


}]);