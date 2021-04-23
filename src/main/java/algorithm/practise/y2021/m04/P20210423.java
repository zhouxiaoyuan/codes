package algorithm.practise.y2021.m04;

import algorithm.practise.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description algorithm.practise.y2021.m04.P20210423
 * @Created by zhouxiaoyuan on 2021/4/23 9:27
 */
public class P20210423 {

    public static void main(String[] args) {


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2));

        for (int i = 0; i < 50; i++) {
            threadPoolExecutor.execute(()->
            {
                System.out.println(Thread.currentThread().getName());
            });
        }


        while(true){

        }




        /*TreeNode root = TreeNode.getTree(3, 50);
        TreeNode node = root;
        System.out.println("");
        TreeNode.dg(node,1);
        System.out.println("");
//        level(root);
        pre2(node);
        System.out.println("");*/
    }

    public static void pre(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while ( !stack.empty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if( stack.empty() || node != stack.peek().right ){
                    System.out.print(node.val + "-");
                }
                node = node.right;
            }
        }
    }

    public static void pre2(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.empty() || node != null) {
            while(node != null ){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.print(node.val + "-");
            node = node.right;
            /*if( !stack.empty() && node == stack.peek().left ){
                node = stack.peek().right;
            }else{
                node = null;
            }*/

        }

    }


    public static void level(TreeNode node){
        if(node==null){
            return ;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(node);
        while(!queue.isEmpty()){
            node = queue.poll();
            System.out.print(node.val + "-");
            if( node.left != null){
                queue.offer(node.left);
            }
            if( node.right != null){
                queue.offer(node.right);
            }
        }
    }


    public static void pre1(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()) {

            node = stack.pop();
            System.out.print(node.val + "-");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

}