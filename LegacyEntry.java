public class LegacyEntry {
    private String title;
    private String encryptedContent;

    public LegacyEntry(String title, String encryptedContent) {
        this.title = title;
        this.encryptedContent = encryptedContent;
    }

    public String getTitle() { return title; }
    public String getEncryptedContent() { return encryptedContent; }

    @Override
    public String toString() {
        return "📜 Title: " + title + " | 🔒 Encrypted Data Stored";
    }
}
