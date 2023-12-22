import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueueClass {

	
    private List<Shopper> heap; //creating a list to store our values for our heap.
    private Comparator<Shopper> comparator;
   

    //constructor
    public PriorityQueueClass() {
        this.heap = new ArrayList<>();
        this.comparator = new shopperComparator(); //create shopperComparator object to use for comparing elements.

    }

    public void insert(Shopper shopper) {
        heap.add(shopper);
      
        heapifyUp(); //deals with the first element that was inserted into the heap to start.
        
    }
    

    public Shopper poll() { //dequeue
    	
        if(heap.size() == 0) {
            return null; // queue is empty
        }

        Shopper maxPriority = heap.get(0);//retrieves the first element of the heap

        heap.set(0, heap.get(heap.size() - 1)); //replacing the root element of the heap with the last element of the heap
        heap.remove(heap.size() - 1 ); //removes last element of the heap after it has been moved to the root
        

        if (heap.size() > 0) {//only perform heapifyDown if heap is full.
            heapifyDown(0); // call the heapifyDown method passing into it the root element.
        }

        return maxPriority;

    }
	private void heapifyUp() {

		int currentIndex = heap.size() - 1;
		int parentIndex = parent(currentIndex);
		while(currentIndex > 0) {
			if(comparator.compare(heap.get(currentIndex), heap.get(parentIndex)) < 0) {
				swap(currentIndex, parentIndex);
				currentIndex = parentIndex;
				parentIndex = parent(currentIndex);
			}
			else {
				break; // heap property is restored
			}}
		}
//	}


    private void heapifyDown(int index) {

        while(true) {
            int currentIndex = index;
            int leftChild = leftChild(index);
            int rightChild = rightChild(index);

            //compares the leftChild with the currentIndex(root)
            if(leftChild < heap.size() && comparator.compare(heap.get(leftChild),(heap.get(index))) < 0) {
                currentIndex = leftChild; //sets currentIndex to be the leftChild to prepare for a potential swap.
            }

            if(rightChild < heap.size() && comparator.compare(heap.get(rightChild), (heap.get(currentIndex))) < 0) {
                currentIndex = rightChild;//sets currentIndex to be rightChild to prepare for a potential swap.
            }

            if(index != currentIndex) {
                swap(index, currentIndex);
                currentIndex = index;
            }
            else {
                break;//restores heap property
            }
        }
    }


    public int parent(int index) {
        return (index - 1) / 2;//code to find the parent of a child index

    }

    public int leftChild(int index) {
        return 2 * index + 1;//to find the leftChild
    }

    public int rightChild(int index) {
        return 2 * index + 2;//to find the rightChild
    }
    public void swap(int i, int j) {

        Shopper temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    public boolean isEmpty() {
        if(heap.size() == 0) {
            return true;
        }
        return false;
    }

    public void checkout(PriorityQueueClass shopperPriority) {
        while(!shopperPriority.isEmpty()) {
            Shopper shopper = shopperPriority.poll();
            System.out.println("--------------------------------");
            System.out.println("Checking out " + shopper.getName() + ":");
            System.out.println("Originally you were " + shopper.getInsertionOrder() + " in line");
            System.out.println("You purchased " + shopper.getItemsPurchased() + " items");
            
                shopper.couponReward(shopper.getTotalPurchased());
            
        }

    }
    public void printQueue() {
        System.out.println("Order of Queue before the update: ");
        for(int i = 0; i < heap.size() ; i++) {
            System.out.println("Name: " + heap.get(i).getName() +
                    "\nAmount of Items: " + heap.get(i).getItemsPurchased() + "\nCart total: $" + heap.get(i).getTotalPurchased()
                    +"\nYour line number is: " + heap.get(i).getInsertionOrder());
        }
    }






}