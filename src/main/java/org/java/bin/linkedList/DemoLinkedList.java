package org.java.bin.linkedList;

/**
 * Created by wangbin on 16/12/19.
 */
public class DemoLinkedList {


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node cur = head;
        Node reHead = null;
        /**
         *
         while (cur != null) {
         Node preCur = cur;      // 用preCur保存住对要处理节点的引用
         cur = cur.next;             // cur更新到下一个节点
         preCur.next = reHead;   // 更新要处理节点的next引用
         reHead = preCur;            // reHead指向要处理节点的前一个节点
         }
         */
        while (cur != null) {
            Node preCur = cur;
            cur = cur.next;
            preCur.next = reHead;
            reHead = preCur;
        }
        return reHead;
    }

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
