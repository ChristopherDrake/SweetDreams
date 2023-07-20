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
    private String title;
    private String dreamMood;
    private String dreamType;
    private String dreamSetting;
    private String dreamPeople;
    private String dreamEmotions;
    private String dreamColors;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDreamMood() {
        return dreamMood;
    }

    public void setDreamMood(String dreamMood) {
        this.dreamMood = dreamMood;
    }

    public String getDreamType() {
        return dreamType;
    }

    public void setDreamType(String dreamType) {
        this.dreamType = dreamType;
    }

    public String getDreamSetting() {
        return dreamSetting;
    }

    public void setDreamSetting(String dreamSetting) {
        this.dreamSetting = dreamSetting;
    }

    public String getDreamPeople() {
        return dreamPeople;
    }

    public void setDreamPeople(String dreamPeople) {
        this.dreamPeople = dreamPeople;
    }

    public String getDreamEmotions() {
        return dreamEmotions;
    }

    public void setDreamEmotions(String dreamEmotions) {
        this.dreamEmotions = dreamEmotions;
    }

    public String getDreamColors() {
        return dreamColors;
    }

    public void setDreamColors(String dreamColors) {
        this.dreamColors = dreamColors;
    }
}
