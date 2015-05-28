package Domain;

import javax.swing.table.DefaultTableModel;

public class ClosedColumnTableModel extends DefaultTableModel {

	@Override
	public boolean isCellEditable(int row, int col) {
		boolean editable = (col != 0);
		return editable;
	}
}
