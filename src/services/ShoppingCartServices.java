package services;

import models.Product;
import models.ShoppingCart;
import models.ShoppingCartInterface;

import java.util.Comparator;


public class ShoppingCartServices implements ShoppingCartInterface {


    // Filtrar y mostrar productos con precio > 100 de la categoria LIBRARY
    public void imprimirProductosLibreriaConPrecioMayorA100(ShoppingCart cart) {
        System.out.println("Productos en la categoría LIBRERÍA con precio > 100:");
        cart.getProducts().stream()
                .filter(product -> product.getPrice() > 100 && product.getType() == Product.Type.LIBRARY)
                .forEach(System.out::println);
    }

    // Calcular y mostrar la suma total de los precios de todos los productos
    public double calcularPrecioTotal(ShoppingCart cart) {
        return cart.getProducts().stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    // Calcular y mostrar la suma de los precios de los productos de la categoría ELECTRONICS
    public double calcularPrecioTotalProductosElectronicos(ShoppingCart cart) {
        return cart.getProducts().stream()
                .filter(product -> product.getType() == Product.Type.ELECTRONIC)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    // Imprimir toda la información del carrito ordenada por precio
    public void imprimirInformacionCarritoOrdenadoPorPrecio(ShoppingCart cart) {
        System.out.printf("%-10s | %-3s | %-15s | %-20s | %-5s\n", "ID CarT", "ID", "TYPE", "NAME", "PRICE");
        System.out.println("-----------------------------------------------------------------------");

        cart.getProducts().stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .forEach(product -> System.out.printf(
                        "%-10s | %-3s | %-15s | %-20s | %.2f\n",
                        cart.getId(),
                        product.getId(),
                        product.getType(),
                        product.getName(),
                        product.getPrice()
                ));
    }

    // Ver productos en el carrito
    @Override
    public void viewCart(ShoppingCart cart) {
        System.out.println("Productos en el carrito:");
        cart.getProducts().forEach(product ->
                System.out.printf("%-3s | %-20s | %.2f\n",
                        product.getId(),
                        product.getName(),
                        product.getPrice()));
    }

    // Ver detalles de los productos en el carrito (con descripcion)
    @Override
    public void viewCartDetails(ShoppingCart cart) {
        System.out.println("Detalles de los productos en el carrito:");
        cart.getProducts().forEach(product ->
                System.out.printf("%-3s | %-20s | %.2f | %s\n",
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getDescription()));
    }

    @Override
    public void addProduct(ShoppingCart cart, Product product) {

    }

    @Override
    public void buyProducts(ShoppingCart cart) {

    }
}
