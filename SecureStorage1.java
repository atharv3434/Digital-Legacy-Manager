import java.io.*;
import java.util.*;

public class SecureStorage1 {
    private static final String FILE_PATH = "digital_legacy.dat";

    public static void saveLegacyEntries(List<LegacyEntry> legacyEntries) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(legacyEntries);
        } catch (IOException e) {
            System.out.println("❌ Error saving legacy entries.");
        }
    }

    public static List<LegacyEntry> loadLegacyEntries() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<LegacyEntry>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
