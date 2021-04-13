package algorithm.practise.y2021.m04;

import java.util.ArrayList;

/**
 * @Description algorithm.practise.y2021.m04.P20210413
 * @Created by zhouxiaoyuan on 2021/4/13 9:30
 */
public class P20210413 {

    public static void main(String[] args) {
        int a = 7;
        int b = 13;
        System.out.println(a + "," +b);
        a = a^b;
        b = a^b;
        a = a^b;

        System.out.println(a + "," +b);

        int arrs[] = {3,3,4,4,4,5,5,6,6};
        int eor = 0 ;
        for(int i = 0 ; i < arrs.length;i++){
            eor ^= arrs[i];
        }

        System.out.println(eor);

        get2nums();

    }

    public static void get2nums(){
        int arrs[] = {3,3,4,4,4,5,5,6,6,7};
        int eor = 0 ;
        for(int i = 0 ; i < arrs.length;i++){
            eor ^= arrs[i];
        }
        System.out.println("eor:" + eor);

        int firstOne = eor&(-eor);

        int getOne = 0;;
        for (int i = 0; i < arrs.length; i++) {
            if((arrs[i]&firstOne)!=0){
                getOne ^= arrs[i];
            }
        }
        System.out.println("getOne:" + getOne);

        System.out.println( getOne + "," + (getOne^eor) );
    }

    /*
     * @Author zhouxiaoyuan
     * @Description //TODO 通过递归找到数组里所有所有出现过奇数次的数, 比如有3个，通过一次区分，有2个的到底在哪个区间?
     * @Date 10:02 2021/4/13
     * @Param [arrs, time, eorList, list]
     * @return void
     **/
    public static void getNnums(int[] arrs, int time, ArrayList<Integer> eorList , ArrayList list){

        int eor = 0;
        int needNum = 0;
        for (int i = 0; i < arrs.length; i++) {
            for (Integer o : eorList) {
                needNum = o&arrs[i];
            }
        }
        if(time == 1){
            list.add(eor);
        }else{
            int subInt = eor&(-eor);
        }
    }
}
