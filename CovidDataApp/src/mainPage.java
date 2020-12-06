import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


public class mainPage implements ActionListener {

    private static JFrame frame;
    private static JLabel lblAddACountry;
    private static JLabel lblRemoveACountry;
    private static JButton addCountryButton;
    private static JButton removeCountryButton;
    private static JComboBox<String> addCountryBox;
    private static JLabel lblOutput;
    private static JTextArea outputPanel;
    private static JTextArea listOfSelectedCountriesPanel;
    private static JLabel lblAnalysisMethod;
    private static JComboBox<String> removeCountryBox;
    private static JComboBox<String> analysisBox;
    private static JLabel listOfSelectedCountriesBox;
    private static JButton recalculateButton;
    private static ArrayList<String> countryList = new ArrayList<>();
    private static String[] countries;
    private static Country[] countryArray;
    private static JButton logoutButton;

    mainPage() {

        //Imports Country Array
        countryDataImport data = new countryDataImport();
        countryArray = data.getCountryArray();
        countries = new String[countryArray.length];

        //creates a window
        frame = new JFrame("COVID-19 Stats");
        frame.setBounds(75, 120, 1260, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        //creates a label and puts a map jpg on main GUI
        JLabel map = new JLabel("");
        File file = new File("imgs//map.jpg");
        try{
            Image img = ImageIO.read(file);
            map.setIcon(new ImageIcon(img));
        }
        catch (Exception e){
            System.out.println("Error reading map");
        }
        map.setBounds(17, 20, 1034, 587);
        frame.getContentPane().add(map);

        //creates a add country button
        addCountryButton = new JButton("+");
        addCountryButton.addActionListener(this);
        addCountryButton.setBounds(467, 10, 58, 29);
        frame.getContentPane().add(addCountryButton);

        //add country text
        lblAddACountry = new JLabel("Add a Country:");
        lblAddACountry.setBounds(74, 15, 103, 16);
        frame.getContentPane().add(lblAddACountry);

        //remove country label
        lblRemoveACountry = new JLabel("Remove a Country:");
        lblRemoveACountry.setBounds(537, 15, 122, 16);
        frame.getContentPane().add(lblRemoveACountry);

        //remove country button
        removeCountryButton = new JButton("-");
        removeCountryButton.addActionListener(this);
        removeCountryButton.setBounds(952, 10, 58, 29);
        frame.getContentPane().add(removeCountryButton);

        //remove country button
        logoutButton = new JButton("Log Out");
        logoutButton.setFont(new Font("Dialog", Font.BOLD, 13));
        logoutButton.addActionListener(this);
        logoutButton.setBounds(1070, 11, 110, 25);
        frame.getContentPane().add(logoutButton);

        //drop down/ type box for add country
        for (int i = 0; i < countryArray.length; i++) {
            countries[i] = countryArray[i].getName();
        }
        addCountryBox = new JComboBox<>(countries);
        addCountryBox.setEditable(true);
        addCountryBox.setBounds(170, 10, 300, 25);
        frame.getContentPane().add(addCountryBox);

        //drop down/type box for remove country
        removeCountryBox = new JComboBox();
        removeCountryBox.setEditable(true);
        removeCountryBox.setBounds(654, 10, 300, 25);
        frame.getContentPane().add(removeCountryBox);

        //drop down for analysis
        String[] analysis = new String[]{"Total Covid Cases", "Cases per Capita", "Growth Rate", "Total Male Cases", "Total Female Cases", "Male Cases Per Capita", "Female Cases Per Capita"};
        analysisBox = new JComboBox<>(analysis);
        analysisBox.setBounds(482, 585, 180, 27);
        frame.getContentPane().add(analysisBox);

        //text for list of selected countries
        listOfSelectedCountriesBox = new JLabel("List Of Selected Countries:");
        listOfSelectedCountriesBox.setBounds(1050, 45, 170, 16);
        frame.getContentPane().add(listOfSelectedCountriesBox);

        //recalculate button
        recalculateButton = new JButton("Recalculate");
        recalculateButton.addActionListener(this);
        recalculateButton.setBounds(1070, 360, 117, 29);
        frame.getContentPane().add(recalculateButton);

        //output text
        lblOutput = new JLabel("Output:");
        lblOutput.setBounds(1105, 390, 61, 16);
        frame.getContentPane().add(lblOutput);

        //choose analysis text
        lblAnalysisMethod = new JLabel("Choose Analysis Method:");
        lblAnalysisMethod.setBounds(320, 590, 163, 16);
        frame.getContentPane().add(lblAnalysisMethod);

        //list of selected countries panel
        listOfSelectedCountriesPanel = new JTextArea();
        listOfSelectedCountriesPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        listOfSelectedCountriesPanel.setEditable(false);
        listOfSelectedCountriesPanel.setBounds(1025, 65, 219, 292);
        frame.getContentPane().add(listOfSelectedCountriesPanel);

        //output panel
        outputPanel = new JTextArea();
        outputPanel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        outputPanel.setEditable(false);
        outputPanel.setBounds(1025, 410, 219, 150);
        frame.getContentPane().add(outputPanel);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addCountryButton) {
            addCountryButtonAction();
        }
        if (e.getSource() == removeCountryButton) {
            removeCountryButtonAction();
        }
        if (e.getSource() == recalculateButton) {
            recalculateButtonAction();
        }
        if (e.getSource() == logoutButton){
            logoutButtonAction();
        }
    }

