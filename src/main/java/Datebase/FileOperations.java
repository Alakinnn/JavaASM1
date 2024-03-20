package Datebase;

import Claim.Claim;
import Customer.Customer;
import InsuranceCard.InsuranceCard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations<T extends Recordable> implements Serializable {
    private static List<Customer> customers = new ArrayList<>();
    private static List<InsuranceCard> insuranceCards = new ArrayList<>();
    private static List<Claim> claims = new ArrayList<>();

    ObjectInputStream read(String FILE_NAME) {
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            return new ObjectInputStream(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    void write(T item, String FILE_NAME) {
         try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             oos.writeObject(item);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }

    public void populateDate() {
        populateCustomers("resources/customers.txt");
        populateClaims("resources/claims.txt");
        populateInsuranceCards("resources/insuranceCards.txt");
    }

    public void populateCustomers(String fileName) {
          try (ObjectInputStream br = read(fileName)) {
              Customer data;
              while ((data = (Customer) br.readObject()) != null) {
                  customers.add(data);
              }
          } catch (IOException | ClassNotFoundException e) {
              throw new RuntimeException(e);
          }
    }

    public void populateInsuranceCards(String fileName) {
        try (ObjectInputStream br = read(fileName)) {
            InsuranceCard data;
            while ((data = (InsuranceCard) br.readObject()) != null) {
                insuranceCards.add(data);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void populateClaims(String fileName) {
        try (ObjectInputStream br = read(fileName)) {
            Claim data;
            while ((data = (Claim) br.readObject()) != null) {
                claims.add(data);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
