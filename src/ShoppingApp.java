import models.Customer;
import models.Product;
import models.ShoppingCart;
import services.ShoppingCartServices;

import java.time.LocalDate;

public class ShoppingApp {
    public static void main(String[] args) {
        // Crear cliente
        Customer customer = new Customer("John", "Smith", LocalDate.of(1990, 1, 1), "john@gmail.com", "123456789", "DNI123");

        // Crear carrito
        ShoppingCart cart = new ShoppingCart(customer);

        // Agregar productos al carrito

        // Productos ELECTRONIC
        cart.getProducts().add(new Product(200.00, "CPU I5", "High performance CPU", Product.Type.ELECTRONIC));
        cart.getProducts().add(new Product(500.40, "CPU I7", "Top tier CPU", Product.Type.ELECTRONIC));
        cart.getProducts().add(new Product(150.00, "GPU RTX 3060", "Gaming Graphics Card", Product.Type.ELECTRONIC));

        // Productos LIBRARY
        cart.getProducts().add(new Product(15.40, "Harry Potter", "A great book", Product.Type.LIBRARY));
        cart.getProducts().add(new Product(20.30, "1984", "A dystopian novel", Product.Type.LIBRARY));
        cart.getProducts().add(new Product(120.00, "Java 8", "Programming book", Product.Type.LIBRARY));

        // Productos OTHER
        cart.getProducts().add(new Product(12.40, "T-shirt", "A cool t-shirt", Product.Type.OTHER));
        cart.getProducts().add(new Product(5.99, "Mug", "Coffee mug", Product.Type.OTHER));
        cart.getProducts().add(new Product(30.00, "Backpack", "Travel backpack", Product.Type.OTHER));

        // Instanciar shoppingCartServicews
        ShoppingCartServices shoppingCartService = new ShoppingCartServices();

        // Llamar a los metodos
        shoppingCartService.imprimirProductosLibreriaConPrecioMayorA100(cart);

        System.out.println();

        double totalPrecio = shoppingCartService.calcularPrecioTotal(cart);
        System.out.println("Suma total de precios de todos los productos: " + totalPrecio);

        System.out.println();


        double totalElectronicos = shoppingCartService.calcularPrecioTotalProductosElectronicos(cart);
        System.out.println("Suma total de precios de productos electrónicos: " + totalElectronicos);

        System.out.println();

        shoppingCartService.imprimirInformacionCarritoOrdenadoPorPrecio(cart);

    }
}
