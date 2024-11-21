package com.example.geoloc;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class ResponseFormatter {
    public static String formatResponse(Response response) {
        String responseBody = response.getBody().asString();
        System.out.println("API Response: " + responseBody);

        try {
            // Check if response is a valid JSON array
            JSONArray jsonArray = new JSONArray(responseBody);

            if (jsonArray.isEmpty()) {
                return "No data found for the given input.";
            }

            // Extract the first result
            JSONObject firstResult = jsonArray.getJSONObject(0);
            String place = firstResult.optString("name", "N/A");
            double latitude = firstResult.optDouble("lat", 0.0);
            double longitude = firstResult.optDouble("lon", 0.0);

            return String.format("Place: %s, Latitude: %f, Longitude: %f", place, latitude, longitude);
        } catch (Exception e) {
            // Handle unexpected formats or errors
            return "Error: Unable to parse response. Response body: " + responseBody;
        }
    }
}
