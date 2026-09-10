package com.varunbkarmikanda.lab5.company;

import java.util.Arrays;

public class HWitem extends Sales{
    private String category;
    private String oem;

    HWitem(String title, double price, double sales1, double sales2, double sales3, String category, String oem){
        super(title, price, sales1, sales2, sales3);
        this.category = category;
        this.oem = oem;
    }

    public String getCategory(){
        return category;
    }

    public String getOem(){
        return oem;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setOem(String oem){
        this.oem = oem;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tcategory: \"" + category + "\"," +
                "\n\toem: \"" + oem + "\"," +
                "\n\titem_type: \"hardware\"" +
                "\n}";
    }
}
