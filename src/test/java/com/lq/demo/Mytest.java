package com.lq.demo;

import org.junit.Test;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Mytest {



    @Test
    public void test_1() {
        System.out.println(sub(new int[] {4,5,6,7,5,6,8},new int[] {5,6}));
        System.out.println(sub(new int[] {4,5,7,5,8},new int[] {5,6}));
        System.out.println(sub(new int[] {4,5,6,7,5,6,8},new int[] {6}));
        System.out.println(sub(new int[] {4,5,6,7,5,6,8},new int[] {4,5,6}));
    }

    public int sub(int[] a,int[] b){
        int results[]=new int[a.length];
        for(int i=0;i<results.length;i++)
            results[i]=-1;
        int result=-1;
        for(int i=0,j=0;i<a.length;i++){
            if(b[0]==a[i]){
                results[j]=i;
                j++;
            }
        }

        for(int i=0;i<results.length&&results[i]!=-1;i++){
            for(int j=0,k=results[i];j<b.length;j++,k++){
                if(b[j]!=a[k]){
                    result=-1;
                    break;
                }
                result=results[i];
//                System.out.println(result);
            }
        }

//        for(int i=0;i<results.length;i++)
//            System.out.print(results[i]+" ");
        return result;
    }


    //转为char数组，很麻烦
    @Test
    public void test_2(){
        try {
            System.out.println(add("a","123"));
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    private String add(String a,String b) throws Exception{
        char[] as=a.toCharArray();          //将字符串a转为char数组
        char[] bs=b.toCharArray();
        char[] cs;
        if(a.length()>b.length()){
            cs=new char[a.length()+1];
            cs[0]='0';
            for(int i=1;i<cs.length;i++){
                cs[i]=as[i-1];
            }
        }else {
            cs=new char[b.length()+1];
            cs[0]='0';
            for(int i=1;i<cs.length;i++){
                cs[i]=bs[i-1];
            }
        }



        for(int i=a.length()-1,j=b.length()-1,k=cs.length-1;i>=0&&j>=0;i--,j--,k--)
        {
            System.out.print(as[i]+"+"+bs[j]+"=");
            int c=Integer.parseInt(String.valueOf(as[i]))+Integer.parseInt(String.valueOf(bs[j]));
            System.out.println(c);
            if(c>10){
                c=c-10;
                cs[k]=String.valueOf(c).charAt(0);
                if((a.length()>b.length()?i:j)==0)
                    cs[k]=String.valueOf(c).charAt(1);
                else {
                    if(a.length()>b.length())
                        as[i - 1] = String.valueOf((Integer.parseInt(String.valueOf(as[i-1])) + 1)).charAt(0);
                    else
                        bs[i - 1] = String.valueOf((Integer.parseInt(String.valueOf(bs[i-1])) + 1)).charAt(0);
                }
            }else {
                cs[k]=String.valueOf(c).charAt(0);
            }
        }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<cs.length;i++){
            if(i==0&&cs[i]=='0')
                continue;
            result.append(cs[i]);
        }
        return result.toString();
    }

    @Test
    public void test_3(){
        try {
            System.out.println(add2("a","123456789123456789123456789"));
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
    private String add2(String a,String b) throws Exception{
        int[] as=new int[a.length()+1];
        int[] bs=new int[b.length()+1];
        for(int i=0;i<a.length();i++)
            as[i+1]= Integer.parseInt(String.valueOf(a.charAt(i)));
        for(int i=0;i<b.length();i++)
            bs[i+1]= Integer.parseInt(String.valueOf(b.charAt(i)));
        if(a.length()<b.length()){
            int[] cs=as.clone();
            as=bs.clone();
            bs=cs.clone();
        }

        for(int i=as.length-1,j=bs.length-1;j>=1;i--,j--) {
            int c = as[i] + bs[j];
            if (c > 10) {
                if (as[i - 1] != 9) {
                    as[i - 1] += 1;
                } else {
                    as[i - 1] = 0;
                    as[i - 2] += 1;
                }
                as[i] = c - 10;
            }else
                as[i] = c;
        }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<as.length;i++){
            if(i==0&&as[i]==0)
                continue;
            result.append(as[i]);
        }

        return result.toString();
    }

    @Test
    public void test_tuzi(){
//        int r=2;
//        int
//        for(int i=1;i<24;i++){
//            if(i%3==0){
//                r=2*r;
//            }
//        }
    }
}


