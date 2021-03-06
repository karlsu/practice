package com.example;

/**
 * Created by suwantao on 17/5/26.
 * 题目：输入一个单向链表，输出该链表中倒数第k个结点。链表的倒数第0个结点为链表的尾指针。
 * 分析：为了得到倒数第k个结点，很自然的想法是先走到链表的尾端，再从尾端回溯k步。
 * 可是输入的是单向链表，只有从前往后的指针而没有从后往前的指针。因此我们需要打开我们的思路。
 * 既然不能从尾结点开始遍历这个链表，我们还是把思路回到头结点上来。假设整个链表有n个结点，那么倒数第k个结点是从头结点开始的第n-k-1个结点（从0开始计数）。
 * 如果我们能够得到链表中结点的个数n，那我们只要从头结点开始往后走n-k-1步就可以了。
 * 如何得到结点数n？这个不难，只需要从头开始遍历链表，每经过一个结点，计数器加一就行了。
 * 这种思路的时间复杂度是O(n)，但需要遍历链表两次。第一次得到链表中结点个数n，第二次得到从头结点开始的第n­-k-1个结点即倒数第k个结点。如 果链表的结点数不多，这是一种很好的方法。
 * 但如果输入的链表的结点个数很多，有可能不能一次性把整个链表都从硬盘读入物理内存，那么遍历两遍意味着一个结 点需要两次从硬盘读入到物理内存。我们知道把数据从硬盘读入到内存是非常耗时间的操作。
 * 我们能不能把链表遍历的次数减少到1？如果可以，将能有效地提高代码执行的时间效率。如果我们在遍历时维持两个指针，第一个指针从链表的头指针开始遍历，在第k-1步之前，第二个指针保持不动；在第k-1步开始，第二个指针也开始从链表的头指针开始遍历。
 * 由于两个指针的距离保持在k-1，当第一个（走在前面的）指针到达链表的尾结点时，第二个指针（走在后面的）指针正好是倒数第k个结点。
 * 这种思路只需要遍历链表一次。对于很长的链表，只需要把每个结点从硬盘导入到内存一次。因此这一方法的时间效率前面的方法要高。
 */

public class FindKNode {

    public static void main(String args[]) {
        //头节点
        Node head = null;
        //当前节点
        Node curNode = null;
        for (int i = 0; i < 10; i++) {
            if (i != 0) {
                Node node = new Node(i + 1);
                curNode.setNext(node);
                curNode = node;
            } else {
                head = new Node(i);
                curNode = new Node(i + 1);
                head.setNext(curNode);
            }

        }
        Node kNode = findKNode(head,5);
        System.out.println("倒数第K个节点是："+kNode.getData());
    }

    public static Node findKNode(Node head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        Node firstNode = head;
        Node secondNode = head;
        for (int i = 0; i < k - 1; i++) {
            if (firstNode.next != null) {
                firstNode = firstNode.next;
            } else {
                return null;
            }
        }
        while (firstNode.next != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return secondNode;
    }


}
