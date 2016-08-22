'use strict';

/* Controllers */

var app = angular.module('opower.controllers', []);

app.controller('personListCtrl', ['$scope', 'PersonsFactory', 'PersonFactory', '$location',
    function ($scope, PersonsFactory, PersonFactory, $location) {

        // callback for ng-click 'editPerson':
        $scope.editPerson = function (personId) {
            $location.path('/person-detail/' + personId);
        };

        // callback for ng-click 'deletePerson':
        $scope.deletePerson = function (personId) {
            PersonFactory.delete({ id: personId });
            $scope.Persons = PersonsFactory.query();
        };

        // callback for ng-click 'createPerson':
        $scope.createNewPerson = function () {
            $location.path('/person-creation');
        };

        $scope.Persons = PersonsFactory.query();
    }]);

app.controller('personDetailCtrl', ['$scope', '$routeParams', 'PersonFactory', '$location',
    function ($scope, $routeParams, PersonFactory, $location) {

        // callback for ng-click 'updatePerson':
        $scope.updatePerson = function () {
            PersonFactory.update($scope.Person);
            $location.path('/person-list');
        };

        // callback for ng-click 'cancel':
        $scope.cancel = function () {
            $location.path('/person-list');
        };

        $scope.Person = PersonFactory.show({id: $routeParams.id});
    }]);

app.controller('personCreationCtrl', ['$scope', 'PersonsFactory', '$location',
    function ($scope, PersonsFactory, $location) {

        // callback for ng-click 'createNewPerson':
        $scope.createNewPerson = function () {
            PersonsFactory.create($scope.Person);
            $location.path('/person-list');
        }
    }]);
