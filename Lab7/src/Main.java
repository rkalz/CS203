
import java.util.ArrayList;
import java.util.Date;

public class Main {
	public static void main(String[] args){
		ArrayList<Item> inventory = new ArrayList<Item>();
		for(int i = 0; i < 5; i++){
			inventory.add(new Physical_Item(i,i));
		}
		inventory.add(new Digital_Item(4,new Date()));
		Date release = new Date(System.currentTimeMillis() + 1000000);
		inventory.add(new Digital_Item(4,release));
		//TODO create visitor object and call visitInventory
		Visitor visitor = new Visitor();
		visitInventory(inventory,visitor);
		System.out.println();
		System.out.println("Total items available is: " + visitor.getTotalItems());
		System.out.println("Amount of physical items in stock is: " + visitor.getPhysicalItemsInStock());
		System.out.println("Number of digital items available is: " + visitor.availableDigitalItems());
	}
	//Do NOT edit this code
	public static void visitInventory(ArrayList<Item> inventory, ItemVisitor visitor){
		for(Item item: inventory){
			item.accept(visitor);
		}
	}
}
