package com.zzu.algorithm.quiz.bst;

import java.util.Arrays;
import java.util.Scanner;

// write your code here
public class lcs{
    //备忘录消除重叠子问题
    int[][] memo;
    int longestCommonSubsequence(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        //初始化memo为全-1
        memo = new int[m][n];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return dp(s1,0,s2,0);
    }
    int dp(String s1, int i, String s2, int j){
        //边界情况：s1||s2搜索完毕
        if(i==s1.length()||j==s2.length()){
            return 0;
        }
        if(memo[i][j]!=-1) return memo[i][j];

        //Case1: s1[i]==s2[j]
        if(s1.charAt(i)==s2.charAt(j)){
            memo[i][j]=1+dp(s1,i+1,s2,j+1);
        }else{
            //Case2:s1[i]!=s2[j]
            //穷举其余几种情况
            memo[i][j] = Math.max(
                    //Case2.1:s1[i]不属于lcs
                    dp(s1,i+1,s2,j),
                    //Case2.2:s2[j]不属于lcs
                    dp(s1,i,s2,j+1)
            );
        }
        return memo[i][j];
    }


    public static void main(String[] args) {
//        args = new String[]{"abcfbc", "abfcab", "programming", "contest", "abcd", "mnp"};
        Scanner input = new Scanner(System.in);
//        Scanner debug = new Scanner(System.in);
        lcs obj = new lcs();
        while(input.hasNextLine()){
            String s1 = input.next();
            if(s1.equals("")) break;
//            System.out.println(s1);
            String s2 = input.next();
//            System.out.println(s2);
//            System.out.println(debug.nextLine());
            System.out.println(obj.longestCommonSubsequence(s1,s2));

//            if(input.)
        }
//        for(int i=0;i<args.length;i+=2){
//            System.out.println(obj.longestCommonSubsequence(args[i],args[i+1]));
//        }
    }
}