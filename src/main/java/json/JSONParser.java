package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
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

    /* PRIVATE METHODS*/

    private static Gson generarGson() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Asignaciones.class ,new AsignacionesDeserializer())
                .create();
        return gson;
    }

}
