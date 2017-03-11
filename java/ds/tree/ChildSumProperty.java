package ds.tree;
class TNode 
{
    int data;
    TNode left, right;
  
    TNode(int item) 
    {
        data = item;
        left = right = null;
    }
}

class ChildSumProperty 
{
    
    /* This function changes a tree to to hold children sum
       property */
  TNode roo;
    int convertTree(TNode root,int diff) 
    {
    	if(root==null) return 0;
    	
    	if(root.data != 0 && diff > root.data)
    		root.data = diff;
    	if(root.left == null && root.right == null)return root.data;
    	int l = convertTree(root.left,0);
    	
    	if(root.data>l)
    		diff = root.data - l;
    	int r = convertTree(root.right,diff);
    	
    	root.data = l +r;
    	return root.data;
    		
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		//ChildSumProperty is a tree, to understand problem by file name name is changed
		ChildSumProperty tree = new ChildSumProperty();
        tree.roo = new TNode(50);
        tree.roo.left = new TNode(7);
        tree.roo.right = new TNode(2);
        tree.roo.left.left = new TNode(3);
        tree.roo.left.right = new TNode(5);
        tree.roo.right.left = new TNode(1);
        tree.roo.right.right = new TNode(30);
  
        System.out.println("Inorder traversal before conversion is :");
        tree.printInorder(tree.roo);
  
        tree.convertTree(tree.roo,0);
        System.out.println("");
  
        System.out.println("Inorder traversal after conversion is :");
        tree.printInorder(tree.roo);
  
    }
	
	
	
	void printInorder(TNode node) 
    {
        if (node == null)
            return;
             
        /* first recur on left child */
        printInorder(node.left);
  
        /* then print the data of node */
        System.out.print(node.data + " ");
  
        /* now recur on right child */
        printInorder(node.right);
    }
    
    
}