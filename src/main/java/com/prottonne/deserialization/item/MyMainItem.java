package com.prottonne.deserialization.item;

public class MyMainItem {

    private Item item;

    public MyMainItem() {
        super();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "MyMainItem{" + "item=" + item + '}';
    }

}
