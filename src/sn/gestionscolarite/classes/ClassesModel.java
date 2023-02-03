package sn.gestionscolarite.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class ClassesModel  extends AbstractTableModel{
	private static final long serialVersionUID = 1L;

	private Vector<Object[]> rows = new Vector<Object[]>();
	private List<Classes> classes = new ArrayList<Classes>();
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

	public void setProduits(List<Classes> classes) {
		clear ();

		this.classes.addAll(classes);


		for (Classes classe : classes ) {
			rows.add( new Object [] {
					classe.getId(),
					    classe.getLibelle()
			});
		}

		fireTableDataChanged();
	}

	public void clear () {
		rows.clear();
		classes.clear();

		fireTableDataChanged();
	}

	public List<Classes> getProduits() {
		return classes;
	}
}
