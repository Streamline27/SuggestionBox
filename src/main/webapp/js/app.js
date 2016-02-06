/**
 * Created by Vladislav on 12/14/2015.
 */
var app = angular.module('SuggestionBox', ['ngRoute']);

app.constant('ENDPOINT_URL', 'http://localhost:8080/api/');

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
        .otherwise({
            redirectTo: '/'
        });

});