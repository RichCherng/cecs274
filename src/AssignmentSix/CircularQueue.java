package AssignmentSix;

/**
 * This is CircularQueue class
 * This class uses array, the array will be fixed size during the run time
 * and there will be two point point to first and last element.
 * @author Pongsathorn Cherngchaosil 012124071
 *
 */
public class CircularQueue {
	
	/**
	 * This is a class structure of the class CircularQueue
	 * @param max max is the length of the array that will be use during the runtime
	 */
	public CircularQueue(int max)
	{
		que = new int[max];
		mFront = 0;
		mRear = 0;
	}
	
	/**
	 * This method will printout The index of first and last pointer, how many data in the array and 
	 * the size of the actual array.
	 * @param word  word is the input string that user want to printout
	 */
	public void enumerate(String word)
	{
		System.out.println(word +" queue contents:\n"+"Front:"+mFront+
							", Rear = "+mRear+", Count = "
							+mCount+", Size = "+que.length);
		if(!isEmpty())
		{
			for(int i=0; i<mCount; i++)
			{
				System.out.print(que[(mFront+i)%que.length]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * THis method add element to the queue
	 * @param x is the integer that will be put in the queue
	 */
	public void add(int x)
	{
		int max = que.length;
		if(mCount == 0)
		{
			que[mRear] = x;
			mCount++;
		}
		else if(mCount == que.length)
		{
			System.out.println("Que is full. May not add item "+x);
		}
		else
		{
			que[mRear] = x;
			mCount++;
		}
		mRear = (mRear+1)%que.length;
	}
	
	/**
	 * this method remove the first element in the queue or the element that been in the queue the longest/
	 */
	public void remove()
	{
		mFront = (mFront+1)%que.length;
		mCount -= 1;
	}
	
	/**
	 * return the index of the element of the array that is in front of the queue.
	 * @return index of the front pointer, index of the fist element.
	 */
	public int peekFront()
	{
		if(mCount == 0)
			System.out.println("Queue is empty. May not peek front");
		return que[mFront];
	}
	
	/**
	 * return the index of the element in the array that is the last to be put in the queue
	 * @return the index of rear pointer, index of the last element.
	 */
	public int peekRear()
	{
		if(mCount == 0)
		{
			System.out.println("Queue is empty. May not peek rear");
			return 0;
		}
		else
		{
			if(mRear == 0)
			{
				return que[que.length-1];
			}
			else
				return que[mRear -1];
		}
	}
	
	/**
	 * Check if the queue is empty
	 * @return true if there is an element in the queue, false if queue is empty
	 * 
	 */
	public boolean isEmpty()
	{
		return mCount == 0;
	}
	
	
	
	private int mFront, mRear,mCount;
	private int[] que;
}
