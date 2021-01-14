package com.prottonne.deserialization.item;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemDeserializer extends StdDeserializer<Item> {

    public ItemDeserializer() {
        this(null);
    }

    public ItemDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Item deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        JsonNode node = jp.getCodec().readTree(jp);
        JsonNode myNode = node.get("myNodeName");
        if (null == myNode) {
            return null;
        } else {
            return new Item(getList(myNode));
        }
    }

    private List<InnerItem> getList(JsonNode myNode) {

        List<InnerItem> myList = new ArrayList<>();

        if (myNode.isArray()) {
            for (final JsonNode oneElementNode : myNode) {
                myList.add(getItem(oneElementNode));
            }
        } else {
            myList.add(getItem(myNode));
        }

        return myList;
    }

    private InnerItem getItem(JsonNode node) {
        JsonNode dataNode = node.get("attrName");
        String data = (null == dataNode) ? null : dataNode.asText();
        InnerItem innerItem = new InnerItem();
        innerItem.setData(data);
        return innerItem;
    }

}
