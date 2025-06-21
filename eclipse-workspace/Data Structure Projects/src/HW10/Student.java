package HW10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Student {

	private String first,last;
	private int id;
	private float grade;
	ArrayList<Student> added = new ArrayList<>();
	Scanner fileInput = new Scanner("/Users/elijahjay/eclipse-workspace/Practice/src/HW/students.txt");
	
	public Student (){
		
	}
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
	public String getName() {
		return first+" "+last;
	}
	public int getid() {
		return id;
	}
	public float getGrade() {
		return grade;
	}

	public Scanner getFileInput() {
		return fileInput;
	}
	
	public void getList(ArrayList<Student> added) {
		for (Student e : added) {
			System.out.println(e);
		}
	}
	
	@Override
	public String toString() {
		return first+" "+last+" "+id+" "+grade;
		
	}

	
	public ArrayList<Student> setGetFileInput(Scanner fileInput) {
		int count = 0;
		while(fileInput.hasNext()) {
			this.first = fileInput.next();
			this.last = fileInput.next();
			this.id = fileInput.nextInt();
			this.grade = fileInput.nextFloat();
			
			this.added.add(new Student(first,last,id,grade));
			count++;
		}
		return new ArrayList<>(count);
	}
	
	



	
}
