package sn.scolarite.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import sn.gestionexception.app.BadFormatException;
import sn.gestionscolarite.app.Dao;
import sn.gestionscolarite.classes.Classes;
import sn.gestionscolarite.classes.Formation;
import sn.gestionscolarite.datasource.ClasseDaoibd;
import sn.gestionscolarite.datasource.ElevesDaoibd;
import sn.gestionscolarite.datasource.FormationDaoibd;
import sn.gestionscolarite.model.Eleve;
import sn.gestionscolarite.outils.Utilitaires;

public class UIFormEleveManager extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nomTf;
	private JTextField prenomTf;
	private JTextField dateTf;
	private JRadioButton femmeBtrg;
	private JRadioButton hommeBtgr;
	private Dao<Classes> listClasses;
	private Dao<Formation> listFormations;
	private Dao<Eleve> listeEleves;
	private JComboBox selectedOption;
	private JComboBox selectedOption_1;
	public UIFormEleveManager() {
		listClasses= new ClasseDaoibd();
		listFormations=new FormationDaoibd();
		listeEleves =new ElevesDaoibd();
		setSize(new Dimension(573, 455));
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(15);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1.setBackground(new Color(255, 255, 255));
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\gestion-scolarite-app\\src\\ressource\\OIP.jpeg"));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(50);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Gestionnaire Scolarite");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBackground(new Color(46, 46, 46));
		panel.add(panel_25);
		panel_25.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("Ajouter un  Eleve");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_25.add(lblNewLabel_7);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_23 = new JPanel();
		panel_23.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_14 = (FlowLayout) panel_23.getLayout();
		flowLayout_14.setVgap(20);
		panel_3.add(panel_23);
		
		JButton ajouteBt = new JButton("Ajouter");
		ajouteBt.setPreferredSize(new Dimension(150, 30));
		ajouteBt.setBackground(new Color(46, 46, 46));
		ajouteBt.setForeground(new Color(255, 255, 255));
		ajouteBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ajoutOnClicked();
			}
		});
		ajouteBt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_23.add(ajouteBt);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_15 = (FlowLayout) panel_24.getLayout();
		flowLayout_15.setVgap(20);
		panel_3.add(panel_24);
		
		JButton quiiterBtn = new JButton("Quitter");
		quiiterBtn.setPreferredSize(new Dimension(150, 30));
		quiiterBtn.setForeground(new Color(255, 255, 255));
		quiiterBtn.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onQuitterClick();		
			}
		});
		quiiterBtn.setBackground(new Color(46, 46, 46));
		quiiterBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_24.add(quiiterBtn);
		
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_11 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_11.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(30);
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_6.add(panel_11);
		
		JLabel nomtitle = new JLabel("Nom :");
		nomtitle.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_11.add(nomtitle);
		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_12.getLayout();
		flowLayout_8.setVgap(10);
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		panel_6.add(panel_12);
		
		nomTf = new JTextField();
		nomTf.setPreferredSize(new Dimension(7, 30));
		panel_12.add(nomTf);
		nomTf.setColumns(20);
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_13 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_13.getLayout();
		flowLayout_3.setVgap(10);
		flowLayout_3.setHgap(30);
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		panel_7.add(panel_13);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_13.add(lblNewLabel_2);
		
		JPanel panel_14 = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panel_14.getLayout();
		flowLayout_9.setVgap(10);
		flowLayout_9.setAlignment(FlowLayout.LEFT);
		panel_7.add(panel_14);
		
		prenomTf = new JTextField();
		prenomTf.setPreferredSize(new Dimension(7, 30));
		panel_14.add(prenomTf);
		prenomTf.setColumns(20);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_15 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_15.getLayout();
		flowLayout_4.setVgap(10);
		flowLayout_4.setHgap(30);
		flowLayout_4.setAlignment(FlowLayout.RIGHT);
		panel_8.add(panel_15);
		
		JLabel lblNewLabel_3 = new JLabel("Data de Naissance :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_3);
		
		JPanel panel_16 = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) panel_16.getLayout();
		flowLayout_10.setVgap(10);
		flowLayout_10.setAlignment(FlowLayout.LEFT);
		panel_8.add(panel_16);
		
		dateTf = new JTextField();
		dateTf.setPreferredSize(new Dimension(7, 30));
		panel_16.add(dateTf);
		dateTf.setColumns(20);
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_17 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_17.getLayout();
		flowLayout_5.setHgap(30);
		flowLayout_5.setAlignment(FlowLayout.RIGHT);
		panel_9.add(panel_17);
		
		JLabel lblNewLabel_4 = new JLabel("Sexe :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_17.add(lblNewLabel_4);
		
		JPanel panel_18 = new JPanel();
		FlowLayout flowLayout_11 = (FlowLayout) panel_18.getLayout();
		flowLayout_11.setHgap(40);
		flowLayout_11.setAlignment(FlowLayout.LEFT);
		panel_9.add(panel_18);
		
		hommeBtgr = new JRadioButton("H");
		hommeBtgr.setHorizontalAlignment(SwingConstants.CENTER);
		hommeBtgr.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_18.add(hommeBtgr);
		
		femmeBtrg = new JRadioButton("F");
		femmeBtrg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_18.add(femmeBtrg);
		ButtonGroup btn = new ButtonGroup();
		btn.add(femmeBtrg);
		btn.add(hommeBtgr);
		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10);
		panel_10.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_19 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_19.getLayout();
		flowLayout_6.setHgap(30);
		flowLayout_6.setAlignment(FlowLayout.RIGHT);
		panel_10.add(panel_19);
		
		JLabel lblNewLabel_5 = new JLabel("Formation :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_19.add(lblNewLabel_5);
		
		JPanel panel_20 = new JPanel();
		FlowLayout flowLayout_12 = (FlowLayout) panel_20.getLayout();
		flowLayout_12.setAlignment(FlowLayout.LEFT);
		panel_10.add(panel_20);
		
		
		selectedOption = new JComboBox();
		selectedOption.setBorder(null);
		selectedOption.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		selectedOption.setForeground(new Color(46, 46, 46));
		selectedOption.setBackground(new Color(255, 255, 255));
		selectedOption.setPreferredSize(new Dimension(223, 30));
		selectedOption.setMaximumRowCount(10);
		//ajoute option liste
		ajouteListeOptionFormation();
		panel_20.add(selectedOption);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_21 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_21.getLayout();
		flowLayout_7.setHgap(30);
		flowLayout_7.setAlignment(FlowLayout.RIGHT);
		panel_5.add(panel_21);
		
		JLabel lblNewLabel_6 = new JLabel("Classe :");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_21.add(lblNewLabel_6);
		
		JPanel panel_22 = new JPanel();
		FlowLayout flowLayout_13 = (FlowLayout) panel_22.getLayout();
		flowLayout_13.setAlignment(FlowLayout.LEFT);
		panel_5.add(panel_22);
	
		selectedOption_1 = new JComboBox();
		selectedOption_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		selectedOption_1.setForeground(new Color(46, 46, 46));
		selectedOption_1.setBackground(new Color(255, 255, 255));
		selectedOption_1.setPreferredSize(new Dimension(223, 30));
		ajoutListeOptionClasse();
		panel_22.add(selectedOption_1);
		Utilitaires.center(this, getSize());
	}
	private void onQuitterClick() {
		UIFenetreChoixSecretaire choix= new UIFenetreChoixSecretaire();
		choix.showMe();
		dispose();
	}
	
	private void viderFormulaire() {
		this.nomTf.setText(null);
		this.prenomTf.setText(null);
		this.dateTf.setText(null);
		this.selectedOption.setSelectedIndex(0);
		this.selectedOption_1.setSelectedIndex(0);
	}
	
	
	private void ajoutOnClicked() {
		String nom=nomTf.getText();
		String prenom = prenomTf.getText();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dateString = dateTf.getText();	 
		LocalDate dateNaissance = LocalDate.parse(dateString, dateTimeFormatter);
		char sexe;
		String formation = null;
		String classe = null;
		if (hommeBtgr.isSelected()) {
			sexe='M';
		} else {
			sexe='F';
		}
		if (selectedOption.getSelectedIndex()!=-1) {
			formation=	(String) selectedOption.getItemAt(selectedOption.getSelectedIndex());
		}
		if (selectedOption_1.getSelectedIndex()!=-1) {
			classe=	(String) selectedOption_1.getItemAt(selectedOption_1.getSelectedIndex());
		}
		try {
			Eleve eleve = new Eleve(nom, prenom, dateNaissance, formation, sexe, classe);
			listeEleves.add(eleve);
			viderFormulaire();
		} catch (BadFormatException e) {
			e.printStackTrace();
		}
	}
	
	
	private void ajoutListeOptionClasse() {
		try {
			String [] tableClasses= new String[listClasses.list().size()];
			int i=0;
			for (Classes formation : listClasses.list()) {
				tableClasses[i]=formation.getLibelle();
				i++;
			}
			selectedOption_1.setModel(new DefaultComboBoxModel(tableClasses));
		} catch (BadFormatException e) {
			e.printStackTrace();
		}
	}
	private void ajouteListeOptionFormation() {
		try {
			String [] tableFormations= new String[listFormations.list().size()];
			int i=0;
			for (Formation formation : listFormations.list()) {
				tableFormations[i]=formation.getLibelle();
				i++;
			}
			selectedOption.setModel(new DefaultComboBoxModel(tableFormations));
		} catch (BadFormatException e) {
			e.printStackTrace();
		}
	}
	
	public void showMe() {
		this.setVisible(true);
	}
}
