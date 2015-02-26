
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * This assignment is to refresh the skills you learned in CECS 174.
 * 
 * @author Pongsathorn Cherngchaosil 003598177
 *
 */

public class AssignmentOne
{
	/**
	 * 
	 * Reads and returns the input stored in fileName. The first int is the number of following ints.
	 * The second int is the length of the array
	 * 
	 * @param fileName the full path of the input file
	 * @return a String array of the input
	 * @throws IsOException
	 */
	public static String[] getInput(String fileName) throws IOException
	{
		BufferedReader bufReader = null;
		 
		String currentLine;
 
		bufReader = new BufferedReader(new FileReader(fileName));
 
		currentLine = bufReader.readLine();
		count = Integer.parseInt(currentLine);
		index = Integer.parseInt(bufReader.readLine());
		String[] input = new String[count];
			
		for(int i = 0; i < count; i++)
		{
			currentLine = bufReader.readLine();
			input[i] = currentLine;
		}
		
		bufReader.close();
			
		return input;
	}
	
	/**
	 * Prints the String inside the array.
	 * 
	 * @param input The array of data from the file.
	 * 
	 */	
	public static void print(String[] input)
	{
		System.out.println("\nThe original data is:");
		for(int i=0; i<count; i++)
		{
			System.out.println(i+"."+input[i]);
		}
		System.out.println();
	}
	
	/**
	 * Prints the sorted array of data from the file.
	 * 
	 * @param input The array of data from the file.
	 * 
	 */	
	public static void sorted(String[] input)
	{
		System.out.println("\nThe sorted data is:");
		String[] dat = Arrays.copyOf(input, input.length);
		Arrays.sort(dat);
		for(int i=0; i<count; i++)
		{
			System.out.println(i+"."+dat[i]);
		}
	}
	
	/**
	 * Prints the location of the file.
	 * 
	 * @param fileLocation The String to the file's location.
	 * 
	 */	
	public static void fileLo(String fileLocation)
	{
		System.out.println("The input filename is: "+fileLocation);

	}
	
	/**
	 * Prints the String at the specify index of the array.
	 * 
	 * @param input The array of data from the file.
	 * 
	 */	
	public static void valueAt(String[] input)
	{
		System.out.println("\nThe value at index " + index + 
				" in the original data is: "+input[index] );
	}
	
	/**
	 * Prints the list of String array input and their reversed.
	 * 
	 * @param input The array of data from the file.
	 * 
	 */	
	public static void reverseList(String[] input)
	{
		System.out.println("The reversed list is: ");
		for(String i: input)
		{
			System.out.println(i+" becomes " + rev(i) );
		}
	}
	
	/**
	 * Reverse the input String
	 * 
	 * @param in A String from the method reverseList.
	 * 
	 * @return The reversed version of the input String
	 */	
	public static String rev(String in)
	{
		String temp = "";
		for(int i = in.length(); i > 0 ; i--)
		{
			temp += in.charAt(i-1);
		}
		return temp;
	}
	
	/**
	 * Prints the list of Strings that are palindrome from the input data
	 * 
	 * @param input The array of data from the file.
	 * 
	 */	
	public static void palin(String[] input)
	{
		System.out.println("\nThe palindromes are: ");
		for(String i:input)
		{
			if(i.equals(rev(i)))
				System.out.println(i);
		}
		
	}
	
	/**
	 * @param args contains the full path name of the input file
	 */
	public static void main(String[] args) throws IOException 
	{
		fileLo(args[0]);
		String[] in = getInput(args[0]);
		print(in);
		sorted(in);
		valueAt(in);
		reverseList(in);
		palin(in);
	}

	private static int count;
	private static int index;
}
