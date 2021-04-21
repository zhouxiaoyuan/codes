package algorithm.practise.y2021.m04;

import algorithm.practise.TreeNode;

import java.util.Stack;

/**
 * @Description algorithm.practise.y2021.m04.P20210421
 * @Created by zhouxiaoyuan on 2021/4/21 9:36
 */
public class P20210421 {

    public static void main(String[] args) {

        TreeNode root = TreeNode.getTree(5, 100);

        System.out.println("");
        dgPre(root);
        System.out.println("");
        pre1(root);


    }

    public static void dgPre(TreeNode root){
        if(root == null){
            return ;
        }
        TreeNode node = root;
        System.out.print(node.val + "-");
        dgPre(node.left);
        dgPre(node.right);
    }

    public static void dgMid(TreeNode root){
        if(root == null){
            return ;
        }
        TreeNode node = root;
        dgPre(node.left);
        System.out.print(node.val + "-");
        dgPre(node.right);
    }

    public static void pre(TreeNode root){
        if(root == null){
            return ;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node;
        while (!stack.empty()){
            node = stack.pop();
            System.out.print(node.val+"-");
            if( node.right != null ){
                stack.push(node.right);
            }
            if( node.left != null ){
                stack.push(node.left);
            }

        }

    }

    public static void mid(TreeNode root){
        if(root == null){
            return ;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        TreeNode node;
        while (!stack.empty()){
            node = stack.pop();
            if( node.right != null ){
                stack.push(node.right);
            }
            System.out.print(node.val+"-");
            if( node.left != null ){
                stack.push(node.left);
            }

        }

    }

    public static void pre1(TreeNode root){
        if(root==null){
            return ;
        }
        Stack<TreeNode> statck = new Stack<>();

        TreeNode node = root;
        //statck.push(root);
        /*while( node!= null || !statck.empty() ){
            System.out.print(node.val + "-");
            while(node.left != null){
                if(node.right!=null){
                    statck.push(node.right);
                }
                node = node.left;
                System.out.print(node.val + "-");
            }
            node = statck.empty() ? null : statck.pop();
        }*/



        while( node != null || !statck.empty() ){

            while(node.left!=null){
                statck.push(node.left);
                node = node.left;
            }

            System.out.print(node.val + "-");

            if( node.right != null ){
                node = node.right;
            }else{
                node = statck.pop();
            }




        }

    }


}
