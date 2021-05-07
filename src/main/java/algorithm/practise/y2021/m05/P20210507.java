package algorithm.practise.y2021.m05;

import algorithm.practise.TreeNode;
import algorithm.practise.y2021.m04.P20210429;

import java.util.Stack;

/**
 * @Description algorithm.practise.y2021.m05.P20210507
 * @Created by zhouxiaoyuan on 2021/5/7 8:44
 */
public class P20210507 {

    public static void main(String[] args) {

        TreeNode root = TreeNode.getTree(4, 50);
        TreeNode node = root;

        TreeNode.backDg(root);
        System.out.println("");
        notRecursion(node, 1);

    }

    public static void notRecursion(TreeNode node , int type){

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(node);

        while( !s1.empty() ){

            node = s1.pop();
            s2.push(node);

            if(node.left != null){
                s1.push(node.left);
            }
            if(node.right != null ){
                s1.push(node.right);
            }
        }

        while(!s2.empty()){
            node = s2.pop();
            System.out.print(node.val + "-");
        }



    }


}
