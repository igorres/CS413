/*************************************************
File: MyLList
By: Igor Tello
Date: 2/21
Compile: 
Usage: 
System: 
Description: Creates a linked list using Nodes, and the necessary methods to upkeep.
*************************************************/

package HW1;
import java.util.*;

public class MyLList<E extends Comparable<? super E>> implements ListInterface<E> {

    public Node firstNode;
    private int numberOfEntries;

	public MyLList(){
		firstNode = null;
		numberOfEntries = 0;
	}

    public void add(E newEntry) {
        Node newNode = new Node(newEntry);
		if (isEmpty()) {
			firstNode = newNode;
		} else { 
			Node lastNode = getNodeAt(numberOfEntries);

			lastNode.setNextNode(newNode); 
		} 
		numberOfEntries++;
    }

    public boolean add(int newPosition, E newEntry) {
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
			
			Node newNode = new Node(newEntry);
			
			if (newPosition == 1) { // adding to front
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			} else { 
				Node nodeBefore = getNodeAt(newPosition - 1);
				Node nodeAfter = nodeBefore.next; 
				newNode.setNextNode(nodeAfter);
				nodeBefore.setNextNode(newNode);
			} 
			numberOfEntries++;
            return true;
		} else {
			throw new IndexOutOfBoundsException("Illegal operation.");
		}
	}

    public Comparable remove(int givenPosition) {
		E result = null; 
		if (validPosition(givenPosition)) {
			if (givenPosition == 1) { // removes the first node
				result = firstNode.data; 
				firstNode = firstNode.next; 
			} else { // removes everything else
				Node nodeBefore = getNodeAt(givenPosition - 1);
				Node nodeToRemove = nodeBefore.next;
				result = nodeToRemove.data; 
				Node nodeAfter = nodeToRemove.next;
				nodeBefore.setNextNode(nodeAfter); // removes node
			} 
			numberOfEntries--;
			return result; 
		} else {
			throw new IndexOutOfBoundsException("Illegal operation.");
		}
	} 

    /** Removes all entries from this list. */
    public void clear() {
		E result = null;
		while (firstNode != null) {
			result = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;
		}
	}


    public E replace(int givenPosition, E newEntry) {
		if (validPosition(givenPosition)) {
			Node desiredNode = getNodeAt(givenPosition);
			E originalEntry = desiredNode.data;
			desiredNode.data = newEntry;
			return originalEntry;
		} else {
			throw new IndexOutOfBoundsException("Illegal operation.");
		}
	}


    public Comparable getEntry(int givenPosition) {
		E entry = null;
		if(givenPosition >= 0 && givenPosition < size()) {
			Node currentNode = firstNode;
			for(int i=0; i<givenPosition; i++) {
				currentNode = currentNode.next;
			}
			entry = currentNode.data;
		}
        else {
			throw new IndexOutOfBoundsException("Illegal operation.");
		}
		return entry;
	}

    public Comparable[] toArray() {
		@SuppressWarnings("unchecked")
		E[] result = (E[]) new Comparable[numberOfEntries];
		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			currentNode = currentNode.next;
			index++;
		} 
		return result;
	}

    public boolean contains(E anEntry) {
		Node currentNode = firstNode;
		
		while(currentNode != null) {
			if(currentNode.data.equals(anEntry)) {
			return true;
			}
		currentNode = currentNode.next;
		}
		return false;
	}

    public int getLength() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
		boolean result;
		if (numberOfEntries == 0) { 
			result = true;
		} else {
			result = false;
		} 
		return result;
	}

    private boolean validPosition(int position) {
		return position >= 1 && position <= numberOfEntries;
	}

    private Node getNodeAt(int givenPosition) {
		Node currentNode = firstNode;
		for (int i = 1; i < givenPosition; i++) {
			currentNode = currentNode.getNextNode();
		}
		return currentNode;
	}

    public int size() {
		return numberOfEntries;
	}

	public Iterator<E> getIterator(){
		LinkedListWithIterator<E> obj = new LinkedListWithIterator<>();
		return obj.getIterator();
		
	}


	public class Node {
		public E data;
		public Node next;

		private Node(E dataPortion) {
			data = dataPortion;
			next = null;
		}

		private Node(E dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}

		public E getData() {
			return data;
		}

		public void setData(E newData) {
			data = newData;
		}

		public Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {	
			next = nextNode;
		} 
	}


	public static void main(String[] args){

        MyLList<String> linkedList = new MyLList<>();

        linkedList.add("hello");
        linkedList.add("new world");
        linkedList.add("it has been fun");

        Iterator<String> linkedListIterator = linkedList.getIterator();

		System.out.println("-----------Testing--------------------");
		System.out.println(linkedList.size());
		System.out.println(linkedList.getEntry(0));
		System.out.println(linkedList.getEntry(1));
		System.out.println(linkedList.getEntry(2));


		
        System.out.println(linkedListIterator.next());
		

    }

}