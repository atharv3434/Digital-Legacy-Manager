import java.util.*;

public class LegacyManager {
    private List<LegacyEntry> legacyEntries;
    private Scanner sc;

    public LegacyManager() {
        this.legacyEntries = SecureStorage1.loadLegacyEntries();
        this.sc = new Scanner(System.in);
    }

    public void addLegacyEntry() {
        System.out.print("Enter a title (e.g., 'Email Password', 'Message for Family'): ");
        String title = sc.nextLine();
        System.out.print("Enter the confidential content: ");
        String content = sc.nextLine();

        String encryptedContent = CryptoUtil.encrypt(content);
        legacyEntries.add(new LegacyEntry(title, encryptedContent));
        SecureStorage1.saveLegacyEntries(legacyEntries);
        System.out.println("✅ Legacy Entry Stored Securely!");
    }

    public void viewLegacyEntries() {
        if (legacyEntries.isEmpty()) {
            System.out.println("📄 No digital legacy records found.");
            return;
        }

        System.out.println("\n🔐 Your Digital Legacy:");
        for (int i = 0; i < legacyEntries.size(); i++) {
            System.out.println((i + 1) + ". " + legacyEntries.get(i).toString());
        }

        System.out.print("\nEnter the entry number to decrypt and view: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < legacyEntries.size()) {
            String decryptedContent = CryptoUtil.decrypt(legacyEntries.get(index).getEncryptedContent());
            System.out.println("\n📜 Decrypted Content:\n" + decryptedContent);
        } else {
            System.out.println("❌ Invalid selection.");
        }
    }

    public void deleteLegacyEntry() {
        viewLegacyEntries();
        System.out.print("Enter the entry number to delete: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < legacyEntries.size()) {
            legacyEntries.remove(index);
            SecureStorage1.saveLegacyEntries(legacyEntries);
            System.out.println("✅ Legacy Entry Deleted Successfully!");
        } else {
            System.out.println("❌ Invalid selection.");
        }
    }
}
