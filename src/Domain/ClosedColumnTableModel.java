package Domain;

import javax.swing.table.DefaultTableModel;

/**
 * Bruges istedet for DefaultTableModel for at gører første kolonne i et JTable umuligt at skrive i<br>
 * Brugbart for at sikrer at id'et på diverse objekter ikke kan ændres. Extender DefaultTableModel, så ejer alle yderlige metoder herfra.
 * @author PeterRaasthøj
 *
 */
@SuppressWarnings("serial")
public class ClosedColumnTableModel extends DefaultTableModel {
	@Override
	public boolean isCellEditable(int row, int col) {
		boolean editable = (col != 0);
		return editable;
	}
}
