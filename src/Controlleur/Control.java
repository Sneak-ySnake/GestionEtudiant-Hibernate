package Controlleur;

import java.util.List;

import Dao.Etudiant;
import Dao.GroupeTd;
import Dao.Operation;
import Dao.Salle;

public class Control {

	private Operation op = new Operation();
	
	public void ajouterEtudiant(Etudiant e) {
		op.ajouterEtudiant(e);
	}
	
	public void ajouterSalle(Salle s) {
		op.ajouterSalle(s);	
	}
	
	public List<Salle> getAllSalle() {
		
		List<Salle> listeSalle = op.getAllSalle();
		return listeSalle;
	}
	
	public Salle getSalle(int idSalle) {
		
		Salle s = op.getSalle(idSalle);
		return s;
	}
	
	public void ajouterGroupe(GroupeTd g) {
		op.ajouterGroupe(g);
	}
	
	public List<GroupeTd> getAllGroupe() {
		List<GroupeTd> listeGroupe = op.getAllGroupe();
		return listeGroupe;
	}
	
	public GroupeTd getGroupe(int codeGroupe) {
		GroupeTd g = op.getGroupe(codeGroupe);
		return g;
	}
	
	public Etudiant getEtudiant(int codeEtudiant) {
		Etudiant e = op.getEtudiant(codeEtudiant);
		return e;
	}
	
}
