package algorithm.practise;

import org.junit.Test;

/**
 * @Description P20210329
 * @Created by Administrator on 2021/3/29 16:58
 */
public class P20210329 extends P20210325{

    @Test
    public void testGB(){
        getArray();
        int L = 0 ;
    }

    public void merge(int[] arrs, int l , int m , int r){

        int[] help = new int[r-l+1];
        int i = 0 ;
        int p1 = l;
        int p2 = m + 1;
        while( p1 <= m && p2 <= r){
            help[i++] = arrs[p1] <= arrs[p2] ? arrs[p1++] : arrs[p2++];
        }
        while( p1 <= m ){
            help[i++] = arrs[p1++];
        }
        while( p2 <= r ){
            help[i++] = arrs[p2++];
        }

        for(int s = 0 ; s < help.length ; s++){
            arrs[l+s] = help[s];
        }
    }

    public static void main(String[] args) {
        P20210329 day = new P20210329();
        day.getArray();
        day.mergeSort2(arrs);
        day.check(arrs);
    }

    public void mergeSort1(int[] arrs){
        if(arrs == null || arrs.length < 2){
            return;
        }
        process(arrs, 0,arrs.length-1 );

    }

    public void mergeSort2(int[] arrs){
        if( arrs == null || arrs.length <2){
            return ;
        }
        int mergeSize = 1;
        int L = 0 ;
        int N = arrs.length ;

        while( mergeSize < N ){
            L = 0 ;
            while(L < N){
                if( mergeSize >= N - L ){
                    break;
                }
                int M = L + mergeSize - 1 ;
                int R = M +  Math.min( mergeSize  , N - M -1 ) ;
                merge(arrs, L, M,R);
                L = R + 1;
            }

            if(mergeSize > (N/2)){
                break;
            }
            mergeSize <<= 1 ;
        }


    }

    public void process(int[] arrs, int l,int r){
        if(arrs == null || l == r){
            return;
        }
        int m = l + ((r-l)>>1);
        process(arrs, l, m);
        process(arrs, m+1, r);
        merge(arrs, l, m, r);
    }

}
