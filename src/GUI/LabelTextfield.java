package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	}
	
	public String getInputText() {
		return textField.getText();
	}

}
