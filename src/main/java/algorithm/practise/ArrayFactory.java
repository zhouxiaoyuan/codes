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
        //System.out.println( sb.toString().substring(0,sb.length()-1));
        return arrs;
    }

    public static Boolean check(int[] arrs){
        System.out.println();

        System.out.print( arrs[0] );
        for(int i  = 1; i < arrs.length  ; i++ ){
//            System.out.print( "-" );
//            System.out.print( arrs[i] );
            if(arrs[i] < arrs[i-1]){
//                System.out.println("fail");
                return false;
            }
        }
//        System.out.println();
//        System.out.println("success");
        return true;
    }

    /***********归并排序*************************************************/
    public void gbSort(int[] arrs,int start ,int end){
        if(arrs==null ||  start >= end){
            return ;
        }
        int mid = start + ((end-start)>>1);
        gbSort(arrs,start, mid);
        gbSort(arrs,mid+1,end);
        merge(arrs,start , mid ,end);

    }

    public void merge(int[] arrs, int start , int mid, int end){
        int p1 = start;
        int p2 = mid+1;
        int p = 0;
        int[] helper = new int[end-start+1];
        while(p1 <= mid && p2 <= end){
            helper[p++] = arrs[p1] <= arrs[p2] ? arrs[p1++] : arrs[p2++];
        }
        while(p1 <= mid){
            helper[p++] = arrs[p1++];
        }
        while(p2 <= end){
            helper[p++] = arrs[p2++];
        }

        for(int i = 0 ; i < helper.length ; i++){
            arrs[start+i] = helper[i];
        }
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

    /*
    交换数组下标对应的值
     */
    public void swap(int[] arrs, int start , int end){
        if( arrs == null || start == end || start >= arrs.length || end >= arrs.length ){
            return ;
        }

        int temp = arrs[start];
        arrs[start] = arrs[end];
        arrs[end] = temp;
    }



    //桶排序
    public static void bucketSort(int[] arrs){
        //找到最大的数字
        int max = arrs[0];
        for(int i : arrs){
            if(max<i){
                max = i;
            }
        }
        //计算需要多少次倒腾
        int time = 1 ;
        while((max=max/10)>0){
            time++;
        }

        int[] bucketSrc = arrs;
        for( int i = 0 ; i < time ; i++){
            int[] count = new int[10];
            int[] bucketTo = new int[arrs.length];
            int compareBase = 1;
            int s = 0 ;

            while(s<i){
                compareBase *= 10;
                s++;
            }

            for( int j = 0 ; j < arrs.length ;j++ ){
                count[(arrs[j]/compareBase)%10]++;
            }
            for( int j = 1 ; j < count.length ; j++){
                count[j] += count[j-1];
            }

            int num = 0;
            int index = 0;
            //将bucketSrc数据填入bucketTo
            for(int j = bucketSrc.length-1 ; j >= 0 ; j-- ){
                num = (bucketSrc[j]/compareBase)%10;
                index = count[num];
                bucketTo[index-1] = bucketSrc[j];
                count[num]--;
            }
            bucketSrc = bucketTo;
        }
        System.arraycopy(bucketSrc, 0, arrs, 0, arrs.length);

    }


}
