/*************************************************
File: ListWithIteratorInterface
By: Igor Tello
Date: 2/21
Compile: 
Usage: 
System: 
Description: Contains the getIterator() method implemented in LinkedListWithIterator.java
*************************************************/

package HW1;
import java.util.Iterator;

public interface ListWithIteratorInterface<E> extends Iterable<E>{

    public Iterator<E> getIterator();
    
}