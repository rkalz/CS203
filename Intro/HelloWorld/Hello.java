
public class Hello {
	public static String name = "Brian";
	
	publuc static String good()
	{
		return "Good";
	}
	
	public static void main(String[] args)
	{
		String hello = "Hello, World!";
		System.out.println(hello);
		String world = "I didn't say hello, World";
		System.out.println(hello + " " + world);
		name = "Coolio";
		System.out.println(name);
		
		int seven = 7;
		System.out.println(seven + " " + hello);
		
		int inte = 7;
		long lo = 70000000;
		double dou = 5.9;
		float flo = (float) 55555555.6;
		char ch = 'r';
		boolean bool = false;
		
		double x = inte + inte * inte;
		
		for (int i = 0; i < 10; i++)
		{
			System.out.println(i);
		}
		
		int x = 0;
		while (x < 10)
		{
			System.out.println(x);
			x++;
		}
	}

}
