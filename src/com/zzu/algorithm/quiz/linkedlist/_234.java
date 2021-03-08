package com.zzu.algorithm.quiz.linkedlist;

import com.zzu.algorithm.tool.ListNode;

public class _234 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public boolean isPalindromeByPostTraverse(ListNode head) {
        left=head;
        return traverse(head);
    }
    //w1: 使用后序遍历+左侧指针实现 O(N)
    ListNode left;

    public boolean traverse(ListNode right) {
        if(right==null) return true;

        boolean res = traverse(right.next);
        // 后序遍历代码
        res=res&&(right.val== left.val);
        left= left.next;
        return res;
    }

    //w2: 优化空间复杂度：使用快慢指针
    public ListNode reverse(ListNode head){
        ListNode pre = null, cur=head;
        while (cur!=null){
            //保存当前的next节点
            ListNode next = cur.next;
            //将当前节点作为上一个节点的前驱节点
            cur.next=pre;
            //将当前节点作为新的后继节点
            pre=cur;
            //将next节点作为新的当前节点（下次迭代的前驱节点）
            cur=next;
        }
        return pre;
    }
    public boolean isPalindromeBySlowFastPointer(ListNode head){
        ListNode slow,fast; //快慢指针
        ListNode p,q; //链表还原指针
        p=q=null;
        slow=fast=head;

        while (fast!=null&&fast.next!=null){
            if(p!=slow){
                //让p比slow慢一位
                p=head.next;
                q=head.next.next;
            }else if(p.next==slow){
                q=q.next.next;
            }

            slow=slow.next;
            fast=fast.next.next;
        }

        //slow指向中点
        //fix：可能存在fast尚未指向null，此时链表长度为奇数
        assert q != null;
        q=q.next;
        if(fast!=null) {
            p=p.next;
            slow=slow.next;
            q=fast;
        }

        ListNode left = head;
        //反转slow后面的指针实现链表变换
        ListNode right = reverse(slow);

        while(right!=null){
            if(left.val!= right.val) return false;
            left= left.next;
            right= right.next;
        }

        //还原链表
        p.next=reverse(q);
        return true;
    }


}