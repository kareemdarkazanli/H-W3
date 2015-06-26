import java.util.Random;

public class BSTMainMethod {
	
	  public static void main(String[] args) {

			BinarySearchTree bst = new BinarySearchTree();
	    	for(int i = 0; i < 10; i++)
	    	{
	    	Random random = new Random();
	    	int number = random.nextInt(10000 - 0 + 1);
	    	bst.add(number);
	    	}
	    	TreePrinter tp = new TreePrinter(bst);
	    	tp.print("Original Tree ");
	    	for(int i = 0; i < 10; i++)
	    	{
	    	bst.remove(bst.root.data);
	    	tp = new TreePrinter(bst);
	    	if(bst.root == null)
	    	{
	    		tp.print("Tree is now empty");
	    	}
	    	else
	    	tp.print("Deleted root: ");
	    	}
	    }

}
