'use strict';

/**
 * @ngdoc function
 * @name webappApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webappApp
 */
angular.module('webappApp')
  .controller('MainCtrl', function ($scope,$http) {
//get the information from the server
    $scope.getData = function(){
      console.log("toto");
      $http({
        method: 'GET',
        url: '/department'
      }).then(function successCallback(response) {

        console.log(response.data);
        $scope.depts = response.data;
      }, function errorCallback(response) {
      });

    }
  });
