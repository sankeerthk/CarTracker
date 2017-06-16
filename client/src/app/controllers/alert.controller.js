(function () {
    'use strict';

    angular.module('carTracker')
        .controller('alertController', alertController);

    alertController.$inject = ['alertService', '$routeParams'];

    function alertController(alertService, $routeParams) {

        var alertVm = this;

        alertVm.changeSort = changeSort;

        init();

        function init() {
            alertVm.sorter = {
                by: 'timestamp',
                reverse: false
            };

            alertService.getHighAlerts().then(function (highAlerts) {
                alertVm.highAlerts = highAlerts;
            }, function (error) {
                console.log(error);
            });

            alertService.getAllAlerts().then(function (allAlerts) {
                alertVm.allAlerts = allAlerts;
            }, function (error) {
                console.log(error);
            });

            alertService.getAlertsByVin($routeParams.vin)
                .then(function (alertsByVin) {
                    alertVm.alertsByVin = alertsByVin;
                }, function (error) {
                    console.log(error)
                });
        }

        function changeSort(prop) {
            alertVm.sorter.by = prop;
            alertVm.sorter.reverse = !alertVm.sorter.reverse;
        }
    }
})();