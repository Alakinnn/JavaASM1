import Claim.Claim;
import Customer.Customer;
import Datebase.*;
import InsuranceCard.InsuranceCard;
import Utils.SampleDataGenerator;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        RecordManager rm = new RecordManager<>();
//        Program program = new Program(rm);
//
//        program.start();
//        SampleDataGenerator sdg = new SampleDataGenerator();
//        FileOperations.write(sdg.getSampleCards(), "src/main/resources/insuranceCards.txt");
//        FileOperations.write(sdg.getSampleClaims(), "src/main/resources/claims.txt");
//        FileOperations.write(sdg.getSampleCustomers(), "src/main/resources/customers.txt");

        List<InsuranceCard> cardList = new ArrayList<>();
        List<Claim> claimList = new ArrayList<>();
        List<Customer> customerList = new ArrayList<>();

        try (ObjectInputStream br = FileOperations.read("src/main/resources/insuranceCards.txt")){
            cardList = (List<InsuranceCard>) br.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream br = FileOperations.read("src/main/resources/claims.txt")){
            claimList = (List<Claim>) br.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream br = FileOperations.read("src/main/resources/customers.txt")){
            customerList = (List<Customer>) br.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (InsuranceCard card : cardList) {
            System.out.println(card);
        }

        for (Customer customer : customerList) {
            System.out.println(customer);
        }

        for (Claim claim : claimList) {
            System.out.println(claim);
        }
    }
}
