package lab6;

import java.io.*;

public class Auth {
    File login_file_path = new File("src/lab6/login.txt");

    public boolean authenticate(String[] userDetails){
        String name = userDetails[0];
        String password = userDetails[1];

        try(BufferedReader br = new BufferedReader(new FileReader(login_file_path))){
            String credentials = br.readLine();
            while (credentials != null) {
                String[] user = credentials.split(",");

                if(name.equals(user[0]) && password.equals(user[1])) return true;

                credentials = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Failed to authenticate: " + e);
        }
        return false;
    }
}
