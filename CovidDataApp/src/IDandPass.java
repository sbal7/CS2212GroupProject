import java.io.*;
import java.util.*;

public class IDandPass {

    private HashMap<String, String> loginInfo = new HashMap<String, String>();

    IDandPass() {
        // Read all the text files in "users" and add them to "loginInfo"
        File folder = new File("users//");
        File[] listOfFiles = folder.listFiles();

        String[] usernames;
        String[] passwords;

        //Get Usernames and passwords
        usernames = getUsernames(listOfFiles);
        passwords = getPasswords(listOfFiles);

        //Write them into hashtable
        writeUserBase(usernames, passwords);

    }

    public HashMap getLoginInfo() {
        return loginInfo;
    }

    private String[] getUsernames(File[] listOfFiles) {
        try {
            if (listOfFiles != null && listOfFiles.length > 0) {
                String[] usernames = new String[listOfFiles.length];
                for (int i = 0; i < listOfFiles.length; i++) {
                    usernames[i] = listOfFiles[i].getName().split("\\.")[0];
                }
                return usernames;
            }
        } catch (NullPointerException e) {
            System.out.println("Please Create a user");
        }
        return null;
    }

    private String[] getPasswords(File[] listOfFiles) {
        try {
            if (listOfFiles != null && listOfFiles.length > 0) {
                String[] passwords = new String[listOfFiles.length];
                for (int i = 0; i < listOfFiles.length; i++) {

                    File file = new File(listOfFiles[i].getPath());
                    Scanner scanner = new Scanner(file);
                    String line = "";

                    line = scanner.nextLine();
                    passwords[i] = line;

                }
                return passwords;
            }
        } catch (Exception e) {
            System.out.println("Password read error");
        }
        return null;
    }

    private void writeUserBase(String[] users, String[] passes) {
        for (int i = 0; i < users.length; i++) {
            loginInfo.put(users[i], passes[i]);
        }
    }
}