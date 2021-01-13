package com.prottonne.deserialization.item;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

@JsonDeserialize(using = ItemDeserializer.class)
public class Item {

    private List<InnerItem> innerItems;

    public Item() {
        super();
    }

    public Item(List<InnerItem> innerItems) {
        this.innerItems = innerItems;
    }

    public List<InnerItem> getInnerItems() {
        return innerItems;
    }

    public void setInnerItems(List<InnerItem> innerItems) {
        this.innerItems = innerItems;
    }

    @Override
    public String toString() {
        return "Item{" + "innerItems=" + innerItems + '}';
    }

}
