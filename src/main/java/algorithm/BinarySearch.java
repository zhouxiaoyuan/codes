package algorithm;

import java.util.Date;

/**
 * @Description BinarySearch
 * @Created by Administrator on 2021/3/15 10:13
 */
public class BinarySearch {
    int binarySearchSelf(int[] nums,int target){
        int start = 0 ;
        int end = nums.length - 1;
        int mid = start + (end-start)/2;
        while(start <= mid){
            if( nums[mid] == target ){
                return nums[mid];
            }else if( target < nums[mid] ){
                mid = start + (mid - start)/2;
            }else if( target > nums[mid] ){
                mid = start + (end-mid)/2;
            }
        }
        return -1;
    }

    static boolean binarySearch(int[] nums,int target,Integer index){
        int left = 0 ;
        int right = nums.length -1 ;
        while(left <= right){
            int mid = left + (right-left)/2;
            if( nums[mid] == target ){
                index = mid;
                return true;
            }else if( target < nums[mid] ){
                right = mid - 1 ;
            }else if( target > nums[mid] ){
                left = mid + 1;
            }
        }
        return false;
    }

    public static void change(Integer num){
        num = 100;
    }

    public static void main(String[] args) {
        /*int[] ints = {1,5,6,8,7,5,5,41,125,54,5,5,5,5};
        int find = 5;
        Integer target = 125;
        System.out.println(System.currentTimeMillis());
        binarySearch(ints,find,target);
        System.out.println(target);
        System.out.println(System.currentTimeMillis());*/

        Integer i  = 50;
        change(i);
        System.out.println( i );

    }




}
