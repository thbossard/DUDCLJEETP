'use strict';

// routage des urls vers les vues
angular.module('opower', ['opower.services', 'opower.directives', 'opower.controllers']).
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/person-list', {templateUrl: 'views/person-list.html', controller: 'personListCtrl'});
        $routeProvider.when('/person-detail/:id', {templateUrl: 'views/person-detail.html', controller: 'personDetailCtrl'});
        $routeProvider.when('/person-creation', {templateUrl: 'views/person-creation.html', controller: 'personCreationCtrl'});
       }]);
