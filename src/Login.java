import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Login implements ActionListener {

	private static JLabel userLabel;
	private static JTextField userTxt;
	private static JLabel passLabel;
	private static JPasswordField passTxt;
	private static JButton loginButton;
	private static JButton resetButton;
	private static JButton newUserButton;
	private static JLabel success;
	private static JButton editPasswordButton;
	HashMap<String,String> loginInfo = new HashMap<String,String>();
	JFrame frame = new JFrame("Login Covid-19 App");
	JPanel panel = new JPanel();

	Login(HashMap<String,String>loginInfoOg) {

		loginInfo = loginInfoOg;

		// Set window size
		frame.setSize(450,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);

		// User-name Label
		userLabel = new JLabel("Username:");
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);

		// User-name text field
		userTxt = new JTextField(20);
		userTxt.setBounds(100, 20, 300, 25);
		panel.add(userTxt);

		// Password Label
		passLabel = new JLabel("Password:");
		passLabel.setBounds(10, 50, 80, 25);
		panel.add(passLabel);

		// Password text field (with privacy dots)
		passTxt = new JPasswordField(20);
		passTxt.setBounds(100, 50, 300, 25);
		panel.add(passTxt);

		// Submit button
		loginButton = new JButton("Submit!");
		loginButton.setBounds(100, 80, 130, 25);
		loginButton.addActionListener(this);
		panel.add(loginButton);

		//Edit Password Button
		editPasswordButton = new JButton("Edit Password");
		editPasswordButton.setBounds(270, 110, 130, 25);
		editPasswordButton.addActionListener(this);
		panel.add(editPasswordButton);

		// Reset button
		resetButton = new JButton("Reset");
		resetButton.setBounds(270, 80, 130, 25);
		resetButton.addActionListener(this);
		panel.add(resetButton);

		// New user button
		newUserButton = new JButton("New User");
		newUserButton.setBounds(100, 110, 130, 25);
		newUserButton.addActionListener(this);
		panel.add(newUserButton);

		// Display message
		success = new JLabel("");
		success.setBounds(100, 135, 300, 25);
		panel.add(success);


		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Action performed if reset button is pressed
		if(e.getSource()==resetButton) {
			resetButtonAction();
		}
		// Action performed if login button is pressed
		if(e.getSource()==loginButton) {
			loginAction();
		}
		// Action performed if new user button is pressed
		if (e.getSource() == newUserButton) {
			NewUserButtonAction();
		}
		if (e.getSource() == editPasswordButton){
			editPasswordAction();
		}
	}

	private void NewUserButtonAction(){
		success.setText("");
		userTxt.setText("");
		passTxt.setText("");

		// Opens create new user page
		frame.dispose();
		NewUserPage newuserpage = new NewUserPage(loginInfo);
	}
	private void resetButtonAction(){
		userTxt.setText(""); // empty text field
		passTxt.setText(""); // empty text field
	}
	private void loginAction(){

		success.setText("");
		// Get user-name and password
		String userID = userTxt.getText();
		String password = String.valueOf(passTxt.getPassword());

		// Check if user-name is in the database
		if(loginInfo.containsKey(userID)) {

			// Check if password matches the user-name
			if(loginInfo.get(userID).equals(password)) {
				success.setForeground(Color.green); // Color of message (Green)
				success.setText("Login Successful!"); // Login successful display message

				// Close login page and Display main page
				frame.dispose();
				mainPage mainPage = new mainPage(userID);
			}
			else {
				success.setForeground(Color.red);
				success.setText("Wrong Password");
			}

			// If user-name and password field is empty
		}else if(userID.isEmpty() && password.isEmpty()) {
			success.setForeground(Color.red); // Color of message (Red)
			success.setText("Fill All Fields"); // Display message
		}
		else {
			success.setForeground(Color.red);
			success.setText("Username Not Found");
		}

	}
	private void editPasswordAction(){
		String userID = userTxt.getText();
		if (userID != null){
			if(loginInfo.containsKey(userID)){
				// Opens edit password page
				frame.dispose();
				editPasswordPage newPasswordPage = new editPasswordPage(userID,loginInfo);
			}
			else {
				success.setText("User Doesn't Exist");
			}
		}
		else{
			success.setText("Please Enter a Username");
		}
	}
}