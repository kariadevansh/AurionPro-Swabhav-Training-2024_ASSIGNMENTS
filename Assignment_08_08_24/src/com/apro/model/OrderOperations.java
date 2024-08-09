package com.apro.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class OrderOperations implements OperationsInterface<Order> {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public OrderOperations(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void get() {
    	try {
			preparedStatement = connection.prepareStatement("select * from orders");
			ResultSet dbOrderData = preparedStatement.executeQuery();
			while (dbOrderData.next()) {
				System.out
						.println(dbOrderData.getInt(1) + "\t" + dbOrderData.getDate(2) + "\t" + dbOrderData.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void add(Order order) {
    	try {
    		PreparedStatement checkStatement = connection
					.prepareStatement("SELECT COUNT(*) FROM products WHERE suppliersId = ?");
			checkStatement.setInt(1, order.getId());
			ResultSet resultSet = checkStatement.executeQuery();
			if (!resultSet.next() && resultSet.getInt(1) <= 0) {
				preparedStatement = connection.prepareStatement("INSERT INTO orders  VALUES (?, ?, ?)");
	            preparedStatement.setInt(1, order.getId());
	            preparedStatement.setDate(2, order.getDate());
	            preparedStatement.setInt(3, order.getSupplierId());
	            int rowsAffected = preparedStatement.executeUpdate();
	            System.out.println("Order added. Rows affected: " + rowsAffected);
	            return;
			}
			System.out.println("Order with ID " + order.getId() + " already exists.");
			
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Order order) {
    	try {
			preparedStatement = connection
					.prepareStatement("UPDATE orders SET date = ?, suppliersId = ? WHERE ordersId = ?");
            preparedStatement.setDate(1, order.getDate());
            preparedStatement.setInt(2, order.getSupplierId());
            preparedStatement.setInt(3, order.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Order updated. Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
    	try {
			preparedStatement = connection.prepareStatement("DELETE FROM orders WHERE ordersId = ?");
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Order deleted. Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public int checkExists(int id) {
		 Scanner scanner = new Scanner(System.in);
		    PreparedStatement checkStatement = null;
		    ResultSet resultSet = null;

		    try {
		        // Check if the order exists
		        checkStatement = connection.prepareStatement("SELECT * FROM orders WHERE ordersId = ?");
		        checkStatement.setInt(1, id);
		        resultSet = checkStatement.executeQuery();

		        if (!resultSet.next()) {
		            // Order does not exist
		            System.out.println("The order with ID: " + id + " does not exist!");

		            boolean flag = true;
		            while (flag) {
		                System.out.println("\n1. Use an existing order or 2. Add a new order");
		                int choice = scanner.nextInt();
		                switch (choice) {
		                    case 1:
		                        System.out.println("Use any of these orders:");
		                        get(); // Display all orders
		                        System.out.println("Select any ID from here:");
		                        int newId = scanner.nextInt();
		                        flag = false;
		                        return newId;
		                    case 2:
		                        System.out.println("Add a new order");
		                        System.out.println("Enter Order ID:");
		                        int orderId = scanner.nextInt();
		                        System.out.println("Enter Order Date (YYYY-MM-DD):");
		                        java.sql.Date orderDate = java.sql.Date.valueOf(scanner.next());
		                        System.out.println("Enter Supplier ID:");
		                        int supplierId = scanner.nextInt();
		                        add(new Order(orderId, orderDate, supplierId));
		                        flag = false;
		                        return orderId;
		                    default:
		                        System.out.println("Select a valid option");
		                        break;
		                }
		            }
		        } 
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } 
		    scanner.close();
		return id;
		
	}
}
