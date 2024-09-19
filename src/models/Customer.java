package models;

import java.time.LocalDate;
import java.util.Date;

public class Customer {
    private static long customerIdCounter = 100;  // Comienza en 100 como ejemplo
    private long id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private String identificationNumber;
    private ShoppingCart shoppingCart;

    public Customer(String name, String lastName, LocalDate birthDate, String email, String phone, String identificationNumber) {
        this.id = generateCustomerId();  // Genera un ID unico para el cliente
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.identificationNumber = identificationNumber;
    }

    // Mutodo para generar un ID unico
    private synchronized long generateCustomerId() {
        return customerIdCounter++;  // Devuelve el valor actual y luego incrementa
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    @Override
    public String toString() {
        return String.format("Customer ID: %d, Name: %s %s, Identification: %s",
                id, name, lastName, identificationNumber);
    }
}
