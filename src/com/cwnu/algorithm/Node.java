package com.cwnu.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 使用链表存放的数据判断是否是回文
 * 通过快慢指针
 */
public class Node {

    /**
     * 单链表的数据结构
     */
    private Node next;
    private Integer data;

    public Node(){}

    public Node(Integer x){
        data = x;
        next = null;
    }

    /**
     * 打印链表
     * @param node
     * @return
     */
    public static String printNode(Node node){
        StringBuilder result = new StringBuilder(node.data + ">");
        Node paramNode = node.next;
        while (paramNode  != null){
            result.append(paramNode.data).append(">");
            paramNode = paramNode.next;
        }
        return result.toString().substring(0,result.length()-1);
    }


    //单链表反转

    /**
     * 基于数组：用数组存储链表前半段的值，使用快慢指针法进行截取
     * @param node
     * @return
     */
    private static boolean isPalindromeByArray(Node node) {
        if (null == node || null == node.next) return true;
        List<Integer> nodeList = new ArrayList<>();
        Node fast = node;
        Node slow = node;
        nodeList.add(0, slow.data);
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
            nodeList.add(0, slow.data);
        }
        Node curNode = slow;
        if (null != fast.next) {
            curNode = slow.next;
        }
        int index = 0;
        while (null != curNode) {
            if (curNode.data.intValue() != nodeList.get(index)) {
                return false;
            }
            curNode = curNode.next;
            ++index;
        }
        return true;
    }

    /**
     * 基于栈
     * @param node
     * @return
     */
    private static boolean isPalindromeByStack(Node node) {
        if (null == node || null == node.next) return true;
        Stack<Integer> stack = new Stack<>();
        Node fast = node;
        Node slow = node;
        stack.push(slow.data);
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
            stack.push(slow.data);
        }
        if (null != fast.next) {
            slow = slow.next;
        }
        Node curNode = slow;
        while (null != curNode) {
            if (curNode.data.intValue() != stack.pop()) {
                return false;
            }
            curNode = curNode.next;
        }
        return true;
    }


    /**
     * 原地链表法：不借助外部存储实现回文，用到了链表反转的思想。先使用快慢指针
     * @param node
     * @return
     */
    private static boolean isPalindromeAuto(Node node) {
        if (null == node || null == node.next) return true;
        Node fast = node;
        Node slow = node;
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node preNode = slow;
        Node firstNode = slow.next;
        Node curNode = slow.next.next;
        firstNode.next = null;
        while (null != curNode) {
            Node nextNode = curNode.next;
            curNode.next = preNode.next;
            preNode.next = curNode;
            curNode = nextNode;
        }
        slow = node;
        fast = preNode.next;
        while (null != fast) {
            if (fast.data.intValue() != slow.data) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static void main(String[] args) {
//        Node node = new Node();
//        node.data = 1;
//
//        Node node1 = new Node();
//        node1.data = 2;
//        node.next = node1;
//
//
//        Node node2 = new Node();
//        node2.data = 1;
//        node.next.next = node2;
//
//        boolean flag = isPalindromeByArray(node);
//        System.out.println(flag);


        Node node = new Node();
        node.data = 1;

        Node node1 = new Node();
        node1.data = 2;
        node.next = node1;


        Node node2 = new Node();
        node2.data = 3;
        node.next.next = node2;

        Node node3 = new Node();
        node3.data = 4;
        node.next.next.next = node3;

        Node node4 = new Node();
        node4.data = 5;
        node.next.next.next.next = node4;

        System.out.println(printNode(node));
    }
}
