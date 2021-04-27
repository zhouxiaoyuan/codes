package algorithm.practise;

import org.junit.Test;

import java.util.*;

/**
 * @Description TreeNode
 * @Created by Administrator on 2021/3/31 10:21
 */
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;
  public TreeNode() {}
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
        //System.out.println( increasingBSTWithStack(getTree(2,100)));

        /*TreeNode node = getTree();
        System.out.println(node);*/

        TreeNode node = getTree(5, 50);
        int type = 2;
        System.out.println("");
        dg(node,type);
        System.out.println("");
//        notDg(node,type);
        backDg(node);
        System.out.println("");

    }

    @Test
    public void testToArray(){
        int depth = 5;
        TreeNode node = TreeNode.getTree(depth, 100);
        int i = 1 ;
        int size = 1;
        int levelSize = 1;
        while( i < depth ){
            levelSize = levelSize <<1 ;
            size += levelSize;
            i++;
        }
//        size = size - 1;
        System.out.println("array size:" + size);

        TreeNode[] arrs = new TreeNode[size];
        toArray(arrs,0,node);
        System.out.println(Arrays.toString(arrs));
    }

    public static void toArray(TreeNode[] arrs , int position, TreeNode node){
        arrs[position] = node;
        if(node.left!=null){
            toArray(arrs, 2*position+1, node.left);
        }
        if(node.right!=null){
            toArray(arrs, 2*position+2, node.right);
        }
    }

    public static void notDg(TreeNode node,int type){
        if(node == null ){
            return ;
        }
        Stack<TreeNode> stack = new Stack();
        while( !stack.empty() || node != null){
            if(node!=null){
                if( type == 0 ){
                    System.out.print(node.val + "-");
                }
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                if( type == 1 ){
                    System.out.print(node.val + "-");
                }
                node = node.right;
            }
        }
    }


    public static void backDg(TreeNode node){

        if(node==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(node != null || !stack.empty()){

           while( node != null){
               stack.push(node);
               node = node.left;
           }
           node = stack.pop();
            System.out.print(node.val + "-");
            if( !stack.empty() && node == stack.peek().left ){
                node = stack.peek().right;
            }else{
                node = null;
            }

        }
    }

    public static void dgPre(TreeNode node){
        dg(node,0);
    }

    public static void dgMid(TreeNode node){
        dg(node,1);
    }

    public static void dgBack(TreeNode node){
        dg(node, 2);
    }

    static StringBuilder sb = null;

    public static String dg(TreeNode node,int type){
        if(sb==null){
            sb = new StringBuilder("");
        }
        if(node == null){
            return sb.toString();
        }
        if(type==0){
            System.out.print(node.val + "-");
            sb.append(node.val + "-");
        }

        dg(node.left,type);
        if(type==1){
            System.out.print(node.val + "-");
            sb.append(node.val + "-");
        }
        dg(node.right,type);
        if(type==2){
            System.out.print(node.val + "-");
            sb.append(node.val + "-");
        }
        return sb.toString();
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


    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                '}';
    }
}
