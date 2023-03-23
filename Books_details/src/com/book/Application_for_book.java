package com.book;

import java.util.Scanner;

public class Application_for_book {

	public static void main(String[] args) {
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
				//	add new book		
				break;
			case 2:
				//find the book in between 1000 and 200
			    break;
			case 3:
				//Change the Auther Name by Book ID
			    break;
			case 4:
				//Delete the Book in data bases
			    break;
			case 5:
				// Display book which is publish is particular year
			    break;
            case 6:
				//display all book
			    break;
			 default:
				 System.out.println("please enter valid number valid number");
			}
			
			
		}while(res!=0);
		sc.close();
	}

}
