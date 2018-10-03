package client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.HttpHeaders;

public class RestClient {
    private String url;
    private String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";

    public RestClient(String url) {
        this.url = url;
    }

    public String getResource(String resourceUrl){
        WebResource resource = createWebResource(resourceUrl);
        ClientResponse response = resource
                .accept("application/json")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + TOKEN)
                .get(ClientResponse.class);
        return validateAndReturn(response);
    }

    public String putResource(String resourceUrl, String jsonString){
        WebResource resource = createWebResource(resourceUrl);
        ClientResponse response = resource
                .type("application/json")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + TOKEN)
                .put(ClientResponse.class, jsonString);
        return validateAndReturn(response);
    }

    /* PRIVATE METHODS */

    private WebResource createWebResource (String resourceUrl) {
        Client client = Client.create();
        return client.resource(url + "/" + resourceUrl);
    }

    private void validateResponse(ClientResponse response) {
        int status  = response.getStatus();
        if (status < 200 || status > 299 ) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
    }

    private String validateAndReturn(ClientResponse response){
        validateResponse(response);
        return response.getEntity(String.class);
    }
}
