import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener {
	
	private static JLabel userLabel;
	private static JTextField userTxt;
	private static JLabel passLabel;
	private static JPasswordField passTxt;
	private static JButton button;
	private static JLabel success;

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setSize(350,160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		panel.setLayout(null);
		
		userLabel = new JLabel("Username:");
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		
		userTxt = new JTextField(20);
		userTxt.setBounds(100, 20, 200, 25);
		panel.add(userTxt);
		
		passLabel = new JLabel("Password:");
		passLabel.setBounds(10, 50, 80, 25);
		panel.add(passLabel);
		
		passTxt = new JPasswordField(20);
		passTxt.setBounds(100, 50, 200, 25);
		panel.add(passTxt);
		
		button = new JButton("Submit!");
		button.setBounds(90, 80, 80, 25);
		button.addActionListener(new Login());
		panel.add(button);
		
		success = new JLabel("");
		success.setBounds(10, 110, 300, 25);
		panel.add(success);
		
		
		frame.setVisible(true);
		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String user = userTxt.getText();
		String password = passTxt.getText();
		System.out.println(user + "," + password);
		
		if(user.equals("sunny") && password.equals("cs2212")) {
			success.setText("Login Successful!");
		}else {
			success.setText("INVALID LOGIN!");
		}
		
	}

}
