package AssignmentFour;

/**
 * This is Stack class. This class create a list of element, and one object can be access at a time, which is the object at 
 * the top of the stack.Top Node always points to the previous or next Node.
 * @author Pongsathorn Cherngchaosil 012124071
 *
 */
public class Stack 
{
	
	/**
	 * Construct Stack with no Node and pointing to null
	 */
	public Stack()
	{
		mTop = null;
	}
	
	/**
	 * This method return the word in the top of the stack/list
	 * @return the work from the top of the stack/list.
	 */
	public String peek()
	{
		return mTop.mWord;
	}
	
	/**
	 * This method creates new Node with new word and put it to the top of the stack. 
	 * @param The word that will in the node at the top of the stack
	 */
	public void push(String top)
	{
		Node newNode = new Node(top);
		newNode.mNext = mTop;
		mTop = newNode;
	}
	
	/**
	 * This method return the word at the top of the stack and remove the top.
	 * @return return the word from the top of the stack
	 */
	public String pop()
	{
		String word = mTop.mWord;
		mTop = mTop.mNext;
			return word;
	}
	
	/**
	 * Check if the list is empty.
	 * @return 
	 */
	public boolean isEmpty()
	{
		return mTop == null;
	}
	
	/**
	 * Class constructor for object Node
	 */
	private class Node
	{
		/**
		 * Node constructor
		 * @param word The string that will be element of the Node.
		 */
		public Node(String word)
		{
			mWord = word;
			mNext = null;
		}
		
		private String mWord;

		private Node mNext;
	}

	private Node mTop;
}
