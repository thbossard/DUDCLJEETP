package web.rest;

import io.swagger.annotations.Api;
import repository.DAOPerson;
import domain.Person;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.FormParam;


@Path("/person")
@Api(value="/person", description = "Personnes ayant un bien immobilier")
public class PersonResource {


    private DAOPerson PersonRepository = new DAOPerson();

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersonAll(){
    
    	return PersonRepository.findAll();
            //.map(e -> Response.ok().entity(e).build())
            //.orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    // ne fonctionne pas en cas de personnes ayant le même nom
    //@GET
    //@Path(value = "{name}")
    //@Produces(MediaType.APPLICATION_JSON)
    //public Response getPersonByName(@PathParam("name") String name) {
     //   	return PersonRepository.findOneByName(name)
      //      .map(e -> Response.ok().entity(e).build())
       //     .orElse(Response.status(Response.Status.NOT_FOUND).build());
    
    //}

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Person getPersonById(@PathParam("id") String id) {
        	return PersonRepository.findById(Integer.parseInt(id));
    }

    @POST //Pour ajouter une personne
    public void createPerson(@FormParam("nom") String nomP,
            @FormParam("prenom") String prenomP,
            @FormParam("mail") String mailP) {  
			PersonRepository.createPerson(nomP,prenomP,mailP);
	} 
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
    public void createPerson(Person p) { 
		PersonRepository.createPerson(p.getPersonFname(),p.getPersonLName(),p.getPersonMail());
    } 
    
    //maj d'une maison associée à une personne
    @POST 
    @Path("/{id}") 
    public void majPersonHome(@PathParam("id") String id,@FormParam("name") String nom,@FormParam("type") String type,
    		@FormParam("size") int size,
            @FormParam("roomCount") int roomCount) { 
			PersonRepository.updatePersonHome(Integer.parseInt(id), nom, type, size, roomCount);
    } 
    
    
	@PUT //update des personnes
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void majPerson(Person p){
		Person majp = PersonRepository.findById(p.getPersonId());
		if (majp != null) { //l'Id existe...
			PersonRepository.update(p);
		}else{
			System.out.println("l'Id n'existe pas !! update impossible");
		}
	}
	
	@DELETE //suppression... 
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletePerson(@PathParam("id") String id){
		PersonRepository.deletePerson(Integer.parseInt(id));
	}
}