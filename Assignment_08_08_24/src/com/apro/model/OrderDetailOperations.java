package com.apro.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailOperations implements OperationsInterface<OrderDetail> {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public OrderDetailOperations(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void get() {
    	try {
    		
			preparedStatement = connection.prepareStatement("select * from orderdetails");
			ResultSet dbOrderDetailsData = preparedStatement.executeQuery();
			while (dbOrderDetailsData.next()) {
				System.out.println(dbOrderDetailsData.getInt(1) + "\t" + dbOrderDetailsData.getInt(2) + "\t"
						+ dbOrderDetailsData.getInt(3) + "\t" + dbOrderDetailsData.getInt(4) + "\t"
						+ dbOrderDetailsData.getDouble(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public void add(OrderDetail orderDetail) {
    	try {
    		PreparedStatement checkStatement = connection
					.prepareStatement("SELECT COUNT(*) FROM products WHERE suppliersId = ?");
			checkStatement.setInt(1, orderDetail.getOrderDetailId());
			ResultSet resultSet = checkStatement.executeQuery();
			if (!resultSet.next() && resultSet.getInt(1) <= 0) {
				preparedStatement = connection.prepareStatement("INSERT INTO orderdetails VALUES (?, ?, ?, ?, ?)");            preparedStatement.setInt(1, orderDetail.getOrderDetailId());
	            preparedStatement.setInt(2, orderDetail.getOrderId());
	            preparedStatement.setInt(3, orderDetail.getProductId());
	            preparedStatement.setInt(4, orderDetail.getQuantity());
	            preparedStatement.setDouble(5, orderDetail.getPrice());
	            int rowsAffected = preparedStatement.executeUpdate();
	            System.out.println("OrderDetail added. Rows affected: " + rowsAffected);
	            return;
			}
			System.out.println("OrderDetail with ID " + orderDetail.getOrderDetailId() + " already exists.");
			
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(OrderDetail orderDetail) {
    	try {
			preparedStatement = connection
					.prepareStatement("UPDATE orderdetails SET quantity = ? , price = ? WHERE orderDetailId = ? ");
            preparedStatement.setInt(1, orderDetail.getQuantity());
            preparedStatement.setDouble(2, orderDetail.getPrice());
            preparedStatement.setInt(3, orderDetail.getOrderDetailId());
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("OrderDetail updated. Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
    	try {
			preparedStatement = connection.prepareStatement("DELETE FROM orderdetails WHERE orderDetailId = ?");            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("OrderDetail deleted. Rows affected: " + rowsAffected);
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
