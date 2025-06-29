package studentSort_Timespan_linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayBoundedListTest {
    public static void main(String[] args) {
        ArrayBoundedList<String> list = new ArrayBoundedList<>(4);
        list.add("b");
        list.add("A");
        Iterator<String> iterator = list.iterator();
      //  System.out.println(iterator.hasNext()); // false
        System.out.println(iterator.next()+"\n");
        System.out.println(iterator.next());
        

        // Good, NoSuchElementException thrown
        try {
            iterator.next();
            System.out.println("Exception not thrown!");
        } catch (NoSuchElementException e) {
            System.out.println("Good, NoSuchElementException thrown");
        } catch (Exception e) {
            System.out.println("Wrong type of exception thrown!");
        }

        list.add("a");
        iterator = list.iterator();
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next());    // a
        System.out.println(iterator.hasNext()); // false

        // Good, NoSuchElementException thrown
        try {
            iterator.next();
            System.out.println("Exception not thrown!");
        } catch (NoSuchElementException e) {
            System.out.println("Good, NoSuchElementException thrown");
        } catch (Exception e) {
            System.out.println("Wrong type of exception thrown!");
        }

        iterator = list.iterator();
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next());    // a
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next());    // b
        System.out.println(iterator.hasNext()); // false

        // Good, NoSuchElementException thrown
        try {
            iterator.next();
            System.out.println("Exception not thrown!");
        } catch (NoSuchElementException e) {
            System.out.println("Good, NoSuchElementException thrown");
        } catch (Exception e) {
            System.out.println("Wrong type of exception thrown!");
        }

        list.add("c");
        iterator = list.iterator();
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next());    // a
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next());    // b
        System.out.println(iterator.hasNext()); // true
        System.out.println(iterator.next());    // c
        System.out.println(iterator.hasNext()); // false

        // Good, NoSuchElementException thrown
        try {
            iterator.next();
            System.out.println("Exception not thrown!");
        } catch (NoSuchElementException e) {
            System.out.println("Good, NoSuchElementException thrown");
        } catch (Exception e) {
            System.out.println("Wrong type of exception thrown!");
        }

        for (String s : list) {
            System.out.println(s);
        }
        // a
        // b
        // c
    }
}