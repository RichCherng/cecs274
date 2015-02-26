package AssignmentSix;

public class Assignment6 
{

	public static void main(String[] args) 
	{
		final int SIZE = 10;
		int ii = 0;
		CircularQueue q = new CircularQueue(SIZE);
		
		q.enumerate("Original");
		
		for(ii = 1; ii <= SIZE; ii++)
		{
			q.add(ii);
		}
		
		q.enumerate("\nAfter adding 1 thru " + SIZE);
		
		System.out.println("\nRemove all");
		while(!q.isEmpty())
		{
			System.out.print(q.peekFront() + " ");
			q.remove();
		}
		System.out.println();
		
		for(ii = 1; ii < SIZE * 5; ++ii)
		{
			q.add(1);
			q.add(2);
			q.remove();
			q.remove();
		}
		
		q.enumerate("\nAfter adding 2 elements and removing 2 elements repetitively");
		
		q.add(1);
		q.add(2);
		q.enumerate("\nAfter adding 1 and 2");
		
		while(!q.isEmpty()) q.remove();
		q.enumerate("\nRemoving all");
		
		// Cause peek error
		System.out.println();
		q.peekFront();
		q.peekRear();
		
		System.out.println("\nOverfill");
		for(ii = 1; ii <= SIZE + 1; ++ii) q.add(ii);
		

	}

}
