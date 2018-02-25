package com.argalski.weather.service;

import com.argalski.weather.data.Weather;

public interface WeatherService {

    Weather checkWeather(String city) throws Exception;

}
