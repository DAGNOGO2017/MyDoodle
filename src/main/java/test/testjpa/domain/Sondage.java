package test.testjpa.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Sondage")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Sondage {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "libelle")
	private String libelleSondage;
	@Column(name = "datescloture")
	private Date dateCloture;
	@Column(name = "type")
	private String type;
	
	@OneToOne(mappedBy = "sondage")
	private Reunion reunion;
    private Collection<Utilisateur> utilisateurs;
	
	public Sondage(String libelleSondage) {
		super();
		this.libelleSondage = libelleSondage;
	}
	public Sondage() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getLibelleSondage() {
		return libelleSondage;
	}
	public void setLibelleSondage(String libelleSondage) {
		this.libelleSondage = libelleSondage;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCloture() {
		return dateCloture;
	}
	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@ManyToMany
	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

}
