package Datebase;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class FileOperations implements Serializable {

    public static ObjectInputStream read(String FILE_NAME) {
        try  {
            return new ObjectInputStream(new FileInputStream(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void write(List<?> item, String FILE_NAME) {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }

            try (FileOutputStream fos = new FileOutputStream(file)) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
