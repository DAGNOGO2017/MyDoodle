package fr.istic.sir.rest;

import jpa.EntityManagerHelper;
import test.testjpa.domain.Allergie;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Allergie")
public class AllergieService {
    private Allergie allergie;
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager = entityManagerHelper.getEntityManager();
    public AllergieService() {
        super();
        this.allergie = new Allergie();
    }
    @GET
    @Path("/allergie")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Allergie> list(){
        Allergie allergie = new Allergie();
        entityManagerHelper.beginTransaction();
        String req = "Select a from Allergie a";
        Query query = entityManager.createQuery(req,Allergie.class );
        List<Allergie> allergies = (List<Allergie>) query.getResultList();
        return allergies;
    }
}

