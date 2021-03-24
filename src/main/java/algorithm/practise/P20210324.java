package algorithm.practise;

import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Description Sort20210324
 * @Created by Administrator on 2021/3/24 14:43
 */
public class P20210324 {
    static int length = 100;
    static int[] arrs;
    private static int MAX_VALUE = 10000;

    @Test
    public void binarySearchTest(){
        insertSort();
        for(int i = 0 ; i < arrs.length ;i++ ){
            System.out.println( i + "------>" + binarySearch(arrs[i]) + ">>>>>>>>>>>>" + (binarySearch(arrs[i])==i)  );
        }
    }

    /**
     * 二分查找
     * @param target
     * @return 返回查找到的数组位置
     */
    public int binarySearch(int target){
        int left = 0;
        int right = arrs.length-1;
        int mid = 0;
        while(left <= right ){  //计算到重叠
            mid = left + (right - left)/2;
            if(target == arrs[mid]){
                return mid;
            }else if(target < arrs[mid]){
                right = mid - 1 ;       //移动位置，防止位置卡死
            }else if(target > arrs[mid]){
                left = mid + 1;         //移动位置，防止位置卡死
            }
        }
        return -1;
    }

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
        System.out.println("Test array length：" + length );
        arrs = new int[length];
        Set set = new HashSet<Integer>();
        int num = 0 ;
        Random random = new Random();
        for(int i  = 0; i < length;i++){
            while (set.contains(num = random.nextInt(MAX_VALUE))){
            }
            set.add(num);
            arrs[i] = num;
            System.out.print(arrs[i]);
            System.out.print("-");
        }
        System.out.println("--------------");
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
