package Dao;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table (name = "etudiant")
public class Etudiant {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_etudiant")
	private int idEtudiant;
	
	@Column (name = "nom")
	private String nom;
	
	@Column (name = "prenom")
	private String prenom;
	
	@Column (name = "datenaissance")
	private Date dateNaissance;
	
	@ManyToOne ( 
			cascade = {CascadeType.REFRESH}
			)
	@JoinColumn (name = "id_groupe", nullable = false)
	private GroupeTd groupe;
	
	public Etudiant() {
		
	}
	
	public Etudiant(String nom, String prenom, Date dateNaissance, GroupeTd groupe) {
		this.nom=nom;
		this.prenom=prenom;
		this.dateNaissance=dateNaissance;
		this.groupe=groupe;
	}
	
	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public GroupeTd getGroupe() {
		return groupe;
	}

	public void setGroupe(GroupeTd groupe) {
		this.groupe = groupe;
	}
	
	
}
