import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class BinarySearchTree {

	Node root;
	int count = 0;
    
	public void add(Integer obj)
	{
		Node newNode = new Node(obj);
		newNode.left = null;
		newNode.right = null;
		
		if(root == null)
		{
			root = newNode;
		}
		else
		{
			root.addNode(newNode);
		}
		
		count++;
	}
	
	public boolean find(Integer obj)
	{
		Node current = root;
		while(current != null)
		{
			int d = current.data.compareTo(obj);
			if(d == 0)
			{
				return true;
			}
			else if (d > 0)
			{
				current = current.left;
			}
			else
			{
				current = current.right;
			}
		}
		return false;
	}
	
	public void remove(Integer obj)
	{
		Node toBeRemoved = root;
		Node parent = null;
		boolean found = false;
		while(!found && toBeRemoved != null)
		{
			int d = toBeRemoved.data.compareTo(obj);
			if(d==0)
			{
				found = true;
			}
			else
			{
				parent = toBeRemoved;
				if (d > 0)
				{
					toBeRemoved = toBeRemoved.left;
				}
				else
				{
					toBeRemoved = toBeRemoved.right;
				}
			}
		}
		
		if(!found)
		{
			return;
		}
		if(toBeRemoved.left == null || toBeRemoved.right == null)
		{
			Node newChild;
			if(toBeRemoved.left == null)
			{
				newChild = toBeRemoved.right;
			}
			else
			{
				newChild = toBeRemoved.left;
			}
			
			if(parent == null)
			{
				root = newChild;
			}
			else if(parent.left == toBeRemoved)
			{
				parent.left = newChild;
			}
			else
			{
				parent.right = newChild;
			}
			return;
		}
		
		Node smallestParent = toBeRemoved;
		Node smallest = toBeRemoved.right;
		while(smallest.left != null)
		{
			smallestParent = smallest;
			smallest = smallest.left;
		}
		
		toBeRemoved.data = smallest.data;
		if(smallestParent == toBeRemoved)
		{
			smallestParent.right = smallest.right;
		}
		else
		{
			smallestParent.left = smallest.right;
		}
		
	}
	
	public int height(Node node)
	{
	    if (node == null)
	    {
	        return 0;
	    }
	    else
	    {
	        return 1 +
	        Math.max(height(node.left),
	            height(node.right));
	    }
	}
}
