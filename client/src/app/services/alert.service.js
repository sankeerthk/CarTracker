(function () {
    'use strict';

    angular.module('carTracker')
        .service('alertService', alertService);

    alertService.$inject = ['$q', '$http', 'CONFIG'];

    function alertService($q, $http, CONFIG) {

        var self = this;

        self.getHighAlerts = getHighAlerts;
        self.getAllAlerts = getAllAlerts;
        self.getAlertsByVin=getAlertsByVin;

        function getHighAlerts() {
            return $http.get(CONFIG.API_HOST + '/allHighAlerts')
                .then(successFn, errorFn);
        }

        function getAllAlerts(){
            return $http.get(CONFIG.API_HOST + '/allAlerts')
                .then(successFn,errorFn);
        }

        function getAlertsByVin(vin) {
            return $http.get(CONFIG.API_HOST + '/alerts/' + vin)
                .then(successFn,errorFn);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(error) {
            return $q.reject(error);
        }
    }
})();