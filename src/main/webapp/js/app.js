/**
 * Created by Vladislav on 12/14/2015.
 */
var app = angular.module('SuggestionBox', ['ngRoute']);

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
        .otherwise({
            redirectTo: '/'
        });

});