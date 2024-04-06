package UI;
/**
 * @author <Duong Tran Minh Hoang - S3978452>
 */

/**
 * This interface defines operations for displaying UI screens and interacting with the user.
 */
public interface UiScreenOperations {

    /**
     * Displays a welcome message to the user.
     */
    static void displayWelcomeMessage() {
        System.out.println("Welcome to the Insurance Manager Application");
        System.out.println("Version: 1.0.0");
        System.out.println("-----------------------------------------------");
        System.out.println("Please restart on first-time run");
        System.out.println("-----------------------------------------------");
    }

    /**
     * Displays menu options to the user.
     */
    static void displayMenuOptions() {
        System.out.println("""
                1. Add a claim
                2. Update a claim
                3. Delete a claim
                4. Find a claim
                5. Get all claims
                0. Exit Program
                """);
    }

    /**
     * Clears the screen based on the operating system.
     * Note: This method might not work in all environments and is platform-dependent.
     */
    static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
