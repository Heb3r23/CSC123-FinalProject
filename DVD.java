import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DVD extends Material{
	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyy");
	private Date releaseDate;
	private int durationMin;
	
	public DVD(int rv, boolean f, boolean available, String tit, String relDate, int duration) throws ParseException {
		super(rv, 2, f, available, tit);
		releaseDate = df.parse(relDate);
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
	
	
}
