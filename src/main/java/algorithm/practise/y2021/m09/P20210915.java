package algorithm.practise.y2021.m09;

import algorithm.practise.ArrayFactory;
import algorithm.practise.ListNode;
import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class P20210915 {

    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {

        /*Unsafe unsafe = reflectGetUnsafe();

        System.out.println( unsafe.addressSize() );
        System.out.println( unsafe.pageSize() );*/

        /*int[] arr = ArrayFactory.getArray(20000,50000);

        int[] arr1 = arr.clone();
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();

        selectSort(arr1);
        bubbleSort(arr2);
        insertSort(arr3);

        System.out.println(ArrayFactory.check(arr1));;
        System.out.println(ArrayFactory.check(arr2));;
        System.out.println(ArrayFactory.check(arr3));*/

        ListNode node = ListNode.getListNode();
        ListNode.print(node);
        ListNode.print(reverseList(node));

    }

    public static ListNode reverseList(ListNode head){

        ListNode node = head;
        if(node== null ){
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while(node!=null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public static void selectSort(int[] arr){   //选择排序
        if(arr==null || arr.length <= 1){
            return ;
        }
        int min = 0;
        for(int i = 0 ; i < arr.length -1 ; i++ ){
            min = i;
            for(int j = i + 1 ; j < arr.length ; j++ ){
                min = arr[j] < arr[min] ? j : min;
            }
            ArrayFactory.swap(arr,i , min);
        }
    }

    public  static void bubbleSort(int[] arr){
        if(arr==null||arr.length<=1){
            return ;
        }
        for(int l = arr.length - 1  ; l > 0 ; l-- ){
            for(int i = 0 ; i < l ; i++){
                if(arr[i] > arr[i+1]){
                    ArrayFactory.swap(arr,i,i+1);
                }
            }
        }
    }

    public static void insertSort(int[] arr){
        if(arr==null||arr.length<=1){
            return ;
        }
        for(int i = 0 ; i < arr.length - 1 ; i++){
            for(int j = i + 1 ; j > 0 && arr[j-1] > arr[j] ; j-- ){
                ArrayFactory.swap(arr,j-1,j);
            }
        }
    }


}
