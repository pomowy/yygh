package com.maptest;


import org.junit.Test;

/**
 * @author wy
 * @create 2020-08-01 17:09
 */
public class Node {
    public Node next;
    private Object data;

    public Node(Object data) {
        this.data = data;
    }

    //链表 ：链表是一种物理存储单元上非连续、非排序的存储结构
    //特点：插入，删除时间复杂度0（1） 查找遍历时复杂度0（N） 插入快 查找慢
    public static void main(String[] arges){

        Node node = new Node("monkey");
        node.next = new Node("张三");
        node.next.next = new Node("王五");
        System.out.println(node.data);
        System.out.println(node.next.data);
        System.out.println(node.next.next.data);
    }





}
