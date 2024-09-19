package models;

import java.util.UUID;

public class Product {
    private static long productIdCounter = 1;  // Comienza en 1
    private long id;
    private double price;
    private String name;
    private String description;
    private Type type;

    public Product(double price, String name, String description, Type type) {
        this.id = generateProductId();  // Genera un ID unico
        this.price = price;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public enum Type {
        LIBRARY, ELECTRONIC, OTHER
    }

    // Getters y Setters
    public long getId() { return id; }
    public double getPrice() { return price; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Type getType() { return type; }

    public void setPrice(double price) { this.price = price; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setType(Type type) { this.type = type; }

    // Metodo para generar un ID unico
    private synchronized long generateProductId() {
        return productIdCounter++;  // Incrementa el contador
    }

    // toString
    @Override
    public String toString() {
        return String.format("%-10s | %-3s | %-15s | %-20s | %.2f",
                id, type, name, description, price);
    }
}
