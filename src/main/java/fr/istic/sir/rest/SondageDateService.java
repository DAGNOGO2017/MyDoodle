package fr.istic.sir.rest;

import jpa.EntityManagerHelper;
import test.testjpa.domain.Allergie;
import test.testjpa.domain.SondageDate;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/SondageDate")
public class SondageDateService {
    private SondageDate sondageDate;
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager = entityManagerHelper.getEntityManager();
    public SondageDateService() {
        super();
        this.sondageDate = new SondageDate();
    }
    @GET
    @Path("/sondageDate")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SondageDate> list(){
        SondageDate sondageDate = new SondageDate();
        entityManagerHelper.beginTransaction();
        String req = "Select s from SondageDate s";
        Query query = entityManager.createQuery(req,SondageDate.class );
        List<SondageDate> sondageDates = (List<SondageDate>) query.getResultList();
        return sondageDates;
    }

}

