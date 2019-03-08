package fr.istic.sir.rest;

import jpa.EntityManagerHelper;
import test.testjpa.domain.Dates;
import test.testjpa.domain.PreferenceAlimentaire;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Date")
public class DateService {
    private Dates dates;
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager = entityManagerHelper.getEntityManager();
    public DateService() {
        super();
        this.dates = new Dates();
    }
    @GET
    @Path("/date")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dates> list(){
        Dates date = new Dates();
        entityManagerHelper.beginTransaction();
        String req = "Select d from Dates d";
        Query query = entityManager.createQuery(req,Dates.class );
        List<Dates> dates = (List<Dates>) query.getResultList();
        return dates;
    }
}

