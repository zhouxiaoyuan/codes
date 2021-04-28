package algorithm.practise.y2021.m04;

import algorithm.practise.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description algorithm.practise.y2021.m04.P20210428
 * @Created by zhouxiaoyuan on 2021/4/28 8:29
 */
public class P20210428 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree(3, 50);
        List<List<Integer>> list = levelOrderBottom(root);
        System.out.println(list);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList();
        if(root==null){
            return list;
        }
        TreeNode curEnd = root;
        TreeNode nextEnd = null;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        List<Integer> subList = new LinkedList();
        Stack<List<Integer>> stack = new Stack();
        while(!queue.isEmpty()){
            root = queue.poll();
            subList.add(root.val);
            if(root.left != null){
                queue.offer(root.left);
                nextEnd = root.left;
            }
            if(root.right != null){
                queue.offer(root.right);
                nextEnd = root.right;
            }
            if(root == curEnd){
                curEnd = nextEnd;
                nextEnd = null;
                stack.push(subList);
                subList = new LinkedList();  //TODO 本行结束，需要下一行初始化; 不要用nextNull判断，最后一层得nextEnd都是null ;并且注意添加和赋值顺序
            }
        }

        while(!stack.empty()){
            subList = stack.pop();
            list.add(subList);
        }

        return list;

    }

    public static void notRecursion(TreeNode node,int type,StringBuilder sb){
        if( node == null ){
            return;
        }
        Stack<TreeNode> stack = new Stack();
        while(!stack.empty() || node != null ){
            while(node != null){
                if(type == 0){
                    sb.append(node.val).append(",");
                }
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(type != 0){
                sb.append(node.val).append(",");
            }
            if(type==2){
                if(!stack.empty() && stack.peek().left == node ){
                    node = stack.peek().right;
                }else{
                    node = null;
                }
            }else{
                node = node.right;
            }


        }
    }

}
