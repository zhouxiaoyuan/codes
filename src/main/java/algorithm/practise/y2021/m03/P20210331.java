package algorithm.practise.y2021.m03;

import algorithm.practise.TreeNode;

import java.util.Stack;

/**
 * @Description P20210331
 * @Created by Administrator on 2021/3/31 10:21
 */
public class P20210331 {


    public static void main(String[] args) {
        //树
        TreeNode node = TreeNode.getTree();

        //qx(node); //qx
        //zx(node);//zx
        hx(node); //hx
        System.out.println("");

        Stack<TreeNode> stack = new Stack();
        TreeNode p = node;

        //hx
        TreeNode visited = null;
        while(p!=null){
            stack.push(p);
            p = p.left;
        }

        while(!stack.empty()){
            p = stack.pop();
            if(p.right == null || visited == p.right ){
                System.out.print(p.val+"-");
                visited = p ;
            }else{
                stack.push(p);
                p = p.right;
                while(p!=null){
                    stack.push(p);
                    p = p.left;
                }
            }
        }

        //qx
        /*while (!stack.empty() || p != null) {
            if (p != null) {
                stack.push(p);
                System.out.print(p.val + "-");
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }*/

        //zx
        /*while (!stack.empty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                System.out.print(p.val + "-");
                p = p.right;
            }

        }*/






    }

        //递柜
        /*qx(node);
        System.out.println("");
        zx(node);
        System.out.println("");
        hx(node);*/

    //前序遍历
    public static void qx(TreeNode node){
        if(node == null){
            return ;
        }
        System.out.print(node.val+"-");
        qx(node.left);
        qx(node.right);
    }

    public static void zx(TreeNode node){
        if(node == null ){
            return ;
        }
        zx(node.left);
        System.out.print(node.val+"-");
        zx(node.right);
    }

    public static void hx(TreeNode node){
        if(node == null){
            return;
        }
        hx(node.left);
        hx(node.right);
        System.out.print(node.val+"-");
    }





}
