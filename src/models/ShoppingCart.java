package models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private static long cartIdCounter = 120300;  // Comienza en 120300 como ejemplo
    private long id;
    private Customer customer;
    private List<Product> products;
    private Status status;

    public enum Status {
        DRAFT, SUBMIT
    }

    // Constructor
    public ShoppingCart(Customer customer) {
        this.id = generateCartId();  // Genera un ID unico para el carrito
        this.products = new ArrayList<>();
        this.status = Status.DRAFT;
        this.customer = customer;
    }

    // Metodo para generar un ID unico
    private synchronized long generateCartId() {
        return cartIdCounter++;  // Devuelve el valor actual y luego incrementa
    }

    public long getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Imprimir toda la informacion del carrito
    @Override
    public String toString() {
        StringBuilder printCart = new StringBuilder();

        // Secciones
        printCart.append(String.format("%-10s | %-3s | %-15s | %-20s | %-5s\n", "Cart ID", "ID", "PRODUCT TYPE", "PRODUCT NAME", "PRICE"));
        printCart.append("-----------------------------------------------------------------------\n");

        // Mostrar productos de la lista sin orden
        for (Product product : products) {
            printCart.append(String.format("%-10s | %-3s | %-15s | %-20s | %.2f\n",
                    id, // Cart ID
                    product.getId(),         // Product ID
                    product.getType(),      // Product Type
                    product.getName(),     // Product Name
                    product.getPrice())); // Price
        }

        return printCart.toString();
    }
}
