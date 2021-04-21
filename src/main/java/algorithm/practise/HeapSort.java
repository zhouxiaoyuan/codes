package algorithm.practise;

/**
 * @Description algorithm.practise.HeapSort
 * @Created by zhouxiaoyuan on 2021/4/19 10:21
 */
public class HeapSort {
    int initSize = 100;
    int[] arrs = new int[initSize];
    int heapSize = 0;

    HeapSort(int[] arrsTemp) {
        if (arrsTemp == null || arrsTemp.length == 0) {
            return;
        }
        for (int i = 0; i < arrs.length; i++) {
            heapInsert(arrsTemp[i]);
        }

    }

    //上浮
    public void heapInsert(int i) {
        arrs[heapSize] = i;
        int t = heapSize;
        while (arrs[t] < arrs[(t - 1) / 2]) {
            int temp = arrs[t];
            arrs[t] = arrs[(t - 1) / 2];
            arrs[(t - 1) / 2] = temp;
            t = (t - 1) / 2;
        }
    }

    public int pop(){
        int result = arrs[0];
        arrs[heapSize] = arrs[0];
        arrs[0] = arrs[--heapSize];
        heapify();
        return result;
    }

    //heapify
    public void heapify(){
        int temp = 0;

        int sonMax = (2*temp+1) <= heapSize && arrs[2*temp+1] > arrs[temp] ? (2*temp+1) :temp;
        sonMax = (2*temp+2) <= heapSize && arrs[2*temp+2] > arrs[sonMax] ? (2*temp+2) :temp;

        while( sonMax > temp ){
            //swap
            int t = arrs[temp];
            arrs[temp] = arrs[sonMax];
            arrs[sonMax] = t;
            temp = sonMax;
        }
    }




}