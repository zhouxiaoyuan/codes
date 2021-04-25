package algorithm.practise.y2021.m04;

import algorithm.practise.TreeNode;

import java.util.Stack;

/**
 * @Description algorithm.practise.y2021.m04.P20210425
 * @Created by zhouxiaoyuan on 2021/4/25 8:49
 */
// go all out ; spare no pains ; pull out all stops ; do one's level best.
// Every day is so import! It consisitent your life. So you must spare no pains。
    //  framework architecture
public class P20210425 {


    public static void main(String[] args){
        TreeNode root = TreeNode.getTree(3, 50);
        TreeNode node = root;
        TreeNode.dg(root, 1);
        System.out.println("");
        mid(node);
    }

    public static void pre(TreeNode node){
        if(node == null){return ;}
        Stack<TreeNode> statck = new Stack<>();
        while (!statck.empty() || node != null){
            while(node != null){
                System.out.print(node.val + "-");
                statck.push(node);
                node = node.left;
            }
            node = statck.pop();
            node = node.right;
        }
    }

    public static void mid(TreeNode node){
        if(node == null){return ;}
        Stack<TreeNode> statck = new Stack<>();
        while (!statck.empty() || node != null){
            while(node != null){
                statck.push(node);
                node = node.left;
            }
            node = statck.pop();
            System.out.print(node.val + "-");
            node = node.right;
        }
    }

    public static void back(TreeNode node){
        if(node == null){
            return ;
        }
        Stack<TreeNode> statck = new Stack<>();
        while (!statck.empty() || node != null){
            while(node != null){
//                System.out.print(node.val + "-");
                statck.push(node);
                node = node.left;
            }
            node = statck.pop();
            System.out.print(node.val + "-");
            if( !statck.empty() && node == statck.peek().left ){
                node = statck.peek().right;
            }else{
                node = null;
            }
        }

    }

    public static INFO_HEIGHT isBCT(TreeNode node){
        if( node == null ){
            return new INFO_HEIGHT(true, 0);
        }
        INFO_HEIGHT left = isBCT(node.left);
        INFO_HEIGHT right = isBCT(node.right);
        boolean isSearch = false;
        int height = Math.max(left.height, right.height) + 1;
        if(left.isBST
                && right.isBST
                && Math.abs(left.height- right.height ) < 2  ){
            isSearch = true;
        }
        return new INFO_HEIGHT(isSearch, height);
    }

    public static INFO_SEARCH isBST(TreeNode node){
        if(node == null){
            return null;
        }
        int max = node.val;
        int min = node.val;
        boolean isBST = false;
        INFO_SEARCH left = isBST(node.left);
        INFO_SEARCH right = isBST(node.right);

        if( left != null && left.max > max ){
            max = left.max;
        }
        if( right != null && right.max > max ){
            max = right.max;
        }

        if( left != null && left.min < min){
            min = left.min;
        }

        if( right != null && right.min < min){
            min = right.min;
        }

        if( (left != null && left.min == min)
           || (right != null && right.max == max)
        ){
            isBST = true;
        }

        return new INFO_SEARCH(isBST,max,min);


    }



    public static class INFO_HEIGHT{
        boolean isBST;
        int height;

        public INFO_HEIGHT(boolean isBST, int height) {
            this.isBST = isBST;
            this.height = height;
        }
    }

    public static class INFO_SEARCH{
        boolean isSearch;
        int max;
        int min;

        public INFO_SEARCH(boolean isSearch, int max, int min) {
            this.isSearch = isSearch;
            this.max = max;
            this.min = min;
        }
    }


}
