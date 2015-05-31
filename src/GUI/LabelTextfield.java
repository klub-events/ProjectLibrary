package GUI;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
// smelter teksten og skrive feltet sammen
/**
 * Bruges for at lave et enkelt objekt som består af et JTextField og et JLabel. For at have et label foran et textfield<br>
 * for hurtig adgang, opsætning og brug.
 * 
 * extender JPanel, og ejer derfor alle metoder herfra.
 * @author PeterRaasthøj
 *
 */
@SuppressWarnings("serial")
public class LabelTextfield extends JPanel {
	JTextField textField = new JTextField();
	JLabel label = new JLabel();
	
	public LabelTextfield (String labeltext) {
		label.setText(labeltext);
		this.setLayout(new GridLayout(1, 4));
		this.add(new JLabel());
		this.add(label);
		this.add(textField);
		this.add(new JLabel());
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		textField.setFont(font1);
		
	}
	
	/**
	 * udfører textField.getText() funktionen.
	 * @return Inputtet fra LabelTextfielded
	 */
	public String getInputText() {
		return textField.getText();
	}

	/**
	 * Manuelt sætter teksten på LabelTextfielded
	 * <p>Tager en <b>String</b> som input</p>
	 * @param string
	 */
	public void setText(String string) {
		textField.setText(null);
	}

}
