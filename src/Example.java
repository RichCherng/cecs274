import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * This is an example of your first programming assignment. It shows how you must document and
 * format your programs. These rules can be found under Content in Beachboard.
 * 
 * This assignment is to refresh the skills you learned in CECS 174.
 * 
 * @author Frank Murgolo 003598177
 *
 */
public class Example 
{
	/**
	 * Reads and returns the input stored in fileName. The first int is the number of following ints.
	 * Also saves the count as a private class variable.
	 * 
	 * @param fileName the full path of the input file
	 * @return an int array of the input
	 * @throws IOException
	 */
	
	
	public static int[] getInput(String fileName) throws IOException
	{
		BufferedReader bufReader = null;
		 
		String currentInt;
 
		bufReader = new BufferedReader(new FileReader(fileName));
 
		currentInt = bufReader.readLine();
		m_count = Integer.parseInt(currentInt);
		int[] input = new int[m_count];
			
		for(int ii = 0; ii < m_count; ++ii)
		{
			currentInt = bufReader.readLine();
			input[ii] = Integer.parseInt(currentInt);
		}
		
		bufReader.close();
			
		return input;
	}
	
	/**
	 * Prints data in sorted order.
	 * 
	 * @param data The data to sort
	 */
	public static void showSorted(int [] data)
	{
		System.out.println("\nThe sorted data is:");
		
		Arrays.sort(data);
		for(int ii = 0; ii < data.length; ++ii)
		{
			System.out.println(data[ii]);
		}
		
		System.out.println();
	}
	
	/**
	 * Prints the minimum value of the data.
	 * 
	 * @param data The data for which to show the Minimum
	 */
	public static void showMinimum(int [] data)
	{
		System.out.print("\nThe minimum value is: ");
		
		Arrays.sort(data);
		System.out.println(data[0]);
		System.out.println();
	}
	
	/**
	 * Prints the maximum value of the data.
	 * 
	 * @param data The data to show the Maximum
	 */
	public static void showMaximum(int [] data)
	{
		System.out.print("\nThe maximum value is: ");
		
		Arrays.sort(data);
		System.out.println(data[data.length - 1]);
		System.out.println();
	}
	
	/**
	 * Prints the average value of the data.
	 * 
	 * @param data The data to compute its average.
	 * 
	 */
	public static void showAverage(int[] data)
	{
		double sum = 0.0;
		for(int ii = 0; ii < data.length; ++ii) sum += data[ii];
		
		System.out.println("\nThe average is: " + sum / data.length);
	}
	
	/**
	 * @param args contains the full path name of the input file
	 */
	public static void main(String[] args) throws IOException
	{
		int [] input = getInput(args[0]);
		
		showSorted(input);
		showMinimum(input);
		showMaximum(input);
		showAverage(input);
	}
	
	// You might find this technique useful in Assignment One for saving the "ith"
	private static int m_count; 
		
}