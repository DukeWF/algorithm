package com.zzu.algorithm.quiz.bst;

public class _96 {
    public int numTrees(int n) {
        return count(1, n);
    }

    public int count(int lo, int hi) {
        // base case
        if(lo>hi) return 1;

        int res = 0;
        for(int i=lo;i<hi;i++){
            int left = count(lo,i-1);
            int right = count(i+1,hi);
            res = left*right;
        }
        return res;
    }

}
