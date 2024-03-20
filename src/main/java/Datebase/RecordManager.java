package Datebase;

import Claim.Claim;
import Customer.Customer;
import InsuranceCard.InsuranceCard;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Datebase.FileOperations.*;

public class RecordManager<T extends Recordable> implements Serializable {
    private Map<String, T> database = new HashMap<>();
    private static List<Customer> customers = new ArrayList<>();
    private static List<InsuranceCard> insuranceCards = new ArrayList<>();
    private static List<Claim> claims = new ArrayList<>();

    public RecordManager() {
    }

    public void addData(T record) {
        String id = record.getID();
        database.put(id, record);
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
