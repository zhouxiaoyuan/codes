package algorithm.practise.y2021.m04;

import algorithm.practise.ArrayFactory;
import algorithm.practise.TreeNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @Description algorithm.practise.y2021.m04.P20210427
 * @Created by zhouxiaoyuan on 2021/4/27 8:18
 */
public class P20210427 {

    public static void main(String[] args) {
        /*TreeNode root = TreeNode.getTree(10, 50);
        int type = 2;
        TreeNode node = root;
        String s1 = TreeNode.dg(node,type );
        String s2 = notRecursion(root, type);
        System.out.println("");
        System.out.println("s1:"+s1);
        System.out.println("s2:"+s2);
        System.out.println(s1.equals(s2));*/

        for(int i = 0 ; i < 10000 ; i++ ){
            int[] arrs = ArrayFactory.getArray(100, 200);
            Heap heap = new Heap(arrs, new MaxComparator());
            heap.sort();
            if( !ArrayFactory.check(arrs)){
                System.out.println("fail:" + Arrays.toString(arrs));
                return ;
            }
        }
        System.out.println("sucess");
    }


    public static class Heap{
        int[] arrs;
        int heapSize=-1;
        Comparator comparator;

        public Heap(int[] arr,Comparator comparator){
            this.arrs = arr;
            this.comparator = comparator;
        }

        public void sort(){
            for(int i =0 ; i < arrs.length ; i++ ){
                heapInsert(i);
            }
            for(int i =0 ; i < arrs.length ; i++ ){
                heapRemove();
            }
        }

        public void heapInsert( int point){
            heapSize++;
            int p ;
            while(  comparator.compare( arrs[point],arrs[p=(point-1)/2] ) > 0  ){
                swap(point, p);
                point = p;
            }
        }

        public void heapify( int point ){
            int leftPoint = 2*point + 1;
            int rightPoint = 2*point + 2;
            while( ( leftPoint<=heapSize && comparator.compare( arrs[leftPoint] , arrs[point]) > 0 )  ||
                    ( rightPoint<=heapSize && comparator.compare( arrs[rightPoint] , arrs[point]) > 0 )
            ){
                if( (rightPoint <= heapSize) && comparator.compare(arrs[rightPoint],arrs[leftPoint]) > 0 ){
                    swap(point, rightPoint);
                    point = rightPoint;
                }else{
                    swap(point, leftPoint);
                    point = leftPoint;
                }
                leftPoint = 2*point + 1;
                rightPoint = 2*point + 2;
            }
        }

        public void heapRemove(){
            swap(heapSize, 0);
            heapSize--;
            heapify(0);
        }

        public void swap(int p1,int p2){
            int temp = arrs[p1];
            arrs[p1] = arrs[p2];
            arrs[p2] = temp;
        }
    }

    public static class MaxComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }



    public static String notRecursion(TreeNode node ,int type){
        StringBuilder sb = new StringBuilder("");
        if(node == null){
            return sb.toString();
        }

        Stack<TreeNode> stack = new Stack();
        while( !stack.empty() || node != null){
            while(node!=null){
                if(type==0){sb.append(node.val+"-");}
                stack.push(node);
                node = node.left;
            }
            node=stack.pop();
            if(type!=0){sb.append(node.val+"-");}
            if(type==2){
                if(!stack.empty() && node == stack.peek().left ){
                    node = stack.peek().right;
                }else{
                    node = null;
                }
            }else {
                node = node.right;
            }
        }
        return sb.toString();
    }

}
