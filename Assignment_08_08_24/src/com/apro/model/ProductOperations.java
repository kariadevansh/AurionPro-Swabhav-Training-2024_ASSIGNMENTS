package com.apro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductOperations implements OperationsInterface<Product> {
	private Connection connection;
	private PreparedStatement preparedStatement;

	public ProductOperations(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void get() {
		try {
			preparedStatement = connection.prepareStatement("select * from products");
			ResultSet dbProductData = preparedStatement.executeQuery();
			while (dbProductData.next()) {
				System.out.println(dbProductData.getInt(1) + "\t" + dbProductData.getString(2) + "\t"
						+ dbProductData.getString(3) + "\t" + dbProductData.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void add(Product product) {
		try {
			PreparedStatement checkStatement = connection
					.prepareStatement("SELECT COUNT(*) FROM products WHERE suppliersId = ?");
			checkStatement.setInt(1, product.getId());
			ResultSet resultSet = checkStatement.executeQuery();
			if (resultSet.next() && resultSet.getInt(1) > 0) {
				// Supplier already exists
				System.out.println("Product with ID " + product.getId() + " already exists.");
				return; // Exit the method if the supplier exists
			}
			preparedStatement = connection.prepareStatement("INSERT INTO products  VALUES (?, ?, ?, ?)");
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setInt(4, product.getSupplierId());
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Product added. Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Product product) {
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE products SET name = ?, description = ?, suppliersId = ? WHERE productId = ?");
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setInt(3, product.getSupplierId());
			preparedStatement.setInt(4, product.getId());
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Product updated. Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM products WHERE productId = ?");
			preparedStatement.setInt(1, id);
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Product deleted. Rows affected: " + rowsAffected);
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
			// Check if the product exists
			checkStatement = connection.prepareStatement("SELECT * FROM products WHERE productId = ?");
			checkStatement.setInt(1, id);
			resultSet = checkStatement.executeQuery();

			if (!resultSet.next()) {
				// Product does not exist
				System.out.println("The product with ID: " + id + " does not exist!");

				boolean flag = true;
				while (flag) {
					System.out.println("\n1. Use an existing product or 2. Add a new product");
					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Use any of these products:");
						get(); // Display all products
						System.out.println("Select any ID from here:");
						int newId = scanner.nextInt();
						flag = false;
						return newId;
					case 2:
						System.out.println("Add a new product");
						System.out.println("Enter Product ID:");
						int productId = scanner.nextInt();
						System.out.println("Enter Product Name:");
						String productName = scanner.next();
						System.out.println("Enter Product Description:");
						String productDescription = scanner.next();
						System.out.println("Enter Supplier ID:");
						int supplierId = scanner.nextInt();
						add(new Product(productId, productName, productDescription, supplierId));
						flag = false;
						return productId;
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
