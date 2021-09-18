package algorithm.practise.y2021;

import algorithm.practise.ArrayFactory;
import org.junit.Test;

import java.util.HashMap;


public class Practise {


    HashMap map;

    public static void main(String[] args) {

        int[] arr = ArrayFactory.getArray(1000,1000);
        int[] arr1 = arr.clone();
        int[] arr2 = arr.clone();
        int[] arr3 = arr.clone();

        /*selectSort(arr1);
        System.out.println(ArrayFactory.check(arr1));*/

        bubbleSort(arr2);
        System.out.println(ArrayFactory.check(arr2));

        insertSort(arr3);
        System.out.println(ArrayFactory.check(arr3));

    }

    public static void selectSort(int[] arr){
        if(arr==null||arr.length<=1){
            return;
        }

        //TODO


    }

    public static void bubbleSort(int[] arr){
        if(arr==null || arr.length<=1){
            return ;
        }
        //TODO

    }

    public static void insertSort(int[] arr){
        if(arr==null||arr.length<=1){
            return;
        }
        //TODO

    }

    @Test
    public void testBSExit(){
        int[] arrs = {1,2,4,5,6,7,7,88};
        System.out.println(BSExit(arrs,2));
        System.out.println(BSExit(arrs,88));
        System.out.println(BSExit(arrs,20));
    }

    public static boolean BSExit(int[]  arr, int des){
        if(arr==null){
            return false;
        }
        int l = 0, mid = 0;
        int r = arr.length - 1;

        //TODO

        return false;

    }


}
