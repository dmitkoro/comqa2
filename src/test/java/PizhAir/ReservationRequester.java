package PizhAir;


import PizhAir.model.Registration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class ReservationRequester {

    private final String url = "http://qaguru.lv:8090/tickets/getReservations.php";

    public Registration[] getRegistration () throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        String responseToParse = restTemplate.getForEntity(url, String.class).getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(responseToParse, Registration[].class);

    }

}
