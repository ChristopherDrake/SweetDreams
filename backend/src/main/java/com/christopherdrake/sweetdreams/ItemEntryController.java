package com.christopherdrake.sweetdreams;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.christopherdrake.sweetdreams.ItemEntry;
import com.christopherdrake.sweetdreams.ItemEntryServiceImpl;

@RestController
@RequestMapping("/item")
public class ItemEntryController {
    private final ItemEntryServiceImpl ItemEntryService;

    public ItemEntryController(ItemEntryServiceImpl ItemEntryService) {
        this.ItemEntryService = ItemEntryService;
    }

    @PostMapping("/entry")
    public ResponseEntity<Void> createItemEntry(@RequestBody ItemEntry ItemEntry) {
        ItemEntryService.createItemEntry(ItemEntry);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/entry/{userId}/{itemId}")
    public ResponseEntity<ItemEntry> getItemEntry(@PathVariable String userId, @PathVariable int itemId) {
        ItemEntry ItemEntry = ItemEntryService.getItemEntry(userId, itemId);
        return ResponseEntity.ok(ItemEntry);
    }

    @PutMapping("/entry")
    public ResponseEntity<Void> updateItemEntry(@RequestBody ItemEntry ItemEntry) {
        ItemEntryService.updateItemEntry(ItemEntry);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/entry/{userId}/{itemId}")
    public ResponseEntity<Void> deleteItemEntry(@PathVariable String userId, @PathVariable int itemId) {
        ItemEntryService.deleteItemEntry(userId, itemId);
        return ResponseEntity.ok().build();
    }
}
