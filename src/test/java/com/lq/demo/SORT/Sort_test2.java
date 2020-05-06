package com.lq.demo.SORT;

import sun.security.util.Length;

public class Sort_test2 {
    public static void main(String[] args) {
        int[] nums = new int[]{6,2,8,3,4,5,9,10,2,7};
        Mysort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.print(num+",");
        }
    }

    private static void Mysort(int[] nums,int min,int max) {
        int min0=min;
        int max0=max;
        if (min > max) {
            return;
        }
        int temp=nums[min];
        while(min!=max){
            if (nums[max] < temp) {
                while (min!=max){
                    if (nums[min] > temp) {
                        int temp2=nums[min];
                        nums[min] = nums[max];
                        nums[max]=temp2;
                        break;
                    }else {
                        min++;
                    }
                }
            }else {
                max--;
            }
        }
        nums[min0]=nums[min];
        nums[min]=temp;

        Mysort(nums,min0,min-1);
        Mysort(nums,min+1,max0);
    }
}
