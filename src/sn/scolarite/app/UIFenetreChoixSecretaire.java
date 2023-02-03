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

import sn.gestionexception.app.BadFormatException;
import sn.gestionscolarite.outils.Utilitaires;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;

public class UIFenetreChoixSecretaire extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public UIFenetreChoixSecretaire() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		try {
			createInstanceComponents();
			initComponent();
		} catch (BadFormatException e) {
		}
	}

	private void createInstanceComponents() throws BadFormatException {

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

		JButton quiterBtn = new JButton("Quitter");
		quiterBtn.setPreferredSize(new Dimension(150, 30));
		quiterBtn.setForeground(new Color(255, 255, 255));
		quiterBtn.setBackground(new Color(46, 46, 46));
		quiterBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_24.add(quiterBtn);

		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(2, 2, 0, 0));

		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_10 = new JPanel();
		panel_6.add(panel_10);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(null);
		lblNewLabel_2.setIcon(
				new ImageIcon(UIFenetreChoixSecretaire.class.getResource("/ressource/utilisateur (2).png")));
		panel_10.add(lblNewLabel_2);

		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9);

		JButton boutonAjouterEleve = new JButton("Ajouter");
		boutonAjouterEleve.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		boutonAjouterEleve.setForeground(new Color(255, 255, 255));
		boutonAjouterEleve.setBackground(new Color(46, 46, 46));
		boutonAjouterEleve.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				onBouttonAjoutEleveClick();
			}
		});
		boutonAjouterEleve.setPreferredSize(new Dimension(150, 30));
		panel_9.add(boutonAjouterEleve);

		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_12 = new JPanel();
		panel_5.add(panel_12);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(
				new ImageIcon(UIFenetreChoixSecretaire.class.getResource("/ressource/liste-de-souhaits.png")));
		panel_12.add(lblNewLabel_3);

		JPanel panel_11 = new JPanel();
		panel_5.add(panel_11);

		JButton boutonListerClasse = new JButton("Liste Classe");
		boutonListerClasse.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		boutonListerClasse.setForeground(new Color(255, 255, 255));
		boutonListerClasse.setBackground(new Color(46, 46, 46));
		boutonListerClasse.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				onBoutonListerClasseClick();
			}
		});
		boutonListerClasse.setPreferredSize(new Dimension(150, 30));
		panel_11.add(boutonListerClasse);

		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		panel_7.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_13 = new JPanel();
		panel_7.add(panel_13);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(
				new ImageIcon(UIFenetreChoixSecretaire.class.getResource("/ressource/qualifications.png")));
		panel_13.add(lblNewLabel_5);

		JPanel panel_14 = new JPanel();
		panel_7.add(panel_14);

		JButton boutonPrepareBulletin = new JButton("Preparer Bulletin");
		boutonPrepareBulletin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		boutonPrepareBulletin.setForeground(new Color(255, 255, 255));
		boutonPrepareBulletin.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		boutonPrepareBulletin.setBackground(new Color(46, 46, 46));
		boutonPrepareBulletin.setPreferredSize(new Dimension(150, 30));
		panel_14.add(boutonPrepareBulletin);

		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		panel_8.setLayout(new GridLayout(2, 0, 0, 0));

		JPanel panel_16 = new JPanel();
		panel_8.add(panel_16);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(UIFenetreChoixSecretaire.class.getResource("/ressource/id.png")));
		panel_16.add(lblNewLabel_4);

		JPanel panel_15 = new JPanel();
		panel_8.add(panel_15);

		JButton boutonListerEleve = new JButton("LIste Eleve");
		boutonListerEleve.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		boutonListerEleve.setForeground(new Color(255, 255, 255));
		boutonListerEleve.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				onListerEleveClick();
				
			}
		});
		boutonListerEleve.setBackground(new Color(46, 46, 46));
		boutonListerEleve.setPreferredSize(new Dimension(150, 30));
		panel_15.add(boutonListerEleve);

		Utilitaires.center(this, getSize());
	}
	public void onListerEleveClick() {
		UIListeEleveMananger liste = new UIListeEleveMananger();
		liste.showMe();
		dispose();
	}
	public void onBouttonAjoutEleveClick() {
		UIFormEleveManager formulaireAjout= new UIFormEleveManager();
		formulaireAjout.showMe();
		dispose();
	}
	public void onBoutonListerClasseClick() {
		UITableListClasseManager listeClasse= new UITableListClasseManager();
		listeClasse.showMe();
		dispose();
	}
	public void showMe() {
		this.setVisible(true);
	}
}
