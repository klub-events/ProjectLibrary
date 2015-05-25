package GUI;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
// smelter teksten og skrive feltet sammen
public class LabelTextfield extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public String getInputText() {
		return textField.getText();
	}

	public void setText(String string) {
		textField.setText("");
	}

}
