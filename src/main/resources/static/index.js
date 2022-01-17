angular.module('app', []).controller('indexController', function ($scope, $http) {
    $scope.consumption = {};

    function getDate(initDate) {
        if (initDate == null) {
            return '';
        }
        let date = new Date(initDate);
        return date.toISOString();
    }

    $scope.getConsumption = function () {
        $http({
            url: 'api/v1/water', method: 'GET', params: {
                date: getDate($scope.consumption.consumptionDate)
            }
        })
            .then(function success(response) {
                $scope.consumption = response.data;
                $scope.consumption.consumptionDate = new Date($scope.consumption.consumptionDate);
            }, function error(response) {
                alert(response)
            });
    }

    $scope.sendConsumption = function () {
        $http.post('api/v1/water', $scope.consumption)
            .then(function success() {
                $scope.getConsumption();
            }, function error(response) {
                alert(response)
            });
    }

    $scope.getConsumption();
});