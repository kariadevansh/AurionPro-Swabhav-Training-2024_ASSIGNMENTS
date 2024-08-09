package com.apro.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryOperations implements OperationsInterface<Inventory> {
	private Connection connection;
	private PreparedStatement preparedStatement;

	public InventoryOperations(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void get() {
		try {
			preparedStatement = connection.prepareStatement("select * from inventory");
			ResultSet dbInventoryData = preparedStatement.executeQuery();
			while (dbInventoryData.next()) {
				System.out.println(dbInventoryData.getInt(1) + "\t" + dbInventoryData.getInt(2) + "\t"
						+ dbInventoryData.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void add(Inventory inventory) {
		try {
			PreparedStatement checkStatement = connection
					.prepareStatement("SELECT COUNT(*) FROM products WHERE suppliersId = ?");
			checkStatement.setInt(1, inventory.getInventoryId());
			ResultSet resultSet = checkStatement.executeQuery();
			if (!resultSet.next() && resultSet.getInt(1) <= 0) {
				preparedStatement = connection.prepareStatement("INSERT INTO inventory  VALUES (?, ?, ?)");
				preparedStatement.setInt(1, inventory.getInventoryId());
				preparedStatement.setInt(2, inventory.getProductId());
				preparedStatement.setInt(3, inventory.getQuantityOnHand());
				int rowsAffected = preparedStatement.executeUpdate();
				System.out.println("Inventory added. Rows affected: " + rowsAffected);
				return;
			}
			System.out.println("Inventory with ID " + inventory.getInventoryId()+ " already exists.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Inventory inventory) {
		try {
			preparedStatement = connection
					.prepareStatement("UPDATE inventory SET quantityOnHand = ? WHERE inventoryId = ?");
			preparedStatement.setInt(1, inventory.getProductId());
			preparedStatement.setInt(2, inventory.getQuantityOnHand());
			preparedStatement.setInt(3, inventory.getInventoryId());
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Inventory updated. Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM inventory WHERE inventoryId = ?");
			preparedStatement.setInt(1, id);
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Inventory deleted. Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int checkExists(int id) {
		return id;
		// TODO Auto-generated method stub
		
	}
}
