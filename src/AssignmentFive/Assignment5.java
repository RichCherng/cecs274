package AssignmentFive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment5 {

	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner reader = new Scanner(new File(args[0]));
		Queue que = new Queue();
		while(reader.hasNext())
		{
			String[] input = reader.nextLine().split(" ");
			char action = input[0].toUpperCase().charAt(0);
			int flight = Integer.parseInt(input[1]);
			int priority;
			switch(action)
			{
				case 'A':   // A gaurentee to have 3 elements in input[]
					priority = Integer.parseInt(input[2]);
					System.out.println("ARRIVAL: Flight #: " + flight +
							", Priority: " + priority + ". Waiting for permission to land.");
					que.add(flight,priority);
					break;
				case 'C':
					priority = Integer.parseInt(input[2]);	
					if(que.contain(flight))
					{
						System.out.println("PRIORITY CHANGE: Flight #: " +flight+ " to priority "+ priority +". Change was successful.");
					
						que.remove(flight);
						que.add(flight,priority);
					}
					else
					{
						System.out.println("PRIORITY CHANGE: Flight #: "+flight+" to priority "+priority+". Flight not found.");

					}
					break;
				case 'L':
					if(que.contain(flight))
					{
						que.remove(flight);
						System.out.println("EMERGENCY LANDING: Flight #: "+flight+
										". Flight #: "+flight+", Priority 10. Successful landing.");
					}
					else
						System.out.println("EMERGENCY LANDING: Flight #: "+flight+". Flight #: "+flight+" not found.");
					break;
			}
		
		}
		System.out.println("LAND ALL FLIGHTS");
		
		while(que.hasNext())
		{
			System.out.println(que.next());
		}
	}

}
