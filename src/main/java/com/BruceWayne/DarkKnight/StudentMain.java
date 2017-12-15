package com.BruceWayne.DarkKnight;

import java.util.Scanner;


public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		int MID;
		 String Name=null; String Location;String Lead;String Track;String s;
		System.out.println("===========================DB_MENU=========================");
		Scanner scanner=new Scanner(System.in);
		do{
		System.out.println("Enter 1 for Insert");
		System.out.println("Enter 2 for Delete");
		System.out.println("Enter 3 to Get Data by MID");
		System.out.println("Enter 4 to Get All info from Database ");
		System.out.println("Enter 5 to Quit");
		n=scanner.nextInt();
     switch(n){
		
		case 1: 
		{
			System.out.println("Enter the MID of the Student");
		     MID=scanner.nextInt();
             scanner.nextLine();
			System.out.println("Enter the Name of the Student");
			Name=scanner.nextLine();
			System.out.println("Enter the Location of the Student");
			Location=scanner.nextLine();
			System.out.println("Enter the LeadName of the Student");
			Lead=scanner.nextLine();
			System.out.println("Enter the Track of the Student");
			Track=scanner.nextLine();
			StudentImply student=new StudentImply();
			student.setup();
			student.create(MID, Name, Location, Track, Lead);
			break;
		}
		case 2:{
			System.out.println("Enter the mid of the student");
			MID=scanner.nextInt();
			scanner.nextLine();
			StudentImply student=new StudentImply();
			student.setup();
			student.Delete(MID);
			break;
			
		}
		
		case 3:{
			System.out.println("Enter the MID of the student");
			MID=scanner.nextInt();
			scanner.nextLine();
			StudentImply student=new StudentImply();
			StudentRoot stu=new StudentRoot();
			student.setup();
			stu=student.ReadId(MID);
			System.out.println("=====================================================================================================");
			System.out.println("MID \t Name \t Location \t Lead \t Track");
			System.out.println(stu.getMID()+" \t "+stu.getName()+" \t "+stu.getLocation()+" \t "+stu.getLead()+" \t "+stu.getTrack());
			break;
		}
		case 4:{
			StudentImply student=new StudentImply();
			student.setup();
			student.readAllMessages();
			
		}
		}
		}while(n!=5);

		
		
	}

}

