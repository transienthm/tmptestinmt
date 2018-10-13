package org.java.bin.linkedList;

import java.util.List;

/**
 * Created by wangbin on 2017/8/4.
 */
public class AboutNull {
    public static void main(String[] args) {
        ListNode p = new ListNode(1);
        ListNode q = new ListNode(2);
        p.next = q;
        System.out.println(q);
        q = null;
        System.out.println(q);
        System.out.println(p.next);
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
