package sn.gestionscolarite.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import sn.connexionbassedonnes.app.ConnexionBasseDonne;
import sn.gestionexception.app.BadFormatException;
import sn.gestionexception.app.MissingDataException;
import sn.gestionscolarite.app.AutreMethodeDao;
import sn.gestionscolarite.model.Eleve;
import sn.gestionscolarite.utilisateur.Utilisateur;
import sn.scolarite.app.UIBulletinMananger;
import sn.scolarite.app.UIFenetreChoixSecretaire;

public class Authentification implements AutreMethodeDao<Utilisateur> {

	@Override
	public void authentification(String login, String password) throws BadFormatException {
		try (Connection connection = ConnexionBasseDonne.getConnection()) {	
			String query = "Select * From utilisateur where login=? and password=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.first()) {		
				String logins = rs.getString("login");
				String pwd = rs.getString("password");
				if(logins.equals(login) && pwd.equals(password)) {	
					//redirection
					UIFenetreChoixSecretaire fenetre= new UIFenetreChoixSecretaire();
					fenetre.showMe();
				}else {
					throw new BadFormatException("Mot de passe Ou Login Incorrect");
				}
			}else {
				throw new BadFormatException("Vous n'avez pas de compte ");
			}
		} catch (Exception e) {
			throw new BadFormatException(e.getMessage());
		}
	}
	
	@Override
	public void controleFormulaire(String login, String password) throws  BadFormatException,MissingDataException {
		if(login == null || login.length() == 0 || password == null || password.length() == 0) {
			throw new MissingDataException("Remplissez les champs vides ");
		}
		else if(login.length() <= 3 || password.length() <= 3) {
			throw new BadFormatException("Taille du Login ou du Mot de Passe Tros Petit");
		}		
	}

	@Override
	public List<Eleve> recherche(String login) throws BadFormatException {
		// TODO Auto-generated method stub
		return null;
	}

}
