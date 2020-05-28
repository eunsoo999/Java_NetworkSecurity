import java.util.Arrays;

public class Diary implements Cloneable{
	private Date[] listOfDates;
	
	public Diary() {
		listOfDates = new Date[3];
		listOfDates[0] = new Date(2019, 5, 13);
		listOfDates[1] = new Date(2000, 1, 1);
		listOfDates[2] = new Date(1988, 12, 25);
	}
	
	public Diary(Date[] listOfDates) {
		super();
		this.listOfDates = listOfDates;
	}

	public Date[] getListOfDates() {
		return listOfDates;
	}

	public void setListOfDates(Date[] listOfDates) {
		this.listOfDates = listOfDates;
	}

	@Override
	public String toString() {
 		return Arrays.toString(listOfDates);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Diary myDiary = (Diary) super.clone();
		myDiary.listOfDates = (Date[]) listOfDates.clone();
		
		return myDiary;
	}
}
