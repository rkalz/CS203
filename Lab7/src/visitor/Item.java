package visitor;

public class Item {
	protected int id;
	protected boolean isAvailable;
	public Item(int id){
		this.id = id;
	}
	public void accept(ItemVisitor visitor){
		visitor.visit(this);
	}
	public int getId(){
		return id;
	}
	
	public boolean isAvailable(){
		return isAvailable;
	}

}
