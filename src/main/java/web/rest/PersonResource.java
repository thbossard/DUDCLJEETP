package web.rest;



import io.swagger.annotations.Api;
import repository.DAOPerson;
import domain.Person;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/owners")
@Api(value="/owners", description = "Personnes ayant un bien immobilier")
public class PersonResource {


    private DAOPerson PersonRepository = new DAOPerson();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAll(){
    
    	return PersonRepository.findAll();
            //.map(e -> Response.ok().entity(e).build())
            //.orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @GET
    @Path(value = "{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("name") String name) {
        	return PersonRepository.findOneByName(name)
            .map(e -> Response.ok().entity(e).build())
            .orElse(Response.status(Response.Status.NOT_FOUND).build());
    
    }

}