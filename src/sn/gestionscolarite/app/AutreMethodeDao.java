package sn.gestionscolarite.app;

import java.util.List;



import sn.gestionexception.app.BadFormatException;
import sn.gestionexception.app.MissingDataException;
import sn.gestionscolarite.model.Eleve;

public interface AutreMethodeDao <T> {
	public void authentification(String login , String password) throws BadFormatException;
	public void controleFormulaire(String login , String password) throws  BadFormatException,MissingDataException;
	public List<Eleve> recherche (String login) throws BadFormatException;

}
