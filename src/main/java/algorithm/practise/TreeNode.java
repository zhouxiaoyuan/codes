package algorithm.practise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

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
        //levTree(getTree(5,100));

        //System.out.println( hasPathSum(getTree(2,100),3));

        //System.out.println( maxDepth(getTree(20,100)));

        //System.out.println( isBalanced(getTree(3,100)));

        //System.out.println( increasingBST(getTree(2,100)));
        System.out.println( increasingBSTWithStack(getTree(2,100)));

        /*TreeNode node = getTree();
        System.out.println(node);*/
    }

  public static TreeNode getTree(){
        int tree_depth = 3;
      TreeNode root = new TreeNode(random.nextInt(MAX_INT));
      initSubTreeNode(root,tree_depth-1);
      return root;
  }

    public static TreeNode getTree(int tree_depth,int max){
        TreeNode root = new TreeNode(random.nextInt(max));
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


  public static List<List<Integer>> levTree(TreeNode root){   //
      List<TreeNode> list = new ArrayList();
      List<List<Integer>> allList = new ArrayList<List<Integer>>();
      if(root==null){
          return allList;
      }
      list.add(root);

      while (!list.isEmpty()){

          List subList = new ArrayList<>();
          List<Integer> resultList = new ArrayList<Integer>();
          for(TreeNode node : list){
              resultList.add(node.val);
              if(node.left!=null){
                  subList.add(node.left);
              }
              if(node.right!=null){
                  subList.add(node.right);
              }
          }
          if( resultList.size() > 0 ){
              allList.add(resultList);
          }
          list = subList;
      }

      //return allList;

      System.out.println(allList);
      return allList;
  }

    public static  boolean hasPathSum(TreeNode root, int targetSum) { //112. 路径总和
        if(root == null){
            return false;
        }
        if( root.left == null && root.right == null ){
            if(targetSum == root.val){
                return true;
            }else{
                return  false;
            }
        }

        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);

    }

    public static  int maxDepth(TreeNode root) { //剑指 55 - I. 二叉树的深度

        if(root == null ){
            return 0;
        }

        int calDepth = getMaxDepth(root,0);
        return calDepth;

    }

    public static int getMaxDepth(TreeNode node , int maxDepth ){

        if(node == null){
            return maxDepth;
        }
        maxDepth = maxDepth + 1 ;

        int leftDepth = getMaxDepth(node.left, maxDepth);
        int rightDepth = getMaxDepth(node.right, maxDepth);

        return leftDepth > rightDepth ? leftDepth : rightDepth ;

    }

    public static boolean isBalanced(TreeNode root) {  //110. 平衡二叉树
        if(root == null ){
            return true;
        }

        int depth = 0 ;

        int left = getBDepth( root.left, depth);
        int right = getBDepth( root.right, depth);

        int diff = left >= right ? (left - right) : (right - left) ;
        boolean nowBalance = false;

        if( diff <= 1 ){
             nowBalance = true;
        }

        return nowBalance && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getBDepth(TreeNode node , int depth){

        if(node == null){
            return depth;
        }
        depth = depth + 1;

        int left = getBDepth(node.left, depth);
        int right = getBDepth(node.right, depth);

        return left > right ? left : right;

    }


    public static  TreeNode increasingBST(TreeNode root) { //897. 递增顺序查找树

        if(root == null ){
            return root;
        }

        List<TreeNode> list = new ArrayList<TreeNode>();
        TreeNode newNode = new TreeNode();

        getIncreasingBSTListTreeNode(root,list);

        TreeNode p = newNode;
        for(TreeNode node : list){
            p.right = node;
            p.left = null;
            p = node;
        }

        p.right = null;
        p.left = null;

        return newNode.right;

   }

    public static void getIncreasingBSTListTreeNode(TreeNode root,List<TreeNode> list){
        if(root == null ){
            return ;
        }
        getIncreasingBSTListTreeNode(root.left,list);
        list.add(root);
        getIncreasingBSTListTreeNode(root.right,list);
    }


    public static  TreeNode increasingBSTWithStack(TreeNode root) { //897. 递增顺序查找树

        if(root == null ){
            return root;
        }

        TreeNode node = new TreeNode();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = node;
       // stack.push(root);

        p = root;
        List<TreeNode> list = new ArrayList<>();

        TreeNode np = node;
        while( !stack.empty() || p != null ){

            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                list.add(p);

                p = p.right;
            }
        }

        TreeNode n1 = list.get(0);
        TreeNode head = n1;
        for(int i = 1; i< list.size() ;i++){
            list.get(i).left = null;
            n1.right = list.get(i);
            n1 = n1.right;
        }

        return head;

    }



}
