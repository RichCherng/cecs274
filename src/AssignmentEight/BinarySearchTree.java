package AssignmentEight;

/**
 * This is BinarySearchTree class. This class store nodes in Binary Tree Structure according to the key value.
 * @author Pongsathorn Cherngchaosil 012124071
 *
 */
public class BinarySearchTree 
{
	/**
	 * The constructor create instance BinarySearchTree
	 */
	public BinarySearchTree()
	{
	}
	
	/**
	 * This method create a new node and placing it according to their key value
	 * @param key that will determine the placement of the node.
	 * @param value the new value that will be in the tree
	 */
	public void insert(String key, String value)
	{
		Node newNode = new Node(key,value);
		if( mRoot == null)
			mRoot = newNode;
		else
			mRoot.addNode(newNode);
	}
	
	/**
	 * Evaluate the tree and return the final value after evaluation
	 * @return the result of the evaluation
	 */
	public int evaluate()
	{
		if(mRoot.mLeft == null)
			return Integer.parseInt(mRoot.mValue);
		else
			return mRoot.operate();
	}
	
	/**
	 * traverse and print out the nodes of the tree according to the selected order
	 * @param order Order that the tree will transverse
	 */
	public void traverse(TraversalOrder order)
	{
		 switch(order)
		 {
		 	case PREORDER:
		 		System.out.println("PREORDER");
		 		mRoot.preOrder();
		 		break;
		 	case INORDER:
		 		System.out.println("INORDER");
		 		mRoot.inOrder();
		 		break;
		 	case POSTORDER:
		 		System.out.println("POSTORDER");
		 		mRoot.postOrder();
		 		break;
		 }
		
	}
	/**
	 * Check if the node of the this key value exist
	 * @param key key of the node that user is looking for
	 * @return if the node containing the key exist, return true else return false.
	 */
	public boolean isPresent(String key)
	{
		return checkTree(key,mRoot);
	}
	
	/**
	 * This is the helper method of the isPresent method. This method will recursively go through the tree 
	 * to find the node with the selected key. 
	 * @param key Key of the node that user's looking for
	 * @param current Current location of the pointer in recursion.
	 * @return true if the branch of the tree the method is going through containing the node containing the key else return false.
	 */
	private boolean checkTree(String key, Node current)
	{
		if(current != null)
		{
			int k = key.compareTo(current.mKey);
			if(k==0)
				{
				return true;}
			else if (k>0)
				return checkTree(key,current.mRight);
			else
				return checkTree(key,current.mLeft);
		}
		return false;
	}
	
	/**
	 * Class node they will store the key value and value of the node
	 */
	private class Node
	{
		/**
		 * Node constructor
		 * @param key key value of the node that will the determine placement of the node.
		 * @param value value of the Node or data the node is storing.
		 */
		public Node(String key,String value)
		{
			mLeft = null;
			mRight = null;
			mKey = key;
			mValue = value;
		}
		
		/**
		 * The method add node into the tree according to their key value.
		 * @param in Node that will be added
		 */
		public void addNode(Node in)
		{
			int comp = in.mKey.compareTo(mKey);
			if(comp  < 0)
			{
				if(mLeft == null)
					mLeft = in;
				else
					mLeft.addNode(in);
			}
			if(comp > 0)
			{
				if(mRight == null)
					mRight = in;
				else
					mRight.addNode(in);
			}
		}
		
		/**
		 * Helper method of the evaluate method. This method evaluate the child of the node that calling.
		 * @return evaluated value.
		 */
		public int operate()
		{
			int leftOperant,rightOperant;
			if(mLeft.mLeft != null)
				leftOperant = mLeft.operate();
			else
				{
					leftOperant = Integer.parseInt(mLeft.mValue);
					System.out.printf("Evaluated:(%s,%s).Resutl:%s%n",mLeft.mKey,mLeft.mValue,mLeft.mValue);
				}
			if(mRight.mRight != null)
				rightOperant = mRight.operate();
			else
				{
					rightOperant = Integer.parseInt(mRight.mValue);
					System.out.printf("Evaluated:(%s,%s).Resutl:%s%n",mRight.mKey,mRight.mValue,mRight.mValue);
				}
			int evaluated = 0;
			switch(mValue)
			{
				case "+":
					evaluated = leftOperant + rightOperant;
					break;
				case "-":
					evaluated = leftOperant - rightOperant;
					break;
				case "*":
					evaluated = leftOperant * rightOperant;
					break;
				case "/":
					evaluated = leftOperant / rightOperant;
					break;
					
			}
			System.out.printf("Evaluated:(%s,%s).Resutl:%d%n",mKey,mValue,evaluated);
			return evaluated;
		}
		
		/**
		 * Traverse the tree in pre-order.
		 * Print out the node of the tree in pre-order
		 */
		public void preOrder() //me, left, right
		{
			System.out.printf("(%s,%s)%n",mKey,mValue);
			if(mLeft != null)
				mLeft.preOrder();
			if(mRight != null)
				mRight.preOrder();
		}
		
		/**
		 * Traverse the tree in in-order.
		 * Print out the node of the tree in in-order
		 */
		public void inOrder() //Left , me , right
		{
			
			if(mLeft != null)
				mLeft.inOrder();
			System.out.printf("(%s,%s)%n",mKey,mValue);
			if(mRight != null)
				mRight.inOrder();
			
		}
		
		/**
		 * Traverse the tree in post-order.
		 * Print out the node of the tree in post-order
		 */
		public void postOrder() //Left, Right , me
		{
			if(mLeft != null)
				mLeft.postOrder();
			if(mRight != null)
				mRight.postOrder();
			System.out.printf("(%s,%s)%n",mKey,mValue);
		}
		
		
		
		private String mKey;
		private String mValue;
		private Node mLeft;
		private Node mRight;
	}
	
	/**
	 * enum that help method traverse selected the order the tree is printing out.
	 *
	 */
	public enum TraversalOrder { PREORDER, INORDER, POSTORDER };
	
	TraversalOrder O ;
	private Node mRoot;
}

