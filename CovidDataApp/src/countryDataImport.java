import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.*;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;


public class countryDataImport {

    Country[] countryArray;


    public countryDataImport() {

        int length = 0;

        File file = new File("data//data.csv");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                length++;
                scan.nextLine();
            }
        } catch (IOException e) {
            System.out.println("Scan Error Data Import Constructor");
        }

        countryArray = new Country[length];

        for (int i = 0; i < length; i++) {
            countryArray[i] = new Country();
        }

    }

    public void importMethod() {
        for (int i = 0; i < countryArray.length; i++) {
            Country country = new Country();

            addDataFile(country, i);

            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException e) {
                System.out.println("Error with the sleep function");
            }

            importAPIData(country, i);

            countryArray[i] = country;
        }
    }

    public Country[] getCountryArray() {

        File file = new File("data//apiData.csv");
        ZonedDateTime nowZoned = ZonedDateTime.now();
        Instant midnight = nowZoned.toLocalDate().atStartOfDay(nowZoned.getZone()).toInstant();
        Duration duration = Duration.between(midnight, Instant.now());
        long seconds = duration.getSeconds();

        if (file.exists() && file.lastModified() > seconds) {
            try {
                Scanner scan = new Scanner(file);
                int counter = 0;
                while (scan.hasNext()) {
                    Country country = new Country();
                    addDataFile(country, counter);
                    String line = scan.nextLine();
                    int Cases, CasesY, Cases7;
                    Cases = Integer.parseInt(line.split(",")[1]);
                    CasesY = Integer.parseInt(line.split(",")[2]);
                    Cases7 = Integer.parseInt(line.split(",")[3]);
                    country.setCovidCases(Cases);
                    country.setCovidYesterday(CasesY);
                    country.setCovidWeekAgo(Cases7);
                    countryArray[counter] = country;
                    counter++;
                }
            } catch (Exception e) {
                System.out.println("Error reading Api Data CSV");
            }
        } else {
            try {
                importMethod();
                BufferedWriter writer = new BufferedWriter(new FileWriter("data//apiData.csv"));
                for (int i = 0; i < countryArray.length; i++) {
                    writer.write(countryArray[i].getName() + "," + countryArray[i].getCovidCases() + "," + countryArray[i].getCovidYesterday() + "," + countryArray[i].getCovidWeekAgo());
                    writer.newLine();
                }
                writer.close();
            } catch (Exception e) {
                System.out.println("Error Writing Api Data File");
            }
        }


        return countryArray;
    }

    private void addDataFile(Country country, int i) {

        File file = new File("data//data.csv");
        try {
            Scanner sc = new Scanner(file);
            String line;
            String[] rawData;
            int pop;
            double cordN, cordW, covidM, covidF;


            for (int j = 0; j <= i; j++) {
                line = sc.nextLine();
                rawData = line.split(",");

                country.setName(rawData[0]);
                pop = Integer.parseInt(rawData[1]);
                cordN = Double.parseDouble(rawData[2]);
                cordW = Double.parseDouble(rawData[3]);
                double[] cords = {cordN, cordW};
                covidM = Double.parseDouble(rawData[4]);
                covidF = Double.parseDouble(rawData[5]);

                country.setPopulation(pop);
                country.setCoordinates(cords);
                country.setCovidMale(covidM);
                country.setCovidFemale(covidF);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e + "File not Found");
        }


    }

    private void importAPIData(Country country, int k) {

        String urlString = String.format("https://api.covid19api.com/total/dayone/country/%s/status/confirmed", country.getName());
        int covidCases, covidYesterday, covid7Days;

        try {
            int status = 429;
            while (status == 429) {
                // Check and connect to url
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                // Status of connection
                status = connection.getResponseCode();

                // Check is connection is successful
                if (status == 200) { // 200 means connection is successful
                    System.out.println("Connection #" + (k + 1) + " established");


                    // Scan content of url and add it to the empty string
                    String inline = "";
                    Scanner sc = new Scanner(url.openStream());
                    while (sc.hasNext()) {
                        inline = sc.nextLine();
                    }
                    sc.close();

                    JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
                    int size = jsonArray.size();
                    covidCases = jsonArray.get(size - 1).getAsJsonObject().get("Cases").getAsInt();
                    covidYesterday = jsonArray.get(size - 2).getAsJsonObject().get("Cases").getAsInt();
                    covid7Days = jsonArray.get(size - 8).getAsJsonObject().get("Cases").getAsInt();

                    country.setCovidYesterday(covidYesterday);
                    country.setCovidWeekAgo(covid7Days);
                    country.setCovidCases(covidCases);

                }
            }


        } catch (Exception e) {
            System.out.println("API Import Error");
        }


    }


}


