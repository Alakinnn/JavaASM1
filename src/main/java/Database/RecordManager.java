package Database;
/**
 * @author <Duong Tran Minh Hoang - S3978452>
 */

import Claim.Claim;
import Customer.Customer;
import InsuranceCard.InsuranceCard;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static Database.FileOperations.*;

/**
 * Manages records in a database.
 *
 * <p>
 * This class provides methods for adding, deleting, finding, updating, and populating records.
 * It uses file operations for reading and writing records from/to files.
 * </p>
 *
 * <p>
 * Note: This class is serializable.
 * </p>
 *
 * <p>
 * Note: This class expects the file paths for data files to be specified in the FILE_ROOT, CUSTOMER_FILE, CLAIM_FILE, and CARDS_FILE constants.
 * </p>
 *
 * @param <T> The type of record managed by the RecordManager.
 */
public class RecordManager<T extends Recordable> implements RecordOperations<T>, Serializable {
    @Serial
    private static final long serialVersionUID = 250424050L;
    private final Map<String, T> database = new HashMap<>();
    private final List<Customer> customers = new ArrayList<>();
    private final List<InsuranceCard> insuranceCards = new ArrayList<>();
    private final List<Claim> claims = new ArrayList<>();
    private static final String FILE_ROOT = "src/main/resources/";
    private static final String CUSTOMER_FILE = "customers.txt";
    private static final String CLAIM_FILE = "claims.txt";
    private static final String CARDS_FILE = "insuranceCards.txt";

    /**
     * Constructs a RecordManager instance.
     * Populates data from files if the database is empty.
     */
    public RecordManager() {
        if (database.isEmpty() || customers.isEmpty() || insuranceCards.isEmpty() || claims.isEmpty()) {
            populateData();
        }
    }

    /**
     * Populates data from files into the database.
     */
    private void populateData() {
        populateCustomers(FILE_ROOT + CUSTOMER_FILE);
        populateClaims(FILE_ROOT + CLAIM_FILE);
        populateInsuranceCards(FILE_ROOT + CARDS_FILE);
    }

    /**
     * Populates customer data from a file into the database.
     *
     * @param fileName The name of the file containing customer data.
     */
    private void populateCustomers(String fileName) {
        try (ObjectInputStream br = read(fileName)) {
            List<Customer> customerList = (List<Customer>) br.readObject();
            for (Customer customer : customerList) {
                this.add((T) customer);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Populates insurance card data from a file into the database.
     *
     * @param fileName The name of the file containing insurance card data.
     */
    private void populateInsuranceCards(String fileName) {
        try (ObjectInputStream br = read(fileName)) {
            List<InsuranceCard> insuranceCards = (List<InsuranceCard>) br.readObject();
            for (InsuranceCard card : insuranceCards) {
                this.add((T) card);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Populates claim data from a file into the database.
     *
     * @param fileName The name of the file containing claim data.
     */
    private void populateClaims(String fileName) {
        try (ObjectInputStream br = read(fileName)) {
            List<Claim> claimList = (List<Claim>) br.readObject();
            for (Claim claim : claimList) {
                this.add((T) claim);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Adds a record to the database.
     *
     * @param record The record to be added.
     */
    @Override
    public void add(T record) {
        database.put(record.getID(), record);
        addRecords(record);
    }

    /**
     * Deletes a record from the database.
     *
     * @param id The ID of the record to be deleted.
     */
    @Override
    public void delete(String id) {
        T recordToDelete = find(id); // Find the record to delete by ID
        if (recordToDelete != null) {
            // Remove the record from the database
            database.remove(id);

            // Remove the record from the respective list
            if (recordToDelete instanceof Customer) {
                customers.remove((Customer) recordToDelete);
                FileOperations.write(customers, FILE_ROOT + CUSTOMER_FILE);
            } else if (recordToDelete instanceof Claim) {
                claims.remove((Claim) recordToDelete);
                FileOperations.write(claims, FILE_ROOT + CLAIM_FILE);
            } else if (recordToDelete instanceof InsuranceCard) {
                insuranceCards.remove((InsuranceCard) recordToDelete);
                FileOperations.write(insuranceCards, FILE_ROOT + CARDS_FILE);
            }
        } else {
            System.out.println("Record not found for deletion");
        }
    }

    /**
     * Finds a record in the database based on its ID.
     *
     * @param id The ID of the record to find.
     * @return The found record, or null if not found.
     */
    @Override
    public T find(String id) {
        return database.get(id);
    }

    /**
     * Adds records to the respective lists based on their types.
     *
     * @param record The record to be added.
     */
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

    /**
     * Updates records in the database.
     *
     * @param newRecord The updated record.
     */
    @Override
    public void updateRecords(T newRecord) {
        T oldRecord = find(newRecord.getID()); // Find the old record by ID
        if (oldRecord != null) {
            // Remove the old record
            database.remove(oldRecord.getID());
            if (oldRecord instanceof Customer) {
                customers.remove((Customer) oldRecord);
            } else if (oldRecord instanceof Claim) {
                claims.remove((Claim) oldRecord);
            } else if (oldRecord instanceof InsuranceCard) {
                insuranceCards.remove((InsuranceCard) oldRecord);
            }

            // Add the new record
            add(newRecord);
        } else {
            System.out.println("Record not found for update");
        }
    }
}
