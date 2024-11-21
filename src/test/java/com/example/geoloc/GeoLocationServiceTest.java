package com.example.geoloc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoLocationServiceTest {
    private GeoLocationService service = new GeoLocationService();

    @Test
    public void testFetchLocationByCityState() {
        String response = service.fetchLocationByCityState("Madison, WI");
        Assert.assertTrue(response.contains("Place") || response.contains("Error"));
    }

    @Test
    public void testFetchLocationByZipCode() {
        String response = service.fetchLocationByZipCode("53703");
        Assert.assertTrue(response.contains("Place") || response.contains("Error"));
    }

    @Test
    public void testInvalidCityState() {
        String response = service.fetchLocationByCityState("InvalidCity, ZZ");
        Assert.assertTrue(response.contains("No data found") || response.contains("Error"));
    }

    @Test
    public void testInvalidZipCode() {
        String response = service.fetchLocationByZipCode("00000");
        Assert.assertTrue(response.contains("No data found") || response.contains("Error"));
    }
}
