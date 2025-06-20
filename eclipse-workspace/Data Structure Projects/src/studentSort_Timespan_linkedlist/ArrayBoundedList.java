package studentSort_Timespan_linkedlist;

import java.util.*;

public class ArrayBoundedList<E> implements StringBoundedList<E> {
	// array of ELEMENTS
	private E [] arr;
	private int size;

	@SuppressWarnings("unchecked")
	public ArrayBoundedList(int n) throws Exception{
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		// Cast array of objects to elements
		arr = (E[]) new Object[n];
		//size= 0;
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
	public void add(E e) {
		if (size >= arr.length) {
			throw new IllegalStateException();
		}
		//add the element to the current/latest index held by size variable as long as the list isnt full
		arr[size] = e;
		size++;
	}
	@Override
	public void add(int index, E e) {
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
		//add the Element at the index and increase the size
		arr[index] = e;
		size++;
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E old = arr[index];
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
		// first occurence of e < size  shift left till last element 
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
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		//return element
		return arr[index];
	}

	@Override
	public E set(int index, E e) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		E oldString = arr[index];

		arr[index] = e;
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
	//Return Collecttion (View Only)
	public List<E> print() {
		return Collections.unmodifiableList(Arrays.asList(arr));

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

			//	if (i < size - 1) {
			//	string += ", ";  
			//}

		}
		string += "]";  
		return string;
	}


	//ITERATOR ANONYMOUS CLASS IMPLEMENTATION
	public Iterator<E> iterator() {

		//Anon class
		return new Iterator<E>() {
			//count of the iterator like size
			private int i = 0;
			@Override
			public boolean hasNext() {
				//As long as i is less than size return the next element otherwise 
				return i < size;
			}

			@Override
			public E next() {
				if (!hasNext()) {
					//Throw exception if no next element
					throw new NoSuchElementException();
				}
				//Return next element
				return arr[i++];
			}

		};
	}
}
