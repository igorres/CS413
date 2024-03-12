/*************************************************
File: LinkedPriorityQueue.java
By: Igor Tello
Date: 3/12/24
Compile: 
Usage: 
System: java
Description: Creates a Priority Queue based on a linked list
*************************************************/
package Assignment2;

public class LinkedPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {

    private Node firstNode; // Reference to first node of chain, highest priority

	public LinkedPriorityQueue() {
		firstNode = null;
	}

	public void add(T newEntry) {
		Node newNode = new Node(newEntry);
		Node nodeBefore = getNodeBefore(newEntry);

		if (isEmpty() || (nodeBefore == null)) { // Add at beginning
			newNode.next = firstNode;
			firstNode = newNode;
		} else { // Add after nodeBefore
			Node nodeAfter = nodeBefore.next;
			newNode.next = nodeAfter; 
			nodeBefore.next = newNode;
		}
	}

	public T remove() {
		T result = null;

		if (!isEmpty()) {
			result = firstNode.data;
			firstNode = firstNode.next;
		}
		return result;
	}

	public T peek() {
		T result = null;

		if (!isEmpty()) {
			result = firstNode.data;
		}
		return result;
	}

	public boolean isEmpty() {
		return firstNode == null;
	}

	public int getSize() {
		Node current = firstNode;
		int size = 0;
		while (current != null) {
			size++;
			current = current.next;
		}
		return size;
	}

	public void clear() {
		firstNode = null;
	}

	@Override
	public String toString() {
		Node currentNode = firstNode;
		String text = "";
		while (currentNode != null) {
			text += currentNode.data + "  ";
			currentNode = currentNode.next;
		}
		text += "\n";
		return text;
	}

	private Node getNodeBefore(T anEntry) {
		Node currentNode = firstNode;
		Node nodeBefore = null;

		while ((currentNode != null) && 
				(anEntry.compareTo(currentNode.data) >= 0)) { 			
			nodeBefore = currentNode;
			currentNode = currentNode.next;
		}

		return nodeBefore;
	}

	private class Node {
		private T data; 
		private Node next; // Link to next node

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		}

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}

	}
}