    private void addCountryButtonAction() {
        String country = addCountryBox.getSelectedItem().toString();
        int k = -1;
        for(int i = 0; i < countries.length; i++){
            if (country.equalsIgnoreCase(countries[i])){
                k = 1;
                i = countries.length;
            }
        }
        int index = countryList.indexOf(country);
        if (index == -1 && k == 1) {
            listOfSelectedCountriesPanel.append(country + "\n");
            removeCountryBox.addItem(country);
            countryList.add(country);
        }
    }

    private void removeCountryButtonAction() {
        if (removeCountryBox.getItemCount() > 0) {
            String country = removeCountryBox.getSelectedItem().toString();
            int index = countryList.indexOf(country);
            if (index != -1) {
                removeCountryBox.removeItem(country);
                countryList.remove(index);
                listOfSelectedCountriesPanel.setText(null);
                for (int i = 0; i < countryList.size(); i++) {
                    listOfSelectedCountriesPanel.append(countryList.get(i) + "\n");
                }
            }
        }
    }

    private void recalculateButtonAction() {

        //Read country list and compare to country object array, add all in country list to new array and send array to analysis engine
        Country[]dataArray = new Country[countryList.size()];
        for(int i = 0; i < countryList.size(); i++){
            //for (int j = 0; i < countryArray.length; j++){
                //if (countryArray[j].getName().equalsIgnoreCase(countryList.get(i))){
        	dataArray[i] = countryArray[i];
                }
            //}
        //}
        //Read analysis type and import and return data
        String Analysis = analysisBox.getSelectedItem().toString();
        double [] results = new double[dataArray.length];
        AnalysisEngine engine = new AnalysisEngine(dataArray);
        if (Analysis.equals("Total Covid Cases")){
            results = engine.TotalCovidCases();
        }
        else if (Analysis.equals("Cases per Capita")){
            results = engine.CasesPerCapita();
        }
        else if (Analysis.equals("Growth Rate")){
            results = engine.GrowthRate();
        }
        else if (Analysis.equals("Total Male Cases")){
            results = engine.TotalMaleCases();
        }
        else if (Analysis.equals("Total Female Cases")){
            results = engine.TotalFemaleCases();
        }
        else if (Analysis.equals("Male Cases Per Capita")){
            results = engine.MalePerCapita();
        }
        else if (Analysis.equals("Female Cases Per Capita")){
            results = engine.FemalePerCapita();
        }

        //Display results
        for (int i = 0; i < results.length; i++) {
        	outputPanel.setText(null);
        	outputPanel.append(Arrays.toString(results));
        	}
        //for (int i = 0; i < dataArray.length; i++) {
            //displayResults(results[i], dataArray[i]);
        //}


    }
    private void logoutButtonAction(){
        frame.dispose();
        IDandPass idandPass = new IDandPass();
        Login login = new Login(idandPass.getLoginInfo());
    }
    private void displayResults(double result,Country data){

        File file = new File("imgs//map.jpg");
        int mapWidth = 0, mapHeight = 0;
        Graphics2D editableImage = null;
        try{
           Image img = ImageIO.read(file);
           mapWidth =  ((BufferedImage) img).getWidth();
           mapHeight = ((BufferedImage) img).getHeight();
           editableImage = (Graphics2D) img.getGraphics();
        }
        catch (Exception e){
            System.out.println("Error reading map");
        }

        double lng = data.getCoordinates()[0];
        double lat = data.getCoordinates()[1];
        Point point = getXY(lat,lng,mapWidth,mapHeight);
        int ovalDimension = getOvalDimension(result);
        Point2D coords = new Point2D.Double(lng, lat);
        editableImage.setColor(Color.RED);
        editableImage.setStroke(new BasicStroke(3));
        editableImage.fillOval(point.x - (ovalDimension / 2), point.y - (ovalDimension / 2),ovalDimension,ovalDimension);
    }
    private Point getXY(double lat, double lng, int mapWidth, int mapHeight) {

        int screenX = (int) Math.round((((lng + 180) / 360) * mapWidth));

        int screenY = (int) Math.round(((((lat * -1) + 90) / 180) * mapHeight));

        return new Point(screenX, screenY);

    }
    private int getOvalDimension(double maxValue){

        int maxOvalDimension;
        int minOvalDimension = 15;

        if (maxValue < 1){
            maxOvalDimension = 20;
        }
        else if (maxValue < 5){
            maxOvalDimension = 30;
        }
        else if (maxValue < 10){
            maxOvalDimension = 50;
        }
        else{
            maxOvalDimension = 70;
        }

        return (int)Math.round(((maxOvalDimension - minOvalDimension) * maxValue) + minOvalDimension);
    }



}