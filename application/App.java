package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;

public class App {

    private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public static void main(String[] args) {

    Locale.setDefault(Locale.US);
    
    Product product1 = new Product("Monitor", 1000.00);
    Product product2 = new Product("Mouse", 40.00);
   
    OrderItem item1 = new OrderItem(1, 1000.00, product1);
    OrderItem item2 = new OrderItem(2, 40.00, product2);

    Client client = new Client(
      "Maria da Silva", 
      "maria.silva@gmail.com", 
      LocalDate.parse("13/12/2011", dateFormat)
    );

    Order order = new Order(LocalDateTime.now(), OrderStatus.PENDING, client);
    order.addItem(item1);
    order.addItem(item2);

    System.out.println("------------------------------------------");
    System.out.println("ORDER SUMMARY: ");
    System.out.println("------------------------------------------");
    System.out.println(order.toString());
    System.out.println("------------------------------------------");

  }

}