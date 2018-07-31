import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.Icon;

/**
   This component draws two car shapes.
*/
public class IconComponent extends JComponent
{
  public IconComponent(Icon icon)
  {
    this.icon = icon;
    this.x = 0;
    this.y = 0;
  }

  public void paintComponent(Graphics g)
  {
    icon.paintIcon(this, g, x, y);
  }
  
  public void changeX(int delta)
  {
	  x = x + delta;
  }
  
  public void changeY(int delta)
  {
	  y = y + delta;
  }
  
  public void setX(int newX)
  {
	  x = newX;
  }
  
  public void setY(int newY)
  {
	  y = newY;
  }
  
  public int getX()
  {
	  return x;
  }
  
  public int getY()
  {
	  return y;
  }

  private Icon icon;
  private int x;
  private int y;
}
