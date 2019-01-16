package PizhAir;


import org.springframework.web.client.RestTemplate;

import java.util.List;

public class DeleteRequester {

    private String postfix;
    private final String PREFIX = "http://qaguru.lv:8090/tickets/delete.php?id=";

        public void deleteRequest(List<String> idsToRemove) {

            RestTemplate restTemplate = new RestTemplate();
            for (int i = 0; i < idsToRemove.size(); i++) {
                postfix = idsToRemove.get(i);
                restTemplate.delete(PREFIX + postfix);
            }
        }
}
