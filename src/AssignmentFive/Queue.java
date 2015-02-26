package AssignmentFive;


/**
 * This is Queue class. This class is implemented like DoublyLinkedList, with each node has two pointer.
 * This list will be in FIFO, the element that been in the list the longest will be the next exit.
 * @author Pongsathorn Cherngchaosil 012124071
 *
 */
public class Queue 
{
	/**
	 * Constructor, initialize 2 Nodes. First Node has the highest "priority"
	 * Last Node has the Lowest "priority" They both linked to each other.
	 */
	public Queue()
	{
		mFirst = new Node(-1,-1);
		mLast = new Node (10000,11);
		mFirst.mNext = mLast;
		mLast.mPrevious = mFirst;
	}

	/**
	 * This method check if the input flight is in the list
	 * @param flight the flight that the method is checking
	 * @return if the flight exist, return true, and return false otherwise
	 */
	public boolean contain(int flight)
	{
		Node current = mFirst.mNext;
		while(current != mLast)
		{
			if(current.mFlight == flight)
				return true;
			current = current.mNext;
		}
		return false;
	}
	
	/**
	 * This method add the flight to the queue according the the priority
	 * The method will check for priority. The flight with the same priority will be put in a queue with the
	 * same priority depend on who come first
	 * @param flight The flight number that will be added
	 * @param priority The priority of the flight
	 */
	public void add(int flight, int priority)
	{
		Node newNode = new Node(flight,priority);
		Node current = mFirst;
		if(priority > 10 || priority < 1)
		{
			System.out.println("ARRIVAL: Flight #: "+flight+", Priority: "+priority+". Invalid priority: "+priority+". Turned away.");
		}
		else
		{
			while(current != null )
			{
				if(newNode.mPriority < current.mPriority)
				{
					newNode.mNext = current;
					newNode.mPrevious = current.mPrevious;
					current.mPrevious.mNext = newNode;
					current.mPrevious = newNode;
					break;
				}
				current = current.mNext;
			
			}
		}
	}
	
	/**
	 * The Method will remove the next flight in queue
	 */
	public void remove()
	{
		remove(mFirst.mNext.mFlight);
	}
	
	/**
	 * The method will remove the selected flight from the queue
	 * @param flight The selected flight that will be remove
	 */
	public void remove(int flight)
	{
		Node current = mFirst;
		while(current != null)
		{

			if(current.mFlight == flight)
			{
				
				current.mPrevious.mNext = current.mNext;
				current.mNext.mPrevious = current.mPrevious;///this one
				break;
			}
			current = current.mNext;
		}
	}
	
	/**
	 * check if the queue is empty
	 * @return return true if the queue if not empty, return false otherwise.
	 */
	public boolean hasNext()
	{
		return mFirst.mNext != mLast;
	}
	
	/**
	 * remove the next flight in queue
	 * @return return and land the next Flight  in queue.
	 */
	public String next()
	{
		if(mFirst.mNext == null)
		{
			return "The QUEUE is EMPTY";
		}
		int flight = mFirst.mNext.mFlight;
		int priority = mFirst.mNext.mPriority;
		mFirst.mNext = mFirst.mNext.mNext;
		return "Flight #: "+flight+", Priority "+priority+" landed.";
	}
	
	/**
	 * Class constructor for Node object
	 */
	private class Node
	{
		/**
		 * Constructor for Node object
		 * @param flight The flight number that will be store in the Node
		 * @param priority The priority of the flight that will be store in the Node
		 */
		public Node(int flight, int priority)
		{
			mFlight = flight;
			mNext = null;
			mPrevious = null;
			mPriority = priority;
		}
		
		private int mFlight;
		private int mPriority;
		
		private Node mPrevious;
		private Node mNext;
	}

	private Node mFirst,mLast;
}
