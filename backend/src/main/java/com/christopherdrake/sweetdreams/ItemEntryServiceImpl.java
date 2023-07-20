package com.christopherdrake.sweetdreams;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class ItemEntryServiceImpl implements ItemEntryService {
    private final DynamoDbClient dynamoDbClient;

    public ItemEntryServiceImpl(DynamoDbClient dynamoDbClient) {
        this.dynamoDbClient = dynamoDbClient;
    }

    @Override
    public void createItemEntry(ItemEntry itemEntry) {
        Map<String, AttributeValue> dynamoDbItem = toDynamoDbItem(itemEntry);
        PutItemRequest putItemRequest = PutItemRequest.builder()
                .tableName("sweetDreams")
                .item(dynamoDbItem)
                .build();

        dynamoDbClient.putItem(putItemRequest);
    }

    @Override
    public ItemEntry getItemEntry(String userId, int itemId) {
        GetItemRequest getItemRequest = GetItemRequest.builder()
                .tableName("sweetDreams")
                .key(Map.of("userId", AttributeValue.builder().s(userId).build(),
                        "itemId", AttributeValue.builder().n(String.valueOf(itemId)).build()))
                .build();

        Map<String, AttributeValue> dynamoDbItem = dynamoDbClient.getItem(getItemRequest).item();

        return fromDynamoDbItem(dynamoDbItem);
    }

    @Override
    public void updateItemEntry(ItemEntry itemEntry) {
        Map<String, AttributeValue> dynamoDbItem = toDynamoDbItem(itemEntry);
        PutItemRequest putItemRequest = PutItemRequest.builder()
                .tableName("sweetDreams")
                .item(dynamoDbItem)
                .build();

        dynamoDbClient.putItem(putItemRequest);
    }

    @Override
    public void deleteItemEntry(String userId, int itemId) {
        DeleteItemRequest deleteItemRequest = DeleteItemRequest.builder()
                .tableName("sweetDreams")
                .key(Map.of("userId", AttributeValue.builder().s(userId).build(),
                        "itemId", AttributeValue.builder().n(String.valueOf(itemId)).build()))
                .build();

        dynamoDbClient.deleteItem(deleteItemRequest);
    }

    private Map<String, AttributeValue> toDynamoDbItem(ItemEntry itemEntry) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("userId", AttributeValue.builder().s(itemEntry.getUserId()).build());
        item.put("itemId", AttributeValue.builder().n(String.valueOf(itemEntry.getItemId())).build());
        item.put("itemType", AttributeValue.builder().s(itemEntry.getItemType()).build());
        item.put("attachedEntry", AttributeValue.builder().n(String.valueOf(itemEntry.getAttachedEntry())).build());
        item.put("body", AttributeValue.builder().s(itemEntry.getBody()).build());
        item.put("date",
                AttributeValue.builder().s(itemEntry.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)).build());
        item.put("tags", AttributeValue.builder().ss(itemEntry.getTags()).build());
        item.put("title", AttributeValue.builder().s(itemEntry.getTitle()).build());
        item.put("dreamMood", AttributeValue.builder().s(itemEntry.getDreamMood()).build());
        item.put("dreamType", AttributeValue.builder().s(itemEntry.getDreamType()).build());
        item.put("dreamSetting", AttributeValue.builder().s(itemEntry.getDreamSetting()).build());
        item.put("dreamPeople", AttributeValue.builder().s(itemEntry.getDreamPeople()).build());
        item.put("dreamEmotions", AttributeValue.builder().s(itemEntry.getDreamEmotions()).build());
        item.put("dreamColors", AttributeValue.builder().s(itemEntry.getDreamColors()).build());

        return item;
    }

    private ItemEntry fromDynamoDbItem(Map<String, AttributeValue> dynamoDbItem) {
        ItemEntry itemEntry = new ItemEntry();
        itemEntry.setUserId(dynamoDbItem.get("userId").s());
        itemEntry.setItemId(Integer.parseInt(dynamoDbItem.get("itemId").n()));
        itemEntry.setItemType(dynamoDbItem.get("itemType").s());
        itemEntry.setAttachedEntry(Integer.parseInt(dynamoDbItem.get("attachedEntry").n()));
        itemEntry.setBody(dynamoDbItem.get("body").s());
        itemEntry.setDate(LocalDateTime.parse(dynamoDbItem.get("date").s(), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        itemEntry.setTags(dynamoDbItem.get("tags").ss());
        itemEntry.setTitle(dynamoDbItem.get("title").s());
        itemEntry.setDreamMood(dynamoDbItem.get("dreamMood").s());
        itemEntry.setDreamType(dynamoDbItem.get("dreamType").s());
        itemEntry.setDreamSetting(dynamoDbItem.get("dreamSetting").s());
        itemEntry.setDreamPeople(dynamoDbItem.get("dreamPeople").s());
        itemEntry.setDreamEmotions(dynamoDbItem.get("dreamEmotions").s());
        itemEntry.setDreamColors(dynamoDbItem.get("dreamColors").s());

        return itemEntry;
    }
}
