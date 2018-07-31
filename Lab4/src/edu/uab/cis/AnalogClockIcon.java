package edu.uab.cis;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Calendar;

import javax.swing.Icon;

/**
 * Binds together all the clock components as an icon. The display logic of the
 * clock is written in the paintIcon method.
 * 
 */
public class AnalogClockIcon implements Icon {
	
	// width of the clock (conventionally a diameter in a circular clock)
	private int width;

	// radius of the circular clock
	private int radius;

	// length of the hours hand
	private int hoursLen;

	// length of the minutes hand
	private int minutesLen;

	// length of the seconds hand
	private int secondsLen;

	/**
	 * Constructor takes in the width of the clock and lengths of the hours,
	 * minutes and seconds hand respectively. If the size provided is too small,
	 * the sizes are adjusted accordingly.
	 * 
	 * @param width
	 * @param hoursLen
	 * @param minutesLen
	 * @param secondsLen
	 */
	public AnalogClockIcon(int width, int hoursLen, int minutesLen,
			int secondsLen) {
		this.width = (width < 100) ? 100 : width;
		this.radius = this.width / 2;

		this.hoursLen = (hoursLen >= this.radius) ? this.radius - 25 : hoursLen;

		this.minutesLen = (minutesLen <= hoursLen || minutesLen >= this.radius) ? this.hoursLen + 15
				: minutesLen;

		this.secondsLen = (secondsLen <= minutesLen || secondsLen >= this.radius) ? this.minutesLen + 5
				: secondsLen;
	}

	/**
	 * @return the icon height of the clock equals its width(i.e. the diameter)
	 */
	@Override
	public int getIconHeight() {
		return width;
	}

	/**
	 * @return the icon width of the clock equals its width (i.e. the diameter)
	 */
	@Override
	public int getIconWidth() {
		return width;
	}

	/**
	 * The function is called when the method repaint of this component gets
	 * called. This function does the task of painting the icon as a clock
	 * having a circle, and then three hands that takes its position with
	 * respect to the center of the circle and according to the current time in
	 * hours, minutes and seconds.
	 */
	@Override
	public void paintIcon(Component component, Graphics graphics, int x, int y) {
		Graphics2D g2D = (Graphics2D) graphics;

		// center is the center of the circle. since x and y refers to the
		// top left side location, adding radius to both the component
		// transforms the point to the center of the icon.
		Point2D.Double center = new Point2D.Double(x + radius, y + radius);

		drawClock(g2D, center);
		
		drawHours(g2D, center);
		
		drawHands(g2D, center);
	}

	/**
	 * Draw the circle for the clock.
	 * 
	 * @param g2D
	 *            - Graphics2D object to do drawing
	 * @param center
	 *            - center of the icon
	 */
	private void drawClock(Graphics2D g2D, Point2D.Double center) {
		Ellipse2D.Double clockCircle = new Ellipse2D.Double(center.x - radius,
				center.y - radius, width, width);
		g2D.setColor(Color.DARK_GRAY);
		g2D.fill(clockCircle);

	}

	/**
	 * Draw the points in the circular path where we can print the letters "1"
	 * to "12" as seen in a conventional circular clock.
	 * 
	 * @param g2D
	 *            - Graphics2D object to do drawing
	 * @param center
	 *            - center of the icon
	 */
	private void drawHours(Graphics2D g2D, Point2D.Double center) {
		Point2D.Double textPoint = new Point2D.Double(center.x - 5, center.y
				- radius + 15);
		Point2D.Double centerTextPoint = new Point2D.Double(center.x - 5,
				center.y + 5); // transform the center for the text point
								// rotation so that the numbers are correctly
								// alligned
		g2D.setColor(Color.WHITE);
		for (int i = 0; i < 12; i++) {
			g2D.drawString(String.valueOf(i == 0 ? 12 : i), (int) textPoint.x,
					(int) textPoint.y); // where a text is written eg. either
										// "12" or "7",etc.
			textPoint = rotatePoint(centerTextPoint,
					textPoint, 30); // after each text is written rotate
									// clockwise by 30 degree for the point for
									// the next letter to be written
		}
	}
	
	/**
	 * E.g. Point2D.Double hoursEndPoint = new Points2D.Double(30,0);
	 * Point2D.Double center = new Point2D.Double(0,0); hoursEndPoint =
	 * AnalogClockTester.rotatePoint(center, hoursEndPoint, 90);
	 * 
	 * The value of hoursEndPoint after 90 degree clockwise rotation will be (0,
	 * 30)
	 * 
	 * @param point
	 *            : the point to be rotated
	 * @param center
	 *            : the center for the rotated about
	 * @param angle
	 *            : angle the point needs to be rotated about the center in
	 *            degree
	 * @return the rotated point after clockwise rotation
	 */
	public static Point2D.Double rotatePoint(Point2D.Double center,
			Point2D.Double point, double angle) {

		// converted to radian
		angle = (angle / 180.0) * Math.PI;

		double x = (point.x - center.x) * Math.cos(angle)
				- (point.y - center.y) * Math.sin(angle) + center.x;
		double y = (point.y - center.y) * Math.cos(angle)
				+ (point.x - center.x) * Math.sin(angle) + center.y;

		return new Point2D.Double(x, y);
	}

	/**
	 * Draw the hands of the clock according to the current time. See
	 * {@link Calendar} to get the current Calendar instance. Use
	 * {@link AnalogClockTester#rotatePoint} to rotate a point by certain angle
	 * using a axis. Finally draw the hands as a line in two dimension.
	 * 
	 * @param g2D
	 * @param center
	 */
	private void drawHands(Graphics2D g2D, Point2D.Double center) {

		Calendar cal = Calendar.getInstance();
		double curHour = cal.get(Calendar.HOUR);
		double curMin = cal.get(Calendar.MINUTE);
		double curSec = cal.get(Calendar.SECOND);
		
		Point2D.Double hourPoint = new Point2D.Double(radius,radius-hoursLen);
		Point2D.Double miPoint = new Point2D.Double(radius,radius-minutesLen);
		Point2D.Double secPoint = new Point2D.Double(radius,radius-secondsLen);
		
		double secRot = curSec*6;
		double minRot = curMin*6 + (secRot/60);
		double hourRot = curHour*30 + (minRot/12);
		
		hourPoint = rotatePoint(center,hourPoint,hourRot);
		miPoint = rotatePoint(center,miPoint,minRot);
		secPoint = rotatePoint(center,secPoint,secRot);
		
		Line2D.Double hourHand = new Line2D.Double(center, hourPoint);
		Line2D.Double minHand = new Line2D.Double(center, miPoint);
		Line2D.Double secHand = new Line2D.Double(center, secPoint);
		
		g2D.draw(hourHand);
		g2D.draw(minHand);
		g2D.draw(secHand);
		
	}
}