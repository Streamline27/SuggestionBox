/**
 * Created by Vladislav on 12/14/2015.
 */
var app = angular.module('SuggestionBox', ['ngRoute', 'ngCookies', 'ngAnimate']);

//http://geekindulgence.com/environment-variables-in-angularjs-and-ionic/
app.constant('ENDPOINT_URL', 'https://suggest-box.herokuapp.com/api/');

app.config(function($routeProvider){
    $routeProvider
        .when('/', {
            controller: 'HomeController',
            templateUrl: 'views/home.html'
        })
        .when('/suggestion/:Id', {
            controller: 'SuggestionController',
            templateUrl: 'views/suggestion.html'
        })
        .when('/login',{
            controller: 'LoginController',
            templateUrl: 'views/login.html'
        })
        .when('/register',{
            controller: 'RegisterController',
            templateUrl: 'views/register.html'
        })
        .when('/settings',{
            //controller: 'RegisterController',
            templateUrl: 'views/settings.html'
        })
        .otherwise({
            redirectTo: '/'
        });
});
app.run(['AuthenticationService', '$rootScope', function(AuthenticationService, $rootScope) {
    // keep user logged in after page refresh
    AuthenticationService.AuthentifyFromCookies();

    // Set transitions according to routes (http://jsfiddle.net/robro/Xck5Z/)
    $rootScope.transitionClass="slide-left";
    $rootScope.$on("$locationChangeSuccess", function (event, next, current){
        function getRelativeRoute(url){
            return url.slice( next.lastIndexOf('#')+1, next.length );
        }

        var route = getRelativeRoute(next);
        if(route == "/")  $rootScope.transitionClass = "slide-right";
        else              $rootScope.transitionClass="slide-left";
    });
}]);

