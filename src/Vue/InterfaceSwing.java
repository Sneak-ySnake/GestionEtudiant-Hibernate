package Vue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controlleur.Control;
import Dao.Etudiant;
import Dao.GroupeTd;
import Dao.Salle;

public class InterfaceSwing extends JFrame {

	private Control ctrl = new Control();
	
	public InterfaceSwing() {
		
		setSize(1200,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setTitle("JPA TP2");
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		
		JTabbedPane onglet = new JTabbedPane();
		add(onglet);
		
		JPanel ongletEtudiant = new JPanel();
		JPanel ongletGroupe = new JPanel();
		JPanel ongletSalle = new JPanel();
		JPanel ongletRecherche = new JPanel();
		
		////ONGLET ETUDIANT
		onglet.add(ongletEtudiant,"Etudiant");
		
		ongletEtudiant.setLayout(new GridLayout(10,1));
		
		ImageIcon etudiantIcon = new ImageIcon(this.getClass().getResource("/img/hat.png"));
		onglet.setIconAt(0, etudiantIcon);
		
		JPanel naissance = new JPanel();
		JPanel gCombo = new JPanel();
		JPanel boutonAjouterEtu = new JPanel();
		JLabel nomLabel = new JLabel("Nom");
		JLabel prenomLabel = new JLabel("Prenom");
		JLabel dateNaissanceLabel = new JLabel("Date de naissance");
		JLabel groupeLabel = new JLabel("Groupe de TD");
		JTextField nomText = new JTextField();
		JTextField prenomText = new JTextField();
		JComboBox<Integer> groupeCombo = new JComboBox<Integer>();
		JComboBox<Integer> jour = new JComboBox<Integer>(); 
		JComboBox<Integer> mois = new JComboBox<Integer>(); 
		JComboBox<Integer> annee = new JComboBox<Integer>(); 
		JButton ajouterEtudiant = new JButton("Ajouter un étudiant");
		
			////AJOUT DES DATES COMBOBOX ET VERIF COMBO BOX
		for (int i = 1 ; i<32 ; i++) {
			jour.addItem(i);
		}
		for (int i = 1 ; i<13 ; i++) {
			mois.addItem(i);
		}
		for (int i = 1900 ; i<2022 ; i++) {
			annee.addItem(i);
		}
		
		List<GroupeTd> listeGroupe = ctrl.getAllGroupe();
		
		if (listeGroupe.size()==0) {
			nomText.setEnabled(false);
			prenomText.setEnabled(false);
			jour.setEnabled(false);
			mois.setEnabled(false);
			annee.setEnabled(false);
			groupeCombo.setEnabled(false);
			ajouterEtudiant.setEnabled(false);
		}
		
		groupeCombo.removeAllItems();
		
		listeGroupe = ctrl.getAllGroupe();
		
		for (int i=0 ; i<listeGroupe.size() ; i++) {
			groupeCombo.addItem(listeGroupe.get(i).getIdGroupe());
		}
			////
		
		ongletEtudiant.add(nomLabel);
		ongletEtudiant.add(nomText);
		ongletEtudiant.add(prenomLabel);
		ongletEtudiant.add(prenomText);
		ongletEtudiant.add(dateNaissanceLabel);
		ongletEtudiant.add(naissance);
		naissance.add(jour);
		naissance.add(mois);
		naissance.add(annee);
		ongletEtudiant.add(groupeLabel);
		ongletEtudiant.add(gCombo);
		gCombo.add(groupeCombo);
		ongletEtudiant.add(boutonAjouterEtu);
		boutonAjouterEtu.add(ajouterEtudiant);
		
			
		////ONGLET GROUPE
		onglet.add(ongletGroupe, "Groupe de TD");
		
		ongletGroupe.setLayout(new GridLayout(8,1));
		
		ImageIcon groupeIcon = new ImageIcon(this.getClass().getResource("/img/group.png"));
		onglet.setIconAt(1, groupeIcon);
		
		JPanel boutonAjouterG = new JPanel();
		JPanel sCombo = new JPanel();
		JLabel salleLabel = new JLabel("Selectionner une salle");
		JComboBox<Integer> salleCombo = new JComboBox<Integer>();
		JButton ajouterGroupe = new JButton("Ajouter un groupe");
		
		ongletGroupe.add(salleLabel);
		ongletGroupe.add(sCombo);
		sCombo.add(salleCombo);
		ongletGroupe.add(boutonAjouterG);
		boutonAjouterG.add(ajouterGroupe);
		
		
		////ONGLET SALLE
		onglet.add(ongletSalle, "Salle");
		
		ongletSalle.setLayout(new GridLayout(10,1));
		
		ImageIcon salleIcon = new ImageIcon(this.getClass().getResource("/img/room.png"));
		onglet.setIconAt(2, salleIcon);
		
		JPanel radioPanel = new JPanel();
		JPanel ajouterS = new JPanel();
		JLabel nombrePlaceLabel = new JLabel("Nombre de place");
		JLabel nombrePcLabel = new JLabel("Nombre d'ordinateur");
		JLabel videoProLabel = new JLabel("Vidéo projecteur");
		JTextField nombrePlaceText = new JTextField();
		JTextField nombrePcText = new JTextField();
			////MISE EN PLACE BOUTON RADIO
		JRadioButton videoProOui = new JRadioButton("Oui");
		JRadioButton videoProNon = new JRadioButton("Non");
		ButtonGroup videoProRadio = new ButtonGroup();
		videoProRadio.add(videoProOui);
		videoProRadio.add(videoProNon);
			////
		JButton ajouterSalle = new JButton("Ajouter une salle");
		
		ajouterSalle.setEnabled(false);
		
		ongletSalle.add(nombrePlaceLabel);
		ongletSalle.add(nombrePlaceText);
		ongletSalle.add(nombrePcLabel);
		ongletSalle.add(nombrePcText);
		ongletSalle.add(videoProLabel);
		ongletSalle.add(radioPanel);
		radioPanel.add(videoProOui);
		radioPanel.add(videoProNon);
		ongletSalle.add(ajouterS);
		ajouterS.add(ajouterSalle);
		
		////ONGLET RECHERCHE
		onglet.add(ongletRecherche, "Recherche");
		
		ongletRecherche.setLayout(new GridLayout(12,1));
		
		ImageIcon rechercheIcon = new ImageIcon(this.getClass().getResource("/img/search.png"));
		onglet.setIconAt(3, rechercheIcon);
		
		JPanel boutonEtu = new JPanel();
		JPanel boutonGr = new JPanel();
		JPanel boutonSa = new JPanel();
		JLabel idEtudiantLabel = new JLabel("Numéro étudiant");
		JLabel idGroupeLabel = new JLabel("Numéro groupe");
		JLabel idSalleLabel = new JLabel("Numéro salle");
		JTextField idEtudiantText = new JTextField();
		JTextField idGroupeText = new JTextField();
		JTextField idSalleText = new JTextField();
		JTextField affichage = new JTextField();
		affichage.setEditable(false);
		JButton rechercherEtudiant = new JButton("Rechercher un étudiant");
		JButton rechercherGroupe = new JButton("Rechercher un groupe");
		JButton rechercherSalle = new JButton("Rechercher une salle");
		
		ongletRecherche.add(idEtudiantLabel);
		ongletRecherche.add(idEtudiantText);
		ongletRecherche.add(boutonEtu);
		boutonEtu.add(rechercherEtudiant);
		ongletRecherche.add(idGroupeLabel);
		ongletRecherche.add(idGroupeText);
		ongletRecherche.add(boutonGr);
		boutonGr.add(rechercherGroupe);
		ongletRecherche.add(idSalleLabel);
		ongletRecherche.add(idSalleText);
		ongletRecherche.add(boutonSa);
		boutonSa.add(rechercherSalle);
		ongletRecherche.add(affichage);
		
		////LISTENERS ONGLET GENERAL
		onglet.addChangeListener(new ChangeListener() {
			
			
			@Override
			public void stateChanged(ChangeEvent e) {
				groupeCombo.removeAllItems();
				
				List<GroupeTd> listeGroupe = ctrl.getAllGroupe();
				
				if (listeGroupe.size()==0) {
					nomText.setEnabled(false);
					prenomText.setEnabled(false);
					jour.setEnabled(false);
					mois.setEnabled(false);
					annee.setEnabled(false);
					groupeCombo.setEnabled(false);
					ajouterEtudiant.setEnabled(false);
				}
				else {
					nomText.setEnabled(true);
					prenomText.setEnabled(true);
					jour.setEnabled(true);
					mois.setEnabled(true);
					annee.setEnabled(true);
					groupeCombo.setEnabled(true);
					ajouterEtudiant.setEnabled(true);
					
					for (int i=0 ; i<listeGroupe.size() ; i++) {
						groupeCombo.addItem(listeGroupe.get(i).getIdGroupe());
					}
				}
				
			
				salleCombo.removeAllItems();
				
				List<Salle> listeSalle = ctrl.getAllSalle();
				
				if (listeSalle.size()==0) {
					salleCombo.setEnabled(false);
					ajouterGroupe.setEnabled(false);
				}
				else {
					salleCombo.setEnabled(true);
					ajouterGroupe.setEnabled(true);
					
					for (int j=0 ; j<listeSalle.size() ; j++) {
						salleCombo.addItem(listeSalle.get(j).getIdSalle());
					}
				}
				
			}
		});
		
		
		////LISTENERS ONGLET ETUDIANT
		ajouterEtudiant.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String dateNaissance = annee.getSelectedItem().toString()+"-"+mois.getSelectedItem().toString()+"-"+jour.getSelectedItem().toString();
				
				GroupeTd g = ctrl.getGroupe(Integer.parseInt(groupeCombo.getSelectedItem().toString()));
				Etudiant etu = new Etudiant(nomText.getText(), prenomText.getText(), Date.valueOf(dateNaissance), g);
				
				ctrl.ajouterEtudiant(etu);
				
				nomText.setText("");
				prenomText.setText("");
				jour.setSelectedIndex(0);
				mois.setSelectedIndex(0);
				annee.setSelectedIndex(0);
				groupeCombo.setSelectedIndex(0);
			}
		});
		
		
		////LISTENERS ONGLET GROUPE
		ajouterGroupe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Salle s = ctrl.getSalle(Integer.parseInt(salleCombo.getSelectedItem().toString()));
				GroupeTd g=new GroupeTd(s);

				ctrl.ajouterGroupe(g);
				
				salleCombo.setSelectedIndex(0);
			}
		});
		
		
		////LISTENERS ONGLET SALLE
		ajouterSalle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				if (videoProOui.isSelected()) {
					Salle s1 = new Salle(Integer.parseInt(nombrePlaceText.getText()), Integer.parseInt(nombrePcText.getText()), true);
					ctrl.ajouterSalle(s1);
				}
				else if (videoProNon.isSelected()) {
					Salle s2 = new Salle(Integer.parseInt(nombrePlaceText.getText()), Integer.parseInt(nombrePcText.getText()), false);
					ctrl.ajouterSalle(s2);
				}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(getContentPane(), "Format des données entrées incorrect");
				}
				
				nombrePlaceText.setText("");
				nombrePcText.setText("");
			}
		});
		
		videoProOui.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ajouterSalle.setEnabled(true);
				
			}
		});
		videoProNon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ajouterSalle.setEnabled(true);
				
			}
		});
		
		////LISTENERS ONGLET RECHERCHE
		rechercherEtudiant.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				Etudiant etu = null;
				boolean erreurFormat = false;
				
				try {
				etu=ctrl.getEtudiant(Integer.parseInt(idEtudiantText.getText()));
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(getContentPane(), "Format des données entrées incorrect");
					erreurFormat=true;
				} 
				
				if (etu==null && erreurFormat==false) {
					JOptionPane.showMessageDialog(getContentPane(), "Code entré inexistant");
				}
				else {
					affichage.setText("Numéro étudiant : "+etu.getIdEtudiant()+" - Nom : "+etu.getNom()
					+" - Prenom : "+etu.getPrenom()+" - Date de naissance : "+etu.getDateNaissance()
					+" - Groupe de TD : "+etu.getGroupe().getIdGroupe()+" - Salle : "+etu.getGroupe().getSalle().getIdSalle());
				}
				idEtudiantText.setText("");
			}
		});
		
		rechercherGroupe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				GroupeTd g = null;
				boolean erreurFormat=false;
				
				try {
				g=ctrl.getGroupe(Integer.parseInt(idGroupeText.getText()));
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(getContentPane(), "Format des données entrées incorrect");
					erreurFormat=true;
				}
				
				if (g==null && erreurFormat==false) {
					JOptionPane.showMessageDialog(getContentPane(), "Code entré inexistant");
				}
				else {
					affichage.setText("Numéro groupe : "+g.getIdGroupe()+" - Numéro de salle : "
					+g.getSalle().getIdSalle());
				}
				idGroupeText.setText("");
			}
		});

		rechercherSalle.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {

				Salle s = null;
				boolean erreurFormat = false;
				
				try {
				s=ctrl.getSalle(Integer.parseInt(idSalleText.getText()));
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(getContentPane(), "Format des données entrées incorrect");
					erreurFormat=true;
				}
				
				if (s==null && erreurFormat==false) {
					JOptionPane.showMessageDialog(getContentPane(), "Code entré inexistant");
				}
				else {
					String info = "Numéro salle : "+s.getIdSalle()+" - Nombre place : "
						+s.getNombrePlace()+" - Nombre pc : "+s.getNombrePc()+" - Groupe : ";
				
					affichage.setText(info);
				
					if (s.getListeGroupe().size()==0) {
						info = info + "Aucun";
					}
					else {
						for (int i=0 ; i<s.getListeGroupe().size() ; i++) {
							info = info + s.getListeGroupe().get(i).getIdGroupe()+" - ";
						}
						info=info.substring(0, info.length()-2);
					}
					
					affichage.setText(info);
				}
				idSalleText.setText("");
			}
		});
		
		setVisible(true);

	}
	
}
