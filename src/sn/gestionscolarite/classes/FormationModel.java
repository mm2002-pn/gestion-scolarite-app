package sn.gestionscolarite.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class FormationModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	private Vector<Object[]> rows = new Vector<Object[]>();
	private List<Formation> formations = new ArrayList<Formation>();
	protected String [] columns = {"Id", "Libelle"}; 

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

	public void setProduits(List<Formation> formations) {
		clear ();

		this.formations.addAll(formations);


		for (Formation formation : formations ) {
			rows.add( new Object [] {
					formation.getId(),
					formation.getLibelle()
			});
		}

		fireTableDataChanged();
	}

	public void clear () {
		rows.clear();
		formations.clear();

		fireTableDataChanged();
	}

	public List<Formation> getProduits() {
		return formations;
	}
}
