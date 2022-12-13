import java.util.HashMap;
import java.util.ArrayList;

public class Library {
	private static HashMap<Integer, Membership> memMap = new HashMap<Integer, Membership>();
	private static ArrayList<Material> inventoryList = new ArrayList<Material>();
	
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
}
