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
		
		int tempRepVal;
		boolean tempFlag;
		String tempTitle;
		String tempLocation;
		
		String tempAuth;
		String tempIsbn;
		int tempNumPages;
		
		String tempPubDate;
		int tempIssue;
		
		String tempRelDate;
		int tempDuration;
		String type;
		
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
				System.out.println("Enter material type (Book, Magazine, DVD): ");
				type = input.nextLine();
				System.out.println("Please enter replacement value");
				tempRepVal = input.nextInt();
				input.nextLine();
				System.out.println("Please enter true if this material is suitable for children, otherwise enter false (Lowercase. Case Sensitive): ");
				tempFlag = input.nextBoolean();
				input.nextLine();
				System.out.println("Please enter the the location of this item (in format \"shelfid.location\" e.g \"101.12\"");
				tempLocation = input.nextLine();
				System.out.println("Please enter the title of the material: ");
				tempTitle = input.nextLine();
				
				if (type.equalsIgnoreCase("Book")) {
					System.out.println("Please enter the author of the book: ");
					tempAuth = input.nextLine();
					System.out.println("Please enter the ISBN of the book: ");
					tempIsbn = input.nextLine();
					System.out.println("Please enter the number of pages of the book: ");
					tempNumPages = input.nextInt();
					input.nextLine();
					
					Book b = new Book(tempRepVal, tempFlag, true, tempTitle, tempAuth, tempIsbn, tempNumPages, tempLocation);
					Library.addMaterial(b);
					
					System.out.println("Item created with ItemID: " + b.getItemId());
				}
				else if(type.equalsIgnoreCase("Magazine")) {
					System.out.println("Please enter the publication date of the magazine (format MM/dd/yyyy): ");
					tempPubDate = input.nextLine();
					System.out.println("Please enter the issue number of the magazine: ");
					tempIssue = input.nextInt();
					input.nextLine();
					
					Magazine m = new Magazine(tempRepVal, tempFlag, true, tempTitle, tempPubDate, tempIssue, tempLocation);
					Library.addMaterial(m);
					
					System.out.println("Item created with ItemID: " + m.getItemId());
				}
				else if((type.equalsIgnoreCase("DVD"))){
					System.out.println("Please enter the release date of the DVD (format MM/dd/yyyy): ");
					tempRelDate = input.nextLine();
					System.out.println("Please enter the duration(in minutes) of the DVD: ");
					tempDuration = input.nextInt();
					input.nextLine();
					
					DVD d = new DVD(tempRepVal, tempFlag, true, tempTitle,tempRelDate, tempDuration, tempLocation);
					Library.addMaterial(d);
					
					System.out.println("Item created with ItemID: " + d.getItemId());
					
				}
				else {
					System.out.println("Error: invalid type input");
				}
			} 
			else if (menuSelection == 3) {
				int lookupNumber;
				int lookupNumber2;
				System.out.println("Please enter itemID for item to issue");
				lookupNumber = input.nextInt();
				input.nextLine();
				System.out.println("Please enter memberID of member recieving item");
				lookupNumber2 = input.nextInt();
				input.nextLine();
				
				Membership m = Library.lookUpMember(lookupNumber2);
				if(m != null) {
					Library.issueItem(m, lookupNumber);
				}
				else {
					System.out.println("Error, invalid memberID");
				}
				
			} 
			else if (menuSelection == 4) {
				int lookupNumber;
				
				System.out.println("Please enter itemID for item to return");
				lookupNumber = input.nextInt();
				input.nextLine();
				
				Library.returnItem(lookupNumber);
			} 
			else if (menuSelection == 5) {
				Library.reportInventory();
			} 
			else if (menuSelection == 6) {
				Library.reportLoans();
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
			input.nextLine();
		}

	}

	public static void printMenu() {
		System.out.println(
				"\n\n1 - New Membership \n2 - Add Material \n3 - Issue Item \n4 - Return Item \n5 - Report Inventory  \n6 - Report Loans \n7 - Lookup Membership \n8 - Exit \n\nPlease enter your choice:");
	}
}
