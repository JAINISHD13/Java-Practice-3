import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo {

	static String jdbcURL = "jdbc:postgresql://localhost:5432/Shopme";
	static String username = "postgres";
	static String password  = "root";	
	
	private static void insertQuery()
	{
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL,username,password);
			
			System.out.println("Connect to PostgreSQL Server");
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter firstname:");
			String fname = sc.next();
			
			System.out.println("Enter lastname:");
			String lname = sc.next();
			
			System.out.println("Enter email id:");
			String email = sc.next();
						
			String inserQuery = "Insert into contacts (first_name,last_name,email)"+
			"values('"+fname+"','"+lname+"','"+email+"')";
			
			Statement stmt = connection.createStatement();
			int rows = stmt.executeUpdate(inserQuery);
			
			if(rows>0)
				System.out.println("A new contact has been added!");

			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in conneting to PostgreSQL server");
			e.printStackTrace();
		}

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//insertQuery();
		//fetchResult();
		//fetchUnique();
		//insertjoinQuery();
		//joinQuery();
		//fetchJoinData();
		//updateDate();
	}


	private static void updateDate() {
		// TODO Auto-generated method stub
		try {
			
			Connection con = DriverManager.getConnection(jdbcURL,username,password);  
			
			String update = "update employee_details set e_date =  '2021-04-25' where e_name = 'Jainish';";		
			
			Statement stmt=con.createStatement();  
			
			int rows = stmt.executeUpdate(update);
	
			if(rows>0)
				System.out.println("Rows Updated!");
			
			con.close();  
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  
	}


	private static void fetchJoinData() {
		// TODO Auto-generated method stub
		try {
			
			Connection con=DriverManager.getConnection(  
					"jdbc:postgresql://localhost:5432/Shopme","postgres","root");  
					
			Statement stmt=con.createStatement();  

			ResultSet rs=stmt.executeQuery("select employee.e_name, employee_details.e_date from employee inner join employee_details on employee.e_name = employee_details.e_name;");  
//			ResultSet rs=stmt.executeQuery("select DISTINCT last_name,first_name,email from contacts");  
			
			while(rs.next())  
				System.out.println(rs.getString(1)+"  "+rs.getString(2));  
			
			con.close();  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}


	private static void joinQuery() {
		// TODO Auto-generated method stub
		
		try {
			
			Connection con=DriverManager.getConnection(  
					"jdbc:postgresql://localhost:5432/Shopme","postgres","root");  
					
			Statement stmt=con.createStatement();  

		//	ResultSet rs=stmt.executeQuery("select * from contacts");  
			ResultSet rs=stmt.executeQuery("select contacts.first_name,contacts.last_name,contacts.email,address.city,address.state from contacts,address "
					+ "where address.email = contacts.email");  
			
			while(rs.next())  
				System.out.println("  "+rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3) + " "+ rs.getString(4)+" "+ rs.getString(4)+" "+rs.getString(5));  
			
			con.close();  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  		
	}


	private static void insertjoinQuery() {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter email:");
		String email = sc.next();
		
		System.out.println("Enter city:");
		String city = sc.next();
		
		System.out.println("Enter state:");
		String state = sc.next();
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL,username,password);
			
			String insert = "insert into address(email,city,state)"
					+ "values('"+email+"','"+city+"','"+state+"')";		

			Statement stmt = connection.createStatement();
			int rows = stmt.executeUpdate(insert);
			
			if(rows>0)
				System.out.println("A new contact has been added!");

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in conneting to PostgreSQL server");
			e.printStackTrace();
		}	
	}


	private static void fetchUnique() {
		// TODO Auto-generated method stub
		try {
			
			Connection con = DriverManager.getConnection(jdbcURL,username,password);  
			
			//String insert = "insert into employee_details(e_name,e_date) values('Ravi','2021-04-24');";		
			
			Statement stmt=con.createStatement();  
			
			//int rows = stmt.executeUpdate(insert);
	
			//if(rows>0)
			//	System.out.println("Rows Inserted!");
			
			con.close();  
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  
	}
	
	private static void fetchResult() {
		// TODO Auto-generated method stub
		
		try {
			
			Connection con=DriverManager.getConnection(  
					"jdbc:postgresql://localhost:5432/Shopme","postgres","root");  
					
			Statement stmt=con.createStatement();  

			ResultSet rs=stmt.executeQuery("select * from contacts");  
//			ResultSet rs=stmt.executeQuery("select DISTINCT last_name,first_name,email from contacts");  
			
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4));  
			
			con.close();  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
				
	}

}
