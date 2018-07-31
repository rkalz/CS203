package edu.uab.cis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RecordReader {
	
	public RecordReader(String filename) throws FileNotFoundException
	{
		File inp = new File(filename);
		Scanner in = new Scanner(inp);
		
		while (in.hasNext())
		{
			readIn.add(in.next());
		}
		
		for (int i = 0; i < readIn.size(); i = i + 7)
		{
			int rank = Integer.parseInt(readIn.get(i));
			String maleName = readIn.get(i+1);
			double malePercent = Double.parseDouble(readIn.get(i+3));
			String femaleName = readIn.get(i+4);
			double femalePercent = Double.parseDouble(readIn.get(i+6));
			
			System.out.print(rank + " ");
			if (malePercentCount < PERCENT_COUNT)
			{
				System.out.print(maleName);
				malePercentCount = malePercentCount + malePercent;
				System.out.print(" ");
			}
			
			if (femalePercentCount < PERCENT_COUNT)
			{
				System.out.print(femaleName);
				femalePercentCount = femalePercentCount + femalePercent;
			}
			System.out.println();
			
			if (malePercentCount > 50 && femalePercentCount > 50)
			{
				break;
			}
		}
	}
	
	private ArrayList<String> readIn = new ArrayList<String>();
	private static final int PERCENT_COUNT = 50;
	private double malePercentCount = 0;
	private double femalePercentCount = 0;

}
