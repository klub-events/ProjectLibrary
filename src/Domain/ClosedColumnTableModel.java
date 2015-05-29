package Domain;

import javax.swing.table.DefaultTableModel;

public class ClosedColumnTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean isCellEditable(int row, int col) {
		boolean editable = (col != 0);
		return editable;
	}
}
