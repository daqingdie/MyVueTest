package com.lq.demo.SORT;

import org.junit.Test;

/**
 * 练习二分查找
 */
public class Sort_test_1 {
    public static void main(String[] args) {
        int[] nums=new int[] {1,2,3,4,5,6,7,8,9,10};
        int num=10;
        int result = sort_1(nums, num);
        System.out.println(result);
    }

    private static int sort_1(int[] nums, int num) {
        int min=0;
        int max=nums.length-1;
        while (min <= max) {
            int mid=(min+max)/2;
            if (nums[mid] > num) {
                max=mid-1;
            } else if (nums[mid] < num) {
                min = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

}
