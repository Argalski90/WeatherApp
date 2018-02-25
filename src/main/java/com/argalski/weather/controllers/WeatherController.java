package com.argalski.weather.controllers;

import com.argalski.weather.form.WeatherForm;
import com.argalski.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(WeatherController.REQUEST_MAPPING)
public class WeatherController {

    static final String REQUEST_MAPPING = "/weather";

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(method = RequestMethod.GET)
    public String page(Model model) {
        try {
            model.addAttribute("weather", this.weatherService.checkWeather("London"));
        } catch (Exception e) {
            model.addAttribute("error", true);
        }
        model.addAttribute("weatherForm", new WeatherForm());
        return "weather/weather";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String checkWeather(Model model, WeatherForm weatherForm) throws Exception {
        try {
            model.addAttribute("weather", this.weatherService.checkWeather(weatherForm.getCity()));
        } catch (Exception e) {
            model.addAttribute("error", true);
        }
        return "weather/weather";
    }
}
