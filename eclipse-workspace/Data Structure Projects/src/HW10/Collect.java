package HW10;
import java.util.*;
public class Collect implements Comparator<Student> {

	public static void main(String[] args) {
		
		//args = new String[] {"2","8","5","6","4","6","10","2","3","5","7","5"};
		args = new String[] {"1","3","2","4","5","6","7","8","9","10","11","12","1","2","3"};

		int num=0;
		
	Set<Integer> workID = new TreeSet<>();
	
	//Array list is
	List<Integer> studentID = new ArrayList<>();
	
	Map<Integer,String> nameMap = new TreeMap<>();
	
	Student student = new Student() ;
	try {
		//FOR LOOP
		for (String s : args) {
		// student = new Student("hello","world",Integer.valueOf(s)*12,8);
		//	num = Integer.parseInt(s);
			workID.add(student.getId());
			studentID.add(student.getId());
			nameMap.put(student.getId(), student.getName());
		}
		
		//studentID.remove(0);
		//System.out.print(nameMap.size()+"\n");
		
		
		//HashMap/TreeMap

		//System.out.println(nameMap.put(9,"new"));
		//System.out.println(nameMap.put(10,"news"));
	//	System.out.println(nameMap.put(11,"Views"));
		//System.out.println(nameMap.put(9,"Cow"));
Comparator<Student> com = (i1,i2) -> i1.getName().compareTo(i2.getName());
		
Collections.sort(studentID);
		System.out.println("1 map :: "+nameMap.entrySet());
		
		//System.out.print(nameMap.get(nameMap)+"\n");
		//System.out.println(nameMap.get(17));
		
		
		
		//System.out.println("Output of get "+studentID.get(11));
		//studentID.getFirst();
		//ArrayList
		//Collections.swap(studentID, 0, studentID.size()-1);
		
		System.out.println("2 arraylist:: "+studentID);
		//System.out.println(studentID.get(11));

		//System.out.print(studentID.size()+"\n");
		
		//HashSet/TreeSet
		System.out.println("3 hash set :: "+workID);
		//System.out.print(workID.size()+"\n");
		//workID.clear();
		//System.out.print(workID.isEmpty()+"\n");

		//Iterator
			Iterator<Integer> employees = workID.iterator();
			
		for (Integer o :workID) {
			//System.out.println(o);
			
		}
		System.out.println();

			while(employees.hasNext()) {		
		//System.out.println(employees.next()+ " ");
		
				}
			
				
			
		} catch (IllegalArgumentException e) {
			System.out.print("Wrong input");
		}
		catch (IndexOutOfBoundsException e) {
			
			System.out.print("Out of bound ");

		}
		System.out.println();
		System.out.print("hello");
		
	}

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getName().compareTo(o2.getName());
	}

}

class byName implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
	return o1.getName().compareTo(o2.getName());
	}
	
	
}
	

