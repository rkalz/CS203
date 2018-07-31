

public class Physical_Item extends Item{
	private int stock;
	public Physical_Item(int id, int stock){
		super(id);
		if(stock == 0)
			isAvailable = false;
		else
			isAvailable = true;
		this.stock = stock;
		
	}
	
	public int getStock(){
		return stock;
	}
	
	@Override
	public void accept(ItemVisitor visitor){
		visitor.visit(this);
	}
}
