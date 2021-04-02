package algorithm.practise.y2021.m04;

import algorithm.practise.ArrayFactory;

public class P20210402 {

    public static void main(String[] args) {
        int[] arrs = ArrayFactory.getArray(10,100);
        P20210402 sort = new P20210402();
//        ArrayFactory.quickSort(arrs,0,arrs.length-1);
        sort.gbSort(arrs,0,arrs.length-1);
        ArrayFactory.check(arrs);

    }

    public void gbSort( int[] arrs,int start ,int end ){
        if( end == start  ){
            return ;
        }
        int mid = start + ((end-start) >> 1);
        gbSort( arrs, start , mid );
        gbSort( arrs, mid +1 , end );
        merge( arrs, start , mid ,end );
    }

    public void merge(int[] arrs, int start ,int mid ,int end){

        int p1 = start;
        int p2 = mid + 1;
        int p = 0;
        int[] helper = new int[end-start+1];
        while( p1 <= mid && p2 <= end ){
            helper[p++] = arrs[p1] < arrs[p2] ? arrs[p1++] : arrs[p2++];
        }

        while( p1 <= mid ){
            helper[p++] = arrs[p1++];
        }

        while( p2 <= end ){
            helper[p++] = arrs[p2++];
        }

        for( int i = 0 ; i < helper.length ; i++ ){
            arrs[start+i] = helper[i];
        }

    }



}
