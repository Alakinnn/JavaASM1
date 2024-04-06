package UI;

public interface UiScreenOperations {
    static void displayWelcomeMessage() {
        System.out.println("Welcome to the Insurance Manager Application");
        System.out.println("Version: 1.0.0");
        System.out.println("-----------------------------------------------");
        System.out.println("Please restart on first-time run");
        System.out.println("-----------------------------------------------");
    }

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
