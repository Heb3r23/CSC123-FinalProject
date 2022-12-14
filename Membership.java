import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Membership {
	private static int membershipNumCount = 1000;
	private int membershipNum;
	private String fName;
	private String lName;
	private Date dob;
	private String city;
	private String zipCode;
	private Person guardian;
	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	
	public Membership(Person member) {
		fName = member.getfName();
		lName = member.getlName();
		dob = member.getDob();
		city = member.getCity();
		zipCode = member.getZipCode();
		membershipNum = ++membershipNumCount;
	}
	public Membership(Person member, Person guard) {
		this(member);
		guardian = guard;
	}
	public boolean isAdult() {
		
		Calendar tod = Calendar.getInstance();
		
		Calendar comp = Calendar.getInstance();
		comp.set(tod.get(Calendar.YEAR)-18,tod.get(Calendar.MONTH), tod.get(Calendar.DAY_OF_MONTH)) ;
		
		
		if(comp.getTime().before(dob)) {
			return false;
		}
		
		return true;
	}
	public int getMembershipNum() {
		return membershipNum;
	}
	public void setMembershipNum(int membershipNum) {
		this.membershipNum = membershipNum;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getDob() {
		return df.format(dob);
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public Person getGuardian() {
		return guardian;
	}
	public void setGuardian(Person guardian) {
		this.guardian = guardian;
	}
	
	@Override
	public String toString() {
		String ret = (fName + " : " + lName + " : " + df.format(dob) + " : " + city + " : " + zipCode + " Membership Number " + membershipNum);
		if (guardian != null) {
			ret += "\n" + "Guardian Details: \n" + guardian;
		}
		return ret;
	}
}
