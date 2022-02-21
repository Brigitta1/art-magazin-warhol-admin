package entity;

import java.util.UUID;

public class Image {
    private UUID uuid;
    private String category;
    private byte[] content;
    private String extension;

    public Image(String category, byte[] content) {
        this.category = category;
        this.content = content;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getCategory() {
        return category;
    }

    public byte[] getContent() {
        return content;
    }

    public String getExtension() {
        return extension;
    }
}
