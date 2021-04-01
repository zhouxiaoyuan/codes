package algorithm.practise.y2021.m03;

import algorithm.practise.ArrayFactory;
import algorithm.practise.TreeNode;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.awt.image.ImageProducer;
import java.util.*;

/**
 * @Description P20210331
 * @Created by Administrator on 2021/3/31 10:21
 */
public class P20210331  {


    public static void addNode(Map<Integer,List<TreeNode> > map, int height ,TreeNode node){
        if(node == null){
            return ;
        }
        addNodeToMap(map,height,node);
        addNode(map, height+1, node.left);
        addNode(map, height+1, node.right);
    }

    public static void addNodeToMap(Map<Integer,List<TreeNode> > map, int height ,TreeNode node){
        List<TreeNode> list;
        if(map.get(height)==null){
            list = new ArrayList();
            map.put(height,list);
        }
        list = map.get(height);
        list.add(node);

    }

    public static int[] quickSort(int[] arrs,int l ,int r ){
        if(arrs == null || arrs.length == 1){
            return arrs;
        }
        int L = l;
        int R = r;

        int start = arrs[L];

        while( L < R ){
            if( arrs[R] < start ){
                arrs[L] = arrs[R];
                L++;
            }else{
                R--;
                continue;
            }

            if( arrs[L] > start){
                arrs[R] = arrs[L];
                R--;
            }
        }

        arrs[L] = start;
        quickSort(arrs,l,L-1);
        quickSort(arrs,l+1,R);

        return arrs;

    }

    
    public static void main(String[] args) {

        /*int[] arrs = ArrayFactory.getArray();
        quickSort(arrs, 0, arrs.length-1);
        ArrayFactory.check(arrs);*/


        //树
        TreeNode node = TreeNode.getTree(20,1000);
        Stack<TreeNode> stack = new Stack();
        TreeNode p = node;


        //平层访问
        /*stack.push(p);
        List list = new ArrayList() ;
        list.add(node);

        Map<Integer,List<TreeNode> > map = new HashMap<Integer,List<TreeNode> >() ;
        addNode(map,1,node);
        int i = 1;
        List<TreeNode> hlist;
        List<Integer>  allList = new ArrayList<>();
        while( (hlist = map.get(i)) != null ){
            i++;
            for(TreeNode node1 : hlist){
                allList.add(node1.val);
            }
        }

        System.out.println(allList);*/


      //qx(node); //qx
        //zx(node);//zx
        //hx(node); //hx
        //System.out.println("");


        //hx
       /* while(!stack.empty()){
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
        }*/

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

        long t11 = System.currentTimeMillis();
        zx(node);
        long t12 = System.currentTimeMillis();
        System.out.println();
        System.out.println(t12-t11);

        long t21 = System.currentTimeMillis();
        //zx
        while (!stack.empty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                //System.out.print(p.val + "-");
                p = p.right;
            }
        }
        long t22 = System.currentTimeMillis();
        System.out.println();
        System.out.println(t22-t21);


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
        //System.out.print(node.val+"-");
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
