package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.sql.Statement;



public class Application_for_book {

	
	static Connection get_Connection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResourceBundle rs=ResourceBundle.getBundle("dbdetail");
		String url=rs.getString("url");
		String username=rs.getString("username");
		String password=rs.getString("password");
		return DriverManager.getConnection(url,username,password);
	}
	static void closetheconnection(Connection con) throws SQLException {
		if(con!=null) {
			con.close();
		}
	}
	static void addBookToDatabase(Scanner sc) throws ClassNotFoundException, SQLException {
		Connection con=get_Connection();
		Statement st=con.createStatement();
		
		System.out.println("Enter the book id");
		int bid=sc.nextInt();
		System.out.println("Enter the Book name");
		String bname=sc.next();
		System.out.println("Enter the Price");
		Double bprice=sc.nextDouble();
		System.out.println("enter the auther name");
		String bAutherName=sc.next();
		System.out.println("enter the publish year");
		String b_publish_year=sc.next();
		
		String query="insert into Book values("+bid+",'"+bname+"',"+bprice+",'"+b_publish_year+"','"+bAutherName+"');";
		int res=st.executeUpdate(query);
		if(res>0) {
			System.out.println("Book added successfully ");
		}
		else{
			System.out.println("Book not added ");
		}
		closetheconnection(con);
	}
	
	static void findBookInRange1000_2000() throws ClassNotFoundException, SQLException {
		Connection con=get_Connection();
		Statement st=con.createStatement();
		String query="select * from Book where bookPrice between "+1000.00+" and "+2000.00+";";
		System.out.println(query);
		ResultSet rs=st.executeQuery(query);
		if(!rs.isBeforeFirst()&& rs.getRow()==0) {
			System.out.println("no Book present");
		}
		else {
			while(rs.next()) {
				System.out.print(" Book ID "+rs.getInt(1));
				System.out.print(" Book Name "+rs.getString(2));
				System.out.print(" Book Price "+rs.getDouble(3));
				System.out.print(" Book PublishYear "+rs.getString(4));
				System.out.println(" Book Auther "+rs.getString(5));
			}
		}
		closetheconnection(con);
	}
	static void findBookByAutherName(Scanner sc) throws ClassNotFoundException, SQLException {
		Connection con=get_Connection();
		Statement st=con.createStatement();
		System.out.println("Enter the Book ID number");
		int bid=sc.nextInt();
		System.out.println("ENter the Book Auther");
		String bAuther =sc.next();
		String query="update Book set bookAuther='"+bAuther+"' where bookId='"+bid+"';";
		int res=st.executeUpdate(query);
		if(res>0) {
			System.out.println("Auther Name Updated");
		}
		else {
			System.out.println("Invalid ID");
		}
		closetheconnection(con);
	}

	static void publishBookInParticularYear(Scanner sc) throws ClassNotFoundException, SQLException {
		Connection con=get_Connection();
		Statement st=con.createStatement();
		System.out.println("Enter the Year of Publish");
		String PYear=sc.next();
		String query="select * from Book where publishYear='"+PYear+"';";
		ResultSet rs=st.executeQuery(query);
		if(!rs.isBeforeFirst()&& rs.getRow()==0) {
			System.out.println("No Books available ");
		}
		else {
			while(rs.next()) {
				System.out.print("  Book ID "+rs.getInt(1));
				System.out.print("  Book Name "+rs.getString(2));
				System.out.print("  Book Price "+rs.getDouble(3));
				System.out.print("  Book PublishYear "+rs.getString(4));
				System.out.println("  Book Auther "+rs.getString(5));
			}
		}
		closetheconnection(con);
	}
	
	static void displayBook() throws ClassNotFoundException, SQLException {
		Connection con=get_Connection();
		Statement st=con.createStatement();
		
		String query="select * from Book ;";
		ResultSet rs=st.executeQuery(query);
		if(!rs.isBeforeFirst()&& rs.getRow()==0) {
			System.out.println("No Books available ");
		}
		else {
			while(rs.next()) {
				System.out.print("  Book ID "+rs.getInt(1));
				System.out.print("  Book Name "+rs.getString(2));
				System.out.print("  Book Price "+rs.getDouble(3));
				System.out.print("  Book PublishYear "+rs.getString(4));
				System.out.println("  Book Auther "+rs.getString(5));
			}
		}
		closetheconnection(con);
	}
	
//	//delete the book
	
	static void  deletebook(Scanner sc) throws ClassNotFoundException, SQLException {
		Connection con=get_Connection();
		Statement st=con.createStatement();
		System.out.println("Enter the book id ");
		int bid=sc.nextInt();
		String query="delete from Book where bookId="+bid+" ;";
		int res=st.executeUpdate(query);
		if(res>0) {
			System.out.println("Book deleted successfully");
		}
		else {
			System.out.println(" Book not availavle for this id");
		}
		closetheconnection(con);
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub


		Scanner sc=new Scanner(System.in);
		int res=0;
		do {
			System.out.println("========================================================================================");
			System.out.println("Please enter your choice");
			System.out.println("0 for exit");
			System.out.println("1 for add the Book detail");
			System.out.println("2 find the book which has price between 1000 to 2000");
			System.out.println("3 update the auther's Name by id");
			System.out.println("4 Delete the book by id");
			System.out.println("5 display all book in given year ");
			System.out.println("6 Display list of book ");
			System.out.println();
			res=sc.nextInt();
			switch(res) {
			case 0://0 fro exit
				System.out.println("thanks for your services");
			    break;
			case 1:
				addBookToDatabase(sc);
				break;
			case 2:
				findBookInRange1000_2000();
			    break;
			case 3:
				findBookByAutherName(sc);
				break;
			case 4:
				deletebook(sc);
			    break;
			case 5:
				publishBookInParticularYear(sc);
			    break;
            case 6:
            	displayBook();
			    break;
			 default:
				 System.out.println("please enter valid number valid number");
			}
			
			
		}while(res!=0);
		sc.close();
	}

}
