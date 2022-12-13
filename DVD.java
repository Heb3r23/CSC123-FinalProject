import java.text.SimpleDateFormat;
import java.util.Date;

public class DVD extends Material{
	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyy");
	private Date releaseDate;
	private int durationMin;
	
	public DVD() {
		
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
