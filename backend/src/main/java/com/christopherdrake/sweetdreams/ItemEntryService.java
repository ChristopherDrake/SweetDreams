package com.christopherdrake.sweetdreams;

public interface ItemEntryService {
    void createItemEntry(ItemEntry itemEntry);

    ItemEntry getItemEntry(String userId, int itemId);

    void updateItemEntry(ItemEntry itemEntry);

    void deleteItemEntry(String userId, int itemId);
}
