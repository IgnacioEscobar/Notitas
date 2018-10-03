package client;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestClientTest {


    @Test
    public void putResourceTest() {
        RestClient client = new RestClient("http://notitas.herokuapp.com");
        String response = client.putResource("student","{\"code\":\"111222333\",\"first_name\":\"Lisa\",\"last_name\":\"Simpson\",\"github_user\":\"corazonDeLeon\"}");
        assertEquals( "{\"first_name\":\"Lisa\",\"last_name\":\"Simpson\",\"github_user\":\"corazonDeLeon\"}",response);
    }

    @Test
    public void getResourceTest() {
        RestClient client = new RestClient("http://notitas.herokuapp.com");
        String response = client.getResource("student");
        assertEquals("{\"code\":\"111222333\",\"first_name\":\"Lisa\",\"last_name\":\"Simpson\",\"github_user\":\"corazonDeLeon\"}",response);
    }

}
