package studentSort_Timespan_linkedlist;

import java.util.Objects;

public class ArrayStringBoundedList<E> implements StringBoundedList<Object> {

	private String [] arr;
	private int size;

	public ArrayStringBoundedList(int n){
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		arr = new String[n];
		size= 0;
	}

	@Override
	public int capacity() {
		return arr.length;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(Object e) {
		if (size >= arr.length) {
			throw new IllegalStateException();
		}
		//add the string to the current/latest index held by size variable as long as the list isnt full
		arr[size] = e.toString();
		size++;
	}
	@Override
	public void add(int index, Object e) {
		//Exceptions thrown
		if (size >= arr.length) {
			throw new IllegalStateException();
		}
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		//while size > index i-- then shift the elements right
		for(int i = size;i > index;i--) {
			//shift right
			arr[i] = arr[i-1];
		}
		//add the string at the index and increase the size
		arr[index] = e.toString();
		size++;
	}

	@Override
	public String remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		String old = arr[index];
		//??
		for(int i = index;i< size-1;i++) {
			// shift all the elements left
			arr[i] = arr[i+1];
		}
		//decrement array size
		arr[size--]= null;
		return old;
	}

	@Override
	public boolean remove(Object e) {
		if(indexOf(e) == -1) {
			return false;
		}
		// first occurence of s < size  shift left till last element 
		for (int i = indexOf(e);i < size-1;i++){
			//shift left
			arr[i]=arr[i+1];
		}
		//decrement element from array and size of array
		arr[size-1]= null;
		size--;

		return true;	
	}



	@Override
	public Object get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return arr[index];
	}

	@Override
	public Object set(int index, Object e) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		String oldString = arr[index];
		arr[index] = e.toString();
		return oldString;

	}

	@Override
	public int indexOf(Object e) {

		for (int i = 0;i < size;i++) {
			if (Objects.equals(e, arr[i])) {
				return i;
			}
		}
		return -1 ;
	}

	@Override
	public int lastIndexOf(Object e) {
		for (int i = size-1 ;i >= 0;i--) {	
			//if s == the element return i
			if (Objects.equals(e, arr[i])) {
				return i;
			}
		}
		return -1;
	}


	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			arr[i] = null;
		}
		size = 0;
	}

	@Override
	public String toString() {
		if (size == 0) {
			return "[]";  
		}
		String string = "["; 

		for (int i = 0; i < size; i++) {
			string += arr[i];  
			
			if (i < size - 1) {
				string += ", ";  
			}
			
		}
		string += "]";  
		return string;
	}

}

