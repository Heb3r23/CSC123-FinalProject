import java.util.HashMap;
import java.util.ArrayList;

public class Library {
	private static HashMap<Integer, Membership> memMap = new HashMap<Integer, Membership>();
	private static HashMap<Integer, Material> inventoryList = new HashMap<Integer, Material>();
	private static HashMap<Integer, Loan> loans = new HashMap<Integer, Loan>();
	
	public Library() {
		
	}
	
	public static Membership createNewMembership(Person p, Person g) throws Exception {	
		Membership m = new Membership(p, g);
		addMember(m);
		return m;
		
	}
	public static void addMember(Membership m) {
		memMap.put((m.getMembershipNum()), m);
	}
	public static Membership lookUpMember(int memNum) {
		
		return memMap.get(memNum);
	}
	public static Loan lookupLoan(int lookupNum) {
		if(loans.containsKey(lookupNum)) {
			return loans.get(lookupNum);
		}
		else {
			return null;
		}
	}
	public static void addMaterial(Material m) {
		inventoryList.put(m.getItemId(), m);
	}
	public static void reportInventory() {
		for(int i = 0; i < inventoryList.size(); i++) {
			System.out.println(inventoryList.get(i+9001));
		}
	}
	public static Material lookupMaterial(int lookupNum) {
		if(inventoryList.containsKey(lookupNum)) {
			return inventoryList.get(lookupNum);
		}
		else {
			return null;
		}
	}
	public static void issueItem(Membership m, int lookupNum) {
		if((lookupMaterial(lookupNum) != null) && (lookupMaterial(lookupNum).isAvailable()) && (lookupMaterial(lookupNum).flag)){
			Loan l = new Loan(lookupMaterial(lookupNum), m);
			loans.put(lookupNum, l);
			System.out.println("Item loaned to member: " + m.getMembershipNum() + " with loanID: " + l.getLoanId());
		}
		else if((lookupMaterial(lookupNum) != null) && (lookupMaterial(lookupNum).isAvailable()) && (!lookupMaterial(lookupNum).flag) && (m.isAdult())){
			Loan l = new Loan(lookupMaterial(lookupNum), m);
			loans.put(lookupNum, l);
			System.out.println("Item loaned to member: " + m.getMembershipNum() + " with loanID: " + l.getLoanId());
		}
		else if((lookupMaterial(lookupNum) != null) && (lookupMaterial(lookupNum).isAvailable()) && (!lookupMaterial(lookupNum).flag) && (!m.isAdult())){
			System.out.println("Error, this material is not suitable for children ");
		}
		else if(lookupMaterial(lookupNum) != null && (lookupMaterial(lookupNum).isAvailable()==false)){
			System.out.println("Item on loan");
		}
		else {
			System.out.println("Error: Item does not exit");
		}
		
	}
	public static void returnItem(int lookupNum) {
		if(lookupMaterial(lookupNum) == null) {
			System.out.println("Error: Item does not exist");
		}
		else if(lookupMaterial(lookupNum) != null && (lookupMaterial(lookupNum).isAvailable()==true)){
			System.out.println("Error: Item has already been returned");
		}
		else {
			Material m = lookupMaterial(lookupNum);
			m.setAvailable(true);
			loans.remove(lookupNum);
			
			System.out.println("Item " + lookupNum +  " returned successfully");
		}
	}
	public static void reportLoans() {
		
		int i = 9001;
		int count = loans.size();
		int flag = 0;
		
		while(count != flag) {
			if(loans.containsKey(i)) {
				System.out.println(loans.get(i));
				flag++;
				i++;
			}
		}
	}
}
