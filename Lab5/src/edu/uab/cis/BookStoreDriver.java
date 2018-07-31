package edu.uab.cis;

public class BookStoreDriver 
{
	public static void main(String[] args)
	{
		BookStoreTest tester = new BookStoreTest();
		
		tester.setUpBookStore();
		tester.testAddBook();
		tester.testDeleteBook();
		tester.testGetBooksSortedByAuthor();
		tester.testGetBooksSortedByTitle();
		tester.testCountBookWithTitle();
	}
}
