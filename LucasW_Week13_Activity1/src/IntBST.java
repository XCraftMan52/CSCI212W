public class IntBST
{
	
	protected IntBSTNode root;
	
	public IntBST()	// Constructor
	{
		root = null;
	}
	
	protected void visit (IntBSTNode p)	// Print info of node
	{
		System.out.print(p.key + " ");
	}
	
	
	public void insert (int el)
	{
		IntBSTNode p = root;
		IntBSTNode prev = null;
		
		while (p != null)	// find place for inserting new node
		{
			prev = p;
			if (p.key <el)
				p = p.right;
			else 
				p = p.left;
		}
		
		if (root == null)	// tree is empty
			root = new IntBSTNode(el);
		
		else if (prev.key < el)
			prev.right = new IntBSTNode(el);
		else
			prev.left = new IntBSTNode(el);
	}
	
	
	public IntBSTNode search(IntBSTNode p, int el)
	{
		while (p != null)
			if (el == p.key)
				return p;
			else if (el < p.key)
				p = p.left;
			else 
				p = p.right; 
		
		return null;
	}
	
	public static void main(String[] args)
	{
		
		IntBST mytree = new IntBST();
		
		mytree.insert(13);
		mytree.insert(10);
		mytree.insert(2);
		mytree.insert(12);
		mytree.insert(25);
		mytree.insert(20);
		mytree.insert(31);
		mytree.insert(29);
		
		System.out.println( mytree.search(mytree.root, 29).key );
	}
}