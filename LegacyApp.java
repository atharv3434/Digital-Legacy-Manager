import java.util.Scanner;

public class LegacyApp {
    private static LegacyManager legacyManager = new LegacyManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🛡️ Welcome to Digital Legacy Manager 🛡️");

        while (true) {
            System.out.println("\n1. Add Legacy Entry");
            System.out.println("2. View Digital Legacy");
            System.out.println("3. Delete Legacy Entry");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    legacyManager.addLegacyEntry();
                    break;
                case 2:
                    legacyManager.viewLegacyEntries();
                    break;
                case 3:
                    legacyManager.deleteLegacyEntry();
                    break;
                case 4:
                    System.out.println("Exiting... Your digital assets are safe! 🔐");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
