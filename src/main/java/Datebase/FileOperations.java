package Datebase;

import Claim.Claim;
import Customer.Customer;
import InsuranceCard.InsuranceCard;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    static boolean fileExists(String fileName) {
        if (Files.exists(Path.of(fileName))) {
            return true;
        } else {
            try {
                Files.createFile(Path.of(fileName));
                return true;
            } catch (IOException e) {
                return false;
            }
        }
    }
}
