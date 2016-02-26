/**
 * Created by Vladislav on 2/8/2016.
 */
app.service('UserModel', ['$http', 'ENDPOINT_URL', function($http, ENDPOINT_URL){
    var path = "user/register";

    /* Private helper methods */
    function getUrl(){
        return ENDPOINT_URL+path;
    }


    /* Public interface methods */
    this.create = function (user) {
        return $http.post(getUrl(), user);
    };



}]);