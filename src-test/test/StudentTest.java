package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import daten.Student;

public class StudentTest {
	
	private Student s1;
	private Student s2;
	private Student s3;
	private Student s4, s5, s6, s7, s8;
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Student> studentsSorted = new ArrayList<Student>();
	
	@Before
	public void setUp() throws Exception {
		s1 = new Student("Martin", "Hofer");
		s2 = new Student("Maddin", "Hoffer");
		s3 = new Student("Martin", "Hofer");
		s1.setDate(new Date(94,04,13));
		s2.setDate(new Date(75,01,01)); 
		s3.setDate(new Date(94,04,13));
		
		s5 = new Student("Martin", "Hofer");
		s5.setDate(new Date(98,04,13));
		s6 = new Student("Martin", "Hofer");
		s6.setDate(new Date(90,04,13));
		s4 = new Student("Martin", "Hofer");
		s4.setDate(new Date(94,02,13));
		s7 = new Student("Martin", "Hofer");
		s7.setDate(new Date(94,04,18));
		s8 = new Student("Martin", "Hofer");
		s8.setDate(new Date(94,04,11));
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		students.add(s6);
		students.add(s7);
		students.add(s8);
		
		
		studentsSorted.add(s2);
		studentsSorted.add(s6);
		studentsSorted.add(s4);
		studentsSorted.add(s8);
		studentsSorted.add(s1);
		studentsSorted.add(s3);
		studentsSorted.add(s7);
		studentsSorted.add(s5);
	}

	
	@Test
	public void toStringTest() {
		
		assertEquals("Student {firstName=Martin, lastName=Hofer} - 13.4.94",s1.toString());
	}
	@Test
	public void compareToTest() {
		
		assertEquals(-1, s1.compareTo(s2));
		assertEquals(0, s1.compareTo(s3));
	}
	
	@Test
	public void sortByDateTest() {
		assertEquals(studentsSorted, s1.sortByDate(students));
	}

}
