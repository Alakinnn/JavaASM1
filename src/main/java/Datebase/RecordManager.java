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

public class RecordManager<T extends Recordable> implements RecordOperations<T>, Serializable {
    private Map<String, T> database = new HashMap<>();
    private static List<Customer> customers = new ArrayList<>();
    private static List<InsuranceCard> insuranceCards = new ArrayList<>();
    private static List<Claim> claims = new ArrayList<>();
    private static String FILE_ROOT = "resources/";
    private static String CUSTOMER_FILE = "customers.txt";
    private static String CLAIM_FILE ="claims.txt";
    private static String CARDS_FILE = "insuranceCards.txt";

    public RecordManager() {
    }

    private void populateData() {
        populateCustomers(FILE_ROOT + CUSTOMER_FILE);
        populateClaims(FILE_ROOT + CLAIM_FILE);
        populateInsuranceCards(FILE_ROOT + CARDS_FILE);
    }

    private void populateCustomers(String fileName) {
        try (ObjectInputStream br = read(fileName)) {
            T data;
            while ((data = (T) br.readObject()) != null) {
                customers.add((Customer) data);
                this.add(data);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void populateInsuranceCards(String fileName) {
        try (ObjectInputStream br = read(fileName)) {
            T data;
            while ((data = (T) br.readObject()) != null) {
                insuranceCards.add((InsuranceCard) data);
                this.add(data);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void populateClaims(String fileName) {
        try (ObjectInputStream br = read(fileName)) {
            T data;
            while ((data = (T) br.readObject()) != null) {
                claims.add((Claim) data);
                this.add(data);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Claim> getClaims() {
        return claims;
    }
    @Override
    public void add(T record) {
        database.put(record.getID(), record);
        addRecords(record);
    }

    @Override
    public void delete(String id) {
        database.remove(id);
        updateRecords(find(id));
    }

    @Override
    public T find(String id) {
        return database.get(id);
    }

    @Override
    public void addRecords(T record) {
        if (record instanceof Customer) {
            customers.add((Customer) record);
            FileOperations.write(customers, FILE_ROOT + CUSTOMER_FILE);
        } else if (record instanceof Claim) {
            claims.add((Claim) record);
            FileOperations.write(claims, FILE_ROOT + CLAIM_FILE);
        } else if (record instanceof InsuranceCard) {
            insuranceCards.add((InsuranceCard) record);
            FileOperations.write(insuranceCards, FILE_ROOT + CARDS_FILE);
        } else {
            System.out.println("Record class not found");
        }
    }

    @Override
    public void updateRecords(T record) {
        if (record instanceof Customer) {
            customers.remove((Customer) record);
            FileOperations.write(customers, FILE_ROOT + CUSTOMER_FILE);
        } else if (record instanceof Claim) {
            claims.remove((Claim) record);
            FileOperations.write(claims, FILE_ROOT + CLAIM_FILE);
        } else if (record instanceof InsuranceCard) {
            insuranceCards.remove((InsuranceCard) record);
            FileOperations.write(insuranceCards, FILE_ROOT + CARDS_FILE);
        } else {
            System.out.println("Record class not found");
        }
    }
}
