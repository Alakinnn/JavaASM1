package Datebase;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class FileOperations implements Serializable {

    static ObjectInputStream read(String FILE_NAME) {
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            return new ObjectInputStream(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void write(List<?> item, String FILE_NAME) {
         try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             oos.writeObject(item);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
    }
}
