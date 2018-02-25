package com.argalski.weather.data;

import java.math.BigDecimal;

public class Weather {

    private BigDecimal temperatureCelsius;

    private BigDecimal temperatureKelvin;

    private BigDecimal preasure;

    public Weather() {

    }

    public Weather(BigDecimal temperatureCelsius, BigDecimal temperatureKelvin, BigDecimal preasure) {
        this.temperatureCelsius = temperatureCelsius;
        this.temperatureKelvin = temperatureKelvin;
        this.preasure = preasure;
    }

    public BigDecimal getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public void setTemperatureCelsius(BigDecimal temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    public BigDecimal getTemperatureKelvin() {
        return temperatureKelvin;
    }

    public void setTemperatureKelvin(BigDecimal temperatureKelvin) {
        this.temperatureKelvin = temperatureKelvin;
    }

    public BigDecimal getPreasure() {
        return preasure;
    }

    public void setPreasure(BigDecimal preasure) {
        this.preasure = preasure;
    }
}
