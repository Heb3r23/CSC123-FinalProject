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

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public Date getDue() {
		return due;
	}

	public void setDue(Date due) {
		this.due = due;
	}

	public Material getLoanedItem() {
		return loanedItem;
	}

	public void setLoanedItem(Material loanedItem) {
		this.loanedItem = loanedItem;
	}

	public Membership getBorrower() {
		return borrower;
	}

	public void setBorrower(Membership borrower) {
		this.borrower = borrower;
	}
	
	@Override
	public String toString() {
		String status="Child";
		if(borrower.getGuardian()== null) {
			status = "Adult";
		}
		
		String ret = "Item ID " + loanedItem.getItemId() + " : " + loanedItem.getTitle() + " : " + borrower.getfName() + " " + borrower.getlName() + " : " + status + " : " + borrower.getDob();
		
		return ret;
	}
}
