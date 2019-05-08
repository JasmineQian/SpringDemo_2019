package com.example.demo;

import java.util.Arrays;

public class kmp {

    /**
     * KMP算法
     　　KMP算法是D.E.Knuth、V.R.Pratt和J.H.Morris同时发现，所以命名为KMP算法。
     　　此算法可以在O(n+m)的时间数量级上完成串的模式匹配。
     　　主要就是改进了暴力匹配中i回溯的操作，KMP算法中当一趟匹配过程中出现字符比较不等时，
     不直接回溯i，而是利用已经得到的“部分匹配”的结果将模式串向右移动（j-next[k]）的距离。
     */
    public static String kmpStringMatch(String source, String pattern)
    {
        int i = 0;
        int j = 0;
        char[] s = source.toCharArray();
        char[] p = pattern.toCharArray();

        System.out.println("长字符串" + Arrays.toString(s));
        System.out.println("短字符串：" + Arrays.toString(p));
        int slen = s.length;
        int plen = p.length;
        int[] next = getNext(p);
        System.out.println("next函数值：" + Arrays.toString(next));


        while(i < slen && j < plen)
        {
            if(j == -1 || s[i] == p[j])
            {
                ++i;
                ++j;
            }
            else
            {
                //如果j != -1且当前字符匹配失败，则令i不变，
                //j = next[j],即让pattern模式串右移j - next[j]个单位
                j = next[j];
                System.out.println("好神奇的j： "+j);
            }
        }


        if(j == plen)
            return "位置是"+(i+1 - j);
        else
            return "匹配失败"; // 匹配失败
    }


    /**
     * 关于next[k]数组的计算引出的两种办法，一种是递归，一种对递归优化，第一种对应的就是KMP算法，第二种就是优化的KMP算法。
     next函数值仅取决于模式串本身而和主串无关。
     有很多讲next函数值计算办法的资料，在此我想用一种直观的比较容易理解的办法来表达。
     举个栗子：现在有一个模式串abab

     模式串的各个字串　
     前缀  后缀  最大公共元素长度
     a    null    null    0
     ab    a    b    0
     aba    a,ab    a,ba    1
     abab    a,ab,aba    b,ab,bab    2
     */
    private static int[] getNext(char[] p)
    {
        /**
         * 已知next[j] = k, 利用递归的思想求出next[j+1]的值
         * 1.如果p[j] = p[k]，则next[j+1] = next[k] + 1;
         * 2.如果p[j] != p[k],则令k = next[k],如果此时p[j] == p[k],则next[j+1] = k+1
         * 如果不相等，则继续递归前缀索引，令k=next[k],继续判断，直至k=-1(即k=next[0])或者p[j]=p[k]为止
         */
        int plen = p.length;
        int[] next = new int[plen];
        //System.out.println("====1====next函数值：" + Arrays.toString(next));

        int k = -1;
        int j = 0;
        //System.out.println(p[k]);  //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: -1
        next[0] = -1;                //这里采用-1做标识
        //System.out.println("====2====next函数值：" + Arrays.toString(next));
        while(j < plen -1)
        {
            if(k == -1 || p[j] == p[k])
            {
                ++k;
                ++j;
                next[j] = k;
                //System.out.println(next[j]);
                //System.out.println("next函数值：" + Arrays.toString(next));
            }
            else
            {
                k = next[k];
                //System.out.println("else中的k的值是"+k);
            }
        }
        //System.out.println("next函数值：" + Arrays.toString(next));
        return next;
    }

    public static void main(String args[]){
        String a= "abcdeddd";
        String b="ddd";
        String c =kmp.kmpStringMatch(a,b);
        System.out.println(c);

    }
}
