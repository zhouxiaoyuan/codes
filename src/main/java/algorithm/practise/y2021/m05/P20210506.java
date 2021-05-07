package algorithm.practise.y2021.m05;

import algorithm.practise.TreeNode;

import java.util.Stack;

/**
 * @Description algorithm.practise.y2021.m05.P20210506
 * @Created by zhouxiaoyuan on 2021/5/6 9:16
 */
public class P20210506 {


    public static void main(String[] args) {

        TreeNode node = TreeNode.getTree(3, 50);
        notRecursion(node, 1);
        
    }

    public static void notRecursion(TreeNode node ,int type){
        
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(node != null || !stack.empty()){

            while(node != null ){             //TODO 使用了if作为判断
                System.out.print(node.val+"-");
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            node = node.right;

        }



    }


}
