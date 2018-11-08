package notitas.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import notitas.Configuracion;

import javax.ws.rs.core.HttpHeaders;

class RestClient {
    private String url;

    RestClient(String url) {
        this.url = url;
    }

    String getResource(String resourceUrl) {
        WebResource resource = createWebResource(resourceUrl);
        ClientResponse response = resource
                .accept("application/notitas.json")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + Configuracion.token)
                .get(ClientResponse.class);
        return validateAndReturn(response);
    }

    String putResource(String resourceUrl, String jsonString) {
        WebResource resource = createWebResource(resourceUrl);
        ClientResponse response = resource
                .type("application/notitas.json")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + Configuracion.token)
                .put(ClientResponse.class, jsonString);
        return validateAndReturn(response);
    }

    /* PRIVATE METHODS */

    private WebResource createWebResource(String resourceUrl) {
        Client client = Client.create();
        return client.resource(url + "/" + resourceUrl);
    }

    private void validateResponse(ClientResponse response) {
        int status = response.getStatus();
        if (status < 200 || status > 299) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
    }

    private String validateAndReturn(ClientResponse response) {
        validateResponse(response);
        return response.getEntity(String.class);
    }
}
