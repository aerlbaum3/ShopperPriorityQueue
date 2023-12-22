import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PriorityQueueTest {
	
	private PriorityQueueClass shopperPriority;

	@BeforeEach
	void createQueue() {
		shopperPriority = new PriorityQueueClass();
	}
	@Test
	void testGetItemsPurchased() {
		Shopper shopper = new Shopper("Adeena" , 9 , 19);
		assertEquals(9, shopper.getItemsPurchased());
	}
	@Test
	void testInsertAndPollPrintTheListInDescOrder() {
		//PriorityQueueClass shopperPriority = new PriorityQueueClass();
		
		//insert shoppers with different item counts
		shopperPriority.insert(new Shopper("Ahuva",9,50));
		shopperPriority.insert(new Shopper("Shayna",10,20));
		shopperPriority.insert(new Shopper("Baila", 5,12));
		
		//should print out in desc order
		assertEquals("Shayna", shopperPriority.poll().getName());
		assertEquals("Ahuva",shopperPriority.poll().getName());
		assertEquals("Baila",shopperPriority.poll().getName());
	}
	@Test
	void testInsertionOrderWhenAmntOfItemsAreEqual() {
		shopperPriority.insert(new Shopper("Adeena",10,50));
		shopperPriority.insert(new Shopper("Rivka",10,100));
		
		//Adeena should print before Rivka
		
		assertEquals("Adeena", shopperPriority.poll().getName());
		assertEquals("Rivka", shopperPriority.poll().getName());
	}
	@Test
	void testWhenQueueIsEmptyShouldReturnNull() {
		assertNull(shopperPriority.poll());
	}
		
	
		
	}


