package algorithm.practise.y2021.m04;

import algorithm.practise.ArrayFactory;

/**
 * @Description P20210406
 * @Created by Administrator on 2021/4/6 9:06
 */
public class P20210406 {

    public static void main(String[] args) {
        int arrs[] = ArrayFactory.getArray();
        P20210406 sort = new P20210406();
        sort.gbSort(arrs, 0, arrs.length-1);
        ArrayFactory.check(arrs);
    }

    /***************************************************************************/
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




    /**************************************************************************/
    public void quickSort(int[] arrs, int start ,int end){
        if(start >= end){
            return ;
        }
        int location = partition(arrs,start, end);
        quickSort(arrs, start, location-1);
        quickSort(arrs, location+1,end );
    }

    public int partition(int[] arrs, int start ,int end){
        int mark = start;
        int pivot = arrs[mark];
        for( int p = start; p <= end ; p++ ){
            if( arrs[p] < pivot ){
                mark++;
                swap(arrs, mark ,p);
            }
        }
        arrs[start] = arrs[mark];
        arrs[mark] = pivot;
        return mark;
    }

    public void swap(int[] arrs, int start , int end){
        if( arrs == null || start == end || start >= arrs.length || end >= arrs.length ){
            return ;
        }

        int temp = arrs[start];
        arrs[start] = arrs[end];
        arrs[end] = temp;
    }


}
