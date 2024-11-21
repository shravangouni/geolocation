package com.example.geoloc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Ensure arguments are provided
        if (args.length == 0) {
            System.out.println("Usage: geoloc-util --locations \"City, State\" \"ZIP Code\"");
            return;
        }

        // Parse arguments
        List<String> locations = new ArrayList<>();
        if (args[0].equals("--locations")) {
            locations.addAll(Arrays.asList(args).subList(1, args.length));
        } else {
            System.out.println("Error: Invalid flag. Use --locations to specify inputs.");
            return;
        }

        // Handle locations
        LocationRequestHandler handler = new LocationRequestHandler();
        handler.handleRequests(locations);
    }
}
