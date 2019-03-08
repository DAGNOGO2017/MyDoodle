package fr.istic.sir.rest;

import jpa.EntityManagerHelper;
import test.testjpa.domain.Createur;
import test.testjpa.domain.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Utilisateur")
public class UtilisateurServ {
    private Utilisateur createur;
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager = entityManagerHelper.getEntityManager();
    public UtilisateurServ() {
        super();
        this.createur = new Createur();
    }
        @GET
        @Path("/user")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Createur> list(){
        Createur createur = new Createur();
            entityManagerHelper.beginTransaction();
            String req = "Select c from Createur c";
            Query query = entityManager.createQuery(req,Createur.class );
            List<Createur> createurs = (List<Createur>) query.getResultList();
            return createurs;
        }
    }

