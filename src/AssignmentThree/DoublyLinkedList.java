package AssignmentThree;

import java.util.Arrays;

/**
 * This is DoublyLinkedList class. This class is similar to singlyLinkedList class but instead of only
 * one point, DoublyLinkedList has two. One pointing to previous Node and other pointing to next Node
 * 
 * @author Pongsathorn Cherngchaosil 012124071
 *
 */

public class DoublyLinkedList {
	/**
	 * Construct DoublyLinkedList with first Node String as "DummyFront" and Last Node String
	 * as "DummyRear."
	 * First Node point Last Node and Vice versa.
	 */
	public DoublyLinkedList()
	{
		mFront = new Node("DummyFront");
		mRear = new Node("DummyRear");
		mFront.mNext = mRear;
		mRear.mPrevious = mFront;
	}
	
	/**
	 * Insert input word in front of the first Node of the List, making it "first" Node.
	 * @param word String input that will be insert to the front
	 */
	public void appendFront(String word)
	{
		Node newNode = new Node(word);
		newNode.mNext = mFront.mNext;
		newNode.mPrevious = mFront;
		mFront.mNext = newNode;
		newNode.mNext.mPrevious = newNode;
	}
	
	/**
	 * Insert input word behind the last Node of the List, making it "last" Node
	 * @param word String input that will be insert to the last as Last Node
	 */
	public void appendRear(String word)
	{
		Node newNode = new Node(word);
		newNode.mNext = mRear;
		newNode.mPrevious = mRear.mPrevious;
		mRear.mPrevious = newNode;
		newNode.mPrevious.mNext = newNode;
	}
	
	/**
	 * Insert input word before the selected Node
	 * @param marker Selected Node that the word will be insert in the front.
	 * @param word String input that will be insert in front of marker's Node.
	 */
	public void insertBefore(String marker, String word)
	{
		Node newNode = new Node(word);
		Node current = mFront.mNext;
		
		while(current != mRear)
		{
			if(current.mWord.equals(marker))  //check for marker, the it is the marker
			{
				newNode.mPrevious = current.mPrevious; //newNode's mPrevious becomes current's previous
				newNode.mNext = current;   //newNode's mNext becomes current
				current.mPrevious.mNext = newNode;
				current.mPrevious = newNode;
				break;
			}
			current = current.mNext;
		}
	}
	
	/**
	 * Insert input word after the selected Node
	 * @param marker Selected NOde that the word will be insert behind.
	 * @param word String input that will be insert behind the marker's Node.
	 */
	public void insertAfter(String marker, String word) 
	{
		Node newNode = new Node(word);
		Node current = mFront.mNext;
		
		while(current != mRear)
		{
			if(current.mWord.equals(marker))
			{
				newNode.mNext = current.mNext;
				newNode.mPrevious = current;
				current.mNext.mPrevious = newNode;
				current.mNext = newNode;
				break;
			}
			current = current.mNext;
		}
	}
	
	/**
	 * Check if the Node containing the word is in the List.
	 * @param word String input uses to check the word in the List.
	 * @return return true if the word is in the list, return false otherwise.
	 */
	public boolean isPresent(String word)
	{
		Node current = mFront.mNext;
		
		while(current != mRear)
		{
			if(current.mWord.equals(word))
				return true;
			current = current.mNext;
		}
		
		return false;
	}
	
	/**
	 * Remove the Node containing the word input.
	 * @param word String input that will be remove if present in the List.
	 */
	public void remove(String word)
	{
		Node current = mFront.mNext;
		
		while(current != mRear)
		{
			if(current.mWord.equals(word))
			{
				current.mNext.mPrevious = current.mPrevious;
				current.mPrevious.mNext = current.mNext;
				break;
			} current = current.mNext;
		}
	}
	
	/**
	 * Function that will print the unsorted list in DoublyLinkedList
	 */
	public void print()
	{
		System.out.println("\nUnsorted List Forward");
		
		Node current = mFront;
		while(current != null)
		{
			System.out.print(current.mWord + " ");
			current = current.mNext;
		}
		
	}
	
	/**
	 * Function that will print out the unsorted list in DoublyLinkedList backward.
	 */
	public void printBackwards()
	{
		System.out.println("\n\nUnsorted List Backward");
		
		Node current = mRear;
			while(current != null)
			{
			System.out.print(current.mWord + " ");
			current = current.mPrevious;
			}
		
		System.out.println();
	}
	
	/**
	 * Print the sorted List in DoublyLinkedList.
	 */
	public void sortAndPrint()
	{
		System.out.println("\nSorted List");
		
		int count = getCount();
		if(count == 0) return;
		
		String[] words = new String[count];
		Node current = mFront;
		int index = 0;
		
		while(current != null)
		{
			words[index++] = current.mWord;
			current = current.mNext;
		}
		
		Arrays.sort(words);
		
		for(String word : words)
			System.out.print(word + " ");
		System.out.println();
	}
	
	/**
	 * Private method that will count how many element are in the list.
	 * @return the number of elements that are in the list.
	 */
	private int getCount()
	{
		int count = 0;
		Node current = mFront;
		
		while(current != null)
		{
			++count;
			current =current.mNext;
		}
		
		return count;
	}
	
	/**
	 * Class constructor for object Node
	 */
	private class Node
	{
		/**
		 * Node constructor, creating 2 null Nodes.
		 * @param word The string that will be element of the Node.
		 */
		public Node(String word)
		{
			mWord = word;
			mNext = null;
			mPrevious = null;
		}
		
		private String mWord;
		private Node mPrevious;
		private Node mNext;
	}
	
	private Node mFront;
	private Node mRear;
}
