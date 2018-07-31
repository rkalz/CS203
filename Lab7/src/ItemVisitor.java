

public interface ItemVisitor {
	public void visit(Item item);
	public void visit(Physical_Item item);
	public void visit(Digital_Item item);

}
