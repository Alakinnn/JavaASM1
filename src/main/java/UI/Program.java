package UI;
/**
 * @author <Duong Tran Minh Hoang - S3978452>
 */

import Claim.*;
import Customer.Customer;
import Database.RecordManager;

import java.util.Scanner;

/**
 * <p>
 *     Note: This class serves as the UI for the entire system by implementing switch-case syntax. It also includes null-checking upon inputting.
 * </p>
 */
public class Program {
    private RecordManager rm;

    /**
     * Create a Program object
     * @param rm
     */
    public Program(RecordManager rm) {
        this.rm = rm;
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("Welcome to the Insurance Manager Application");
        System.out.println("Version: 1.0.0");
        System.out.println("-----------------------------------------------");
        System.out.println("Please restart on first-time run");
        System.out.println("-----------------------------------------------");

        while (running) {
            System.out.println("""
                    1. Add a claim
                    2. Update a claim
                    3. Delete a claim
                    4. Find a claim
                    5. Get all claims
                    0. Exit Program
                    """);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Please add claim information");
                    System.out.println("Insured person ID: ");
                    scanner.nextLine();
                    String insuredPersonID = scanner.nextLine();

                    if (rm.find(insuredPersonID) == null) {
                        System.out.println("Not found customer with ID: " + insuredPersonID);
                        continue;
                    }
                    scanner.nextLine();

                    System.out.println("Card Number: ");
                    String cardNumber = scanner.nextLine();
                    if (rm.find(cardNumber) == null) {
                        System.out.println("Not found card with number: " + insuredPersonID);
                        continue;
                    }

                    System.out.println("Exam Date: ");
                    String examDate = scanner.nextLine();

                    System.out.println("Claim Amount: ");
                    double claimAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character

                    System.out.println("Receiver Bank: ");
                    String receiverBank = scanner.nextLine();

                    System.out.println("Receiver Name: ");
                    String receiverName = scanner.nextLine();

                    System.out.println("Receiver Bank Number: ");
                    String receiverBankNumber = scanner.nextLine();
                    Claim claim = ClaimProcessManager.add(insuredPersonID, cardNumber, examDate, claimAmount, receiverBank, receiverName, receiverBankNumber, rm);

                    System.out.println("Successfully added claim!");
                    System.out.println(claim);
                    continue;

                case 2:
                    System.out.println("""
                            1. Update status
                            2. Add document
                            """);
                    int updateChoice = scanner.nextInt();
                    System.out.println("Input Claim ID: ");
                    String methodParam;
                    scanner.nextLine();
                    String claimID = scanner.nextLine();
                    Claim queriedClaim = (Claim) rm.find(claimID);

                    if (queriedClaim == null) {
                        System.out.println("Not found claim with ID: " + claimID);
                        continue;
                    }

                    switch (updateChoice) {
                        case 1:
                            System.out.println("""
                                    1. NEW
                                    2. PROCESSING
                                    3. DONE
                                    """);
                            int statusChoice = scanner.nextInt();
                            statusChoice--;
                            methodParam = updateChoice + " " + statusChoice;
                            ClaimProcessManager.update(claimID, rm, methodParam);
                            System.out.println("Successfully updated claim status!");
                            System.out.println(rm.find(claimID));
                            continue;

                        case 2:
                            System.out.println("Please enter your document file in pdf format: ");
                            System.out.println("Example: mydocument.pdf");

                            String newDocument = scanner.nextLine();
                            Customer associatedCustomer = (Customer) rm.find(queriedClaim.getInsuredPersonId());
                            newDocument = claimID + "_" + associatedCustomer.getInsuranceCard().getCardNumber() + "_" + newDocument;

                            methodParam = updateChoice + " " + newDocument;
                            ClaimProcessManager.update(claimID, rm, methodParam);
                            System.out.println("Successfully added claim's document!");
                            System.out.println(rm.find(claimID));
                            continue;

                        default:
                            System.out.println("Invalid choice");
                            continue;
                    }

                case 3:
                    System.out.println("Please enter claim ID: ");
                    scanner.nextLine();
                    String deleteClaimID = scanner.nextLine();
                    if (rm.find(deleteClaimID) != null) {
                        ClaimProcessManager.delete(deleteClaimID, rm);
                        System.out.println("Successfully deleted claim with ID: " + deleteClaimID);
                        continue;
                    } else {
                        System.out.println("Claim not found!");
                        continue;
                    }

                case 4:
                    scanner.nextLine();
                    System.out.println("Please enter claim ID: ");
                    String queriedClaimID = scanner.nextLine();
                    if (rm.find(queriedClaimID) != null) {
                        System.out.println(rm.find(queriedClaimID));
                        continue;
                    } else {
                        System.out.println("Claim not found!");
                        continue;
                    }

                case 5:
                    scanner.nextLine();
                    System.out.println("Please enter customer ID: ");
                    String customerID = scanner.nextLine();
                    if (rm.find(customerID) != null){
                        Customer customer = (Customer) rm.find(customerID);
                        if (customer.getClaimList().isEmpty()) {
                            System.out.println("Customer has no claim!");
                            continue;
                        } else {
                            ClaimProcessManager.getAll(customerID, rm);
                            continue;
                        }
                    } else {
                        System.out.println("Customer not found!");
                        continue;
                    }

                case 0:
                    System.out.println("Thank you for your time! Program closing...");
                    return;
            }
        }
    }
}
