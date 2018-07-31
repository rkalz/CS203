package edu.uab.cis;

import static org.junit.Assert.*; 
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class BookStoreTest {

	private BookStore store;
	private Book b1 = new Book(1, "Harper Lee", "To Kill a Mockingbird");
	private Book b2 = new Book(2, "Harper Lee", "To Kill a Mockingbird");
	private Book b3 = new Book(3, "Frances Hodgson", "The Secret Garden");
	private Book b4 = new Book(5, "J.K. Rowling",
			"Harry Potter and the Sorcerer's Stone");
	private Book b5 = new Book(4, "Douglas Adams",
			"The Hitchhiker's Guide to the Galaxy");



	/**
	 * setup the store
	 * 
	 */
	@Before
	public void setUpBookStore() {
		System.out.println("Setting up new bookstore...");
		store = new BookStore();
		store.addBook(b1);
		store.addBook(b2);
		store.addBook(b3);
		store.addBook(b4);
		System.out.println(store);
	}
	
	

	/**
	 * tests the addition of book
	 * 
	 */

	@Test
	public void testAddBook() {
		//System.out.println("Adding book to bookstore...");
		store.addBook(b5);
		assertTrue(store.getBooks().contains(b5));
		//System.out.println(store);
	}

	/**
	 * tests the deletion of book
	 * 
	 */

	@Test
	public void testDeleteBook() {
		//System.out.println("Deleting book from bookstore...");
		store.deleteBook(b1);
		assertFalse(store.getBooks().contains(b1));
		//System.out.println(store);
	}

	/**
	 * tests sorting of books by author name
	 * 
	 */

	@Test
	public void testGetBooksSortedByAuthor() {
		System.out.println("Sorting books by author name...");
		List<Book> result = store.getBooksSortedByAuthor();
		System.out.println(result);
	}

	/**
	 * tests sorting of books by title
	 * 
	 */

	@Test
	public void testGetBooksSortedByTitle() {
		System.out.println("Sorting books by title...");
		List<Book> result = store.getBooksSortedByTitle();
		System.out.println(result);
	}

	/**
	 * tests the number of copies of book in store
	 * 
	 */

	@Test
	public void testCountBookWithTitle() {
		//System.out.println("Counting books with the title, The Secret Garden...");
		int result = store.countBookWithTitle("The Secret Garden");
		assertTrue(result == 1);
		//System.out.println(result);
	}
	
	private boolean isEqual(List<Book> a, List<Book> b)
	{
		boolean ans = false;
		
		for (int i = 0; i < a.size(); i++)
		{
			if (
					(a.get(i).getAuthorName().equals(b.get(i).getAuthorName()))
					)
			{
				ans = true;
			}
			else
			{
				ans = false;
				break;
			}
		}
		return ans;
	}

}
