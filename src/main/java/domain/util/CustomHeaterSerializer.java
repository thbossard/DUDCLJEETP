package domain.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import domain.Heater;

public class CustomHeaterSerializer extends JsonSerializer<Heater> {
	@Override
    public void serialize(Heater heater, JsonGenerator generator, SerializerProvider serializerProvider)
    		throws IOException, JsonProcessingException {
        	generator.writeString(heater.getHeaterName());
    }
}
