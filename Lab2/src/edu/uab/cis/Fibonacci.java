package edu.uab.cis;

public class Fibonacci {
	
	private static int callCount = 0;

	public static void main(String[] args) 
	{
		System.out.println(fibonacci(20));
		System.out.println(callCount);

	}
	
	public static int fibonacci(int count)
	{
		
		callCount++;
		
		if (count == 0)
		{
			return 0;
		}
		else if (count < 2)
		{
			return 1;
		}
		else
		{
			return fibonacci(count-1) + fibonacci(count-2);
		}
		
	}

}
