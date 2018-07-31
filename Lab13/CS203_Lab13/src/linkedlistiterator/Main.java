package linkedlistiterator;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args){
		MyLinkedList myNumbers = new MyLinkedList();
		ListIterator it = myNumbers.listIterator();
		for(int i = 0; i < 10; i++){
			it.add(new Integer(i));
		}
		it = myNumbers.listIterator();
		it.next();
		it.remove();
		it = myNumbers.listIterator();
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
		System.out.println();
		MyLinkedList myCharacters = new MyLinkedList();
		it = myCharacters.listIterator();
		for(int i = 0; i < 10; i++){
			it.add(new String("a" + i));
		}
		it = myCharacters.listIterator();
		it.next();
		it.remove();
		it = myCharacters.listIterator();
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
	}
}
