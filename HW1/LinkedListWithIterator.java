package HW1;
import java.util.*;

public class LinkedListWithIterator<E> extends MyLList<E>{

    private Node firstNode;
    private int numberOfEntries;

    public LinkedListWithIterator() {
        clear();
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
                return returnNode.getData();
            }
            else {
                throw new NoSuchElementException("Illegal call");
            }

        }
    }
    
}
