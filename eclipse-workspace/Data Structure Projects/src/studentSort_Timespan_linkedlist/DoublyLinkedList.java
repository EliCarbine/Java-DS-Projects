package studentSort_Timespan_linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
//LINKED LIST 
public class DoublyLinkedList<E> implements Iterable<E>{
	//Node anonymous class
	private static class Node<E> {
		//Element itself data prev/next
		private E data;
		private Node<E> previous; 
		private Node<E> next;     


		public Node(E data, Node<E> previous, Node<E> next) {
			this.data = data;
			this.previous = previous;
			this.next = next;
		}


		public Node(E data) {
			this(data, null, null);
		}
	}

	//Node holding data head,tail,size
	private Node<E> head;   
	private Node<E> tail;   
	private int size;       

	public DoublyLinkedList() {
		tail = head = null;
		size = 0;
	}
	// ADD ELSE STATEMENT (Add first if not full case) size++ after method(outside if-else statement)
	public void addFirst(E element) {

		if(isEmpty()) {
			head = tail = new Node<>(element);
		} else {	
			// Create new node
			Node<E> list = new Node<>(element);

			//New node .next point to head
			list.next = head;

			//head previous point to new node
			head.previous = list;
			// head point to new node
			head = list;
		}
		//add size either way
		size++;
	}

	public void addLast(E element) {
		if(isEmpty()) {
			addFirst(element);
		} else {
			// Create a new Node assign to tail?
			//New Node
			Node<E> list = new Node<>(element);	

			//prev tail equals new node prev
			list.previous = tail;
			//
			tail.next = list;
			//tail point to new node
			tail = list;

			size++;
		} 
	}

	public E getFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return head.data;

	}

	public E getLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return tail.data;
	}

	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;

	}

	@Override
	public String toString() {
		StringBuilder s =  new StringBuilder("[");
		Node<E> c = head;

		//While head isnt null append data
		while (c != null) {
			s.append(c.data);
			//handle commas
			if(c.next != null ) {
				s.append(", ");
			}
			//move to the next node
			c= c.next;
		}


		s.append("]");
		return s.toString();

	}

	public String toReverseString() {
		StringBuilder s =  new StringBuilder("[");
		Node<E> c = tail;
		//while tail isnt null append the data in the string

		while(c != null) {
			s.append(c.data);
			//handle the commas
			if (c.previous != null) {
				s.append(", ");
			}
			//move to the previous node
			c = c.previous;
		}
		s.append("]");

		return s.toString();
	}

	public E removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} 


		E start= head.data;

		head = head.next;
		//head = null;
		size--;
		// if list empty tail =null	
		if (isEmpty()) {
			tail = null;
		} else {
			//previous head to null
			head.previous = null;
		}

		return start;

	}

	public E removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} 
		E last = tail.data;
		// 2 Node case 
		if(size == 1) {
			head = tail= null;
		} else {

			tail =tail.previous;			
			tail.next = null;
		}
		size--;

		return last;	
	}

	public void clear() {	
		while(!isEmpty()) {
			removeFirst();
		}
	}
	public boolean contains(Object o) {
		Node<E>c  = head;
		while(c != null) {
			if (Objects.equals(c.data, o)) {
				return true;
			}
			c = c.next;
		}
		return false;
	}
	public boolean add(E e) {
		if (isEmpty()) {
			head = tail = new Node<>(e);
		} else {
			Node<E> c = head;
			while (c != null) {
				c = c.next;		
			}

			Node<E> element = new Node<>(e);
			//prev of new node points to tail
			element.previous = tail;
			// tail.next/tail point to new node
			tail.next = tail = element;

		}
		size++;
		return true;

	}
	//Remove element return bool
	public boolean remove(Object o) {
		if (isEmpty()) {
			return false;
		}
		Node<E> c = head;
		//go through list
		while(c != null) {
			if (Objects.equals(c.data, o)) {
				//if at the start remove 
				if(c == head) {
					removeFirst();
					return true;
				}
				//if at the end remove
				if (c == tail) {
					removeLast();
					return true;
				}
				//if in the middle
				else {
					//??
					c.previous.next = c.next;
					c.next.previous = c.previous;
				}
				//decrement size
				size--;	
				return true;
			}
			c= c.next;
		}

		return false;
	}

	public int indexOf(Object o) {
		int count = 0;
		Node<E> c = head;

		while(c != null ) {
			if(Objects.equals(c.data,o)) {
				return count;
			}
			count++;
			c = c.next;
		}


		return -1;
	}
	public int lastIndexOf(Object o) {
		int count = size-1;
		Node<E> c = tail;

		while(c != null ) {
			if(Objects.equals(c.data, o)) {
				return count;
			}
			count--;
			c = c.previous;
		}

		return -1;
	}

	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> element = head;

		for (int i = 0;i < size;i++) {
			if (i == index) {

				return element.data;		
			}
			element = element.next;
		}
		return element.data;
	}

	public E set(int index, E element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> c;
		E old;
		// if index is in first half do method else from tail(cuts down runtime)
		if (index < (size/2)) {
			c = head;

			for (int i = 0; i < index; i++) {
				c=c.next;
			}

		} else {
			c = tail;
			for (int i = size - 1; i > index; i--) {
				c = c.previous;
			}
		}
		old = c.data;
		c.data = element;

		return old;
	}


	public void add(int index, E element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> c;
		int count;

		//add at start
		if (index == 0) {
			addFirst(element);
			return;
		}

		//  add at the end
		if (index == size) {
			addLast(element);
			return;
		}
		//middle

		if (index < (size / 2)) {
			c = head;
			for (count = 0; count < index; count++) {
				c = c.next;
			}
		} else {
			c = tail;
			for (count = size - 1; count > index; count--) {
				c = c.previous;
			}
		}

		Node<E> newNode = new Node<>(element);
		newNode.next = c;
		newNode.previous = c.previous;
		c.previous.next = newNode;
		c.previous = newNode;
		size++;

	}



	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E element;
		Node<E>c;
		int count;

		if (index == 0) {
			//removeFirst();
			return removeFirst();
		}

		//  add at the end
		if (index == size-1) {
			return removeLast();
		}

		if (index < size / 2) {
			c = head;
			for (int i = 0; i < index; i++) {
				c = c.next;
			}
		} else {
			c = tail;
			for (int i = size - 1; i > index; i--) {
				c = c.previous;
			}
		}


		element = c.data;  
		c.previous.next = c.next;
		c.next.previous = c.previous;
		size--;

		return element;
	}
	
	 @Override
	    public Iterator<E> iterator() {
	 return new ListIterator();
	 }
	 private class ListIterator implements Iterator<E> {
		 private Node<E>c =head;
		 private Node<E> tail = null;
		 @Override
		 public boolean hasNext() {	
			 return c != null;
		 }
		 @Override
		 public E next() {
			 if (!hasNext()) {
				 throw new NoSuchElementException();
			 }
			 tail = c;
			 E data = c.data;  
			 c = c.next; 
			 return data;
		 }
	 }	 
}
