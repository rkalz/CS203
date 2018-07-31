package linkedlistiterator;

import java.util.NoSuchElementException;

public class MyLinkedList{
	private Node first;
	
	public MyLinkedList(){
		first = new Node();
	}
	
	public void addFirst(Object element){
		first.data = element;
	}
	
	public Object getFirst(){
		if(first == null){ throw new NoSuchElementException();}
		return first.data;
	}
	
	public Object removeFirst(){
		if(first == null){ throw new NoSuchElementException();}
		Object element = first.data;
		first = first.next;
		return element;
	}

	public ListIterator listIterator(){
		return new LinkedListIterator();
	}
	/*
	 * YOUR WORK HERE
	 */
	public class LinkedListIterator implements ListIterator {

		public LinkedListIterator(){
			currentNode = null;
			previousNode = null;
			next = false;
			
		}
		@Override
		public void add(Object arg0) {
			Node newNode = new Node();
			newNode.data = arg0;
			if (currentNode == null)
			{
				addFirst(arg0);
				currentNode = first;
			}
			else
			{
				currentNode.next = newNode;
				currentNode = currentNode.next;
				
			}
			
			next = false;
			
			
		}

		@Override
		public boolean hasNext() {
			if (currentNode == null)
			{
				return first != null;
			}
			else
			{
				return currentNode.next != null;
			}
		}

		@Override
		public Object next() {
			if (!hasNext())
			{
				throw new NoSuchElementException();
			}
			previousNode = currentNode;
			next = true;
			
			if (previousNode == null)
			{
				previousNode = first;
			}
			else
			{
				currentNode = currentNode.next;
			}
			return currentNode.data;
			
			
		}

		@Override
		public void remove() {
			if (hasNext())
			{
				previousNode.next = null;
				previousNode = currentNode;
			}
			
		}
		
		Node currentNode;
		Node previousNode;
		boolean next;


	}

}
