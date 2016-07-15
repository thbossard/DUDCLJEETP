package domain.util;
import domain.Home;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
public class CustomHomeSerializer extends JsonSerializer<Home> {
	@Override
    public void serialize(Home home, JsonGenerator generator, SerializerProvider serializerProvider)
    		throws IOException, JsonProcessingException {
        	generator.writeString(home.getHomeName());
    }
}
