package algorithm.practise;

import java.util.Random;

/**
 * @Description TreeNode
 * @Created by Administrator on 2021/3/31 10:21
 */
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }

  public static Random random = new Random();
  public static int MAX_INT = 100;
  public static int TREE_HEIGHT = 1;

    public static void main(String[] args) {
        TreeNode node = getTree();
        System.out.println(node);
    }

  public static TreeNode getTree(){
        int tree_depth = 3;
      TreeNode root = new TreeNode(random.nextInt(MAX_INT));
      initSubTreeNode(root,tree_depth-1);
      return root;
  }

  public static void initSubTreeNode(TreeNode node,int height){
      //生产左右子节点，递柜生成

      node.left = new TreeNode(random.nextInt(MAX_INT));
      node.right = new TreeNode(random.nextInt(MAX_INT));
      int hasHeight = height - 1;
      if( hasHeight > 0 ){
          initSubTreeNode(node.left,height-1);
          initSubTreeNode(node.right,height-1);
      }

  }



}
