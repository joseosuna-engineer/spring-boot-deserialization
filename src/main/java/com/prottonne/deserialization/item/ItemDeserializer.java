package com.prottonne.deserialization.item;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

        if (myNode instanceof List) {
            ArrayNode arrayNode = (ArrayNode) myNode;
            Iterator<JsonNode> itr = arrayNode.elements();
            while (itr.hasNext()) {
                myList.add(getItem(itr.next()));
            }
        } else {
            myList.add(getItem(myNode));
        }

        return myList;
    }

    private InnerItem getItem(JsonNode node) {
        String data = node.get("attName").asText();
        InnerItem innerItem = new InnerItem();
        innerItem.setData(data);
        return innerItem;
    }

}
