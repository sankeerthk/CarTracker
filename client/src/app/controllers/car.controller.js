(function () {
    'use strict';

    angular.module('carTracker')
        .controller('carController',carController);

    carController.$inject=['carService'];
    function carController(carService) {
        
        var carVm =this;

        carVm.changeSort=changeSort;

        init();

        function init() {
            console.log('UsersController');

            carVm.sorter = {
                by: 'lastServiceDate',
                reverse: false
            };

            carService.getCars().then(function (cars) {
                carVm.cars = cars;
                console.log(carVm.car);
            }, function (error) {
                console.log(error);
            });
        }

        function changeSort(prop) {
            carVm.sorter.by= prop;
            carVm.sorter.reverse = !carVm.sorter.reverse;
        }
    }
})();