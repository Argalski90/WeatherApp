package com.argalski.weather.service;

import com.argalski.weather.data.Weather;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.Charset;

@Service("weatherService")
public class WeatherServiceImpl implements WeatherService {

    private static String KEY = "&appid=a25ffdbfe6fd993d36b6436b2579c146";

    private static String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s" + KEY;


    public Weather checkWeather(String city) throws Exception {
        JSONObject jsonObject = readJsonFromUrl(String.format(WEATHER_URL, city));

        BigDecimal kelvin = new BigDecimal(((JSONObject)jsonObject.get("main")).get("temp").toString());
        BigDecimal celsius = kelvin.subtract(new BigDecimal("273")).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal pressure = new BigDecimal(((JSONObject)jsonObject.get("main")).get("pressure").toString()).setScale(2, BigDecimal.ROUND_HALF_EVEN);


        return new Weather(celsius, kelvin, pressure);
    }

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

}
