import java.util.Comparator;

public class shopperComparator implements Comparator<Shopper>{

	//This class implements the Comparator and overrides the method compare.
	//It takes both shoppers and compares its amount of items purchased. 
	//It returns a positive value if the first object is greater than the second and returns a negative number
	//if the first object is less than the second object
	@Override
	public int compare(Shopper shopper1, Shopper shopper2) {
		int result = Integer.compare(shopper2.getItemsPurchased(), shopper1.getItemsPurchased());
		
		//if itemsPurchased are equal(the compare method will return 0) use insertion order to maintain stable sort
				
		if(result == 0) {
			result = Integer.compare(shopper1.getInsertionOrder(), shopper2.getInsertionOrder());
		}
		return result;
	}

}