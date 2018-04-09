/*  https://leetcode.com/problems/maximum-width-of-binary-tree/



*/

class Solution {
    int max_width = 0;
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    public int widthOfBinaryTree(TreeNode root) {
     
        if(root == null)
            return 0;
       return findMaxWidth(root, 0, 0);
    }
    
   public int findMaxWidth(TreeNode root, int level, int value){
       if(root == null)
           return 0;
       
       if(!map.containsKey(level))
           map.put(level, value);
       
       int temp = value - map.get(level);
       
       max_width = Math.max(max_width, temp);
       findMaxWidth(root.left, level + 1, value*2 + 1);
       findMaxWidth(root.right, level + 1, value*2 + 2);
       
       return max_width + 1 ;
       
       
       
   }
}
