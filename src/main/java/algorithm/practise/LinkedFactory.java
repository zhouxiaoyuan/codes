package algorithm.practise;

/**
 * @Description algorithm.practise.LinkedFactory
 * @Created by zhouxiaoyuan on 2021/4/20 17:56
 */

import java.util.Random;

/**
 * @Author zhouxiaoyuan
 * @Description 连表操作
 * @Date 17:56 2021/4/20
 * @Param
 * @return
 **/
public class LinkedFactory {

    /**
     * 判断有环: 1.快慢指针
     * 找到环的开始位置: 1.快慢指针相遇时，让快指针指向头节点 2.再次相遇即是开始位置
     * 判断2个链表相交: 1. 结尾位置必然相等
     *
     **/

    public static void main(String[] args) {
        ListNode node = getCicNodes(5 , false);
        System.out.println(node);

        System.out.println(checkCic(node));

    }


    public static boolean checkCic(ListNode node){
        ListNode f = node;
        ListNode s = node;
        while( f != s){
            s = s.next;
            f = f.next ;
            if( s == null || f == null ){
                return false;
            }
            s = s.next;
            if( s == null ){
                return false;
            }
        }
        return true;
    }

    public static ListNode getCicNodes(int size,boolean flag){
        ListNode root = new ListNode(0);
        ListNode point = root;
        Random random = new Random();
        int index = random.nextInt(size);
        ListNode temp = null ;
        for (int i = 0; i < size ; i++) {

            ListNode ln =  new ListNode(i);
            if( index == i  ){
                temp  = ln;
            }

            point.next = ln;
            point = point.next;
        }
        if(flag){
            point.next = temp;
        }
        return root;

    }

    public void linkCheck(){

    }

}
