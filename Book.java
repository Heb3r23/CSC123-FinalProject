import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book extends Material{
	private String author;
	private String isbn;
	private int numPages;
	
	public Book(int rv, boolean f, boolean available, String tit, String auth, String isb, int pages) throws ParseException {
		super(rv, 7, f, available, tit);
		author = auth;
		isbn = isb;
		numPages = pages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNumPages() {
		return numPages;
	}

	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}
	
	@Override
	public String toString() {
		String ret = itemId + " : " + "Book" + " : " + "Available: " + isAvailable;
		if(isAvailable != true) {
			ret += " : " + "Currently loaned to: ";
		}
		return ret;
	}
}
