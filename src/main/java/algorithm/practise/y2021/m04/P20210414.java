package algorithm.practise.y2021.m04;

/**
 * @Description algorithm.practise.y2021.m04.P20210414
 * @Created by zhouxiaoyuan on 2021/4/14 9:03
 */
public class P20210414 {

    public static void main(String[] args) {


    }

    public static void getKnums(){   //获取出现K次的数字，其它的出现m次
        int k = 1;
        int m = 2;
        int[] arrs = {7,7,100,2,2,3,3,4,4,9,9};
        int ans = 0 ;

        int[] carrs = new  int[32];

        for(int i = 0 ; i < arrs.length;i++){
            for(int j = 0 ; j < 32 ; j++){
                carrs[j] = carrs[j] + (arrs[i]>>j)&1;
            }
        }

        for(int i = 0 ; i < carrs.length ; i++){
            if((carrs[i]%m)!=0){
                ans |= (1<<i);
            }
        }

        System.out.println(ans);
    }

}
