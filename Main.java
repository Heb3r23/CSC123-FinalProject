import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int menuSelection = 0;
		
		
		Person pico = new Person("Pico", "Wyler", "12/13/2004", "Los Angeles", "90057");
		System.out.println(pico.isAdult());
		System.out.println(pico);
		
		printMenu();
		menuSelection = input.nextInt();
		while (menuSelection != 8) {
			if (menuSelection == 1) {
				
				
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
