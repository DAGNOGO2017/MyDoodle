package fr.istic.sir.rest;

import jpa.EntityManagerHelper;
import test.testjpa.domain.PreferenceAlimentaire;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Preference")
public class PreferenceService {
    private PreferenceAlimentaire preferenceAlimentaire;
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager = entityManagerHelper.getEntityManager();
    public PreferenceService() {
        super();
        this.preferenceAlimentaire = new PreferenceAlimentaire();
    }
    @GET
    @Path("/preference")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PreferenceAlimentaire> list(){
        PreferenceAlimentaire preferenceAlimentaire = new PreferenceAlimentaire();
        entityManagerHelper.beginTransaction();
        String req = "Select p from PreferenceAlimentaire p";
        Query query = entityManager.createQuery(req,PreferenceAlimentaire.class );
        List<PreferenceAlimentaire> preferenceAlimentaires = (List<PreferenceAlimentaire>) query.getResultList();
        return preferenceAlimentaires;
    }
}

