package sn.connexionbassedonnes.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import sn.gestionexception.app.BadFormatException;

public class ConnexionBasseDonne {
	private static Connection connection = null;
	public static Connection getConnection () throws BadFormatException{
		try {
			// Chargement du driver jdbc mysql
			Class.forName ("com.mysql.cj.jdbc.Driver");
			// Ouverture de la connexion
			connection = DriverManager.getConnection ("jdbc:mysql://localhost/scolarite_db","root","");
			return connection;
		} catch (ClassNotFoundException e) {
			throw new BadFormatException ("Driver Class not found : '" + e.getMessage () + "' ");
		} catch (SQLException e) {
			throw new BadFormatException ("Error : Unable to open connection with database !");
		}
	}
}
