public class tileColor 
{
	
	public static void main(String[] args)
	{
		int i = 0;
		while (i < 15)
		{
			if (i % 5 == 0)
			{
				System.out.println();
			}
			if (i % 2 == 0)
			{
				System.out.print("B");
			}
			else
			{
				System.out.print("W");
			}
			System.out.print(" ");
			i++;
	   }
	}
}