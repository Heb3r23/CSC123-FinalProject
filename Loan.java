import java.text.SimpleDateFormat;
import java.util.Date;

public class Loan {
	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyy");
	private static int loanIdCount = 5000;
	private int loanId;
	private Date due;
	private Material loanedItem;
	private Membership borrower;
	
	public Loan(Material loan, Membership member) {
		loanId = ++loanIdCount;
		loanedItem = loan;
		borrower = member;
		due = new Date();
		Date today = new Date();
		today.setHours(0);
		due.setHours(today.getHours()+(24*loanedItem.getLoanPeriod()));
		loanedItem.setAvailable(false);
	}
}
