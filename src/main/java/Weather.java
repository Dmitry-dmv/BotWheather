import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
public class Weather {
    private double latitude;
    private double longitude;
    private static final String openWeatherToken = "2269618e11a881c9903c1ac7cd68cfa2";

    public Weather() {}

    public Weather(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public void setCoords(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public String getForecast(){
        var sb = new StringBuilder();

        try{
            var url = new URL("http://api.openweathermap.org/data/2.5/weather?lat="
                    + latitude + "&lon=" + longitude + "&appid=" + openWeatherToken + "&units=metric");
            var reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String temp;
            while((temp = reader.readLine()) != null) sb.append(temp + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObj = new JSONObject(sb.toString());
        var desc = jsonObj.getJSONArray("weather").getJSONObject(0).getString("main");
        var temp = jsonObj.getJSONObject("main").getDouble("temp");
        var feelsLike = jsonObj.getJSONObject("main").getDouble("feels_like");
        var humidity = jsonObj.getJSONObject("main").getInt("humidity");
        var pressure = jsonObj.getJSONObject("main").getInt("pressure");
        var windSpeed = jsonObj.getJSONObject("wind").getInt("speed");

        sb.setLength(0);
        sb.append("Weather at you location is: " + desc.toLowerCase() + ",  " +
                temp + "°C. Feels like: " + feelsLike + "°C. Humidity is: " +
                humidity + ", pressure is: " + pressure + ", wind speed is: "
                + windSpeed + " m/s.");

        return sb.toString();

    }
}

