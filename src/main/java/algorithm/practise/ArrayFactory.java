package algorithm.practise;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * @Description ArrayFactory
 * @Created by Administrator on 2021/3/31 16:50
 */
public class ArrayFactory {

    static public int length = 20;
    static public int MAX_VALUE = 100;
    static public int[] arrs ;


    public static void main(String[] args) {
        int[] arrs = getArray();
        gbSort(arrs, 0, arrs.length-1);
        check(arrs);
    }

    public static int[] getArray(){
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
        return arrs;
    }

    public static  void check(int[] arrs){
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

    public static void swap(int[] a , int start , int end ){
        int temp = a[end];
        a[end] = a[start];
        a[start] = temp;
    }

    public static void gbSort(int[] arrs , int start ,int end){

        if( end > start ){
            int mid = start + ( end - start ) >> 1;
            gbSort(arrs, start, mid);
            gbSort(arrs, mid+1, end);
            merge(arrs,start,mid,end);
        }

    }

    public static void merge(int[] arrs, int start , int mid ,int end){

        int[] helper = new int[end - start + 1];
        int p1 = start;
        int p2 = mid;
        int p = start;

        while( p1 <= mid && p2 <= end ){
            helper[p++] = arrs[p1] <= arrs[p2] ? arrs[p1++] : arrs[p2++];
        }

        while (p1<= mid){
            helper[p++] = arrs[p1++];
        }

        while(p2 <= end){
            helper[p++] = arrs[p2++];
        }

        System.arraycopy(helper, 0, arrs, start, end-start+1);

    }


    public static void quickSort(int[] arrs,int start, int end){
        if(arrs.length < 2 || end >= arrs.length || start >= end){
            return;
        }

        int pivot = arrs[start];
        int mark = start;
        int l = start;
        int r = end;
        int p = l + 1;


        for ( int i = 0 ; i <= end ; i++ ){

            if( arrs[mark] < arrs[mark] ){
                mark++;
            }

        }


    }




    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length == 1){
            return intervals;
        }

        int m = intervals.length - 1;

        for(int i = 0 ; i < m ; i++ ){
            for( int j =  i+1; j <= m ; j++ ){
                mergeSub(intervals,i,j);
            }
        }

        List<int[]> list = new ArrayList();
        for(int i = 0 ; i <= m ; i++){
            if(intervals[i] != null){
                list.add(intervals[i]);
            }
        }

        int[][] result = new int[list.size()][2];
        for(int i = 0 ; i < list.size() ; i++ ){
            result[i] = list.get(i);
        }

        return result;

    }

    @Test
    public void test1(){
        int[][] arrs = {{0,0},{1,2},{5,5},{2,4},{3,3},{5,6},{5,6},{4,6},{0,0},{1,2},{0,2},{4,5}};
        merge(arrs);
        merge(arrs);
        System.out.println(arrs);
    }

    public void mergeSub( int[][] intervals ,int pre, int next){
        if( intervals[pre] == null ||  intervals[next] == null ){
            return ;
        }
        boolean b1 = intervals[pre][1] >= intervals[next][0] && intervals[pre][1] <= intervals[next][1];
        boolean b2 = intervals[next][1] >= intervals[pre][0] && intervals[next][1] <= intervals[pre][1];
        if(b1 || b2 ){
            int[] temp = new int[2];
            temp[0] = intervals[pre][0] <= intervals[next][0] ? intervals[pre][0] : intervals[next][0];
            temp[1] = intervals[pre][1] >= intervals[next][1] ? intervals[pre][1] : intervals[next][1];
            if( intervals[pre][1] > intervals[next][1] ){
                intervals[pre] = temp;
                intervals[next] = null;
            }else{
                intervals[pre] = null;
                intervals[next] = temp;
            }

        }


    }


}
