package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "groupe_td")
public class GroupeTd {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_groupe")
	private int idGroupe;

	@ManyToOne ( 
			cascade = {CascadeType.REFRESH}
			)
	@JoinColumn(name = "id_salle", nullable = false)
	private Salle salle;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "groupe")
	private List<Etudiant> listeEtudiant = new ArrayList<>();
	 
	public GroupeTd() {

	}

	public GroupeTd(Salle salle) {
		this.salle = salle;
	}

	public int getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public List<Etudiant> getListeEtudiant() {
		return listeEtudiant;
	}

	
	
}
