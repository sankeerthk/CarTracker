(function () {
    'use strict';

    angular.module('carTracker')
        .service('carService',carService);

    carService.$inject=['$q','$http','CONFIG'];

    function carService($q,$http,CONFIG) {

        var self=this;

        self.getCars = getCars;

        function getCars() {
            return $http.get(CONFIG.API_HOST + '/vehicles')
                .then(successFn, errorFn);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject("ERROR : "+response.statusText);
        }
    }
})();