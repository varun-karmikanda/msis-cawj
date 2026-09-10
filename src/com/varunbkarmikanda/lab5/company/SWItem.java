package com.varunbkarmikanda.lab5.company;

public class SWItem extends Sales {
    private String type;
    private String os;


    public SWItem(String title, double price, double sales1, double sales2, double sales3, String type, String os) {
        super(title, price, sales1, sales2, sales3);
        this.type = type;
        this.os = os;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\ttype: \"" + type + "\"," +
                "\n\tos: \"" + os + "\"," +
                "\n\titem_type: \"software\"" +
                "\n}";
    }
}
