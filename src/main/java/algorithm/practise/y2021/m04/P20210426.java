package algorithm.practise.y2021.m04;

import algorithm.practise.ArrayFactory;
import algorithm.practise.TreeNode;

import java.util.Stack;

/**
 * @Description algorithm.practise.y2021.m04.P20210426
 * @Created by zhouxiaoyuan on 2021/4/26 8:14
 */
public class P20210426 {

    public static void main(String[] args) {

        /*TreeNode node = TreeNode.getTree(3, 50);
        int type = 2;

        System.out.println("");
        TreeNode.dg(node, type);
        System.out.println("");
        notRecursion(node, type);
        System.out.println("");*/

        /*int[] arrs = ArrayFactory.getArray(20, 50);
        gdSort(arrs, 0, arrs.length-1);
        ArrayFactory.check(arrs);*/

        TreeNode treeNode = TreeNode.getTree(21, 100);
        System.out.println(maxDeepth(treeNode));

    }

    public static int maxDeepth(TreeNode node){
        if(node==null){
            return 0;
        }
        return Math.max(maxDeepth(node.left), maxDeepth(node.right)) + 1;
    }

    public static void gdSort(int[] arrs, int l ,int r){
        if(arrs == null || l >= r ){
            return ;
        }
        int mid = l + ((r-l)>>1);
        gdSort(arrs,l, mid);
        gdSort(arrs,mid+1, r);
        merge(arrs,l ,mid , r);
    }

    public static void merge( int[] arrs, int l ,int m ,int r ){

        int p1 = l ;
        int p2 = m + 1;
        int p3 = 0 ;
        int[] helper = new int[r-l+1];

        while( p1<= m && p2 <= r){
            helper[p3++] = arrs[p1] <= arrs[p2] ? arrs[p1++] : arrs[p2++];
        }

        while( p1 <= m){
            helper[p3++] = arrs[p1++];
        }

        while( p2 <= r){
            helper[p3++] = arrs[p2++];  //TODO 少写了一个p3++
        }

        for(int i = 0 ; i < helper.length ; i++ ){
            arrs[l+i] = helper[i];
        }
        System.out.print("");

    }




    public static void pre(TreeNode node){
        notRecursion(node,0);
    }

    public static void mid(TreeNode node){
        notRecursion(node,1);
    }

    public static void back(TreeNode node){
        notRecursion(node,2);
    }

    public static void notRecursion(TreeNode node,int type){
        if(node == null ){
            return ;
        }
        Stack<TreeNode> stack = new Stack();
        while ( !stack.empty() || node != null ){
            while(node!=null){
                if(type == 0 ){
                    System.out.print( node.val + "-");
                }
                stack.push(node); //顺序需要注意
                node = node.left;
            }
            node = stack.pop();
            if(type != 0 ){
                System.out.print( node.val + "-");
            }
            if(type == 2){
                if( !stack.empty() && node == stack.peek().left ){
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
