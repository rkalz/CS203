package edu.uab.cis;

public class FibonacciTree 
{
	public static void main(String[] args) 
	{
		int a = fibonacci(5,0);
	}
	
	public static int fibonacci(int count, int spaces)
	{
		int nMinOne = 0;
		int nMinTwo = 0;
		if (count == 0)
		{
			printSpaces(spaces);
			System.out.println("fib(0)-->0");
			return 0;
		}
		else if (count < 2)
		{
			printSpaces(spaces);
			System.out.println("fib(1)-->1");
			return 1;
		}
		else
		{
			nMinOne = fibonacci(count-1, spaces+5);
			printSpaces(spaces);
			System.out.println("fib(" + count + ")");
			nMinTwo = fibonacci(count-2, spaces+5);
			return nMinOne+nMinTwo;
		}
	}
	
	public static void printSpaces(int space)
	{
		for (int i = 0; i < space; i++)
		{
			System.out.print(" ");
		}
	}

}
