package rutas;

import java.io.*;
import java.util.*;

public class LoginManager {
    private static final String FILE_PATH = "data/usuarios.txt";
    private Map<String, String> credentials = new HashMap<>();

    public LoginManager() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split(":");
                if (parts.length == 2) {
                    credentials.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo usuarios: " + e.getMessage());
        }
    }

    public boolean isValid(String username, String password) {
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }
}
