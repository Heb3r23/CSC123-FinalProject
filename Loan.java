import java.text.SimpleDateFormat;
import java.util.Date;

public class Loan {
	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyy");
	private static int loanId = 5000;
	private Date due;
	private Material loanedItem;
	private int memberId;
	
	public Loan() {
		
	}
}
