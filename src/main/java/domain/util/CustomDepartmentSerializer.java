package domain.util;

import domain.Department;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

/**
 * Created by leiko on 24/09/15.
 */
public class CustomDepartmentSerializer extends JsonSerializer<Department> {
    @Override
    public void serialize(Department department, JsonGenerator generator, SerializerProvider serializerProvider)
            throws IOException, JsonProcessingException {
        generator.writeString(department.getName());
    }
}
