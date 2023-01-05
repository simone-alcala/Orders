package model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.enums.OrderStatus;

public class Order {
  private LocalDateTime moment;
  
  private OrderStatus status;
  private Client client;
  private List<OrderItem> orderItems = new ArrayList<OrderItem>();

  private static DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

  public Order() {}

  public Order(LocalDateTime moment, OrderStatus status, Client client) {
    this.moment = moment;
    this.status = status;
    this.client = client;
  }

  public LocalDateTime getMoment() {
    return moment;
  }

  public void setMoment(LocalDateTime moment) {
    this.moment = moment;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public List<OrderItem> getOrderItems() {
    return orderItems;
  }

  public void addItem(OrderItem orderItem) {
    orderItems.add(orderItem);
  }

  public void removeItem(OrderItem orderItem) {
    orderItems.remove(orderItem);
  }

  public Double getTotal() {
    Double total = 0.00;

    for (OrderItem item : orderItems) {
      total += item.subTotal();
    }

    return total;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    
    sb.append("Client: " + client.getName() + "\n");
    sb.append("Created at: " + moment.format(dateTimeFormat) + "\n");
    sb.append("Status: " + status + "\n");
    sb.append("Items: " + "\n");
    
    for (OrderItem item : orderItems) {
      sb.append(" > " + item.toString() + "\n");
    }
    
    sb.append("Total: $ " + String.format("%.2f", getTotal()));

    return sb.toString();
  }
}
