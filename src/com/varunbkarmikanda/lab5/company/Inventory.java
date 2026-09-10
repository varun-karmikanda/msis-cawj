package com.varunbkarmikanda.lab5.company;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> inventory = new ArrayList<>();


    Inventory(){
        initialiseInventory();
    }

    public void addToInventory(Item item){
        this.inventory.add(item);
    }

    public List<Item> getInventory(){
        return inventory;
    }

    public Item searchByTitle(String title){
        String cleanedTitle = title.strip().toLowerCase();
        for (Item item: inventory){
            if(item.getTitle().toLowerCase().equals(cleanedTitle)) return item;
        }
        return null;
    }

    public List<Item> inventoryReport(int choice){
        List<Item> invReport = new ArrayList<>();
        for(Item item: inventory){
            if(choice == 1 && item instanceof HWitem){
                invReport.add(item);
            } else if(choice == 2 && item instanceof SWItem){
                invReport.add(item);
            }
        }
        if(invReport.size() > 0) return invReport;
        return inventory;
    }

    private void initialiseInventory(){
        inventory.add(new HWitem("Mechanical Keyboard", 120.00, 1500, 1800, 2100, "Peripherals", "Logitech"));
        inventory.add(new HWitem("Gaming Monitor", 350.50, 4200, 3900, 5100, "Display", "ASUS"));
        inventory.add(new HWitem("1TB NVMe SSD", 95.00, 3100, 2900, 3400, "Storage", "Samsung"));
        inventory.add(new HWitem("Graphics Card RTX 4070", 599.99, 12000, 15000, 11000, "Processing", "NVIDIA"));
        inventory.add(new HWitem("Wi-Fi 6 Router", 89.99, 800, 950, 1100, "Networking", "TP-Link"));

        inventory.add(new SWItem("Photoshop", 239.88, 5000, 5200, 6100, "Graphics", "macOS"));
        inventory.add(new SWItem("Visual Studio Pro", 499.00, 8000, 7500, 9200, "IDE", "Windows"));
        inventory.add(new SWItem("CyberProtect Antivirus", 49.99, 1200, 1400, 1300, "Security", "Windows"));
        inventory.add(new SWItem("Final Cut Pro", 299.99, 3000, 3100, 2800, "Video Editing", "macOS"));
        inventory.add(new SWItem("Ubuntu Enterprise Server", 150.00, 4500, 4800, 5000, "OS Support", "Linux"));
    }

    public void displayInventory(){
        for (Item item : inventory) {
            System.out.println(item.toString() + "\n");
        }
    }
}
