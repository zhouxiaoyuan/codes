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

    public int[] getArray(){
        arrs = new int[length];
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        HashSet set = new HashSet();
        for(int i = 0 ; i < length ; i++ ){
            while(set.contains(( arrs[i] = random.nextInt(MAX_VALUE)))){}
            set.add(arrs[i]);
            sb.append(arrs[i]).append("-");
        }
        System.out.println( sb.toString().substring(0,sb.length()-1));
        return arrs;
    }

    public void check(int[] arrs){
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
}
