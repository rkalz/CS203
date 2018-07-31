import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
*/
public class AnimationTester
{
   public static void main(String[] args) throws InterruptedException
   {
      final AnimatedIcon walkericon = new AnimatedIcon();

      for (int i = 0; i < 8; ++i)
      {
        walkericon.addIcon("0" + i + "walk.gif");
      }

      JComponent comp  = new IconComponent(walkericon);
      JFrame     frame = new JFrame();
      frame.add(comp);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setSize(300, 300);
      frame.setVisible(true);
      
      frame.addKeyListener(new KeyListener() {
      	public void keyPressed(KeyEvent e) {
      		switch (e.getKeyCode())
      		{
      		case (37):
      		{
      			((IconComponent) comp).changeX(-5);
      			break;
      		}
      		case (39):
      		{
      			((IconComponent) comp).changeX(5);
      			break;
      		}
      		}
      	}
      	public void keyReleased(KeyEvent e) {
      		
      	}
      	public void keyTyped(KeyEvent e) {}
      });
      
      frame.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
    	  
      });

      while (true)
      {
        Thread.sleep(100);
        comp.repaint();
      }
   }
}
