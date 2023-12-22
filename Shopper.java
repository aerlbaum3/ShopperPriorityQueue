
public class Shopper {

	//fields
    private String name;
    private int itemsPurchased;
    private int totalPurchased;
    private int insertionOrder;
    private static int totalOrders = 1;

    
    //constructor
    public Shopper(String name,int itemsPurchased, int totalPurchased) {
        this.name = name;
        this.itemsPurchased = itemsPurchased;
        this.totalPurchased = totalPurchased;
        insertionOrder = totalOrders++; //increment the insertionOrder as each new object is created

    }

    //setters
    public void setItemsPurchased(int itemsPurchased) {
        this.itemsPurchased = itemsPurchased;
    }

    public void setTotalPurchased(int totalPurchased) {
        this.totalPurchased = totalPurchased;
    }

    //getters
    public int getItemsPurchased() {
        return itemsPurchased;
    }

    public int getTotalPurchased() {
        return totalPurchased;
    }

    public int getInsertionOrder() {
        return this.insertionOrder;
    }
    public String getName() {
        return this.name;
    }
    //coupon method
    public void couponReward(int totalPurchased) {
    	System.out.println("**********");
    	System.out.println("Lucky you! We are now giving out coupons based on the amount you spent. \n"
    			+ "Spend $100 get $10 off.\nSpend over $100 get $15 off.");
        if(totalPurchased == 100) {
        	totalPurchased = totalPurchased - 10;
            System.out.println("You saved 10 dollars! \nYour new Total is: $" + totalPurchased );
         
           

        }
        if(totalPurchased > 100) {
            System.out.println("You saved 15 dollars! \nYour new Total is: $" + (totalPurchased - 15));
           
        }

        if(totalPurchased < 100) {
        	System.out.println("No coupon.\nYour total is: $" + totalPurchased);
        }
    }



}
