import java.util.HashMap;
import java.util.ArrayList;

public class Library {
	private static HashMap<Integer, Membership> memMap = new HashMap<Integer, Membership>();
	private static HashMap<Integer, Material> inventoryList = new HashMap<Integer, Material>();
	
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
	public static void printMembers() {
		
	}
	public static Membership lookUpMember(int memNum) {
		
		return memMap.get(memNum);
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
		if((lookupMaterial(lookupNum) != null) && (lookupMaterial(lookupNum).isAvailable())){
			Loan l = new Loan(lookupMaterial(lookupNum), m);
			System.out.println("Item loaned to member: " + m.getMembershipNum());
		}
		else if(lookupMaterial(lookupNum) != null && (lookupMaterial(lookupNum).isAvailable()==false)){
			System.out.println("Item on loan");
		}
		else {
			System.out.println("Error: Item does not exit");
		}
		
	}
}
