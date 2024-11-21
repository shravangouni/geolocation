
# GeoLocation Utility

GeoLocation Utility is a command-line tool to fetch geographical details like latitude, longitude, and place name using the OpenWeather Geocoding API.

---

## How to Build and Run the Project

### Prerequisites
- **Java**: Ensure Java 11 or later is installed.
- **Maven**: Ensure Maven is installed.

### Build the Project
To build the project, run:
```bash
mvn clean package
```

### Run the Project
To execute the application with sample inputs, use:
```bash
mvn exec:java -Dexec.args="--locations 'Madison, WI' '12345'"
```

Replace `--locations 'Madison, WI' '12345'` with the desired city/state or ZIP code inputs.

---

## Example Output
For the command:
```bash
mvn exec:java -Dexec.args="--locations 'Madison, WI' '12345'"
```
The output might look like:
```
Processing City/State: Madison, WI
Place: Madison, Latitude: 43.0731, Longitude: -89.4012
Processing ZIP Code: 12345
Place: Schenectady, Latitude: 42.8142, Longitude: -73.9396
```


