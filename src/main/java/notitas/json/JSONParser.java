package notitas.json;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class JSONParser{

    public static <T> T objetoDesdeString(String string, Class<T> claseDelObjeto){
        Gson gson = generarGson();
        return gson.fromJson(string, claseDelObjeto);
    }

    public static <T> List<T> objetosDesdeString(String string, Class<T[]> claseDelObjeto){
        Gson gson = generarGson();
        return Arrays.asList(gson.fromJson(string, claseDelObjeto));
    }
    
    public static String stringDesdeObjeto(Object objeto) {
    	Gson gson = generarGson();
    	return gson.toJson(objeto);
    }

    /* PRIVATE METHODS*/

    private static Gson generarGson() {
        Gson gson = new GsonBuilder()
                .create();
        return gson;
    }

}
