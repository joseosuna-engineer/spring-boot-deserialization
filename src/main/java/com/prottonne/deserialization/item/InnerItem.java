package com.prottonne.deserialization.item;

public class InnerItem {

    private String data;

    public InnerItem() {
        super();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "InnerItem{" + "data=" + data + '}';
    }

}
