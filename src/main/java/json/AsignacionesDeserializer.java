package json;

import com.google.gson.*;
import model.Tarea;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class AsignacionesDeserializer implements JsonDeserializer<Asignaciones> {

    @Override
    public Asignaciones deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String jsonArrayString = extraerArrayJsonDeTareas(jsonElement);
        List<Tarea> tareas = parsearTareas(jsonArrayString);
        return new Asignaciones(tareas);
    }

    private List<Tarea>  parsearTareas(String jsonArrayString) {
        Gson gson = new GsonBuilder().create();
        return Arrays.asList(gson.fromJson(jsonArrayString, Tarea[].class));
    }

    private String extraerArrayJsonDeTareas (JsonElement jsonElement){
        return jsonElement
                .getAsJsonObject()
                .get("assignments")
                .getAsJsonArray()
                .toString();
    }


}
