package sn.scolarite.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import sn.gestionexception.app.BadFormatException;
import sn.gestionscolarite.app.AutreMethodeDao;
import sn.gestionscolarite.app.Dao;
import sn.gestionscolarite.classes.Classes;
import sn.gestionscolarite.datasource.AutreMethodeDaoibd;
import sn.gestionscolarite.datasource.ClasseDaoibd;
import sn.gestionscolarite.datasource.ElevesDaoibd;
import sn.gestionscolarite.model.Eleve;
import sn.gestionscolarite.model.EleveModel;
import sn.gestionscolarite.outils.Utilitaires;

public class UIListeEleveMananger extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private AutreMethodeDao<Eleve> listEleves;
	private EleveModel eleveModel;
	private Dao<Classes> listClasses;
	private JComboBox selectedOption_1;

	public UIListeEleveMananger() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		try {
			createInstanceComponents();
			initComponent();
		} catch (BadFormatException e) {
		}
	}

	private void createInstanceComponents() throws BadFormatException {
		eleveModel = new EleveModel();
		listClasses=new ClasseDaoibd();
		listEleves = new AutreMethodeDaoibd();	
		//eleveModel.setEleves(listEleves.list());
	}

	public void initComponent() {

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
		lblNewLabel.setIcon(new ImageIcon(UIFenetreChoixSecretaire.class.getResource("/ressource/OIP.jpeg")));
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

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_23 = new JPanel();
		panel_23.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_14 = (FlowLayout) panel_23.getLayout();
		flowLayout_14.setVgap(15);
		panel_3.add(panel_23);

		JButton bulletinAjoutBtn = new JButton("Preparer Bulletin");
		bulletinAjoutBtn.setPreferredSize(new Dimension(160, 30));
		bulletinAjoutBtn.setBackground(new Color(46, 46, 46));
		bulletinAjoutBtn.addActionListener(new  ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				onPreparerBulletinClick();
			}
		});
		bulletinAjoutBtn.setForeground(new Color(255, 255, 255));
		bulletinAjoutBtn.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		panel_23.add(bulletinAjoutBtn);

		JPanel panel_24 = new JPanel();
		panel_24.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_15 = (FlowLayout) panel_24.getLayout();
		flowLayout_15.setVgap(15);
		panel_3.add(panel_24);

		JButton quiterBtn = new JButton("Quitter");
		quiterBtn.setPreferredSize(new Dimension(160, 30));
		quiterBtn.setForeground(new Color(255, 255, 255));
		quiterBtn.setBackground(new Color(46, 46, 46));
		quiterBtn.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				onQuitterClick();
			}
		});
		quiterBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_24.add(quiterBtn);

		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(46, 46, 46));
		FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_4.add(panel_5, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("Liste des Eleves de la Classe : ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_5.add(lblNewLabel_2);
		
		selectedOption_1 = new JComboBox();
		selectedOption_1.setBackground(new Color(255, 255, 255));
		selectedOption_1.setForeground(new Color(0, 0, 0));
		selectedOption_1.setPreferredSize(new Dimension(150, 22));
		selectedOption_1.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				 JComboBox cb = (JComboBox)e.getSource();
			     String classes = (String)cb.getSelectedItem();
			     oneSelectedClasse(classes);   
			}
		});
		ajoutListeOptionClasse();
		panel_5.add(selectedOption_1);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(550, 250));
		panel_6.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBackground(new Color(239, 239, 239));
		scrollPane.setViewportView(table);
		table.setModel(eleveModel);
		Utilitaires.center(this, getSize());
	}
	private void onPreparerBulletinClick() {	
		int row= table.getSelectedRow();
		if (row==-1) {
			JOptionPane.showMessageDialog(null, "Veuillez s�lectionner un eleve !");
		}else {
			int id = (int) eleveModel.getValueAt(row, 0);
			JOptionPane.showMessageDialog(null, id);
			UIBulletinMananger bulletin= new UIBulletinMananger(id);
			bulletin.showMe();
			dispose();
		}
		
	}
	public void showMe() {
		this.setVisible(true);
	}
	private void onQuitterClick() {
		UIFenetreChoixSecretaire choix= new UIFenetreChoixSecretaire();
		choix.showMe();
		dispose();
	}
	private void oneSelectedClasse(String classeParm) {
		try {	
			eleveModel.setEleves(listEleves.recherche(classeParm));
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
	
	
	
}
