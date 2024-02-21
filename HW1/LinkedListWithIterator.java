package HW1;
import java.util.*;

import HW1.MyLList.Node;

public class LinkedListWithIterator<E extends Comparable<? super E>>{

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
        return (Iterator<E>) new IteratorForLinkedList();
    }

    private class IteratorForLinkedList implements Iterator<E>{

        private Node nextNode;

        private IteratorForLinkedList(){
            nextNode = firstNode;
        }
        public boolean hasNext() {
            return nextNode != null;
        }

        public E next() {
            if (hasNext()) {
                Node returnNode = nextNode;
                nextNode = nextNode.getNextNode();
                return (E) returnNode.getData();
            }
            else {
                throw new NoSuchElementException("Illegal call");
            }

        }
    }
    
}
