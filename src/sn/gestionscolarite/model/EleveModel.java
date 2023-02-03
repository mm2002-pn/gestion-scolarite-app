package sn.gestionscolarite.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class EleveModel  extends AbstractTableModel{
	private static final long serialVersionUID = 1L;

	private Vector<Object[]> rows = new Vector<Object[]>();
	private List<Eleve> eleves = new ArrayList<Eleve>();
	protected String [] columns = {"Id", "Nom", "Prenom", "Date de Naissance","Sexe","Formation"}; 

	@Override	
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {		
		Object [] obj = rows.get(rowIndex);
		return obj[columnIndex];
	}

	@Override
	public String getColumnName(int arg0) {
		return columns[arg0];
	}

	public void setEleves(List<Eleve> eleves) {
		clear ();

		this.eleves.addAll(eleves);


		for (Eleve eleve : eleves ) {
			rows.add( new Object [] {
					eleve.getIndentifiant(),
					eleve.getNom(), 
					eleve.getPrenom(), 
					eleve.getDateNaissance(),
					eleve.getSexe(),
					eleve.getFormation()
			});
		}

		fireTableDataChanged();
	}

	public void clear () {
		rows.clear();
		eleves.clear();

		fireTableDataChanged();
	}

	public List<Eleve> getProduits() {
		return eleves;
	}
}
