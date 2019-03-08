package fr.istic.sir.rest;

import jpa.EntityManagerHelper;
import test.testjpa.domain.SondageLieu;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/SondageLieu")
public class SondageLieuService {
    private SondageLieu sondageLieu;
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager = entityManagerHelper.getEntityManager();
    public SondageLieuService() {
        super();
        this.sondageLieu = new SondageLieu();
    }
    @GET
    @Path("/sondageLieu")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SondageLieu> list(){
        SondageLieu sondageLieu = new SondageLieu();
        entityManagerHelper.beginTransaction();
        String req = "Select s from SondageLieu s";
        Query query = entityManager.createQuery(req,SondageLieu.class );
        List<SondageLieu> sondageLieus = (List<SondageLieu>) query.getResultList();
        return sondageLieus;
    }
}

