package com.example.geoloc;

import java.util.List;

public class LocationRequestHandler {
    private GeoLocationService geoLocationService = new GeoLocationService();

    public void handleRequests(List<String> inputs) {
        inputs.forEach(input -> {
            if (input.matches("\\d{5}")) { // Check if input is a ZIP code
                System.out.println("Processing ZIP Code: " + input);
                System.out.println(geoLocationService.fetchLocationByZipCode(input));
            } else { // Assume it's a city and state
                System.out.println("Processing City/State: " + input);
                System.out.println(geoLocationService.fetchLocationByCityState(input));
            }
        });
    }
}
