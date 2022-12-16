import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DVD extends Material{
	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyy");
	private Date releaseDate;
	private int durationMin;
	
	public DVD(int rv, boolean f, boolean available, String tit, String relDate, int duration, String loc) throws ParseException {
		super(rv, 2, f, available, tit, loc);
		try {
			releaseDate = df.parse(relDate);
		}
		catch (ParseException p){
			System.out.println("ERROR: Unexpected date format, must enter as (MM/dd/yyyy)");
		}
		durationMin = duration;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getDurationMin() {
		return durationMin;
	}

	public void setDurationMin(int durationMin) {
		this.durationMin = durationMin;
	}
	
	@Override
	public String toString() {
		String ret = itemId + " : " + "DVD" + " : " + "Available: " + isAvailable;
		if(isAvailable != true) {
			ret += " : " + "Currently loaned to " + Library.lookupLoan(itemId).getBorrower().getfName() + ", ID: " + Library.lookupLoan(itemId).getBorrower().getMembershipNum();
		}
		return ret;
	}
}
