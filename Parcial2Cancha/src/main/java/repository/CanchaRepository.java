// repository/CanchaRepository.java
package repository;

import domain.Cancha;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CanchaRepository {
    private static final String FILE_PATH = "canchas.txt";

    // Cargar canchas desde el archivo
    public List<Cancha> cargarCanchas() {
        List<Cancha> canchas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            canchas = (List<Cancha>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de canchas no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return canchas;
    }

    // Guardar canchas en el archivo
    public void guardarCanchas(List<Cancha> canchas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(canchas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

