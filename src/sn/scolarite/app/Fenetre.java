package sn.scolarite.app;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import sn.gestionexception.app.BadFormatException;
import sn.gestionexception.app.MissingDataException;
import sn.gestionscolarite.app.AutreMethodeDao;
import sn.gestionscolarite.datasource.Authentification;
import sn.gestionscolarite.outils.Utilitaires;
import sn.gestionscolarite.utilisateur.Utilisateur;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Cursor;

public class Fenetre extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField loginTf;
	private JPasswordField passwordField;
	private AutreMethodeDao<Utilisateur> authentification;
	private JTextPane errorTf;
	private JButton exitBtn;
	public Fenetre() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		authentification =new Authentification();

		setSize(new Dimension(422, 386));
		getContentPane().setSize(new Dimension(436, 340));
		getContentPane().setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(0);
		panel_3.setBackground(new Color(255, 255, 255));
		panel.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Fenetre.class.getResource("/ressource/imagelogo.png")));
		panel_3.add(lblNewLabel);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 255, 255));
		panel.add(panel_12, BorderLayout.CENTER);
		panel_12.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_13 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_13.getLayout();
		flowLayout_8.setVgap(0);
		panel_13.setBackground(new Color(255, 255, 255));
		panel_12.add(panel_13);
		
		JLabel lblNewLabel_4 = new JLabel("User Login");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel_13.add(lblNewLabel_4);
		
		JPanel panel_14 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_14.getLayout();
		flowLayout_3.setHgap(30);
		panel_14.setBackground(new Color(255, 255, 255));
		panel_12.add(panel_14);
		
		errorTf = new JTextPane();
		errorTf.setForeground(new Color(255, 28, 28));
		errorTf.setEditable(false);
		errorTf.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		errorTf.setPreferredSize(new Dimension(300, 20));
		panel_14.add(errorTf);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_7.getLayout();
		flowLayout_6.setVgap(7);
		panel_7.setBackground(new Color(255, 255, 255));
		panel_4.add(panel_7);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLogin.setBackground(new Color(46, 46, 46));
		btnLogin.setPreferredSize(new Dimension(300, 30));
		btnLogin.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				validerLoginbd();				
			}
		});
		panel_7.add(btnLogin);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setVgap(3);
		panel_8.setBackground(new Color(255, 255, 255));
		panel_4.add(panel_8);
		
		exitBtn = new JButton("Exit");
		exitBtn.setForeground(new Color(255, 255, 255));
		exitBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		exitBtn.setSelectedIcon(null);
		exitBtn.setBackground(new Color(46, 46, 46));
		exitBtn.setPreferredSize(new Dimension(300, 30));
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				hideVisible();
				
			}
		});
		panel_8.add(exitBtn);
		
		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(10, 140));
		panel_5.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(238, 238, 238));
		panel_5.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9, BorderLayout.WEST);
		panel_9.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(238, 238, 238));
		FlowLayout flowLayout_2 = (FlowLayout) panel_10.getLayout();
		flowLayout_2.setHgap(40);
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_9.add(panel_10);
		
		JLabel lblNewLabel_2 = new JLabel("Login :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_10.add(lblNewLabel_2);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(238, 238, 238));
		FlowLayout flowLayout_4 = (FlowLayout) panel_11.getLayout();
		flowLayout_4.setHgap(20);
		panel_9.add(panel_11);
		
		loginTf = new JTextField();
		loginTf.setPreferredSize(new Dimension(7, 25));
		panel_11.add(loginTf);
		loginTf.setColumns(13);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 15));
		panel_2.setBackground(new Color(238, 238, 238));
		panel_5.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_2.add(panel_15, BorderLayout.WEST);
		panel_15.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(238, 238, 238));
		FlowLayout flowLayout_1 = (FlowLayout) panel_16.getLayout();
		flowLayout_1.setVgap(7);
		flowLayout_1.setHgap(40);
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_15.add(panel_16);
		
		JLabel lblNewLabel_3 = new JLabel("Password :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_16.add(lblNewLabel_3);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(238, 238, 238));
		FlowLayout flowLayout_5 = (FlowLayout) panel_17.getLayout();
		flowLayout_5.setVgap(7);
		flowLayout_5.setHgap(20);
		panel_15.add(panel_17);
		
		passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(7, 25));
		passwordField.setColumns(13);
		panel_17.add(passwordField);
		Utilitaires.center(this, getSize());
	}

	private void reinitProductDetailsForm () {
		this.loginTf.setText(null);
		this.passwordField.setText(null);
	}

	public void showMe() {
		this.setVisible(true);
	}
	public void hideVisible() {
		dispose();
	}
	public void cacherFentre() {
		this.setVisible(false);
	}
	private void validerLoginbd() {
		char [] passwordChar=passwordField.getPassword();
		String password = String.valueOf(passwordChar);
		try {
			authentification.controleFormulaire(loginTf.getText(), password);
			try {
				authentification.authentification(loginTf.getText(), password);
				this.cacherFentre();
			} catch (BadFormatException e) {
				reinitProductDetailsForm();
				errorTf.setText("mot de passe  corresponde pas");
			}
		} catch (MissingDataException | BadFormatException e) {
			    errorTf.setText("Champs vide ou mot de passe faible");
		}
		
		
	}

}
	