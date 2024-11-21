package com.example.geoloc;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class GeoLocationService {
    private static final String API_KEY = "f897a99d971b5eef57be6fafa0d83239";
    private static final String BASE_URL = "http://api.openweathermap.org/geo/1.0";

    public String fetchLocationByCityState(String cityState) {
        String endpoint = BASE_URL + "/direct";
        Response response = RestAssured.given()
                .queryParam("q", cityState)
                .queryParam("appid", API_KEY)
                .get(endpoint);

        return ResponseFormatter.formatResponse(response);
    }

    public String fetchLocationByZipCode(String zipCode) {
        String endpoint = BASE_URL + "/zip";
        Response response = RestAssured.given()
                .queryParam("zip", zipCode)
                .queryParam("appid", API_KEY)
                .get(endpoint);

        String responseBody = response.getBody().asString();
        System.out.println("ZIP Code API Response: " + responseBody);

        try {
            JSONObject jsonObject = new JSONObject(responseBody);
            String place = jsonObject.optString("name", "N/A");
            double latitude = jsonObject.optDouble("lat", 0.0);
            double longitude = jsonObject.optDouble("lon", 0.0);

            return String.format("Place: %s, Latitude: %f, Longitude: %f", place, latitude, longitude);
        } catch (Exception e) {
            return "Error: Unable to parse ZIP code response. Response body: " + responseBody;
        }
    }

}
