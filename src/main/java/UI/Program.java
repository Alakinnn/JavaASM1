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
        UiScreenOperations.displayWelcomeMessage();
        boolean running = true;


        while (running) {
            UiScreenOperations.displayMenuOptions();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Please add claim information");
                    System.out.println("Insured person ID: ");
                    scanner.nextLine();
                    String insuredPersonID = scanner.nextLine().trim();

                    if (rm.find(insuredPersonID) == null) {
                        System.out.println("Not found customer with ID: " + insuredPersonID);
                        continue;
                    }
                    scanner.nextLine();

                    System.out.println("Card Number: ");
                    String cardNumber = scanner.nextLine().trim();
                    if (rm.find(cardNumber) == null) {
                        System.out.println("Not found card with number: " + insuredPersonID);
                        continue;
                    }

                    System.out.println("Exam Date: ");
                    String examDate = scanner.nextLine().trim();

                    System.out.println("Claim Amount: ");
                    double claimAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character

                    System.out.println("Receiver Bank: ");
                    String receiverBank = scanner.nextLine().trim();

                    System.out.println("Receiver Name: ");
                    String receiverName = scanner.nextLine().trim();

                    System.out.println("Receiver Bank Number: ");
                    String receiverBankNumber = scanner.nextLine().trim();
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
                    String claimID = scanner.nextLine().trim();
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

                            String newDocument = scanner.nextLine().trim();
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
                    String deleteClaimID = scanner.nextLine().trim();
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
                    String queriedClaimID = scanner.nextLine().trim();
                    if (rm.find(queriedClaimID) != null) {
                        Claim foundClaim = (Claim) rm.find(queriedClaimID);
                        System.out.println(rm.find(queriedClaimID));

                        if (!foundClaim.getDocuments().isEmpty()) {
                            for (String document : foundClaim.getDocuments()) {
                                System.out.println(document);
                            }
                        }

                        continue;
                    } else {
                        System.out.println("Claim not found!");
                        continue;
                    }

                case 5:
                    scanner.nextLine();
                    System.out.println("Please enter customer ID: ");
                    String customerID = scanner.nextLine().trim();
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
