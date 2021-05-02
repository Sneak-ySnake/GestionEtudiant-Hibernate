package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Operation {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	public void closeConnection() {
		if (em!=null) {
			em.close();
		}
		if (emf!=null) {
			emf.close();
		}
	}
	
	public void ajouterEtudiant(Etudiant e) {
		
		try {
		emf = Persistence.createEntityManagerFactory("deuxiemetpjpa");
		em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		trans.begin();
			
		em.persist(e);
		
		trans.commit();
		} 
		finally {
			closeConnection();
		}
		
	}
	
	public void ajouterSalle(Salle s) {
		
		try {
		emf = Persistence.createEntityManagerFactory("deuxiemetpjpa");
		em = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		em.persist(s);
		
		trans.commit();
		} 
		finally {
			closeConnection();
		}
		
	}
	
	public List<Salle> getAllSalle() {
		
		List<Salle> listeSalle = new ArrayList<Salle>();
		
		try {
		emf = Persistence.createEntityManagerFactory("deuxiemetpjpa");
		em = emf.createEntityManager();
		
		listeSalle=em.createQuery("from Salle", Salle.class).getResultList();
		
		}
		finally {
			closeConnection();
		}
		
		return listeSalle;
		
	}
	
	public Salle getSalle(int idSalle) {
		
		Salle s = new Salle();
		
		try {
		emf = Persistence.createEntityManagerFactory("deuxiemetpjpa");
		em = emf.createEntityManager();
			
		s=em.find(Salle.class,idSalle);
		
		} finally {
			closeConnection();
		}
		
		return s;
		
	}
	
	public void ajouterGroupe(GroupeTd g) {
		
		try {
		emf = Persistence.createEntityManagerFactory("deuxiemetpjpa");
		em = emf.createEntityManager();	
		
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		em.persist(g);
		
		trans.commit();
		}
		finally {
			closeConnection();
		}
		
	}
	
	public List<GroupeTd> getAllGroupe() {
		
		List<GroupeTd> listeGroupe = new ArrayList<GroupeTd>();
		
		try {
		emf = Persistence.createEntityManagerFactory("deuxiemetpjpa");
		em = emf.createEntityManager();	
			
		listeGroupe = em.createQuery("from GroupeTd",GroupeTd.class).getResultList();
			
		} finally {
			closeConnection();
		}
		
		return listeGroupe;
	}
	
	public GroupeTd getGroupe(int codeGroupe) {
		
		GroupeTd g;
		
		try {
		emf = Persistence.createEntityManagerFactory("deuxiemetpjpa");
		em = emf.createEntityManager();	
			
		g = em.find(GroupeTd.class, codeGroupe);
			
		} finally {
			closeConnection();
		}
		
		return g;
	}
	
	public Etudiant getEtudiant(int codeEtudiant) {
		
		Etudiant e;
		
		try {
		emf = Persistence.createEntityManagerFactory("deuxiemetpjpa");
		em = emf.createEntityManager();	
			
		e = em.find(Etudiant.class, codeEtudiant);
		
		} 
		finally {
			closeConnection();
		}
		
		return e;
	}
	
}
