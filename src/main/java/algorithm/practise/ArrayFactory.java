package algorithm.practise;

import java.util.HashSet;
import java.util.Random;

/**
 * @Description ArrayFactory
 * @Created by Administrator on 2021/3/31 16:50
 */
public class ArrayFactory {

    static public int length = 20;
    static public int MAX_VALUE = 100;
    static public int[] arrs ;

    public static int[] getArray(){
        return getArray(length,MAX_VALUE);
    }

    public static int[] getArray(int length, int max){
        arrs = new int[length];
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        HashSet set = new HashSet();
        for(int i = 0 ; i < length ; i++ ){
            while(set.contains(( arrs[i] = random.nextInt(max)))){}
            set.add(arrs[i]);
            sb.append(arrs[i]).append("-");
        }
        System.out.println( sb.toString().substring(0,sb.length()-1));
        return arrs;
    }

    public static void check(int[] arrs){
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

    /***************快速排序**************/
    public static void quickSort(int[] arrs ,int start ,int end){
        if( start >= end ){
            return;
        }
        int pivotIndex = partition(arrs,start,end);
        quickSort(arrs,start , pivotIndex - 1);
        quickSort(arrs,pivotIndex+1,end);
    }

    public static int partition(int[] arrs,int start ,int end){

        int mark = start;
        int pivot = arrs[start];

        for(int i = start + 1 ; i <= end ; i++ ){
            if( arrs[i] < pivot ){
                mark++;
                int temp = arrs[mark];
                arrs[mark] = arrs[i];
                arrs[i] = temp;
            }
        }

        arrs[start] = arrs[mark];
        arrs[mark] = pivot;
        return mark;

    }
}
