package sn.gestionscolarite.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sn.connexionbassedonnes.app.ConnexionBasseDonne;
import sn.gestionexception.app.BadFormatException;
import sn.gestionscolarite.app.Dao;
import sn.gestionscolarite.classes.Classes;

public class ClasseDaoibd implements Dao<Classes> {

	@Override
	public void add(Classes obj) throws BadFormatException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Classes obj) throws BadFormatException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws BadFormatException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Classes> list() throws BadFormatException {
		List<Classes> classes = new ArrayList<>();
		try (Connection connection = ConnexionBasseDonne.getConnection()) {
			String query = "Select * From classe";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int identifiant = rs.getInt("id_classe");
				String libelle=rs.getString("libelle");
				Classes classe= new Classes(identifiant,libelle);
				classes.add(classe);
			}
		} catch (Exception e) {
			throw new BadFormatException(e.getMessage());
		}
		return classes;
	}

	@Override
	public Classes read(int id) throws BadFormatException {
		// TODO Auto-generated method stub
		return null;
	}

}
