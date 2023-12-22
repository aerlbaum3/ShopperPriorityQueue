import java.util.*;
public class Main {
	
	//The point of this program is to implement a priorityQueue based off of the amount of items a shopper has.
	//The shopper with more items is privileged to check out first.
	//Additionally in this store a coupon is rewarded to those who spend over $100.

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        PriorityQueueClass shopperPriority = new PriorityQueueClass();

        System.out.println("How many shoppers are shopping today? "); //to maintain reusability
        int amntShopper = keyboard.nextInt();
;		for(int i = 1; i <= amntShopper; i++) {
			System.out.println("What is your name?");
			
			keyboard.nextLine();
		    String name = keyboard.nextLine();
			
			System.out.println("How many items do you have?");
			int itemsTotal = keyboard.nextInt();
			
			Random rand = new Random();
			int totalPurchased = rand.nextInt(20,150);
			
			System.out.println("Your total is: " + totalPurchased);
			//create new Shopper objects with this input as you insert them into shoppers.
			shopperPriority.insert(new Shopper(name,itemsTotal,totalPurchased));
		}
		shopperPriority.checkout(shopperPriority);
			
		}



    

   
}



