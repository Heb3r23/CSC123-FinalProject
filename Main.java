import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Main {
	public static void main(String[] args) throws Exception {
		Library mainLib = new Library();
		Scanner input = new Scanner(System.in);
		int menuSelection = 0;
		String tempfName;
		String templName;
		String tempDob;
		String tempCity;
		String tempZip;
		
		printMenu();
		menuSelection = input.nextInt();
		input.nextLine();
		
		while (menuSelection != 8) {
			if (menuSelection == 1) {
				System.out.println("Please enter your first name: ");
				tempfName = input.nextLine();
				System.out.println("Please enter your last name: ");
				templName = input.nextLine();
				System.out.println("Please enter your date of birth (format MM/dd/yyyy): ");
				tempDob = input.nextLine();
				System.out.println("Please enter your city: ");
				tempCity = input.nextLine();
				System.out.println("Please enter your zip code: ");
				tempZip = input.nextLine();
				
				Person p = new Person(tempfName, templName, tempDob, tempCity, tempZip);
				if(p.isAdult()){
					Membership temp = Library.createNewMembership(p, null);
					System.out.println("Membership created with membershipID: " + temp.getMembershipNum());
				}
				else {
					System.out.println("Person entered is a child and will need to input guardian info: \n");
					System.out.println("Please enter guardian's first name: ");
					tempfName = input.nextLine();
					System.out.println("Please enter guardian's last name: ");
					templName = input.nextLine();
					System.out.println("Please enter guardian's date of birth (format MM/dd/yyyy): ");
					tempDob = input.nextLine();
					System.out.println("Please enter guardian's city: ");
					tempCity = input.nextLine();
					System.out.println("Please enter guardian's zip code: ");
					tempZip = input.nextLine();
					Person g = new Person(tempfName, templName, tempDob, tempCity, tempZip);
					
					Membership temp = Library.createNewMembership(p, g);
					System.out.println("Membership created with membershipID: " + temp.getMembershipNum());
				}
				
			} 
			else if (menuSelection == 2) {

			} 
			else if (menuSelection == 3) {

			} 
			else if (menuSelection == 4) {

			} 
			else if (menuSelection == 5) {

			} 
			else if (menuSelection == 6) {

			} 
			else if (menuSelection == 7) {
				int lookupNumber = 1000;
				System.out.println("Please enter membership number to lookup: ");
				lookupNumber = input.nextInt();
				Membership m = Library.lookUpMember(lookupNumber);
				if (m == null) {
					System.out.println("Error: membership not found");
				}
				else {
					System.out.println(m);
				}
			} 
			else if (menuSelection == 8) {
				System.exit(0);
			}
			printMenu();
			menuSelection = input.nextInt();
		}

	}

	public static void printMenu() {
		System.out.println(
				"\n\n1 - New Membership \n2 - Add Material \n3 - Issue Item \n4 - Return Item \n5 - Report Inventory  \n6 - Report Loans \n7 - Lookup Membership \n8 - Exit \n\nPlease enter your choice:");
	}
}
