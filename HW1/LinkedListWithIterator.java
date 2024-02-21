/*************************************************
File: LinkedListWithIterator
By: Igor Tello
Date: 2/21
Compile: 
Usage: 
System: 
Description: Iterates through a linked list using Nodes, able to call next() and determine if list is empty by hasNext()
*************************************************/

package HW1;
import java.util.*;
import HW1.MyLList.Node;

public class LinkedListWithIterator<E> implements ListWithIteratorInterface<E>{

    private Node firstNode;
    private int numberOfEntries;

    public LinkedListWithIterator() {
        clear();
    }

    private void clear() {
        Comparable result = null;
		while (firstNode != null) {
			result = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;
		}
    }

    public Iterator<E> getIterator() {
        return new IteratorForLinkedList();
    }

    private class IteratorForLinkedList implements Iterator<E>{
        private Node nextNode;

        private IteratorForLinkedList(){
            nextNode = firstNode;
        }
        public boolean hasNext() {
            return nextNode != null;
        }

        @SuppressWarnings("unchecked")
        public E next() {
            if (hasNext()) {
                Node returnNode = nextNode;
                nextNode = nextNode.getNextNode();
                return (E) returnNode.getData();
            }
            else {
                throw new NoSuchElementException("Illegal call, iterator at end of list");
            }

        }
        

    }

    public Iterator<E> iterator() {
       return getIterator();
    }
}
