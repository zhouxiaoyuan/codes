package algorithm.practise.y2021.m03;

import algorithm.practise.ListNode;

/**
 * @Description p20210330
 * @Created by Administrator on 2021/3/30 9:08
 */
public class p20210330 {


    public static void main(String[] args) {
        /*ListNode node = ListNode.getListNode();
        ListNode result = reverseList(node.next);
        System.out.println("");
        System.out.println("");
        while(result!=null){
            System.out.print(result.val);
            System.out.print("-");
            result = result.next;
        }*/

        int[][] matrix = {{1,2,3},{4,5,6}};
        transpose(matrix);

        Thread thread;

    }


    public static  int[][] transpose(int[][] matrix) {
        if( matrix == null){
            return matrix;
        }
        int x = matrix.length;
        int y = matrix[0].length;
        if( x == 1 || y== 1){
            return matrix;
        }
        int[][] newMetrix = new int[y][x];
        for( int i = 0 ; i < x ; i++ ){
            for( int j = 0 ; j < y ; j++ ){
                newMetrix[j][i] = matrix[i][j];
            }
        }
        return newMetrix;

    }


    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }//75-82-80-56-53
        ListNode pre = head.next;
        ListNode next = pre.next;
        head.next = null;
        ListNode temp ;
        while ( true  ){

            pre.next = head;
            head = pre;
            pre = next;
            if(pre == null){
                break;
            }

            if(next != null){
                next = next.next;
            }

            System.out.println(pre == next);

            ListNode t = head;
            System.out.println();
            while(t != null){
                System.out.print(t.val);
                System.out.print("-");
                t = t.next;
            }
        }
//        next.next = pre;

        return head;

    }
}

