import java.util.ArrayList;
import java.util.List;

public class PairDriver {

	public static void main(String[] args) {
		Pair<Integer> coordinate = new Pair<Integer>(10, 5);
		//Display the coordinate
		System.out.println(coordinate.toString());
		
		//Add items to the arraylist
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			arrayList.add(i);
		}
		
		//Form a pair from the first and the last element
		Pair<Integer> pair = GenericUtility.getPair(arrayList);
		System.out.println(pair);
		//check equals function
		if(!pair.equals(new Pair<Integer>(0, 9)))
			System.out.println("Error 1");
		else
			System.out.println("Passed Test 1");
		
		//check hashcode function
		if(!(pair.hashCode() == (new Pair<Integer>(0, 9)).hashCode()))
			System.out.println("Error 2");
		else
			System.out.println("Passed Test 2");
		
		
		//create an empty list
		List<Integer> numList1 = new ArrayList<Integer>();
		
		//populate list
		for (Integer i = 0; i < 10; i++)
		{
			numList1.add(i);
		}
		
		//create an empty list
		List<Integer> numList2 = new ArrayList<Integer>();
		
		//create a Comparable object
		Comparable<Integer> compare = new Integer("5");
		
		//call on copyIfGreaterThan with the two lists and the Comparable object
		GenericUtility.copyIfGreaterThan(numList1, numList2,compare);
		
		//create a third list and populate it with items we expect to be returned in numList2
		List<Integer> numList3 = new ArrayList<Integer>();
		
		for (Integer i = 6; i < 10; i++)
		{
			numList3.add(i);
		}
		
		//check copyIfGreaterThan method
		if(!(numList2.equals(numList3)))
			System.out.println("Error 3");
		else
			System.out.println("Passed Test 3");
	}
}
