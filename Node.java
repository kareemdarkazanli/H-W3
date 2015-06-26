public class Node<T extends Comparable<?>> {
    Node<T> left, right;
    Integer data;

    public Node(Integer data) {
        this.data = data;
    }
    
    public void addNode(Node newNode)
	{
		int comp = newNode.data.compareTo(data);
		if(comp < 0)
		{
			if(left == null)
			{
				left = newNode;
			}
			else
			{
				left.addNode(newNode);
			}
		}
		else if (comp > 0)
		{
			if(right == null)
			{
				right = newNode;
			}
			else
			{
				right.addNode(newNode);
			}
		}
	}
}
