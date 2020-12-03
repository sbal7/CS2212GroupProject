import java.io.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.util.*;

public class countryDataImport {

	private double confirmedCases(String country) {

		String urlString = String.format("https://api.covid19api.com/total/dayone/country/%s/status/confirmed",country);
		
		// define int value for total cases
		int casesTotal = 0;
		
		try {
			// Check and connect to url
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			// Status of connection
			int status = connection.getResponseCode();
			
			// Check is connection is successful 
			if (status == 200) { // 200 means connection is successful
				
				// Define empty string 
				String inline = "";
				
				// Scan content of url and add it to the empty string
				Scanner scan = new Scanner(url.openStream());
				while (scan.hasNext()) {
					inline += scan.nextLine();
				}
				scan.close();
				
				// Parse the json data
				JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
				
				// Check array and print out total cases for the country
				int size = jsonArray.size();
				casesTotal = jsonArray.get(size - 1).getAsJsonObject().get("Cases").getAsInt();
				System.out.println("Cases: " + casesTotal);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 
		return casesTotal;
	}
}
