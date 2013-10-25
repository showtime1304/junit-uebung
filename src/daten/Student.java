package daten;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Student extends Person implements Comparable<Student> {

	public Student(String firstName, String lastName) {
		this(firstName, lastName, false);
	}

	public Student(String firstName, String lastName, boolean selfEntitled) {
		super(firstName, lastName);
		setSelfEntitled(selfEntitled);
	}

	private boolean selfEntitled;
	private Date birthDate; // TODO add getter,setter,Constructors

	public void setSelfEntitled(boolean selfEntitled) {
		this.selfEntitled = selfEntitled;
	}
	public void setDate(Date birthDate)
	{
		this.birthDate=birthDate;
	}
	public Date getDate()
	{
		return birthDate;
	}

	@Override
	public int compareTo(Student o) {
		int result = 0;

		// TODO implement meaningful unit tests
		if ((result = getLastName().compareTo(o.getLastName())) == 0) {
			if ((result = getFirstName().compareTo(o.getFirstName())) == 0) {
				result = birthDate.compareTo(o.getDate()); // TODO change to
															// getter after
															// implementation
			}
		}
		return result;
	}
	
	
	public ArrayList<Student> sortByDate(ArrayList<Student> l) {
		Collections.sort(l, new Comparator<Student>(){
			public int compare(Student d1, Student d2) {
				if (d1.getDate().getYear() == d2.getDate().getYear()) {
					if (d1.getDate().getMonth() == d2.getDate().getMonth()) {
						if (d1.getDate().getDate() == d2.getDate().getDate()) {
							return 0;
						} else if (d1.getDate().getDate() > d2.getDate().getDate()) {
							return 1;
						}
					} else if (d1.getDate().getMonth() > d2.getDate().getMonth()) {
						return 1;
					}
				} else if (d1.getDate().getYear() > d2.getDate().getYear()) {
					return 1;
				}
				return -1;
			}
		});
		
		for(Student t: l) {
			System.out.println(t);
		}
		
		return l;
	}

	@Override
	public String toString() {
		// TODO missing implementation
		return super.toString() + " - " + this.getDate().getDate() + "." + this.getDate().getMonth() + "." + this.getDate().getYear();
	}
}
