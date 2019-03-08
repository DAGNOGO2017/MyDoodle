package fr.istic.sir.rest;

import jpa.EntityManagerHelper;
import test.testjpa.domain.Createur;
import test.testjpa.domain.Participant;
import test.testjpa.domain.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Participant")
public class ParticipantServ {
    private Utilisateur participant;
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager = entityManagerHelper.getEntityManager();
    public ParticipantServ() {
        super();
        this.participant = new Participant();
    }
    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Participant> list(){
        Participant participant = new Participant();
        entityManagerHelper.beginTransaction();
        String req = "Select p from Participant p";
        Query query = entityManager.createQuery(req,Participant.class );
        List<Participant> participants = (List<Participant>) query.getResultList();
        entityManagerHelper.closeEntityManager();
        return participants;
    }

    @GET
    @Path("/participant/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Participant rechercher(@PathParam("id") Long id){
        Participant participant = new Participant();
        entityManagerHelper.beginTransaction();
        participant=entityManager.find(Participant.class, id);
        entityManagerHelper.closeEntityManager();
        return participant;
    }

    @DELETE @Path("supprimer/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public  void supprimer(@PathParam("id") int id){
        Utilisateur participant = new Participant();
        entityManagerHelper.beginTransaction();
        participant=entityManager.find(Participant.class, id);
        entityManager.remove(participant);
        entityManagerHelper.closeEntityManager();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes (MediaType.APPLICATION_JSON)
    public  void creer(Participant participant){
        entityManagerHelper.beginTransaction();
        entityManager.persist(participant);
        entityManagerHelper.closeEntityManager();

    }
}

