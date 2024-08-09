package com.apro.test;

import java.sql.Date;
import java.util.Scanner;

import com.apro.model.SCMDB;
import com.apro.model.Supplier;
import com.apro.model.Product;
import com.apro.model.Order;
import com.apro.model.OrderDetail;
import com.apro.model.Inventory;

public class SCMDBTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SCMDB db = new SCMDB(); // Updated to use SCMDB

		mainMenuDriver(scanner, db);

		scanner.close();
	}

	public static void mainMenuDriver(Scanner scanner, SCMDB db) {
		boolean flag = true;

		while (flag) {
			System.out.println("\nSelect an option:\n1. Get Records\t2. Add Records"
					+ "\t3. Update Records\t4. Delete Records\t5. Custom Queries\t6. EXIT");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				getMenuDriver(scanner, db);
				break;
			case 2:
				addMenuDriver(scanner, db);
				break;
			case 3:
				updateMenuDriver(scanner, db);
				break;
			case 4:
				deleteMenuDriver(scanner, db);
				break;
			case 5:
				customQueryMenuDriver(scanner, db);
				break;
			case 6:
				flag = false;
				System.out.println("Bye");
				break;
			default:
				System.out.println("Select a valid option");
				break;
			}
		}
	}

	public static void getMenuDriver(Scanner scanner, SCMDB db) {
		boolean flag = true;

		while (flag) {
			System.out.println("\nSelect the records to view:\n1. View Suppliers\t2. View Products\t3. View Orders"
					+ "\t4. View OrderDetails\t5. View Inventory\t6. BACK");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				db.getSuppliers();
				break;
			case 2:
				db.getProducts();
				break;
			case 3:
				db.getOrders();
				break;
			case 4:
				db.getOrderDetails();
				break;
			case 5:
				db.getInventory();
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("Select a valid option");
				break;
			}
		}
	}

	public static void addMenuDriver(Scanner scanner, SCMDB db) {
		boolean flag = true;

		while (flag) {
			System.out.println("\nSelect the record type to add:\n1. Add Supplier\t2. Add Product\t3. Add Order"
					+ "\t4. Add OrderDetail\t5. Add Inventory\t6. BACK");
			int choice = scanner.nextInt();
			// TODO : take single inputs and check if the foreign key values are present
			// if not present give option to add them
			// &display the values of the foreign keys that are present
			switch (choice) {
			case 1:
				System.out.println("Enter Supplier ID:");
				int supplierId = scanner.nextInt();
				System.out.println("Enter Supplier Name:");
				String supplierName = scanner.next();
				System.out.println("Enter Supplier Contact:");
				String supplierContact = scanner.next();
				System.out.println("Enter Supplier Address:");
				String supplierAddress = scanner.next();
				db.addSupplier(new Supplier(supplierId, supplierName, supplierContact, supplierAddress));
				break;

			case 2:
				System.out.println("Enter Product ID:");
				int productId = scanner.nextInt();
				System.out.println("Enter Product Name:");
				String productName = scanner.next();
				System.out.println("Enter Product Description:");
				String productDescription = scanner.next();
				System.out.println("Enter Supplier ID for Product:");
				int productSupplierId = scanner.nextInt();
				productSupplierId= db.checkSupplierExists(productSupplierId);
				db.addProduct(new Product(productId, productName, productDescription, productSupplierId));
				break;

			case 3:
				System.out.println("Enter Order ID:");
				int orderId = scanner.nextInt();
				System.out.println("Enter Order Date (YYYY-MM-DD):");
				String orderDateInput = scanner.next();
				Date orderDate = Date.valueOf(orderDateInput);
				System.out.println("Enter Supplier ID for Order:");
				int orderSupplierId = scanner.nextInt();
				orderSupplierId = db.checkSupplierExists(orderSupplierId);
				db.addOrder(new Order(orderId, orderDate, orderSupplierId));
				break;

			case 4:
				System.out.println("Enter Order Detail ID:");
				int orderDetailId = scanner.nextInt();
				System.out.println("Enter Order ID for Order Detail:");
				int detailOrderId = scanner.nextInt();
				detailOrderId = db.checkOrderExists(detailOrderId);
				
				System.out.println("Enter Product ID for Order Detail:");
				int detailProductId = scanner.nextInt();
				detailProductId = db.checkProductExists(detailProductId);
				
				System.out.println("Enter Quantity for Order Detail:");
				int detailQuantity = scanner.nextInt();
				System.out.println("Enter Price for Order Detail:");
				double detailPrice = scanner.nextDouble();
				db.addOrderDetail(
						new OrderDetail(orderDetailId, detailOrderId, detailProductId, detailQuantity, detailPrice));
				break;

			case 5:
				System.out.println("Enter Inventory ID:");
				int inventoryId = scanner.nextInt();
				System.out.println("Enter Product ID for Inventory:");
				int inventoryProductId = scanner.nextInt();
				inventoryProductId =db.checkProductExists(inventoryProductId);
				System.out.println("Enter Quantity On Hand for Inventory:");
				int inventoryQuantityOnHand = scanner.nextInt();
				db.addInventory(new Inventory(inventoryId, inventoryProductId, inventoryQuantityOnHand));
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("Select a valid option");
				break;
			}
		}
	}

	public static void updateMenuDriver(Scanner scanner, SCMDB db) {
		boolean flag = true;

		while (flag) {
			System.out.println(
					"\nSelect the record type to update:\n1. Update Supplier\t2. Update Product\t3. Update Order"
							+ "\t4. Update OrderDetail\t5. Update Inventory\t6. BACK");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter Supplier ID, Name, Contact, Address:");
				db.updateSupplier(new Supplier(scanner.nextInt(), scanner.next(), scanner.next(), scanner.next()));
				break;
			case 2:
				System.out.println("Enter Product ID, Name, Description, Supplier ID:");
				db.updateProduct(new Product(scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextInt()));
				break;
			case 3:
				System.out.println("Enter Order ID, Date (YYYY-MM-DD), Supplier ID:");
				db.updateOrder(new Order(scanner.nextInt(), Date.valueOf(scanner.next()), scanner.nextInt()));
				break;
			case 4:
				System.out.println("Enter OrderDetail ID, Quantity, Price:");
				db.updateOrderDetail(new OrderDetail(scanner.nextInt(), scanner.nextInt(), scanner.nextDouble()));
				break;
			case 5:
				System.out.println("Enter Inventory ID, Quantity On Hand:");
				db.updateInventory(new Inventory(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("Select a valid option");
				break;
			}
		}
	}

	public static void deleteMenuDriver(Scanner scanner, SCMDB db) {
		boolean flag = true;

		while (flag) {
			System.out.println(
					"\nSelect the record type to delete:\n1. Delete Supplier\t2. Delete Product\t3. Delete Order"
							+ "\t4. Delete OrderDetail\t5. Delete Inventory\t6. BACK");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter Supplier ID:");
				db.deleteSupplier(scanner.nextInt());
				break;
			case 2:
				System.out.println("Enter Product ID:");
				db.deleteProduct(scanner.nextInt());
				break;
			case 3:
				System.out.println("Enter Order ID:");
				db.deleteOrder(scanner.nextInt());
				break;
			case 4:
				System.out.println("Enter OrderDetail ID:");
				db.deleteOrderDetail(scanner.nextInt());
				break;
			case 5:
				System.out.println("Enter Inventory ID:");
				db.deleteInventory(scanner.nextInt());
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("Select a valid option");
				break;
			}
		}
	}

	public static void customQueryMenuDriver(Scanner scanner, SCMDB db) {
		boolean flag = true;

		while (flag) {
			System.out.println("\nSelect a custom query option:" + "\n1. List Products with Supplier Names"
					+ "\n2. Orders with Details" + "\n3. Suppliers for Specific Product"
					+ "\n4. Products and Inventory Levels" + "\n5. Orders Last Month"
					+ "\n6. Total Quantity Ordered for Each Product" + "\n7. Orders with Total Amount Spent"
					+ "\n8. Products Supplied by More Than One Supplier"
					+ "\n9. Average Inventory Level for Each Product" + "\n10. Suppliers with No Products"
					+ "\n11. BACK");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				db.listProductsWithSupplierNames();
				break;
			case 2:
				db.getOrdersWithDetails();
				break;
			case 3:
				System.out.println("Enter Product ID:");
				db.findSuppliersByProductId(scanner.nextInt());
				break;
			case 4:
				db.listProductsAndInventoryLevels();
				break;
			case 5:
				db.findOrdersLastMonth();
				break;
			case 6:
				db.totalQuantityOrderedForEachProduct();
				break;
			case 7:
				db.retrieveOrdersWithTotalAmount();
				break;
			case 8:
				db.findProductsSuppliedByMoreThanOneSupplier();
				break;
			case 9:
				db.averageInventoryLevelForEachProduct();
				break;
			case 10:
				db.listSuppliersWithNoProducts();
				break;
			case 11:
				flag = false;
				break;
			default:
				System.out.println("Select a valid option");
				break;
			}
		}
	}

	public void metaDataDriver() {

	}
}
