package Domain;

import javax.swing.table.DefaultTableModel;

public class ClosedCellTableModel extends DefaultTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public boolean isCellEditable(int row, int column) {
       return false;
    }
}
