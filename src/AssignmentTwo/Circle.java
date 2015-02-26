package AssignmentTwo;
/**
 * This is a Circle class that contain a class point, radius and functions  to calculate
 * its area, circumference and distance it moved.
 * @author Pongsathorn Cherngchaosil 012124071
 *
 */
public class Circle {
	final int PRECISION = 4;
	
	/**
	 * Construct a new Circle with the point at (0,0) as its center and radius of 1.
	 */
	public Circle()
	{
		point = new Point(0,0);
		mRadius = 1;
	}
	/**
	 * Construct a new Circle with the point (x,y) from the argument as it center
	 * and radius of 1.
	 * @param x the x-coordinate of the center of the Circle
	 * @param y the y-coordinate of the center of the Circle
	 */
	public Circle(int x, int y)
	{
		point = new Point(x,y);
		mRadius = 1;
	}
	
	/**
	 * Construct a new Circle with the center point (x,y) and specific radius
	 *  from the arguments.
	 * @param x the x-coordinate of the center of the Circle
	 * @param y the y-coordinate of the center of the Circle
	 * @param radius the radius of the Circle
	 */
	public Circle(int x,int y,int radius)
	{
		point = new Point(x,y);
		mRadius = radius;
	}
	
	/**
	 * Construct a new Circle with the object point and specific radius from
	 * the arguments. 
	 * @param p Object(point) that 
	 * @param radius the radius of the Circle
	 */
	public Circle(Point p,int radius)
	{
		point = p;
		mRadius = radius;
	}
	
	/**
	 * Calculate the area of the circle
	 * @return return the area of the circle in form of string.
	 */
	public String getArea()
	{
		return prec(Math.PI * Math.pow(mRadius, square));
	}
	
	/**
	 * Calculate the circumference of the circle
	 * @return return the circumference of the circle in the form of string.
	 */
	public String getCircumference()
	{
		return prec(2*Math.PI * mRadius);
	}
	
	/**
	 * Move the center of the circle x unit and y unit
	 * @param x the distance the circle move in x-coordinate direction.
	 * @param y the distance the circle move in y-coordinate direction.
	 */
	public void move(int x, int y)
	{
		point.move(x,y);
	}
	
	/**
	 * Calculate the Distance from the center of this this circle and
	 * the center of the input circle.
	 * @param c Object(Circle) that will be use to calculate the distance.
	 */
	public String getDistance(Circle c)
	{
		return prec(c.getPoint().getDistance(getPoint()));

	}
	
	/**
	 * Allow access to point of this circle
	 * @return object Point of this circle
	 */
	public Point getPoint()
	{
		return point;
	}
	
	/**
	 * Set the Precision of the (double)number
	 * @param n number that this function wll format its precision
	 * @return formatted precision of the number in the form of string
	 */
	public String prec(double n)
	{
		String num = String.valueOf(n);
		int index = num.indexOf(".");
		int length = num.substring(index+1).length();
		if(length < PRECISION)
		{
			//PRECISION - length, add that amount of zero
			for(int i = length; i<PRECISION; i++)
			{
				num += "0";
			}
			return num;
			
		}
		else
		{
			return num.substring(0,index+PRECISION+1);
		}
			
	}
	
	/**
	 * When printing out this class, this function will format the output string
	 * @return the formatted output.
	 */
	public String toString()
	{
		
		return "Center = (" +point+", Radius = " +mRadius;
		
	}

	private Point point ;
	final private int square = 2;
	private int mRadius;
}
