import java.text.ParseException;

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
	
	
	public Person(String fn, String ln, String bd, String cty, String zip) {
		fName = fn;
		lName = ln;
		try {
			dob = df.parse(bd);
		}
		catch (ParseException p){
			System.out.println("ERROR: Unexpected date format, must enter as (MM/dd/yyyy)");
		}
		city = cty;
		zipCode = zip;
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
