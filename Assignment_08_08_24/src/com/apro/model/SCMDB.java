package com.apro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SCMDB {
    private Connection connection;
    private OperationsInterface<Supplier> supplierOps;
    private OperationsInterface<Product> productOps;
    private OperationsInterface<Order> orderOps;
    private OperationsInterface<OrderDetail> orderDetailOps;
    private OperationsInterface<Inventory> inventoryOps;
    private PreparedStatement preparedStatement;

    public SCMDB() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emarket", "root", "root");
            supplierOps = new SupplierOperations(connection);
            productOps = new ProductOperations(connection);
            orderOps = new OrderOperations(connection);
            orderDetailOps = new OrderDetailOperations(connection);
            inventoryOps = new InventoryOperations(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supplier methods
    public void getSuppliers() {
        supplierOps.get();
    }

    public void addSupplier(Supplier supplier) {
        supplierOps.add(supplier);
    }

    public void updateSupplier(Supplier supplier) {
        supplierOps.update(supplier);
    }

    public void deleteSupplier(int id) {
        supplierOps.delete(id);
    }
    
    public int checkSupplierExists(int id) {
    	return supplierOps.checkExists(id);
    }

    // Product methods
    public void getProducts() {
        productOps.get();
    }

    public void addProduct(Product product) {
        productOps.add(product);
    }

    public void updateProduct(Product product) {
        productOps.update(product);
    }

    public void deleteProduct(int id) {
        productOps.delete(id);
    }
    
    public int checkProductExists(int id) {
    	return productOps.checkExists(id);
    }

    // Order methods
    public void getOrders() {
        orderOps.get();
    }

    public void addOrder(Order order) {
        orderOps.add(order);
    }

    public void updateOrder(Order order) {
        orderOps.update(order);
    }

    public void deleteOrder(int id) {
        orderOps.delete(id);
    }
    public int checkOrderExists(int id) {
    	return orderOps.checkExists(id);
    }
    
    // OrderDetail methods
    public void getOrderDetails() {
        orderDetailOps.get();
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetailOps.add(orderDetail);
    }

    public void updateOrderDetail(OrderDetail orderDetail) {
        orderDetailOps.update(orderDetail);
    }

    public void deleteOrderDetail(int id) {
        orderDetailOps.delete(id);
    }

    // Inventory methods
    public void getInventory() {
        inventoryOps.get();
    }

    public void addInventory(Inventory inventory) {
        inventoryOps.add(inventory);
    }

    public void updateInventory(Inventory inventory) {
        inventoryOps.update(inventory);
    }

    public void deleteInventory(int id) {
        inventoryOps.delete(id);
    }
    
 // Custom Query Methods
    public void listProductsWithSupplierNames() {
        try {
            preparedStatement = connection.prepareStatement(
                "SELECT p.*, s.name AS supplierName " +
                "FROM emarket.products p " +
                "JOIN emarket.suppliers s ON p.suppliersId = s.suppliersId"
            );
            ResultSet result = preparedStatement.executeQuery();
           if(!result.isBeforeFirst()) {
        	   System.out.println("No Result Found");
        	   return;
           }
           while (result.next()) {
               System.out.println(result.getInt("productId") + "\t" + result.getString("name") + "\t" +
                                  result.getString("supplierName"));
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getOrdersWithDetails() {
        try {
            preparedStatement = connection.prepareStatement(
                "SELECT o.ordersId, o.orderDate, od.orderDetailId, p.name AS ProductName, " +
                "od.quantity AS Quantities, od.price " +
                "FROM emarket.orders o " +
                "JOIN emarket.orderdetails od ON o.ordersId = od.orderId " +
                "LEFT JOIN emarket.products p ON od.productId = p.productId"
            );
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                System.out.println(result.getInt("ordersId") + "\t" + result.getDate("orderDate") + "\t" +
                                   result.getInt("orderDetailId") + "\t" + result.getString("ProductName") + "\t" +
                                   result.getInt("Quantities") + "\t" + result.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findSuppliersByProductId(int productId) {
        try {
            preparedStatement = connection.prepareStatement(
                "SELECT s.* " +
                "FROM emarket.suppliers s " +
                "LEFT JOIN emarket.products p ON s.suppliersId = p.suppliersId " +
                "WHERE p.productId = ?"
            );
            preparedStatement.setInt(1, productId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                System.out.println(result.getInt("suppliersId") + "\t" + result.getString("name") + "\t" +
                                   result.getString("contactInfo") + "\t" + result.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listProductsAndInventoryLevels() {
        try {
            preparedStatement = connection.prepareStatement(
                "SELECT p.*, i.quantityonHand AS CurrentInventoryLevels " +
                "FROM emarket.products p " +
                "LEFT JOIN emarket.inventory i ON p.productId = i.productId"
            );
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                System.out.println(result.getInt("productId") + "\t" + result.getString("name") + "\t" +
                                   result.getInt("CurrentInventoryLevels"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findOrdersLastMonth() {
        try {
            preparedStatement = connection.prepareStatement(
                "SELECT * " +
                "FROM emarket.orders " +
                "WHERE orderDate >= CURRENT_DATE() - INTERVAL 1 MONTH"
            );
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                System.out.println(result.getInt("ordersId") + "\t" + result.getDate("orderDate") + "\t" +
                                   result.getInt("suppliersId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void totalQuantityOrderedForEachProduct() {
        try {
            preparedStatement = connection.prepareStatement(
                "SELECT p.productId, p.name AS ProductName, SUM(od.quantity) AS TotalQuantityOrdered " +
                "FROM emarket.orderdetails od " +
                "LEFT JOIN emarket.products p ON od.productId = p.productId " +
                "GROUP BY p.productId"
            );
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                System.out.println(result.getInt("productId") + "\t" + result.getString("ProductName") + "\t" +
                                   result.getInt("TotalQuantityOrdered"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void retrieveOrdersWithTotalAmount() {
        try {
            preparedStatement = connection.prepareStatement(
                "SELECT o.*, SUM(od.price * od.quantity) AS totalAmountSpent " +
                "FROM emarket.orders o " +
                "JOIN emarket.orderdetails od ON o.ordersId = od.orderId " +
                "GROUP BY o.ordersId"
            );
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                System.out.println(result.getInt("ordersId") + "\t" + result.getDate("orderDate") + "\t" +
                                   result.getDouble("totalAmountSpent"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findProductsSuppliedByMoreThanOneSupplier() {
        try {
            preparedStatement = connection.prepareStatement(
                "SELECT p.*, COUNT(p.suppliersId) AS supplierCount " +
                "FROM emarket.products p " +
                "JOIN emarket.suppliers s ON p.suppliersId = s.suppliersId " +
                "GROUP BY p.productId " +
                "HAVING COUNT(p.suppliersId) > 1"
            );
            ResultSet result = preparedStatement.executeQuery();
            if(!result.isBeforeFirst()) {
         	   System.out.println("No Result Found");
         	   return;
            }
            while (result.next()) {
                System.out.println(result.getInt("productId") + "\t" + result.getString("name") + "\t" +
                                   result.getInt("supplierCount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void averageInventoryLevelForEachProduct() {
        try {
            preparedStatement = connection.prepareStatement(
                "SELECT p.*, AVG(i.quantityonHand) AS AverageInventoryLevel " +
                "FROM emarket.products p " +
                "JOIN emarket.inventory i ON p.productId = i.productId " +
                "GROUP BY p.productId, p.name"
            );
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                System.out.println(result.getInt("productId") + "\t" + result.getString("name") + "\t" +
                                   result.getDouble("AverageInventoryLevel"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listSuppliersWithNoProducts() {
        try {
            preparedStatement = connection.prepareStatement(
                "SELECT s.* " +
                "FROM emarket.suppliers s " +
                "LEFT JOIN emarket.products p ON s.suppliersId = p.suppliersId " +
                "WHERE p.productId IS NULL"
            );
            ResultSet result = preparedStatement.executeQuery();
            if(!result.isBeforeFirst()) {
         	   System.out.println("No Result Found");
         	   return;
            }
            while (result.next()) {
                System.out.println(result.getInt("suppliersId") + "\t" + result.getString("name") + "\t" +
                                   result.getString("contactInfo") + "\t" + result.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}


