package algorithm.practise.y2021.m04;

import algorithm.practise.TreeNode;

import java.nio.file.StandardWatchEventKinds;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description P20210401
 * @Created by Administrator on 2021/4/1 9:11
 */
public class P20210401 {

    public static void main(String[] args) {

        TreeNode root = TreeNode.getTree(7,1000);

        //tree
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> subStack = new Stack<TreeNode>();
        TreeNode tempNode ;

        List<TreeNode> list = new ArrayList();
        list.add(root);
        List<List<Integer>> allList = new ArrayList<List<Integer>>();

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

    }

}
