package studentSort_Timespan_linkedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque<E> implements Iterable<E>{

	private E [] arr;
	private int indexOfFirst;
	private int indexOfLast;
	private final static int CAPACITY =10;


	public ArrayDeque() {
		this(CAPACITY);
	}

	public ArrayDeque(int initialCapacity) {
		arr = (E[]) new Object[initialCapacity];
		indexOfFirst = indexOfLast= -1;
	}

	public int size() {
		//If empty
		if (indexOfFirst == -1 && indexOfLast == -1) {
			return 0;
		} else if (indexOfFirst <= indexOfLast) {
			//if not empty return size
			return indexOfLast - indexOfFirst + 1;
		} else {
			return arr.length - indexOfFirst + indexOfLast + 1;
		}
	}

	public boolean isEmpty() {
		return indexOfFirst == -1 && indexOfLast == -1 ;
	}



	public void addFirst(E element) {
		//if full double size
		if (size() == arr.length) {
			arr = Arrays.copyOf(arr, 2* size()+1);
		}

		//If empty STILL ADD at 0 position
		if (isEmpty()) { 
			indexOfFirst = indexOfLast = 0;
		} else {
			//increment circularly
			indexOfFirst = (indexOfFirst - 1 + arr.length) % arr.length;
		}
		//add element first
		arr[indexOfFirst] = element;	

	}

	public void addLast(E element) {
		//if size == length(FULL)
		if (size() == arr.length) {
			arr = Arrays.copyOf(arr, 2* size()+1);
		}
		//If empty STILL ADD at 0 position

		if (isEmpty()) {
			indexOfFirst = indexOfLast = 0;
		} else {
			//increment Circularly
			indexOfLast = (indexOfLast + 1) % arr.length;
		}
		//add last element
		arr[indexOfLast] = element;
	}


	public E getFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		return arr[indexOfFirst];
	}
	public E getLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return arr[indexOfLast];
	}






	public E removeFirst() {
		//if empty
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		//E is first element then set to null
		E first = arr[indexOfFirst];
		arr[indexOfFirst] = null;

		// if both index = each other its empty OTHERWISE 

		if (indexOfFirst == indexOfLast) { 
			indexOfFirst = indexOfLast = -1;
		} else {
			indexOfFirst = (indexOfFirst + 1) % arr.length;
		}


		return first;

	}

	public E removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		//Last element and set to null
		E last = arr[indexOfLast];
		arr[indexOfLast] = null;

		if (indexOfFirst == indexOfLast) { 
			indexOfFirst = indexOfLast= -1;
		} else {
			//decrement	
			indexOfLast--;
			if (indexOfLast == -1) {
				indexOfLast = arr.length - 1;
			}

		}

		return last;
	}

	public String toString() {
		StringBuilder s = new StringBuilder("[");


		for (int i = 0; i < size();i++) {
			s.append(arr[(indexOfFirst +i)% arr.length]);
			if (i < size() -1) {
				s.append(",");
			}
		}
		return s.append("]").toString();
	}

	public Iterator<E> iterator() {
		return new ArrayDequeIt();
	}



	//Anonymous
	private class ArrayDequeIt implements Iterator<E> {
		private int index = indexOfFirst;
		private int count = 0;

		public boolean hasNext() {
			return count < size();
		}

		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			E element = arr[index];
			//increment
			index = (index + 1) % arr.length;
			count++;

			return element;

		}
	};

}
