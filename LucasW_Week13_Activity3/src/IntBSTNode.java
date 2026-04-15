public class IntBSTNode 
{

	// Member variables
	protected int key;			// the info
	protected IntBSTNode left;	// reference to left child
	protected IntBSTNode right; // reference to the right child
	
	public IntBSTNode()			// Default constructor
	{
		left = right = null;	// node without children
	}
	
	public IntBSTNode (int el)	// overloaded constructor 
	{
		this(el, null, null);	// build this node without children
	}
	
	public IntBSTNode (int el, IntBSTNode lt, IntBSTNode rt)
	{
		key = el;
		left = lt;
		right = rt;
	}
}