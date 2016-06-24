package web.rest;

import domain.Department;
import io.swagger.annotations.Api;
import repository.DepartmentRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/department")
@Api(value="/department", description = "Department resource")
public class DepartementResource {

    private DepartmentRepository departmentRepository = new DepartmentRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}
