import java.text.SimpleDateFormat;
import java.util.Date;

public class Magazine extends Material {
	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyy");
	private Date publicationDate;
	private int issueNumber;
	
	public Magazine() {
		
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
	
}
