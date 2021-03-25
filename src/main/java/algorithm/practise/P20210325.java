package algorithm.practise;

import org.junit.Test;

import java.util.HashSet;
import java.util.Random;

/**
 * @Description P20210325
 * @Created by Administrator on 2021/3/25 15:02
 */
public class P20210325 {
    static int length = 20;
    static int MAX_VALUE = 100;
    static int[] arrs ;


    @Test
    public void chechBinarySearch(){
        insertSort();
        boolean result = true;
        for( int i = 0 ; i < arrs.length;i++ ){
            int index = binarySearch(arrs[i]);
            System.out.println( i + "-(" + index  + ")" + (i==index));
            if(i!=index){
                result = false;
            }
        }
        System.out.println(result);
    }


    public int binarySearch( int target ){
        int left = 0 ;
        int right = arrs.length - 1;
        int mid = 0 ;
        while( left <= right ){
            mid = left + (right-left)/2;
            if( target == arrs[mid] ){
                return mid;
            }else if( target > arrs[mid] ){
                left = mid + 1;
            }else if( target < arrs[mid] ){
                right = mid - 1;
            }
        }
        return -1;
    }


    @Test
    public void bubbleSort(){
        getArray();
        for(int i = 0 ; i < arrs.length - 1 ; i++){
            for(int j = 0 ; j < arrs.length - 1 - i ; j++ ){
                if( arrs[j] > arrs[j+1] ){
                    swap(arrs,j,j+1);
                }
            }
        }
        check(arrs);
    }

    @Test
    public void insertSort(){
        getArray();
        for(int i = 1 ; i < arrs.length ; i++){
            for(int j = i ; j > 0 && arrs[j] < arrs[j-1] ; j--){
                swap(arrs,j-1 , j);  //交换位置要注意
            }
        }
        check(arrs);
    }


    @Test
    public void selectSort(){
        getArray();
        boolean hasChange = false;
        int curMin = 0 ;
        for(int i = 0 ; i < arrs.length - 1 ; i++ ){
            hasChange = false;
            curMin = i;
            for( int j = i + 1 ; j < arrs.length ; j++ ){
                if(arrs[j] < arrs[curMin]){
                    curMin = j;
                    hasChange = true;
                }
            }
            if(hasChange){
                swap(arrs,i,curMin);
            }
        }
        check(arrs);
    }



    @Test
    public void test(){
        getArray();
    }

    public void check(int[] arrs){
        System.out.println();

        System.out.print( arrs[0] );
        for(int i  = 1; i < arrs.length  ; i++ ){
            System.out.print( "-" );
            System.out.print( arrs[i] );

            if(arrs[i] < arrs[i-1]){

                System.out.println("fail");
                return ;
            }
        }
        System.out.println();
        System.out.println("success");
    }

    public void swap(int[] a , int start , int end ){
        int temp = a[end];
        a[end] = a[start];
        a[start] = temp;
    }

    public void getArray(){
        arrs = new int[length];
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        HashSet set = new HashSet();
        for(int i = 0 ; i < length ; i++ ){
            while(set.contains(( arrs[i] = random.nextInt(MAX_VALUE)))){}
            set.add(arrs[i]);
            sb.append(arrs[i]).append("-");
        }
        System.out.println( sb.toString().substring(0,sb.length()-1));
    }



    public void test(long i){

    }

}
