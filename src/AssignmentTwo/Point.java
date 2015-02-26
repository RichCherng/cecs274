package AssignmentTwo;

/**
 * This is a Point class that contain x and y coordinate.
 * 
 * @author Pongsathorn Cherngchaosil 012124071
 *
 */
public class Point {
	
	/**
	 * Construct a new point at (0,0)
	 */
	public Point()
	{
		mX = 0;
		mY = 0;
	}
	
	/**
	 * Construct a new point at given x and y coordinate
	 * @param x x-coordinate 
	 * @param y y-coordinate
	 */
	public Point(int x,int y)
	{
		mX = x;
		mY = y;
	}
	
	/**
	 * Allow access to x-coordinate of this Point
	 * @return x-coordinate
	 */
	public int getX()
	{
		return mX;
	}

	/**
	 * Allow access to y-coordinate of this Point
	 * @return y-coordinate
	 */
	public int getY()
	{
		return mY;
	}
	
	/**
	 * Get Distance between this point and the point from the argument
	 * @param a class Point
	 * @return calculated distance between the this point and the given point
	 */
	public double getDistance(Point a)
	{
		double distance = Math.sqrt
				(
						Math.pow(mX-a.getX(),2)+
						Math.pow(mY-a.getY(),2)
				);
		return distance;
	}
	
	/**
	 * Move the point in given x and y coordinate.
	 * @param x distance that this point will move in x-coordinate.
	 * @param y distance that this point will move in y-coordinate.
	 */
	public void move(int x, int y)
	{
		mX += x;
		mY += y;
	}
	
	/**
	 * When printing out this class, this function will format the output string
	 * @return formatted output 
	 */
	public String toString()
	{
		return "(" +mX+ "," +mY+ ")";
	}
	
	private int mX;
	private int mY ;
}
