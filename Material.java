import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Material {
	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyy");
	protected static int itemIdCount = 9000;
	protected int itemId;
	protected int replacementValue;
	protected int loanPeriod;
	protected boolean flag;
	protected boolean isAvailable;
	protected String title;
	protected String location;
	
	public Material(int rv, int lp, boolean f, boolean available, String tit, String loc) throws ParseException {
		replacementValue = rv;
		loanPeriod = lp;
		flag = f;
		isAvailable = available;
		title = tit;
		itemId = ++itemIdCount;
		location = loc;
	}
	public void setIsAvailable(boolean set) {
		isAvailable = set;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getLoanPeriod() {
		return loanPeriod;
	}
	public void setLoanPeriod(int loanPeriod) {
		this.loanPeriod = loanPeriod;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
