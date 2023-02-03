package sn.scolarite.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import sn.gestionexception.app.BadFormatException;
import sn.gestionscolarite.app.Dao;
import sn.gestionscolarite.classes.Classes;
import sn.gestionscolarite.classes.ClassesModel;
import sn.gestionscolarite.classes.Formation;
import sn.gestionscolarite.datasource.ClasseDaoibd;
import sn.gestionscolarite.datasource.ElevesDaoibd;
import sn.gestionscolarite.datasource.FormationDaoibd;
import sn.gestionscolarite.model.Eleve;
import sn.gestionscolarite.outils.Utilitaires;


public class UITableListClasseManager extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dao<Classes> listClasses;
	private Dao<Formation> listFormations;
	private Dao<Eleve> listeEleves;
	private JTable table_2;
	private ClassesModel classeModel;
	
	public UITableListClasseManager() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		try {
			createInstanceComponents ();
			initComponent();
		} catch (BadFormatException e) {}
	}

	
	private void createInstanceComponents() throws BadFormatException  {
		classeModel= new ClassesModel();
		listClasses= new ClasseDaoibd();
		listFormations=new FormationDaoibd();
		listeEleves =new ElevesDaoibd();
		classeModel.setProduits(listClasses.list());
	}
	public void initComponent() {
		
		setSize(new Dimension(574, 455));
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
		lblNewLabel.setIcon(new ImageIcon(UITableListClasseManager.class.getResource("/ressource/OIP.jpeg")));
		panel_1.add(lblNewLabel);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_5.getLayout();
		flowLayout_3.setHgap(50);
		panel_5.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Gestionnaire Scolarite");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBackground(new Color(46, 46, 46));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(10);
		panel.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Liste des Classes");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_23 = new JPanel();
		panel_23.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_14 = (FlowLayout) panel_23.getLayout();
		flowLayout_14.setVgap(15);
		panel_3.add(panel_23);

		JButton ajouteBt = new JButton("Liste Eleves");
		ajouteBt.setPreferredSize(new Dimension(150, 30));
		ajouteBt.setBackground(new Color(46, 46, 46));
		ajouteBt.setForeground(new Color(255, 255, 255));
		ajouteBt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		ajouteBt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_23.add(ajouteBt);

		JPanel panel_24 = new JPanel();
		panel_24.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_15 = (FlowLayout) panel_24.getLayout();
		flowLayout_15.setVgap(15);
		panel_3.add(panel_24);

		JButton quiiterBtn = new JButton("Quitter");
		quiiterBtn.setPreferredSize(new Dimension(150, 30));
		quiiterBtn.setForeground(new Color(255, 255, 255));
		quiiterBtn.setBackground(new Color(46, 46, 46));
		quiiterBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				onQuitterClick();
			}
		});
		quiiterBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_24.add(quiiterBtn);

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setVgap(10);
		getContentPane().add(panel_4, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(243, 243, 243));
		scrollPane.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(350, 212));
		panel_4.add(scrollPane);

		table_2 = new JTable();
		table_2.setRowHeight(20);
		table_2.setRowMargin(3);
		table_2.setBorder(null);
		table_2.setBackground(new Color(243, 243, 243));
		table_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		table_2.setModel(classeModel);
		table_2.setPreferredSize(new Dimension(80, 183));
		scrollPane.setViewportView(table_2);
		Utilitaires.center(this, getSize());
		
		
	}
	private void onQuitterClick() {
		UIFenetreChoixSecretaire choix= new UIFenetreChoixSecretaire();
		choix.showMe();
		dispose();
	}
	
	
	public void showMe() {
		this.setVisible(true);
	}
}
