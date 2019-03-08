package fr.istic.sir.rest.DAOImplement;

import jpa.EntityManagerHelper;
import test.testjpa.domain.Participant;

import javax.persistence.EntityManager;
import java.util.Collection;

public class ParticipantDAOImpl {
    private EntityManager entityManager;

    public ParticipantDAOImpl() {
        entityManager = EntityManagerHelper.getEntityManager();
    }

    public Participant getByParticipant(int Userid) {
        Participant participant = entityManager.find(Participant.class, Userid);
        return participant;
    }

    public void addParticipant(Participant participant) {
        entityManager.persist(participant);
    }


    public void removeParticipant(Participant participant) {
        entityManager.remove(participant);
    }


    public void updateParticipant(Participant participant) {
        entityManager.merge(participant);
    }


    public void beginTransaction() {
        entityManager.getTransaction().begin();
    }

    public void commitTransaction() {
        entityManager.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public Collection<Participant> findAllReunions(){
        return (Collection<Participant>)  entityManager.createNamedQuery("findAllReunions", Participant.class).getResultList();

    }

    public boolean existParticipant(int Userid) {
        Participant reunion = entityManager.find(Participant.class, Userid);
        boolean test;
        if (reunion == null) {
            test = false;
        }else {
            test = true;
        }
        return test;
    }
    }
