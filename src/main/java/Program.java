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
                    Any key. Exit Program
                    """);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                case 2:
                    System.out.println("""
                            1. Update status
                            2. Add document
                            """);
                    int updateChoice = scanner.nextInt();
                    System.out.println("Input Claim ID: ");
                    String claimID = scanner.nextLine();
                    switch (updateChoice) {
                        case 1:
                            System.out.println("""
                                    1. NEW
                                    2. PROCESSING
                                    3. DONE
                                    """);
                            int statusChoice = scanner.nextInt();
                            String methodParam = updateChoice + " " + statusChoice;
                            ClaimProcessManager.update(claimID, rm, methodParam);

                    }
                case 3:
                case 4:
                default:
                    System.out.println("Thank you for your time! Program closing...");
            }
        }
    }
}
