package studentSort_Timespan_linkedlist;

import java.io.*;
import java.util.*;


public class StudentSorter {

	public static void main(String[] args) throws FileNotFoundException{

		List<Student> added = new ArrayList<>();
		Scanner fileInput= new Scanner(new File("/Users/elijahjay/eclipse-workspace/Practice/src/HW/students.txt"));

		while(fileInput.hasNext()) {
			added.add(new Student(fileInput.next(),fileInput.next(),fileInput.nextInt(),fileInput.nextFloat()));
		}
		Iterator<Student> it = added.iterator();
		while(it.hasNext()) {
			System.out.println(it.next()+" \n");
		}
		Scanner keyboard = new Scanner(System.in);
		char choice;

		do {
			System.out.print("Choices:\n"
					+ "F - sort by first name\n"
					+ "L - sort by last name\n"
					+ "I - sort by id\n"
					+ "G - sort by grade\n"
					+ "Q - quit\n");
			choice = keyboard.next().charAt(0);
			switch (choice) {
			case 'F':
				added.sort((i1,i2) -> i1.getFirst().compareTo(i2.getFirst()));
				System.out.println("students sorted by first name:");
				StudentSorter.printList(added);
				break;
			case 'L':
				added.sort((i1,i2) -> i1.getLast().compareTo(i2.getLast()));
				System.out.println("students sorted by last name:");
				StudentSorter.printList(added);	
				break;
			case 'I':
				added.sort((i1,i2) -> Integer.compare(i1.getid(), i2.getid()));
				System.out.println("students sorted by id:");
				StudentSorter.printList(added);
				break;
			case 'G':
				added.sort((i1,i2) -> Float.compare(i1.getGrade(), i2.getGrade()));
				System.out.println("students sorted by grade:");
				StudentSorter.printList(added);
				break;
			case 'Q':
				keyboard.close();
				fileInput.close();
				break;
			default:
				System.out.println("Invalid choice");
			}
		} while (choice != 'Q');

	}
	public static void printList(List<Student> added) {
		for (Student e : added) {
			System.out.println(e);
		}	
	}
}

class Student{
	private String first,last;
	private int id;
	private float grade;

	public Student (){	}

	public Student(String first,String last, int id, float grade){
		this.first= first;
		this.last= last;
		this.id = id;
		this.grade = grade;
	}

	public int getId(){
		return id;
	}
	public String getLast() {
		return last;
	}
	public String getFirst() {
		return first;
	}
	public int getid() {
		return id;
	}
	public float getGrade() {
		return grade;
	}

	public void getList(List<Student> added) {
		for (Student e : added) {
			System.out.println(e);
		}
	}

	@Override
	public String toString() {
		return first+" "+last+" "+id+" "+grade;		
	}
}