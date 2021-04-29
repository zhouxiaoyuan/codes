package algorithm.practise.y2021.m04;

import algorithm.practise.ArrayFactory;
import algorithm.practise.TreeNode;

import java.util.Stack;

/**
 * @Description algorithm.practise.y2021.m04.P20210429
 * @Created by zhouxiaoyuan on 2021/4/29 8:23
 */
public class P20210429 {

    public static void main(String[] args) {
        /*T[] ts = new T[10];
        for (int i = 0; i < 10; i++) {
            ts[i] = new T(i);
        }
        Union union = new Union(ts);
        for(int i = 0 ; i < ts.length - 1; i++){
            union.union(ts[i],ts[i+1]);
        }
        System.out.println();*/

        /*TreeNode node = TreeNode.getTree(3, 50);
        TreeNode root = node;
        StringBuilder s2 = new StringBuilder();
        String s1 = TreeNode.dg(node ,2 );
        back(root , s2);
        System.out.println("");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.equals(s2.toString()));*/

        int t = 2;
        Stack s = new Stack();
        int[] arrs = ArrayFactory.getArray(10, 50);
        String s1 = pushs(arrs,s);
        int i = 0;
        while( i < t ){
            i++;
            s = stackOp(s);
        }
        String s2 = pops(s);
        System.out.println(s1);
        System.out.println(s2);
    }

    public static  String pushs(int[] arrs,Stack s){
//        Stack s = new Stack();
        StringBuilder sb = new StringBuilder();
        for(int i : arrs){
            s.push(i);
            sb.append(i +"-");
        }
        return sb.toString();
    }

    public static String getStackOp(Stack s1){
        return pops(stackOp(s1));
    }

    public static String pops(Stack s){
        StringBuilder sb = new StringBuilder();
        while (!s.empty()){
            sb.append(s.pop() +"-");
        }
        return sb.toString();
    }

    public static Stack stackOp(Stack s1){
        Stack s2 = new Stack();
        while(!s1.empty()){
            s2.push(s1.pop());
        }
        return s2;
    }



    /**
    * 栈有反序作用，并且具有传递性，如果 栈 栈 右能顺序
     **/

    public static void back(TreeNode node,StringBuilder sb){
        if(node == null){
            return ;
        }
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();
        s1.push(node);

        while( !s1.empty()){
            node = s1.pop();
            s2.push(node);
            if( node.left != null){
                s1.push(node.left);
            }
            if( node.right != null ){
                s1.push(node.right);  //TODO 此处写成s2.push(node.right) 造成结果不对
            }
        }

        while(!s2.empty()){
            node = s2.pop();
            sb.append(node.val+"-");
        }
    }

    //
    public static class T{
        T parent;
        int o;
        public T(int i){
            parent = this;
            o = i;
        }
    }

    public static class Union{
        T[] sets;
        T[] parents;
        int size;


        public Union(T[] ts){
            sets = ts;
            parents = ts;
            size = ts.length;

        }

        public T findParent(T t){
            while (t.parent != t){
                t = t.parent;
            }
            return t;
        }

        public void union(T t1, T t2){
            int l1 = 1;
            int l2 = 1;
            T p1 = t1;
            T p2 = t2;
            if( findParent(t1) != findParent(t2)){
                while(p1.parent != p1){
                    l1++;
                    p1 = p1.parent;
                }
                while(p2.parent != p2){
                    l2++;
                    p2 = p2.parent;
                }

                T big = l1 >= l2 ? p1 : p2;
                T small = big == p1 ? p2 : p1;

                small.parent = big;
                size--;
            }

        }

    }


}
