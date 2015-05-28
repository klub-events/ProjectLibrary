package Domain;

import javax.swing.table.DefaultTableModel;

public class ClosedCellTableModel extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int column) {
       return false;
    }
}
