import java.util.List;

/**
 * Utility class for generic methods
 * 
 */
public class GenericUtility {
	/**
	 * Return a pair with first part as the first element in the list and the
	 * second part as the last element in the list.
	 * 
	 * @param list
	 *            non-empty list of elements
	 * @return pair with elements (first element of list,last element of list)
	 */
	public static <E> Pair<E> getPair(List<E> list) {
		
		return new Pair<E>(list.get(0),list.get(list.size()-1));  // you need to replace null with the instance of Pair<E> class
	}
	
	/**
	 * Copy all values in src that are greater than obj to List tgt
	 * 
	 * @param list src non-empty list of elements
	 * 		  list tgt empty list of elements
	 * 		  comparable obj Comparable object
	 */
	static public <E> void copyIfGreaterThan(List<E> src, List<? super E> tgt, Comparable<? super E> obj)
	{
		
		for (int i = 0; i < src.size(); i++)
		{
			if (obj.compareTo(src.get(i)) < 0)
			{
				tgt.add(src.get(i));
			}
		}
	}

}
