package AssignmentNine;

import java.util.Stack;


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
		if(mRoot == null)
			mRoot = newNode;
		else
			addNode(newNode);
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
		 		preOrder();
		 		break;
		 	case INORDER:
		 		System.out.println("INORDER");
		 		inOrder();
		 		break;
		 	case POSTORDER:
		 		System.out.println("POSTORDER");
		 		postOrder();
		 		break;
		 }
		
	}
	
	/**
	 * Traverse the tree in in-order.
	 * Print out the node of the tree in in-order
	 */
	public void inOrder() //left me right
	{
		if(mRoot == null)
			return;
		
		Stack<Node> s = new Stack<Node>();
		
		Node node = mRoot;
		
		while(node != null)
		{
			s.push(node);
			node = node.mLeft;
		}
		
		while(s.size()>0)
		{
			node = s.pop();
			System.out.printf("(%s,%s)%n",node.mKey,node.mValue);
			
			if(node.mRight != null)
			{
				node = node.mRight;
				while(node != null)
				{
					s.push(node);
					node = node.mLeft;
				}
			}

		}
	}
	
	/**
	 * Traverse the tree in post-order.
	 * Print out the node of the tree in post-order
	 */
	public void postOrder() //Left right me
	{
		if(mRoot == null)
			return;
		
		Stack<Node> s = new Stack<Node>();
		Node node = mRoot;
		Node temp;
		
		do
		{
			while(node != null)
			{
				if(node.mRight != null)
					s.push(node.mRight);
				s.push(node);
				node = node.mLeft;
			}
			
			node = s.pop();
			if( node.mRight != null && (!s.isEmpty()&&node.mRight == s.peek()))
			{
				temp = s.pop();
				s.push(node);
				node = temp;
			}
			else
			{
				System.out.printf("(%s,%s)%n",node.mKey,node.mValue);
				node = null;
			}
				
			
		}
		while(!s.isEmpty());	
	}
	
	/**
	 * Traverse the tree in pre-order.
	 * Print out the node of the tree in pre-order
	 */
	public void preOrder() //me left right
	{
		if(mRoot == null)
			return;
		
		Stack<Node> s = new Stack<Node>();
		
		Node node = mRoot;
		
		while(node != null)
		{
			System.out.printf("(%s,%s)%n",node.mKey,node.mValue);
			s.push(node);
			node = node.mLeft;
		}
		
		while(s.size() > 0)
		{
			node = s.pop();
			if(node.mRight != null)
			{
				node = node.mRight;
				while(node!=null)
				{
					System.out.printf("(%s,%s)%n",node.mKey,node.mValue);
					s.push(node);
					node = node.mLeft;
				}
			}
		}
	}
	
	/**
	 * The method add node into the tree according to their key value.
	 * @param newNode Node that will be added
	 */
	public void addNode(Node newNode)
	{
		Node current = mRoot;
		int k;
		while(current != null)
		{
			k = newNode.mKey.compareTo(current.mKey);
			if(k<0)
			{
				if(current.mLeft == null)
				{
					current.mLeft = newNode;
					break;
				}
				current = current.mLeft;
			}
			else if(k>0)
			{
				
				if(current.mRight == null)
				{
					current.mRight = newNode;
					break;
				}
				current = current.mRight;
			}
		}
	}
	
	/**
	 * Check if the node of the this key value exist
	 * @param key key of the node that user is looking for
	 * @return if the node containing the key exist, return true else return false.
	 */
	public boolean isPresent(String key)
	{
		Node current = mRoot;
		int k;
		while(current != null)
		{
			k = key.compareTo(current.mKey);
			if(k<0)
			{
				current = current.mLeft;
			}
			else if(k>0)
			{
				
				current = current.mRight;
			}
			else if(k==0)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Evaluate the tree and return the final value after evaluation
	 * @return the result of the evaluation
	 */
	public int evaluate()
	{
		if(mRoot == null)
			return 0;
		
		Stack<Node> s = new Stack<Node>();
		Stack<String> eva = new Stack<String>();
		
		Node node = mRoot;
		Node temp;
		int leftOperant,rightOperant;
		
		do
		{
			while(node != null)
			{
				if(node.mRight != null)
					s.push(node.mRight);
				s.push(node);
				node = node.mLeft;
			}
			
			node = s.pop();
			if( node.mRight != null && (!s.isEmpty()&& node.mRight == s.peek()))
			{
				temp = s.pop();
				s.push(node);
				node = temp;
			}
			else
			{
				
				switch(node.mValue)
				{
					case "+":
						rightOperant = Integer.parseInt(eva.pop());
						leftOperant = Integer.parseInt(eva.pop());
						eva.push(Integer.toString(leftOperant + rightOperant));
						System.out.printf("Evaluated:(%s,%s).Result:%s%n",node.mKey,node.mValue,eva.peek());
						break;
					case "-":
						rightOperant = Integer.parseInt(eva.pop());
						leftOperant = Integer.parseInt(eva.pop());
						eva.push(Integer.toString(leftOperant - rightOperant));
						System.out.printf("Evaluated:(%s,%s).Result:%s%n",node.mKey,node.mValue,eva.peek());
						break;
					case "*":
						rightOperant = Integer.parseInt(eva.pop());
						leftOperant = Integer.parseInt(eva.pop());
						eva.push(Integer.toString(leftOperant * rightOperant));
						System.out.printf("Evaluated:(%s,%s).Result:%s%n",node.mKey,node.mValue,eva.peek());
						break;
					case "/":
						rightOperant = Integer.parseInt(eva.pop());
						leftOperant = Integer.parseInt(eva.pop());
						eva.push(Integer.toString(leftOperant / rightOperant));
						System.out.printf("Evaluated:(%s,%s).Result:%s%n",node.mKey,node.mValue,eva.peek());
						break;
						
					default :
						eva.push(node.mValue);
						System.out.printf("Evaluated:(%s,%s).Result:%s%n",node.mKey,node.mValue,node.mValue);
						break;
						
				}
				node = null;
			}
		}
		while(!s.isEmpty());	
		return Integer.parseInt(eva.pop());
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
		public Node(String key, String value)
		{
			
			mKey = key;
			mValue = value;
		}
		
		
		private String mKey,mValue;
		private Node mLeft,mRight;
		

	}
	
	/**
	 * enum that help method traverse selected the order the tree is printing out.
	 */
	public enum TraversalOrder { PREORDER, INORDER, POSTORDER };


	private Node mRoot;
}