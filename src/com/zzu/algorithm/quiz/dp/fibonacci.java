package com.zzu.algorithm.quiz.dp;

import java.util.HashMap;

public class fibonacci {
    //朴素的递归解法
    public int fib(int n) {
        if(n==0) return 0;
        else if (n==1) return 1;
        else return fib(n-1)+fib(n-2);
    }
    //带备忘录的递归解法
    public int fibWithMemo(int N){
        if (N<1) return 0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        return helper(memo,N);
    }
    public int helper(HashMap<Integer,Integer> memo, int n){
        //base case
        if(n==1||n==2) return 1;

        //memo中已经存在
        if(memo.get(n)!=null) return memo.get(n);
        memo.put(n,helper(memo,n-1)+helper(memo,n-2));
        return memo.get(n);
    }

    public static void main(String[] args) {
        fibonacci fibonacci = new fibonacci();
        System.out.println(fibonacci.fib(2));
        System.out.println(fibonacci.fib(3));
        System.out.println(fibonacci.fib(4));

        System.out.println();

        System.out.println(fibonacci.fibWithMemo(2));
        System.out.println(fibonacci.fibWithMemo(3));
        System.out.println(fibonacci.fibWithMemo(4));
    }
}
