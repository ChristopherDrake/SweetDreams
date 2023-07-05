package com.christopherdrake.sweetdreams;

import java.util.List;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class ItemEntry {
    private String userId;
    private int itemId;
    private String itemType;
    private int attachedEntry;
    private String body;
    private LocalDateTime date;
    private List<String> tags;

    // getters and setters...
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getAttachedEntry() {
        return attachedEntry;
    }

    public void setAttachedEntry(int attachedEntry) {
        this.attachedEntry = attachedEntry;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setCurrentDateInUTC() {
        this.date = LocalDateTime.now(ZoneOffset.UTC);
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
