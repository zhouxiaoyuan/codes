package algorithm.practise.y2021.m03;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 @Description P20210326
 @Created by Administrator on 2021/3/26 9:40
**/
public class P20210326 extends  P20210325{

    /*static int length = 100;
    static int MAX_VALUE = 1000;
    static int[] arrs ;
    static String SPACE = "-";*/

    public static void main(String[] args) {

        Class c = HashMap.class;
        c.getFields();
        Method[] methods = c.getDeclaredMethods();

        try {

            HashMap hashMap = new HashMap();
            hashMap.put(1,1);
            hashMap.put(2,1);
            hashMap.put(3,1);
            hashMap.put(4,1);

            Field f = c.getDeclaredField("size");

            f.setAccessible(true);
            Object node = f.get(hashMap);
            System.out.println(node);

        } catch ( Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testTwoSum(){
        insertSort();
        HashMap<Integer,Integer> map = new HashMap();
        TreeMap<Integer,Integer> result = new TreeMap();

        Random random = new Random();
        int start = random.nextInt(P20210325.length);
        int end;
        while((end = random.nextInt(P20210325.length)) == start){
        }

        int sum = arrs[start] + arrs[end];
        System.out.println( sum + "=" + start + "+" + end );

        for(int i = 0 ; i < arrs.length ; i++ ){
            map.put(arrs[i],i);
        }

        for( int i = 0 ; i < arrs.length ; i++ ){
            int temp = sum - arrs[i];
            if(map.containsKey(temp)){
                result.put(i,map.get(temp));
            }
        }

        Set set = new HashSet();
        for(Map.Entry<Integer,Integer> entry : result.entrySet()){

            if(set.contains(entry.getKey() + "," + entry.getValue())){
                continue;
            }
            set.add(entry.getKey() + "," + entry.getValue());
            set.add(entry.getValue() + "," + entry.getKey());
            System.out.println( entry.getKey() + "(" + arrs[entry.getKey()] + "),"  + entry.getValue() + "(" + arrs[entry.getValue()] + ")" );
        }


    }

    @Test
    public void binarySearch(){
        insertSort();
        int left = 0 ;
        int right = arrs.length - 1;
        int mid = 0 ;

        int index = new Random().nextInt(P20210325.length);
        int target = arrs[index];
        int findIndex = 0;

        while(left <= right){
            mid = left + (right-left)/2;
            if(target == arrs[mid]){
                findIndex = mid;
                break;
            }else if(target < arrs[mid]){
                right = mid - 1;
            }else if(target > arrs[mid]){
                left = mid + 1;
            }
        }

        System.out.println( "result:" + index + "-" + findIndex );

    }


    @Test
    @Override
    public void bubbleSort(){
        super.getArray();
        for( int i = 0 ; i < arrs.length - 1 ; i++ ){
            for( int j = 0 ; j < arrs.length - 1 - i ; j++ ){
                if( arrs[j] > arrs[j+1] ){
                    swap(arrs,j,j+1);
                }
            }
        }
        super.check(arrs);
    }

    @Test
    @Override
    public void insertSort(){
        super.getArray();
        for( int i = 1 ; i < arrs.length ; i++ ){
            for( int j = i ; j > 0 && arrs[j] < arrs[j-1] ; j--){
                swap(arrs,j-1,j);
            }
        }
        super.check(arrs);
    }


    @Test
    @Override
    public void selectSort(){
        super.getArray();
        boolean hasChanged = false;
        int curMin = 0;
        for(int i = 0 ; i < arrs.length - 1 ; i++ ){
            curMin = i ;hasChanged= false;
            for(int j = i ; j < arrs.length ; j++ ){
                if( arrs[j] < arrs[curMin] ){
                    curMin = j;
                    hasChanged = true;
                }
            }
            if(hasChanged){
                swap(arrs,i,curMin);
            }
        }
        super.check(arrs);
    }

   /* public void check(){
        for(int i = 1; i < arrs.length ; i++ ){
            if(arrs[i] < arrs[i-1]){
                System.out.println("fail");
                return ;
            }
        }
        return ;
    }

    public void getArrys(){
        arrs = new int[length];
        HashSet set = new HashSet();
        Random random = new Random();
        int temp ;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < length ; i++ ){
            while( set.contains(temp = random.nextInt(MAX_VALUE))  ){}
            arrs[i] = temp;
            sb.append(temp).append(SPACE);
        }

        System.out.println(sb.subSequence(0,sb.length()-1));

    }*/



    @Test
    public void testHashMap(){

        HashMap hashMap = new HashMap();
        hashMap.put(1,1);

    }


    static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public static void main1(String[] args) {
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
