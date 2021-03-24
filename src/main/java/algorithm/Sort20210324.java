package algorithm;

import org.junit.Test;

import java.util.Random;

/**
 * @Description Sort20210324
 * @Created by Administrator on 2021/3/24 14:43
 */
public class Sort20210324 {
    static int[] arrs;

    @Test
    public void selectSort(){
       getArrs();
       boolean hasChange = false;
       int curMin = 0;
       for(int i = 0 ; i < arrs.length - 1; i++){
           hasChange = false;
           curMin = i;
           for(int j = i + 1  ; j < arrs.length  ; j++ ){
               if(arrs[j] < arrs[curMin]){
                   curMin = j;
                   hasChange = true;
               }
           }
           if(hasChange){
                swap(arrs,i,curMin);
           }
       }
       checkResult();
    }


    @Test
    public void insertSort(){
        getArrs();
        for(int i = 1; i < arrs.length ; i++){
            for(int j = i  ; j > 0 && arrs[j] < arrs[j-1] ; j-- ){
                swap(arrs,j,j-1);
            }
        }
        checkResult();
    }

    @Test
    public void bubbleSort(){
        getArrs();
        for(int i = 0 ; i < arrs.length - 1 ; i++){
            for(int j = 0 ; j < arrs.length - 1 - i ; j++ ){
                if( arrs[j] > arrs[j + 1] ){
                    swap(arrs,j,j+1);
                }
            }
        }
        checkResult();
    }

    public static void swap(int[] arr , int start , int end ){
        int temp = arr[end];
        arr[end] = arr[start];
        arr[start] = temp;
    }

    public static  void getArrs(){
        int length = 10000;
        System.out.println("Test array length：" + length );
        arrs = new int[length];
        Random random = new Random();
        for(int i  = 0; i < length;i++){
            arrs[i] = random.nextInt(length);
        }
    }

    public void checkResult(){
        for(int i = 0 ; i < arrs.length ; i++){
            System.out.print(arrs[i]);
            System.out.print("-");
            if( i > 1 && arrs[i] < arrs[i-1]){
                System.out.println("");
                System.out.println("fail");
                return ;
            }
        }
        System.out.println("");
        System.out.println("success");
    }

}
