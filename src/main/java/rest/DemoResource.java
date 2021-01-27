package rest;

import com.google.gson.Gson;
import dto.CatDTO;
import dto.ChuckDTO;
import dto.CombinedDTO;
import dto.DadDTO;
import dto.NbaDTO;
import dto.SwapiDTO;
import entities.User;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;
import utils.HttpUtils;

/**
 * @author lam@cphbusiness.dk
 */
@Path("info")
public class DemoResource {
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    //Just to verify if the database is setup
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allUsers() {

        EntityManager em = EMF.createEntityManager();
        try {
            TypedQuery<User> query = em.createQuery ("select u from User u",entities.User.class);
            List<User> users = query.getResultList();
            return "[" + users.size() + "]";
        } finally {
            em.close();
        }
    }

    @GET
    @Path("user")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("user")
    public String getFromUser() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to User: " + thisuser + "\"}";
    }

    @GET
    @Path("admin")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public String getFromAdmin() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
    }
    
    @GET
    @Path("data")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSomeCats() throws Exception {
        Gson gson = new Gson();
        System.out.println("virker");
        
        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        ChuckDTO chuckDTO = gson.fromJson(chuck, ChuckDTO.class);
        
        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");
        DadDTO dadDTO = gson.fromJson(dad, DadDTO.class);
        
        String swapi = HttpUtils.fetchData("https://swapi.dev/api/planets/1/");
        SwapiDTO swapiDTO = gson.fromJson(swapi, SwapiDTO.class);
        
        String cat = HttpUtils.fetchData("https://cat-fact.herokuapp.com/facts/random");
        CatDTO catDTO = gson.fromJson(cat, CatDTO.class);
        
        String nba = HttpUtils.fetchData("https://test.api.suredbits.com/nba/v0/info");
        NbaDTO nbaDTO = gson.fromJson(nba, NbaDTO.class);
        
        CombinedDTO combinedDTO = new CombinedDTO(chuckDTO, dadDTO, swapiDTO, catDTO, nbaDTO);
        String combinedJson = gson.toJson(combinedDTO);
        
        return combinedJson;
    }
}