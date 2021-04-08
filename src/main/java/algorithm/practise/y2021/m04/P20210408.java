package algorithm.practise.y2021.m04;

import algorithm.practise.ArrayFactory;

/**
 * @Description P20210408
 * @Created by Administrator on 2021/4/8 9:18
 */
public class P20210408 {


    public static void main(String[] args) {
        int[] arrs = ArrayFactory.getArray();
        P20210408 sort = new P20210408();
//        sort.quickSort(arrs, 0, arrs.length-1);
        sort.gbSort(arrs, 0, arrs.length-1);
        ArrayFactory.check(arrs);
    }

    /************************************************************************************************/
    public void gbSort(int[] arrs , int start ,int end){

        if(arrs == null || start >= end){
            return ;
        }
        int mid = start + ((end-start)>>1);
        gbSort(arrs,start, mid);
        gbSort(arrs,mid+1,end);
        merge(arrs,start,mid,end);

    }

    private void merge(int[] arrs, int start, int mid, int end) {

        int p1 = start;   //赋值位置注意
        int p2 = mid+1;
        int p = 0 ;
        int[] helper = new int[end-start+1];

        while (p1 <= mid && p2 <= end ){
            helper[p++] = arrs[p1] < arrs[p2] ? arrs[p1++] : arrs[p2++];
        }

        while(p1<=mid){
            helper[p++] = arrs[p1++];
        }

        while(p2<=end){
            helper[p++] = arrs[p2++];
        }

        for(int i = 0 ; i < helper.length ; i++){
            arrs[start+i] = helper[i];
        }

    }


    /****************************************************************************************************************************/

    public  void quickSort(int[] arrs,int start,int end) {
        if( arrs == null || start >= end ){
            return ;
        }
        int pivotIndex = findPivot(arrs,start,end);
        quickSort(arrs,start, pivotIndex-1);
        quickSort(arrs, pivotIndex+1, end);
    }

    public int findPivot(int[] arrs,int start ,int end){

        int mark = start;
        int pivot = arrs[mark];

        for(int i = start + 1 ; i <= end ; i++){
            if(arrs[i] < pivot){
                mark++;             //只是为了增加
                swap(arrs,mark,i);
            }
        }

        arrs[start] = arrs[mark];
        arrs[mark] = pivot;
        return mark;
    }

    private void swap(int[] arrs, int s, int e) {
        if( s == e ){
            return ;
        }
        int temp = arrs[s];
        arrs[s] = arrs[e];
        arrs[e] = temp;
    }

}
