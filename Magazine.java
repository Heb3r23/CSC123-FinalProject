import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Magazine extends Material {
	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	private Date publicationDate;
	private int issueNumber;
	
	public Magazine(int rv, boolean f, boolean available, String tit, String pubDate, int issue, String loc) {
		super(rv, 2, f, available, tit, loc);
		try {
			publicationDate = df.parse(pubDate);
		}
		catch (ParseException p){
			System.out.println("ERROR: Unexpected date format, must enter as (MM/dd/yyyy)");
		}
		issueNumber = issue;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public int getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}
	
	@Override
	public String toString() {
		String ret = itemId + " : " + "Magazine" + " : " + "Available: " + isAvailable;
		if(isAvailable != true) {
			ret += " : " + "Currently loaned to " + Library.lookupLoan(itemId).getBorrower().getfName() + ", ID: " + Library.lookupLoan(itemId).getBorrower().getMembershipNum();
		}
		return ret;
	}
}
