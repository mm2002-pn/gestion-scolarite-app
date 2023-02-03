package sn.gestionscolarite.datasource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import sn.connexionbassedonnes.app.ConnexionBasseDonne;
import sn.gestionexception.app.BadFormatException;
import sn.gestionscolarite.app.Dao;
import sn.gestionscolarite.model.Eleve;

public class ElevesDaoibd implements Dao<Eleve> {

	@Override
	public void add(Eleve obj) throws BadFormatException {
		try (Connection connection = ConnexionBasseDonne.getConnection()) {
			String query = "Insert into eleve (nom, prenom,date_naiss,sexe,formation,classe) values (?,?,?,?,?,?)"; 
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, obj.getNom());
			ps.setString(2, obj.getPrenom());
			ps.setDate(3, Date.valueOf(obj.getDateNaissance()));
			ps.setString(4, String.valueOf(obj.getSexe()));
			ps.setString(5, obj.getFormation());
			ps.setString(6, obj.getClasse());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new BadFormatException(e.getMessage());
		}		
	}

	@Override
	public void update(Eleve obj) throws BadFormatException {
		try (Connection connection = ConnexionBasseDonne.getConnection()) {
			String query = "Update produit Set nom=?, prix=?,solde=?,typeproduit=? Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,"");
			ps.setDouble(2, 0);
			ps.setInt(5, 0);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new BadFormatException(e.getMessage());
		}		
	}



	@Override
	public void delete(int id) throws BadFormatException {
		try (Connection connection = ConnexionBasseDonne.getConnection()) {
			String query = "Delete From produit Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new BadFormatException(e.getMessage());
		}		
	}

	@Override
	public List<Eleve> list() throws BadFormatException {
		List<Eleve> eleves = new ArrayList<>();
		try (Connection connection = ConnexionBasseDonne.getConnection()) {
			String query = "Select * From eleve";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int identifiant = rs.getInt("id_eleve");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String dateNaiss = rs.getString("date_naiss");
				LocalDate dateNaissance = LocalDate.parse(dateNaiss);
				String formation = rs.getString("formation");
				String sexe = rs.getString("sexe");
				char sexeToChar = sexe.charAt(0);
				String clase = rs.getString("classe");
				
				Eleve eleve = new Eleve(identifiant, nom, prenom, dateNaissance, formation, sexeToChar, clase);
				eleves.add(eleve);
			}
		} catch (Exception e) {
			throw new BadFormatException(e.getMessage());
		}
		return eleves;
	}

	@Override
	public Eleve read(int id) throws BadFormatException {
		try (Connection connection = ConnexionBasseDonne.getConnection()) {
			String query = "Select * From eleve where id_eleve=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				int identifiant = rs.getInt("id_eleve");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String dateNaiss = rs.getString("date_naiss");
				LocalDate dateNaissance = LocalDate.parse(dateNaiss);
				String formation = rs.getString("formation");
				String sexe = rs.getString("sexe");
				char sexeToChar = sexe.charAt(0);
				String clase = rs.getString("classe");
				
				Eleve eleve = new Eleve(identifiant, nom, prenom, dateNaissance, formation, sexeToChar, clase);
				return eleve;
			}
		} catch (Exception e) {
			throw new BadFormatException(e.getMessage());
		}
		return null;
	}



}
