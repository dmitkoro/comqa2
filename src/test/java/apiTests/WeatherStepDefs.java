package apiTests;

import apiTests.model.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherStepDefs {
    private String city;
    private WeatherRequester requester = new WeatherRequester();
    private Response response;

    @Given("city name: (.*)")
    public void set_city(String city) {
        this.city = city;
    }

    @When("we are requesting weather info")
    public void request_weather() throws IOException {
        response = requester.getWeather(city);

    }

    @Then("lon is: (.*)")
    public void check_lon(double lon) {
        assertEquals(lon, response.getCoord().getLon(), "Not correct");

    }

    @Then("lat is: (.*)")
    public void check_lat(double lat) {
        assertEquals(lat, response.getCoord().getLat(), "Not correct");
    }

    @Then("weather_id is: (.*) and main is (.*) and description is (.*) and icon is (.*)")
    public void check_weather(Integer weather_id, String main, String description, String icon) {

        assertEquals(weather_id, response.getWeathers().get(0).getId(), "Not correct");
        assertEquals(main, response.getWeathers().get(0).getMain(), "Not correct");
        assertEquals(description, response.getWeathers().get(0).getDescription(), "Not correct");
        assertEquals(icon, response.getWeathers().get(0).getIcon(), "Not correct");
    }

    @Then("base is: (.*)")
    public void check_base(String base) {
        assertEquals(base, response.getBase(), "Not correct");
    }

    @Then("temp is: (.*)")
    public void check_temp(double temp) {
        assertEquals(temp, response.getMain().getTemp(), "Not correct");
    }

    @Then("pressure is: (.*)")
    public void check_pressure(double pressure) {
        assertEquals(pressure, response.getMain().getPressure(), "Not correct");
    }

    @Then("humidity is: (.*)")
    public void check_humidity(double humidity) {
        assertEquals(humidity, response.getMain().getHumidity(), "Not correct");
    }

    @Then("temp_min is: (.*)")
    public void check_temp_min(double temp_min) {
        assertEquals(temp_min, response.getMain().getTemp_min(), "Not correct");
    }

    @Then("temp_max is: (.*)")
    public void check_temp_max(double temp_max) {
        assertEquals(temp_max, response.getMain().getTemp_max(), "Not correct");
    }

    @Then("visibility is: (.*)")
    public void check_base(Integer visibility) {
        assertEquals(visibility, response.getVisibility(), "Not correct");
    }

    @Then("speed is: (.*)")
    public void check_base(double speed) {
        assertEquals(speed, response.getWind().getSpeed(), "Not correct");
    }

    @Then("deg is: (.*)")
    public void check_base(int deg) {
        assertEquals(deg, response.getWind().getDeg(), "Not correct");
    }

    @Then("all is: (.*)")
    public void check_all(Integer all) {
        assertEquals(all, response.getClouds().getAll(), "Not correct");
    }

    @Then("dt is: (.*)")
    public void check_dt(Integer dt) {
        assertEquals(dt, response.getDt(), "Not correct");
    }

    @Then("type is: (.*)")
    public void check_type(Integer type) {
        assertEquals(type, response.getSys().getType(), "Not correct");
    }

    @Then("sys_id is: (.*)")
    public void sys_id(Integer sys_id) {
        assertEquals(sys_id, response.getSys().getId(), "Not correct");
    }

    @Then("message is: (.*)")
    public void check_message(double message) {
        assertEquals(message, response.getSys().getMessage(), "Not correct");
    }

    @Then("country is: (.*)")
    public void check_country(String country) {
        assertEquals(country, response.getSys().getCountry(), "Not correct");
    }

    @Then("sunrise is: (.*)")
    public void check_sunrise(Integer sunrise) {
        assertEquals(sunrise, response.getSys().getSunrise(), "Not correct");
    }

    @Then("sunset is: (.*)")
    public void check_sunset(Integer sunset) {
        assertEquals(sunset, response.getSys().getSunset(), "Not correct");
    }

    @Then("id is: (.*)")
    public void check_id(Integer id) {
        assertEquals(id, response.getId(), "Not correct");
    }

    @Then("name is: (.*)")
    public void check_name(String name) {
        assertEquals(name, response.getName(), "Not correct");
    }

    @Then("cod is: (.*)")
    public void check_cod(Integer cod) {
        assertEquals(cod, response.getCod(), "Not correct");
    }

}
