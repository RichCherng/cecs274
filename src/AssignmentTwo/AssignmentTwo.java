package AssignmentTwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;


public class AssignmentTwo 
{
	public static ArrayList<Circle> getCircles(String fileName) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		ArrayList<Circle> circles = new ArrayList<Circle>();
		
		circles.add(new Circle());
		
		boolean toggle = true;
		
		while(reader.ready())
		{
			int x = Integer.parseInt(reader.readLine());
			int y = Integer.parseInt(reader.readLine());
			int radius = Integer.parseInt(reader.readLine());
			
			if(toggle) circles.add(new Circle(x, y, radius));
			else circles.add(new Circle(new Point(x,y), radius));
			
			toggle = !toggle;
		}
		
		reader.close();
		
		return circles;
	}

	/**
	 * Print out the information for all circles
	 * 
	 * @param circles - the arraylist of circles
	 * 
	 */
	public static void dumpCircles(ArrayList<Circle> circles)
	{
		for(int ii = 0; ii < circles.size(); ++ii)
		{
			System.out.println("Circle(" + ii + ")\n   " + circles.get(ii));
			System.out.println("   Area: " + circles.get(ii).getArea());
			System.out.println("   Circumference: " + circles.get(ii).getCircumference());
		}
		System.out.println();
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		ArrayList<Circle> circles = getCircles(args[0]);
		
		dumpCircles(circles);
		
		System.out.println("Move the first citcle by delta x = 5, delta y = -10\n");		
		circles.get(0).move(5,-10);		
		
		dumpCircles(circles);
		
		System.out.println("Distance from Circle 1 to Circle 2 is " + circles.get(0).getDistance(circles.get(1)));
		System.out.println("Distance from Circle 1 to Circle 3 is " + circles.get(0).getDistance(circles.get(2)));
		System.out.println("Distance from Circle 2 to Circle 3 is " + circles.get(1).getDistance(circles.get(2)));
	}
}
