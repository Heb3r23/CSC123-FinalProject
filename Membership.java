import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Membership {
	private static int membershipNum = 1000;
	private String fName;
	private String lName;
	private Date dob;
	private String city;
	private String zipCode;
	private Person guardian;
	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyy");
	
	public Membership(Person member) {
		fName = member.getfName();
		lName = member.getlName();
		dob = member.getDob();
		city = member.getCity();
		zipCode = member.getZipCode();
		membershipNum += 1;
	}
	public Membership(Person member, Person guard) {
		this(member);
		guardian = guard;
	}
	public int getMembershipNum() {
		return membershipNum;
	}
	public void setMembershipNum(int membershipNum) {
		Membership.membershipNum = membershipNum;
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
	public Date getDob() {
		return dob;
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
		String ret = (fName + " : " + lName + " : " + df.format(dob) + " : " + city + " : " + zipCode );
		if (guardian != null) {
			ret += "\n" + "Guardian Details: \n" + guardian;
		}
		return ret;
	}
}
