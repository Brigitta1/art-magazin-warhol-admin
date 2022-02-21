package model;

import java.util.UUID;

public class Image {

    private UUID uuid;
    private String category;
    private byte[] content;
    private String extension;

    public Image(UUID uuid, String category, byte[] content, String extension) {
        this.uuid = uuid;
        this.category = category;
        this.content = content;
        this.extension = extension;
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
