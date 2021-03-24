package algorithm;

import org.junit.Test;

/**
 * @Description Sorts
 * @Created by Administrator on 2021/3/22 11:36
 */
public class Sorts {

    @Test
    public void testSelectSort(){
        int[] arrs = {4,7,5,6,6,77,88,88};
        selectSort(arrs);
        for( int i  = 0 ; i < arrs.length; i++){
            System.out.print( arrs[i] );
            System.out.print( "-");
        }
    }

    @Test
    public void testInsertSort(){
        int[] arrs = {9,4,100 ,5,6,6,77,88,88};
        insertSort(arrs);
        for( int i  = 0 ; i < arrs.length; i++){
            System.out.print( arrs[i] );
            System.out.print( "-");
        }
    }

    @Test
    public void testBubbleSort(){
        int[] arrs = {9,4,100 ,5,6,6,77,88,88};
        bubbleSort(arrs);
        for( int i  = 0 ; i < arrs.length; i++){
            System.out.print( arrs[i] );
            System.out.print( "-");
        }
    }

    public  void selectSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int curMin = 0 ;
        boolean hasChange = false;
        for( int start = 0 ; start < arr.length - 1 ; start ++ ){
            curMin = start;
            hasChange = false;
            for( int cal = start ; cal < arr.length ; cal++){
                if( arr[cal] < arr[curMin] ){
                    curMin = cal;
                    hasChange = true;
                }
            }
            if(hasChange){
                swap(arr,start,curMin);
            }
        }
    }

    //插入
    public  void insertSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int start =  1 ; start < arr.length ; start++ ){
            for(int cal = start ; cal > 0 ; cal--){
                if( arr[cal] < arr[cal-1] ){
                    swap(arr,cal,cal-1);
                }
            }
        }
    }

    //冒泡
    public void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int start = 0 ; start < arr.length - 1 ; start++ ){
            for(int cal = 0 ; cal < arr.length - 1 - start ; cal++){
                if( arr[cal] > arr[cal+1] ){
                    swap(arr,cal,cal+1);
                }
            }
        }
    }

    @Test
    public void testBinaryFind(){
        int[] arrs = {2,3,4,5,6,7,8,9,10,11,12,13};
        System.out.println(binaryFind(arrs,2));
    }

    public int binaryFind( int[] arr ,int target){
        int left = 0;
        int right = arr.length -1 ;
        int mid = 0;
        while( left <= right ){
            mid = left + (right-left)/2;
            if( arr[mid] == target ){
                return mid;
            }else if( target < arr[mid] ){
                right = mid;
            }else{
                left = mid ;
            }
        }
        return -1;
    }


    public void swap(int[] arr,int start , int end){
        if(start == end){
            return;
        }
        int swap = arr[end];
        arr[end] = arr[start];
        arr[start] = swap;
    }


}
