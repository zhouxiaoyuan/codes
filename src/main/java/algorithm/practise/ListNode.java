package algorithm.practise;

import java.util.HashSet;
import java.util.Random;

/**
 * @Description ListNode
 * @Created by Administrator on 2021/3/30 9:14
 */
public class ListNode {

    static public int length = 5;
    static public int MAX_VALUE = 100;
    public static ListNode node;

    public int val;
    public ListNode next;
//    public ListNode() {}
    public ListNode(int val) { this.val = val; }
//    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void main(String[] args) {

        getListNode();

        ListNode tempNode = node.next;
        while(tempNode != null){
            System.out.print(tempNode.val);
            System.out.print("-");
            tempNode = tempNode.next;
        }
    }

    public static ListNode getListNode(){
        node = new ListNode(0);
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        HashSet set = new HashSet();
        int val;
        ListNode pointNode = node;
        for(int i = 0 ; i < length ; i++ ){
            while(set.contains(( val = random.nextInt(MAX_VALUE)))){}
            ListNode tempNode = new ListNode(val);
            pointNode.next = tempNode;
            pointNode = tempNode;
            sb.append(tempNode.val).append("-");
        }
        System.out.println( sb.toString().substring(0,sb.length()-1));
        return node;
    }

}
