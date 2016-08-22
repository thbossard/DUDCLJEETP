package web.rest;

import io.swagger.annotations.Api;
import repository.DAOHome;
import repository.DAOPerson;
import domain.Home;
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
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;

@Path("/homes")
@Api(value="/homes", description = "Maisons")
public class HomeResource {
	
	private DAOHome HomeRepository = new DAOHome();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Home> getHomeAll(){
    
    	return HomeRepository.findAll();
            
    }
			
	@GET 
	@Path("find/{id}") 
	@Produces({ MediaType.APPLICATION_JSON })
	public Home getById(@PathParam("id") String HomeId){
		return HomeRepository.findById(Integer.parseInt(HomeId));
	}
	
	@GET 
	@Path("find/person/{id}") 
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Home> getByPersonId(@PathParam("id") String p){
		return HomeRepository.findByPersonId(p);
	}

	@POST 
    public void createHome(@FormParam("name") String name, @FormParam("type") String type,
    		@FormParam("size") int size,
            @FormParam("roomCount") int roomCount) { 
			HomeRepository.createHome(name, type, size, roomCount);
    } 
	
	 @POST
	 @Consumes({ MediaType.APPLICATION_JSON }) 
	 	public void createHome(Home h) { 
		 	HomeRepository.createHome(h.getHomeName(),h.getHomeType(),h.getHomeSize(), h.getHomeRoomCount());
	    } 
	
	 @POST @Path("{id}/device/")
	    public void createHomeDevice(@PathParam("id") int deviceId,@FormParam("name") String deviceName,
	    		@FormParam("conso") int deviceConso) { 
				HomeRepository.createHomeDevice(deviceId, deviceName, deviceConso);
		}
	 	 
	 @POST @Path("{id}/heater/")
	    public void createHomeHeater(@PathParam("id") int heaterId,@FormParam("name") String HeaterName,
	    		@FormParam("conso") int heaterConso) { 
				HomeRepository.createHomeHeater(heaterId, HeaterName, heaterConso);
	    }
	 
	 @PUT //update des maisons
		@Consumes({ MediaType.APPLICATION_JSON }) 
		public void majHome(Home h){
			Home majh = HomeRepository.findById(h.getHomeId());
			if (majh != null) { //l'Id existe...
				HomeRepository.update(h);
			}else{
				System.out.println("l'Id n'existe pas !! update impossible");
			}
		}	
	 //suppression sous condition
	 @DELETE @Path("remove/{id}") 
		public void deleteById(@PathParam("id") String homeId) { 
			Home tmpId = HomeRepository.findById(Integer.parseInt(homeId));
			// Le homeId doit exister pour être supprimé
			if (tmpId != null)
				HomeRepository.deleteHome(tmpId);		
		} 	
}
