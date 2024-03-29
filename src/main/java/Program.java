import Claim.ClaimProcessManager;
import Datebase.RecordManager;

import java.util.Scanner;

public class Program {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("Welcome to the Insurance Manager Application");
        System.out.println("Version: 1.0.0");
        System.out.println("----------------------------------");
        RecordManager rm = new RecordManager<>();
        while (running) {
            System.out.println("""
                    1. Add claim
                    2. Update claim
                    3. Delete claim
                    4. Find claim
                    5. Get all claim
                    Any key. Exit Program
                    """);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Please add claim information");
                    System.out.println("DISCLAIMER: DUE TO UNDERDEVELOPED ERROR-HANDLING, INPUTS MUST BE ERROR-FREE!");
                    System.out.println("Insured person ID: ");
                    String insuredPersonID = scanner.nextLine();

                    System.out.println("Card Number: ");
                    String cardNumber = scanner.nextLine();

                    System.out.println("Exam Date: ");
                    String examDate = scanner.nextLine();

                    System.out.println("Claim Amount: ");
                    double claimAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character

                    System.out.println("Status Ordinal: ");
                    int statusOrdinal = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    System.out.println("Receiver Bank: ");
                    String receiverBank = scanner.nextLine();

                    System.out.println("Receiver Name: ");
                    String receiverName = scanner.nextLine();

                    System.out.println("Receiver Bank Number: ");
                    String receiverBankNumber = scanner.nextLine();

                    System.out.println("Document: ");
                    String document = scanner.nextLine();

                    ClaimProcessManager.add(insuredPersonID, cardNumber, examDate, claimAmount, statusOrdinal, receiverBank, receiverName, receiverBankNumber, document, rm);

                    System.out.println("Successfully added claim!");
                    continue;

                case 2:
                    System.out.println("""
                            1. Update status
                            2. Add document
                            """);
                    int updateChoice = scanner.nextInt();
                    System.out.println("Input Claim ID: ");
                    String methodParam;
                    String claimID = scanner.nextLine();

                    switch (updateChoice) {
                        case 1:
                            System.out.println("""
                                    1. NEW
                                    2. PROCESSING
                                    3. DONE
                                    """);
                            int statusChoice = scanner.nextInt();
                             methodParam = updateChoice + " " + statusChoice;
                            ClaimProcessManager.update(claimID, rm, methodParam);
                            System.out.println("Successfully updated claim status!");
                            continue;

                        case 2:
                            System.out.println("Please enter your document file name: ");
                            String newDocument = scanner.nextLine();
                            methodParam = updateChoice + " " + newDocument;
                            ClaimProcessManager.update(claimID, rm, methodParam);
                            System.out.println("Successfully added claim's document!");
                            continue;

                        default:
                            System.out.println("Invalid choice");
                            continue;
                    }

                case 3:
                    System.out.println("Please enter claim ID: ");
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
                    System.out.println("Please enter customer ID: ");
                    String customerID = scanner.nextLine();
                    if (rm.find(customerID) != null){
                        ClaimProcessManager.getAll(customerID, rm);
                        continue;
                    } else {
                        System.out.println("Customer not found!");
                        continue;
                    }

                default:
                    System.out.println("Thank you for your time! Program closing...");
                    break;
            }
        }
    }
}
