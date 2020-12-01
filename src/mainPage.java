
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class mainPage implements ActionListener{

	private static JFrame frame;
	private static JLabel lblAddACountry;
	private static JLabel lblRemoveACountry;
	private static JButton addCountryButton;
	private static JButton removeCountryButton;
	private static JComboBox addCountryBox;
	private static JLabel lblOutput;
	private static JTextArea outputPanel;
	private static JTextArea listOfSelectedCountriesPanel;
	private static JLabel lblAnalysisMethod;
	private static JComboBox removeCountryBox;
	private static JComboBox analysisBox;
	private static JLabel listOfSelectedCountriesBox;
	private static JButton recalculateButton;
	
	mainPage(String userID) {
	
		//creates a window
		frame = new JFrame("COVID-19 Stats");
		frame.setBounds(1350, 1000, 1300, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//creates a label and puts a map jpg on main GUI
		JLabel map = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/map1.jpg")).getImage();
		map.setIcon(new ImageIcon(img));
		map.setBounds(17, 89, 1034, 587);
		frame.getContentPane().add(map);
		
		//creates a add country button
		addCountryButton = new JButton("+");
		addCountryButton.addActionListener(this);
		addCountryButton.setBounds(467, 61, 58, 29);
		frame.getContentPane().add(addCountryButton);
		
		//add country text 
		lblAddACountry = new JLabel("Add a Country");
		lblAddACountry.setBounds(74, 66, 103, 16);
		frame.getContentPane().add(lblAddACountry);
		
		//remove country label
		lblRemoveACountry = new JLabel("Remove a Country");
		lblRemoveACountry.setBounds(537, 66, 122, 16);
		frame.getContentPane().add(lblRemoveACountry);
		
		//remove country button
		removeCountryButton = new JButton("-");
		removeCountryButton.addActionListener(this);
		removeCountryButton.setBounds(952, 61, 58, 29);
		frame.getContentPane().add(removeCountryButton);
		
		
		//drop down/ type box for add country
		addCountryBox = new JComboBox();
		addCountryBox.setEditable(true);
		addCountryBox.setBounds(170, 62, 300, 27);
		frame.getContentPane().add(addCountryBox);
		
		//drop down/type box for remove country
		removeCountryBox = new JComboBox();
		removeCountryBox.setEditable(true);
		removeCountryBox.setBounds(654, 62, 300, 27);
		frame.getContentPane().add(removeCountryBox);
		
		//drop down for analysis
		analysisBox = new JComboBox();
		analysisBox.setBounds(482, 665, 103, 27);
		frame.getContentPane().add(analysisBox);
		
		//text for list of selected countries
		listOfSelectedCountriesBox = new JLabel("List Of Selected Countries");
		listOfSelectedCountriesBox.setBounds(1091, 104, 163, 16);
		frame.getContentPane().add(listOfSelectedCountriesBox);
		
		//recalculate button
		recalculateButton = new JButton("Recalculate");
		recalculateButton.addActionListener(this);
		recalculateButton.setBounds(1116, 437, 117, 29);
		frame.getContentPane().add(recalculateButton);
		
		//output text
		lblOutput = new JLabel("Output");
		lblOutput.setBounds(1149, 466, 61, 16);
		frame.getContentPane().add(lblOutput);
		
		//choose analysis text
		lblAnalysisMethod = new JLabel("Choose Analysis Method");
		lblAnalysisMethod.setBounds(307, 669, 163, 16);
		frame.getContentPane().add(lblAnalysisMethod);
		
		//list of selected countries panel
		listOfSelectedCountriesPanel = new JTextArea();
		listOfSelectedCountriesPanel.setBounds(1063, 132, 219, 292);
		frame.getContentPane().add(listOfSelectedCountriesPanel);
		
		//output panel
		outputPanel = new JTextArea();
		outputPanel.setBounds(1063, 494, 219, 150);
		frame.getContentPane().add(outputPanel);
		
		frame.setVisible(true);
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
