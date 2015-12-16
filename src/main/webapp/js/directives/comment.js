/**
 * Created by Vladislav on 12/14/2015.
 */


app.directive('comment', function(){
    return{
        restrict: 'E',
        scope:{
            info: '='
        },
        templateUrl: 'js/directives/comment.html'
    }
});