package practiceScene;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import studentSort_Timespan_linkedlist.ArrayDeque;

public class Rectangle<E,X,S> implements Comparable<Rectangle>{
	int height,width,size;
	String name;

	//E height;
	Rectangle(int h, int w, int s,String name){
		height = h;
		width = w;
		size= s;
		this.name = name;
	}

	public int getHeight(){
		return height;
	}
	public int getWidth(){
		return width;
	}
	public int getSize(){
		return size;
	}


	//HAS TO BE SORTED	
	public static int binarySearch(List<Integer> num,int start,int end,int target) {

		//int start = 0;
		//int index = 0;
		end = num.size()-1;

		while (start <= end) {
			int mid = (start + end) /2;

			//search middle element
			if (num.get(mid) == target) {
				return mid;	
			}

			//search first half of list
			else if (num.get(mid) < target) {
				binarySearch(num,start,mid -1,target);
			}

			//search second half of list
			else 
				binarySearch(num,mid +1,end,target);
		}
		return -1;
	}

	static int recSearch(List<Integer> L,int n) {
		Iterator<Integer> it = L.iterator();
		int c = L.size()-1;
		while(it.hasNext()){
			if (it.next() == 1) {
				return 1;
			}
			else if (it.next() >= 0) {
				return it.next();
			}
			c--;
		}	
		return n+recSearch(L,n-2);
	}

	public static void main(String[] args) {

		//List
	ArrayList<Integer> numbers = new ArrayList<>(List.of(3, 5, 8, 9, 2,2,9,9,7,15));

		
		//Deque<Integer> copy = new ArrayDeque<>();

		//Queue
		Queue<Integer> q = new LinkedList<>(List.of(7,5,3,1,1,9,11,12,12));



//		for (Integer n : numbers) {
//			q.add(n);
//		}
		
		//Set
		Set<String> se = new LinkedHashSet<>();
		
		
		//Map
		SequencedMap<String,Integer> map = new TreeMap<>();
		Map<Integer,String> map2 = new HashMap<>();




		//System.out.println("Queue");

		StringBuilder s = new StringBuilder("[");
		
//		//Queue iterator
	Iterator<Integer> ti= q.iterator();
//		
		//System.out.println(ti.next());
		//System.out.println(ti.next());
	
//
		while(ti.hasNext()) {
			String numb = ti.next().toString();	
			s.append(numb+" ");
		
			//Count in map
			map.put(numb,map.getOrDefault(numb, 0)+1);
			if(!ti.hasNext()) {
				s.append(numb+"]");	
			}
	}
		
		//Collection of entries from entry set in map
		Collection<Entry<String, Integer>> arr = map.entrySet();
		
	//	List<Collection<Integer>> sort = Arrays.asList(arr);
		
		//Iterator of entry from map
		Iterator<Entry<String, Integer>> mo = arr.iterator();


		
		System.out.println("String from Queue");
		System.out.println(s.toString());
		
		System.out.println("Map printed out value is count");
		System.out.println(map.toString());

		
		System.out.println("Map count elements");
		
		while (mo.hasNext()) {	
		System.out.print(mo.next()+ " ");
		}
		System.out.println();
		
		
		//Stack deque
		Deque<Integer> stack = new LinkedList<>(List.of(1,4,2,3,4,5,10));
		Queue<Integer> queue = new PriorityQueue<>(List.of(1,4,2,3,4,5,10));
		
	   IntStream ste = queue.stream().distinct().mapToInt(Integer :: intValue);
		
	   // Stream to count by 3
		Stream.iterate(0, i -> 3+i).skip(1).limit(10).forEach(System.out::println);
		
		System.out.println("Streams");
		
		queue.stream().mapToInt(Integer:: intValue).sorted().forEach(System.out::println);;
		
//		stack.stream().filter(i -> i%2 == 0)
//		.mapToInt(Integer:: intValue)
//		.forEach(System.out::print);

		int value = stack.stream()
				.filter(i -> i%2 == 0)
				.mapToInt(Integer:: intValue)
				.sum();
		
		//System.out.println(queue);

		//stack.stream().iterate(1,i -> i+1).limit(4).forEach(System.out::print);

		//System.out.println(recSearch(numbers,15));
		//Iterate

		Iterator<Integer> it= numbers.iterator();
		
		
		System.out.println();
		

		
		//collectionMystery1(numbers);
	}
		public static void collectionMystery1(ArrayList<Integer> list) {
		    for (int i = 0; i < list.size(); i++) {
		        int n = list.get(i);
		        list.remove(i);
		        if (n % 2 == 0) {
		            list.add(i);
		        }
		    }
		    System.out.println(list);
		}

		/*	while (it.hasNext()) {
			int i = it.next();
			int i8 = it.next();

			while (it.hasNext()) {

				int i2 = it.next();

				if (i2 == 9) {
					int dup = i2;
					//add to list
					stack.add(dup);
					it.remove();
					System.out.println(dup);		

				}


			}
			System.out.println(i +" "+ i8);
		}*/

		//System.out.println(Collections.unmodifiableCollection(numbers));




//		System.out.println("LIST VIEW");
//
//		//System.out.println(Collections.unmodifiableList(copy)+"\n");
//		//2,3,4,5,10
//		System.out.println("SUBLIST");
//
//		//System.out.println(copy.subList(1, 6)+"\n");
//
//
//		Rectangle<Integer,Integer,Integer>[] first;
//		//first = new Array<>(20,10,100);
		
//		//Sort
//		numbers.add(88);
		//Object[] t =numbers.toArray();
//
//		Collection<Integer> num = numbers.reversed();
//
//		System.out.println("OG LIST VIEW");
//		//original
//		System.out.println(numbers+"\n");
//
//		System.out.println("REVERSE LIST VIEW");
//		num.remove(15);
//		num.add(100);
//		//View Collection
//		System.out.println(num+"\n");
//
//		System.out.println(numbers);

		//copy.getLast();
		//Add all from ArrayList to LinkedList to
//		System.out.println(stack.addAll(numbers));
//		//	copy.remove(4);
//		stack.remove(3);
//
//		//Collections.sort(copy);
//		System.out.println(stack+"\n");

		//System.out.println(recSearch(copy, 4));


	

	@Override
	public int compareTo(Rectangle o) {
		int compbySize = Integer.compare(this.size, o.size);
		int compbyHeight = Integer.compare(this.height, o.height);
		int byName = this.name.compareTo(o.name);

		if (compbySize != 0) {
			return compbySize;	
		} else if(compbyHeight !=0) {
			return compbyHeight;
		}
		return byName;

	}

}