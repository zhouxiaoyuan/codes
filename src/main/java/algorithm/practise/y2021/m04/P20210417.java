package algorithm.practise.y2021.m04;

import algorithm.practise.ArrayFactory;

import java.util.Arrays;

/**
 * @Description algorithm.practise.y2021.m04.P20210417
 * @Created by zhouxiaoyuan on 2021/4/16 11:20
 */
public class P20210417 {


    public static void main(String[] args) {

        int[] arrs = ArrayFactory.getArray(10, 100);
        bucketSort(arrs);
        ArrayFactory.check(arrs);

    }

    /**
     * @Author zhouxiaoyuan
     * @Description 准备一个桶，按照个位放，然后按照
     * @Date 11:31 2021/4/16
     * @Param [arrs]
     * @return void
     **/
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

