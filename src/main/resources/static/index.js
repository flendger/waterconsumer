angular.module('app', []).controller('indexController', function ($scope, $http) {
    $scope.consumption = {};

    $scope.getConsumption = function () {
        $http.get('api/v1/water')
            .then(function success(response) {
                    $scope.consumption = response.data;
                    $scope.consumption.consumptionDate = new Date($scope.consumption.consumptionDate);
                },
                function error(response) {
                    alert(response)
                });
    }

    $scope.sendConsumption = function () {
        $http.post('api/v1/water', $scope.consumption)
            .then(function success() {
                    $scope.getConsumption();
                },
                function error(response) {
                    alert(response)
                });
    }

    $scope.getConsumption();
});