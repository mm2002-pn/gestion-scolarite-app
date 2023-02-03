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
import sn.gestionscolarite.classes.Formation;

public class FormationDaoibd implements Dao<Formation> {

	@Override
	public void add(Formation obj) throws BadFormatException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Formation obj) throws BadFormatException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws BadFormatException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Formation> list() throws BadFormatException {
		List<Formation> formations = new ArrayList<>();
		try (Connection connection = ConnexionBasseDonne.getConnection()) {
			String query = "Select * From formation";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int identifiant = rs.getInt("id_formation");
				String libelle=rs.getString("libelle");
				Formation formation= new Formation(identifiant,libelle);
				formations.add(formation);
			}
		} catch (Exception e) {
			throw new BadFormatException(e.getMessage());
		}
		return formations;
	}

	@Override
	public Formation read(int id) throws BadFormatException {
		// TODO Auto-generated method stub
		return null;
	}

}
