package AssignmentFour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment4 {
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner reader = new Scanner(new File(args[0]));	
		Stack stack = new Stack();
		System.out.println("Input file contains:\n");
		while(reader.hasNext())
		{
			String line = reader.nextLine();
			System.out.print(line+" ");
			stack.push(line);
		}
		reader.close();
		System.out.println ("\n\nEvaluates to: "+calculate(stack));
		
	}
	
	public static int calculate(Stack in)
	{
		Stack list = new Stack();
		while(!in.isEmpty())
		{
			list.push(in.pop());
		}
		
		
		int operantOne = Integer.parseInt(list.pop());
		while(!list.isEmpty())	
		{
			int operantTwo = Integer.parseInt(list.pop());
			String operator = list.pop();
			switch(operator)
			{
				case "+": 
					list.push(Integer.toString(operantOne + operantTwo));
					break;
				case "-":
					list.push(Integer.toString(operantOne - operantTwo));
					break;
				case "*":
					list.push(Integer.toString(operantOne * operantTwo));
					break;
				case "/":
					list.push(Integer.toString(operantOne / operantTwo));
					break;
				case "%":
					list.push(Integer.toString(operantOne % operantTwo));
					break;
			}
			operantOne = Integer.parseInt(list.pop());
		}
		return operantOne;
		
	}

}
