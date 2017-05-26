package com.example;

/**
 * 链表反转
 */
public class NodeReverse {
    public static void main(String args[]) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的链表
        Node h = head;
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
        // 调用反转方法
        // head = reverse1(head);
        head = reverseNodeByRecursion(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }


    /**
     * 遍历反转法：递归反转法是从后往前逆序反转指针域的指向，而遍历反转法是从前往后反转各个结点的指针域的指向。
     * 基本思路是：将当前节点cur的下一个节点 cur.getNext()缓存到temp后，然后更改当前节点指针指向上一结点pre。
     * 也就是说在反转当前结点指针指向前，先把当前结点的指针域用tmp临时保存，以便下一次使用。
     * pre：上一结点
     * cur: 当前结点
     * tmp: 临时结点，用于保存当前结点的指针域（即下一结点）
     *
     * @param head
     * @return
     */
    public static Node reverseNodeByRecursion(Node head) {
        //上一个节点
        Node preNode = head;
        //当前节点
        Node curNode = head.getNext();
        Node tempNode;
        if (head == null) {
            return head;
        }
        while (curNode != null) {
            tempNode = curNode.getNext();
            //反转指针域的指向
            curNode.setNext(preNode);
            // 指针后移
            //上一个节点指向当前节点
            preNode = curNode;
            //当前节点指向下一个节点
            curNode = tempNode;

        }
        head.setNext(null);
        return preNode;
    }

    /**
     * 递归反转法：在反转当前节点之前先反转后续节点。这样从头结点开始，层层深入直到尾结点才开始反转指针域的指向。
     * 简单的说就是从尾结点开始，逆向反转各个结点的指针域指向.
     * head：是前一结点的指针域（PS：前一结点的指针域指向当前结点）
     * head.getNext()：是当前结点的指针域（PS：当前结点的指针域指向下一结点）
     * reHead：是反转后新链表的头结点（即原来单链表的尾结点）
     *
     * @param head
     * @return
     */
    public static Node reverseNodeByTraverse(Node head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        // 若为空链或者当前结点在尾结点，则直接还回
        if (head == null || head.getNext() == null) {
            return head;
        }
        // 先反转后续节点head.getNext()
        Node reHead = reverseNodeByTraverse(head.getNext());
        // 将当前结点的指针域指向前一结点
        head.getNext().setNext(head);
        // 前一结点的指针域置为null;
        head.setNext(null);
        // 反转后新链表的头结点
        return reHead;

    }
}
