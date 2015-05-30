package Domain;

import javax.swing.table.DefaultTableModel;

/**
 * Bruges for at gøre alle celler i et JTable uskrivelige. Extender DefaultTableModel, så ejer alle yderlige metoder herfra.
 * @author PeterRaasthøj
 *
 */
public class ClosedCellTableModel extends DefaultTableModel {
	@Override
    public boolean isCellEditable(int row, int column) {
       return false;
    }
}
