package Services;

import test.testjpa.domain.Createur;
import test.testjpa.domain.Utilisateur;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/Utilisateur")
public class UtilisateurServ {
    private Utilisateur createur;
    public UtilisateurServ(){
        super();
        this.createur = new Createur();

        @GET
        @Path("/user")
        @Produces(MediaType.APPLICATION_JSON)

        public List<Createur> list() throw SQLException {
            Utilisateur utilisateur = new Createur();
            return utilisateur.get;
        }
    }
}
