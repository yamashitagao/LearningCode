package learning.datastructure;

/**
 * @description
 * @author:Gjc
 * @time: 13:24
 * @date: 2021-06-22
 */


public class MyLinkedList {
    /** Initialize your data structure here. */
    private class Node {
        private int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
    private int size;
    Node head = new Node(-1);
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node temp = head;
        for (int x = 0; x <= index; x++) {
            temp = temp.next;
        }
        return temp.data;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        //temp指向head （其实就是head）
        Node temp = head;
        //node 是加入的节点
        //加入的节点尾部指向原来head节点的next元素（如果表无元素，就等于没有指向元素）
        node.next = head.next;
        //头节点尾部指向加入节点的数据 就此加入头部元素完成
        temp.next = node;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        Node temp = head;
        //temp去尾部
        //直到temp的尾部等于null的时候 就到底了
        while (temp.next != null) temp = temp.next;
        temp.next = node;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Node node = new Node(val);
        Node temp = head;
        if (index < 0 || index > size) {
            return;
        }
        //循坏出来找到插入节点
        for (int x = 0; x < index; x++) {
            temp = temp.next;
        }
        //插入节点的尾节点指向原来元素
        node.next = temp.next;
        //插入原来位置的元素尾节点指向插入元素
        temp.next = node;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node temp = head;

        for (int x = 0; x < index; x++) {
            temp = temp.next;
        }
        //覆盖next
        temp.next = temp.next.next;
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList m = new MyLinkedList();
        m.addAtHead(10);
        m.addAtHead(100);
        m.addAtHead(1000);
        m.deleteAtIndex(0);
        System.out.println(m.get(0));
    }

}
