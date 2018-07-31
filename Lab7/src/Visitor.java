import java.util.Date;

public class Visitor implements ItemVisitor 
{
	
	private int totalItems = 0;
	private int physicalInStock = 0;
	private int digitalItemsOut = 0;

	@Override
	public void visit(Item item) {
		System.out.println("Item. ID: " + item.getId());
		totalItems++;
	}

	@Override
	public void visit(Physical_Item item) {
		System.out.println("Physical Item, ID: " + item.getId() + ", Stock: " + item.getStock());
		physicalInStock = physicalInStock + item.getStock();
		totalItems++;
	}

	@Override
	public void visit(Digital_Item item) {
		System.out.println("Digital Item, ID: " + item.getId() + ", Stock: " + item.getReleaseDate());
		Date curDate = new Date();
		if (curDate.after(item.getReleaseDate()))
		{
			digitalItemsOut++;
		}
		totalItems++;
	}
	
	public int getTotalItems()
	{
		return totalItems;
	}
	
	public int getPhysicalItemsInStock()
	{
		return physicalInStock;
	}
	
	public int availableDigitalItems()
	{
		return digitalItemsOut;
	}

}
