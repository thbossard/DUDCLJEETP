package domain.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import domain.ElecDevices;

public class CustomElecDevicesSerializer extends JsonSerializer<ElecDevices>{
	@Override
    public void serialize(ElecDevices elecdevices, JsonGenerator generator, SerializerProvider serializerProvider)
    		throws IOException, JsonProcessingException {
        	generator.writeString(elecdevices.getDeviceName());
    }
}
