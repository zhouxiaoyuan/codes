package algorithm.practise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 @Description P20210326
 @Created by Administrator on 2021/3/26 9:40
**/
public class P20210326 {

    static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode op = head;
        op.next = new ListNode(5);

        testPosition(head,1,2);

        ListNode printNode = head;
        while( printNode != null){
            System.out.print(printNode.val);
            System.out.print("-");
            printNode = printNode.next;
        }

    }


    public static ListNode testPosition(ListNode head,int left ,int right){

        List<ListNode> list = new ArrayList<>();

        ListNode findNode = head;
        int count = 1;
        //1.find
        while( count <= right ){

            if( count++ < left ){
                findNode = findNode.next;
                continue;
            }

            list.add(findNode);
            findNode = findNode.next;

        }

        int l = list.size();
        //2
        for(int start = 0 ; start < l - start ; start++ ){
            int temp = list.get(l-1-start).val;
            list.get(l-1-start).val = list.get(start).val;
            list.get(start).val = temp;
        }

        return head;

       /*ListNode printNode = head;
       while( printNode != null){
           System.out.print(printNode.val);
           System.out.print("-");
           printNode = printNode.next;
       }*/

    }

   @Test
   public static ListNode testValue(ListNode head,int left ,int right){
//       ListNode head = new ListNode(3);
//       ListNode op = head;
       /*for(int i = 1 ; i < 10 ; i++){
           op.next = new ListNode(i);
           op = op.next;
       }*/

//       op.next = new ListNode(5);


//       int left = 3;
//       int right = 5;

       ListNode startNode = head;
       ListNode endNode = head;

       List<ListNode> list = new ArrayList<>();

       ListNode findNode = head;
       //1.find
       while(findNode != null ){

           if( findNode.val <left ){
               findNode = findNode.next;
               continue;
           }

           if( findNode.val > right ){
               break;
           }

           list.add(findNode);
           findNode = findNode.next;

       }

       int l = list.size();
       //2
       for(int start = 0 ; start < l - start ; start++ ){
           int temp = list.get(l-1-start).val;
           list.get(l-1-start).val = list.get(start).val;
           list.get(start).val = temp;
       }

       return head;

       /*ListNode printNode = head;
       while( printNode != null){
           System.out.print(printNode.val);
           System.out.print("-");
           printNode = printNode.next;
       }*/

   }




    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode startNode = head;
        ListNode endNode = head;

        List<ListNode> list = new ArrayList<>();

        //1.find
        while(head.next != null ){

            if( head.val <left || head.val > right ){
                break;
            }

            list.add(head);
        }

        int l = list.size();
        //2
        for(int start = 0 ; start < l - start ; start++ ){
            int temp = list.get(l-1-start).val;
            list.get(l-1-start).val = list.get(start).val;
            list.get(start).val = temp;
        }

        return head;

    }
}
