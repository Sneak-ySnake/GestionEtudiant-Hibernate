package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "salle")
public class Salle {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_salle")
	private int idSalle;
	
	@Column (name = "nombre_pc")
	private int nombrePc;
	
	@Column (name = "nombre_place")
	private int nombrePlace;
	
	@Column (name = "videoprojecteur")
	private boolean videoProjecteur;

	@OneToMany (fetch = FetchType.EAGER, mappedBy = "salle")
	private List<GroupeTd> listeGroupe = new ArrayList<>();
	
	public Salle() {
		
	}
	
	public Salle(int nombrePlace, int nombrePc, boolean videoPro) {
		
		this.nombrePlace = nombrePlace;
		this.nombrePc = nombrePc;
		this.videoProjecteur = videoPro;
		
	}
	
	public int getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	public int getNombrePc() {
		return nombrePc;
	}

	public void setNombrePc(int nombrePc) {
		this.nombrePc = nombrePc;
	}

	public int getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public boolean isVideoProjecteur() {
		return videoProjecteur;
	}

	public void setVideoProjecteur(boolean videoProjecteur) {
		this.videoProjecteur = videoProjecteur;
	}

	public List<GroupeTd> getListeGroupe() {
		return listeGroupe;
	}
	
	
}
