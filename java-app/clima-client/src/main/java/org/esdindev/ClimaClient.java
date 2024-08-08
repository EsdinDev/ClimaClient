package org.esdindev;

public class ClimaClient {

    private ApiService apiService;

    public ClimaClient(ApiService apiService) {
        this.apiService = apiService;
    }

    public Coordinates getCoordinatesByPostalCode(String postalCode) {
        return apiService.getCoordinates(postalCode);
    }
}