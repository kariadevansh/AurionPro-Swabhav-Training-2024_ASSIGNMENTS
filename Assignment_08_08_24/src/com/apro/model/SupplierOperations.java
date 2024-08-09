package com.apro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SupplierOperations implements OperationsInterface<Supplier> {
	private Connection connection;
	private PreparedStatement preparedStatement;

	public SupplierOperations(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void get() {
		try {
			preparedStatement = connection.prepareStatement("select * from suppliers");
			ResultSet dbSupplierData = preparedStatement.executeQuery();
			while (dbSupplierData.next()) {
				System.out.println(dbSupplierData.getInt(1) + "\t" + dbSupplierData.getString(2) + "\t"
						+ dbSupplierData.getString(3) + "\t" + dbSupplierData.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void add(Supplier supplier) {
		try {
			// Check if the supplier already exists
			PreparedStatement checkStatement = connection
					.prepareStatement("SELECT COUNT(*) FROM suppliers WHERE suppliersId = ?");
			checkStatement.setInt(1, supplier.getId());
			ResultSet resultSet = checkStatement.executeQuery();
			if (resultSet.next() && resultSet.getInt(1) > 0) {
				// Supplier already exists
				System.out.println("Supplier with ID " + supplier.getId() + " already exists.");
				return;
			}
			// Supplier does not exist, proceed with insertion
			preparedStatement = connection.prepareStatement("INSERT INTO suppliers VALUES (?, ?, ?, ?)");
			preparedStatement.setInt(1, supplier.getId());
			preparedStatement.setString(2, supplier.getName());
			preparedStatement.setString(3, supplier.getContact());
			preparedStatement.setString(4, supplier.getAddress());
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Supplier added. Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Supplier supplier) {
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE suppliers SET name = ?, contactInfo = ?, address = ? WHERE suppliersId = ?");
			preparedStatement.setString(1, supplier.getName());
			preparedStatement.setString(2, supplier.getContact());
			preparedStatement.setString(3, supplier.getAddress());
			preparedStatement.setInt(4, supplier.getId());
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Supplier updated. Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM suppliers WHERE suppliersId = ?");
			preparedStatement.setInt(1, id);
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Supplier deleted. Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int checkExists(int id) {
		Scanner scanner = new Scanner(System.in);
		PreparedStatement preparedStatement = null;
		ResultSet dbSupplierData = null;

		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM suppliers WHERE suppliersId = ?");
			preparedStatement.setInt(1, id);
			dbSupplierData = preparedStatement.executeQuery();

			if (!dbSupplierData.next()) {
				System.out.println("The supplier with ID: " + id + " does not exist!");

				boolean flag = true;
				while (flag) {
					System.out.println("\n1. Use an existing one or 2. Add new supplier ");
					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Use any of these suppliers:");
						get();
						System.out.println("Select any id from here:");
						int newId = scanner.nextInt();
						flag = false;
						return newId;
					case 2:
						System.out.println("Add new supplier");
						System.out.println("Enter Supplier ID:");
						int supplierId = scanner.nextInt();
						System.out.println("Enter Supplier Name:");
						String supplierName = scanner.next();
						System.out.println("Enter Supplier Contact:");
						String supplierContact = scanner.next();
						System.out.println("Enter Supplier Address:");
						String supplierAddress = scanner.next();
						add(new Supplier(supplierId, supplierName, supplierContact, supplierAddress));
						flag = false;
						return supplierId;
					default:
						System.out.println("Select a valid option");
						break;
					}
				}
			}

			scanner.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
}
