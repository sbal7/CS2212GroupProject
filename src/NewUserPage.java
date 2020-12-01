import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewUserPage implements ActionListener {
	
	private static JLabel newUserLabel;
	private static JTextField newUserTxt;
	private static JLabel newPassLabel;
	private static JPasswordField newPassTxt;
	private static JButton okButton;
	private static JButton resetButton;
	private static JLabel msg;
	HashMap<String,String> loginInfo = new HashMap<String,String>();
	JFrame frame = new JFrame("Create New User Covid-19 App");
	JPanel panel = new JPanel();
	
	NewUserPage(HashMap<String,String>loginInfoNew) {
		
		loginInfo = loginInfoNew;
		
		// Set window size
		frame.setSize(350,160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);
		
		//  New user-name Label
		newUserLabel = new JLabel("New Username:");
		newUserLabel.setBounds(10, 20, 100, 25);
		panel.add(newUserLabel);
		
		// New user-name text field 
		newUserTxt = new JTextField(20);
		newUserTxt.setBounds(120, 20, 200, 25);
		panel.add(newUserTxt);
		
		// New password Label
		newPassLabel = new JLabel("New Password:");
		newPassLabel.setBounds(10, 50, 100, 25);
		panel.add(newPassLabel);
		
		// new password text field (with privacy dots)
		newPassTxt = new JPasswordField(20);
		newPassTxt.setBounds(120, 50, 200, 25);
		panel.add(newPassTxt);
		
		// Create new user button
		okButton = new JButton("Create!");
		okButton.setBounds(118, 80, 80, 25);
		okButton.addActionListener(this);
		panel.add(okButton); 
		
		// Reset button
		resetButton = new JButton("Reset");
		resetButton.setBounds(242, 80, 80, 25);
		resetButton.addActionListener(this);
		panel.add(resetButton);
		
		// Display message
		msg = new JLabel("");
		msg.setBounds(10, 110, 300, 25);
		panel.add(msg);
		
		frame.setVisible(true);	
	}
	
	@Override
	public void actionPerformed(ActionEvent act) {
		
		// Action performed if reset button is pressed 
		if(act.getSource()==resetButton) {
			newUserTxt.setText(""); // empty text field
			newPassTxt.setText(""); // empty text field
		}
		// Action performed if create button is pressed 
		if(act.getSource()== okButton) {
			
			// Get user-name and password
			String user = newUserTxt.getText();
			String pass = String.valueOf(newPassTxt.getPassword());
			
			// If user-name or password field is empty 
			if(user.isEmpty() || pass.isEmpty()) {
				msg.setForeground(Color.red); // Color of message (Red)
				msg.setText("Fill All Fields"); // Display message
			}
			// Check if user-name already exists in database 
			else if(loginInfo.containsKey(user)) {
				msg.setForeground(Color.red); 
				msg.setText("Username Already Exists"); // User-name exists display message
			}
			// Add new user to the database and close create new user page 
			else {
				loginInfo.put(user,pass);
				msg.setForeground(Color.green);
				msg.setText("User Created!");
				frame.dispose();
			}
		}	
	}
}
