(function () {
    'use strict';

    angular
        .module('carTracker',['ngRoute'])
        .config(moduleConfig);

    function moduleConfig($routeProvider) {
        $routeProvider
            .when('/cars', {
                templateUrl: 'app/views/carList.tmpl.html',
                controller: 'carController',
                controllerAs: 'carVm'
            })
            .when('/allAlerts', {
                templateUrl: 'app/views/allAlertsList.tmpl.html',
                controller:'alertController',
                controllerAs:'alertVm'
            })
            .when('/allHighAlerts', {
                templateUrl: 'app/views/allHighAlertsList.tmpl.html',
                controller:'alertController',
                controllerAs:'alertVm'
            })
            .when('/alerts/:vin',{
                templateUrl:'app/views/alertsListByVin.tmpl.html',
                controller:'alertController',
                controllerAs:'alertVm'
            })
            .otherwise({
                redirectTo: '/cars'
            });
    }
})();