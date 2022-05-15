package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Customer {
	// Connect to the DB
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/electrogrid", "root", "");

			// For testing
			System.out.print("Succesfully connected to the DB");
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

	         //Insert Power
			public String insertCustomer(String name, String email, String address, String district)
			{ 
				Connection con = connect();
				String output = "";
				try
				 { 
					  
					 if (con == null) 
					 { 
					    return "Error while connecting to the database"; 
					 } 
					 
					 // create a prepared statement
					 String query = " insert into customer (id,name,email,address,district)" + " values (?, ?, ?, ?, ?)";
					 PreparedStatement Pstatement = con.prepareStatement(query); 
					 
					 // binding values
					 Pstatement.setInt(1, 0); 
					 Pstatement.setString(2, name); 
					 Pstatement.setString(3, email); 
					 Pstatement.setString(4, address); 
					 Pstatement.setString(5, district);
					 
					 
					 
					//execute the statement
					 
					 Pstatement.execute(); 
					 con.close();
					// System.out.println(query);
					 String newCustomer = readCustomer(); 
					 output = "{\"status\":\"success\", \"data\": \"" + 
					 newCustomer + "\"}"; 
					 
					// output = "Power Inserted successfully"; 
				 } 
				
				catch (Exception e) 
				 { 
					 output = "{\"status\":\"error\", \"data\": \"Error while inserting the Customer.\"}"; 
					// output = "Error while inserting"; 
					 
					System.err.println(e.getMessage()); 
					e.printStackTrace();
				 } 
				//binding values
				return output; 
			}

			//Read the Power
			public String readCustomer()
			{ 
				 String output = ""; 
				 
				 try
				 { 
				
			     Connection con = connect(); 
				 if (con == null) 
				 { 
					 return "Error while connecting to the database for reading the Customer."; 
				 } 
				 
				 
				 // Prepare the html table to be displayed
				 output = "<table border='1' class='table bg-dark text-light text-center table-hover'>"
				 		 + "<tr><th>name</th>" 
						 +"<th>email</th>"
						 + "<th>address</th>"
						 + "<th>district</th>" 
						 +"<th>Update</th>"
						 + "<th>Delete</th></tr>"; 
				 
				 String query = "select * from customer"; 
				 
				 Statement stmt = (Statement) con.createStatement(); 
				 ResultSet res = ((java.sql.Statement) stmt).executeQuery(query); 
				 
				 // iterate through the rows in the result set
				 while (res.next()) 
				 { 
					 String id  = Integer.toString(res.getInt("id")); 
					 String name  = res.getString("name"); 
					 String email  = res.getString("email"); 
					 String address  = res.getString("address"); 
					 String district  = res.getString("district"); 
					
					 
					 // Add a row into the html table
					 output += "<tr><td>" + name  + "</td>"; 
					 output += "<td>" + email + "</td>"; 
					 output += "<td>" + address  + "</td>";
					 output += "<td>" + district  + "</td>"; 
					
					 
					 // buttons
					 output += "<td><input name='btnUpdate' type='button' value='Update' "
							 + "class='btnUpdate btn btn-secondary' data-id='" + id  + "'></td>"
							 + "<td><input name='btnRemove' type='button' value='Remove' "
							 + "class='btnRemove btn btn-danger' data-id='" + id + "'></td></tr>";
				 } 
				 
				con.close(); 
				
				     // Complete the html table
				     output += "</table>"; 
				 } 
				 
				catch (Exception e) 
				 { 
					 output = "Error while reading the Customer details."; 
					 System.err.println(e.getMessage()); 
				 } 
				
				
				return output; 
			}

	// Update buyers in the table
	public String updateCustomer(String id, String name , String email, String address, String district)
			{ 
				 String output = ""; 
				 try
				 { 
				 Connection con = connect(); 
				 if (con == null) 
				 {
					 return "Error while connecting to the database for updating the customer."; 
					 
				 } 
				 // create a prepared statement
				 String query = "UPDATE customer  SET name =?,email =?,address =?,district =? WHERE id =? ";
					
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 
				 // binding values
				 
				 preparedStmt.setString(1, name); 
				 preparedStmt.setString(2, email); 
				 preparedStmt.setString(3, address); 
				 preparedStmt.setString(4, district); 
				 preparedStmt.setInt(5, Integer.parseInt(id)); 
				 
				 
				 // execute the statement
				    preparedStmt.execute();			 
				    con.close(); 
				    String newCustomer = readCustomer(); 
					 output = "{\"status\":\"success\", \"data\": \"" + 
					 newCustomer + "\"}"; 
					 
				   // output = "Customer Updated successfully"; 
				 } 
				 
				 catch (Exception e) 
				 { 
					 output = "{\"status\":\"error\", \"data\": \"Error while Updating the Customer.\"}"; 
				     //output = "Error while updating the power details."; 
				     System.err.println(e.getMessage()); 
				     e.printStackTrace();
				 } 
				 
				 return output; 
				 }

	// Delete buyer in the table
	public String deleteCustomer(String id ) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting the Customer.";
			}

			// create a prepared statement
			String query = "delete from customer where id =?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(id));

			// execute the statement
			preparedStmt.execute();
			con.close();

			  String newCustomer = readCustomer(); 
				 output = "{\"status\":\"success\", \"data\": \"" + 
				 newCustomer + "\"}"; 
		//	output = "Power details Deleted successfully";

		} catch (Exception e) {
			 output = "{\"status\":\"error\", \"data\": \"Error while Deleting the Customer.\"}"; 
		//	output = "Error while deleting the Power details.";
			System.err.println(e.getMessage());
		}

		return output;
	}

}

