import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Person {
	private String fName;
	private String lName;
	private Date dob;
	private String city;
	private String zipCode;
	private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyy");
	
	
	public Person(String fn, String ln, String bd, String cty, String zip) throws Exception{
		fName = fn;
		lName = ln;
		dob = df.parse(bd);
		city = cty;
		zipCode = zip;
	}
	
	public boolean isAdult() {
		Date today = new Date();
		today.setHours(0);
		Date compBd = new Date();
		compBd.equals(today);
		compBd.setYear(today.getYear()-18);
		if(compBd.before(dob)) {
			return false;
		}
		
		return true;
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


	@Override
	public String toString(){
		String ret = (fName + " : " + lName + " : " + df.format(dob) + " : " + city + " : " + zipCode );
		return (ret);
	}
}
