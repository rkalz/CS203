package visitor;

import java.util.Date;

public class Digital_Item extends Item{
	private Date releaseDate;
	public Digital_Item(int id, Date releaseDate) throws InterruptedException{
		super(id);
		Thread.sleep(100);
		if(releaseDate.before(new Date()))
				isAvailable = true;
		else
			isAvailable = false;
		this.releaseDate = releaseDate;
	}
	public Date getReleaseDate(){
		return releaseDate;
	}
	@Override
	public void accept(ItemVisitor visitor){
		visitor.visit(this);
	}

}
