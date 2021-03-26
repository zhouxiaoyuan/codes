package algorithm.practise;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

/**
 * @Description P20210325
 * @Created by Administrator on 2021/3/25 15:02
 */
public class P20210325 {
    static public int length = 20;
    static public int MAX_VALUE = 100;
    static public int[] arrs ;


    @Test
    public void twoSumWithSorted(){
        insertSort();

        Random random = new Random();
        int num1 = random.nextInt(length-1);
        int num2 = random.nextInt(length-1);
        while( num2 == num1){
            num2 = random.nextInt(length-1);
        }

        int sum = arrs[num1] + arrs[num2];
        System.out.println( sum + "=" + arrs[num1] + "(" + num1 + ")" + "+" + arrs[num2] + "(" + num2 + ")" );

        int left = 0 ;
        int right = arrs.length - 1;
        HashMap<Integer,Integer> map = new HashMap();
        while(left<right){
            if( sum == arrs[left] + arrs[right] ){
                map.put(left,right);
                left++;
            }else if( sum < arrs[left] + arrs[right] ){
                right--;
            }else if( sum > arrs[left] + arrs[right] ){
                left++;
            }
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println("找到:(" + arrs[entry.getKey()] + "(" + entry.getKey() + ")" + "," +   arrs[entry.getValue()] + "(" + entry.getValue() + ")"+ ")");
        }

        /*if(map.size()==0){
            System.out.println("没有找到");
        }*/
    }

    //TWOSUM 使用map，降低一维查找
    @Test
    public void twoSum(){
        getArray();

        Random random = new Random();
        int num1 = random.nextInt(length-1);
        int num2 = random.nextInt(length-1);
        while( num2 == num1){
            num2 = random.nextInt(length-1);
        }

        int sum = arrs[num1] + arrs[num2];
        System.out.println( sum + "=" + arrs[num1] + "(" + num1 + ")" + "+" + arrs[num2] + "(" + num2 + ")" );

        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0 ; i < arrs.length ; i++ ){
            map.put(arrs[i],i);
        }

        int findTimes = 0;

        for( int i = 0 ; i < arrs.length ; i++ ){
            int find = sum - arrs[i];
            if( map.containsKey(find) && map.get(find) != i){
                System.out.println("找到:(" + arrs[i] + "(" + i + ")" + "," +   arrs[map.get(find)] + "(" + map.get(find) + ")"+ ")");
                findTimes++;
            }
        }

        if(findTimes == 0 ){
            System.out.println("没有找到");
        }




    }

    @Test
    public void chechBinarySearch(){
        insertSort();
        boolean result = true;
        for( int i = 0 ; i < arrs.length;i++ ){
            int index = binarySearch(arrs[i]);
            System.out.println( i + "-(" + index  + ")" + (i==index));
            if(i!=index){
                result = false;
            }
        }
        System.out.println(result);
    }


    public int binarySearch( int target ){
        int left = 0 ;
        int right = arrs.length - 1;
        int mid = 0 ;
        while( left <= right ){
            mid = left + (right-left)/2;
            if( target == arrs[mid] ){
                return mid;
            }else if( target > arrs[mid] ){
                left = mid + 1;
            }else if( target < arrs[mid] ){
                right = mid - 1;
            }
        }
        return -1;
    }


    @Test
    public void bubbleSort(){
        getArray();
        for(int i = 0 ; i < arrs.length - 1 ; i++){
            for(int j = 0 ; j < arrs.length - 1 - i ; j++ ){
                if( arrs[j] > arrs[j+1] ){
                    swap(arrs,j,j+1);
                }
            }
        }
        check(arrs);
    }

    @Test
    public void insertSort(){
        getArray();
        for(int i = 1 ; i < arrs.length ; i++){
            for(int j = i ; j > 0 && arrs[j] < arrs[j-1] ; j--){
                swap(arrs,j-1 , j);  //交换位置要注意
            }
        }
        check(arrs);
    }


    @Test
    public void selectSort(){
        getArray();
        boolean hasChange = false;
        int curMin = 0 ;
        for(int i = 0 ; i < arrs.length - 1 ; i++ ){
            hasChange = false;
            curMin = i;
            for( int j = i + 1 ; j < arrs.length ; j++ ){
                if(arrs[j] < arrs[curMin]){
                    curMin = j;
                    hasChange = true;
                }
            }
            if(hasChange){
                swap(arrs,i,curMin);
            }
        }
        check(arrs);
    }



    @Test
    public void test(){
        getArray();
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

    public void swap(int[] a , int start , int end ){
        int temp = a[end];
        a[end] = a[start];
        a[start] = temp;
    }

    public void getArray(){
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
    }


    @Test
    public void testADD(){

        String a =        "101011011";
        String b = "1101010101010101";
        if(a==null || a.length() == 0 ) return ;
        if(b==null || b.length() == 0  ) return ;

        int l = a.length() > b.length() ? a.length() : b.length();
        l = l + 1;
        System.out.println(l);
        int[] result = new int[l];
        for(int i = 0 ; i < result.length ; i++){
            result[i] = -1;
        }
        int add = 0;
        int up = 0 ;
        for(int i = 0 ; i < l  ; i++){
            add = 0;
            if(i<=a.length()-1){
                add += (int)(a.charAt(a.length()-1-i)-'0');
            }
            if(i<=b.length()-1){
                add += (int)(b.charAt(b.length()-1-i)-'0');
            }
            add += up;
            if(add <= 1){
                result[i] = add;
                up = 0;
            }else{
                result[i] = add - 2 ;
                up = 1;
            }
        }
        /*if(up > 0 ){
            result[l+1] = 1;
        }*/

        String s = "";
        for(int i = result.length - 1 ; i >= 0 ; i-- ){
            if( i < (result.length - 1) || (i == (result.length - 1) && result[i] > 0) ){
                s = s + result[i];

            }
        }


        System.out.println(s);
    }

}
