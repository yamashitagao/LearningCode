package learning.datastructure;

/**
 * @description
 * @author:Gjc
 * @time: 12:19
 * @date: 2021-06-23
 */


public class MyLinkedList {

    private DualNode prev;
    private DualNode next;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.prev = new DualNode(-1);
        this.next = new DualNode(-1);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if(index < 0 || index >= size) {
            return -1;
        }

        int i = 0;
        DualNode tempNode = prev.next;
        while(tempNode != null) {
            if(i == index) {
                return tempNode.val;
            }
            tempNode = tempNode.next;
            i ++;
        }
        return -1;

    }

    /**
     * 三步
     * 1.插入节点的尾部    --->    原链表头元素节点
     * 2.原链表头元素节点  --->    插入节点
     * 3.头部节点尾部     --->    插入节点
     */
    public void addAtHead(int val) {
        DualNode node = new DualNode(val);
        if (size == 0) {
            prev.next = node;
            next.prev = node;
            size++;
            return;
        }
        //插入节点 尾部指到 上个节点
        node.next = prev.next;
        //未加节点的头部 指向 插入的节点
        prev.next.prev = node;
        //头节点 尾部指向 插入的节点
        prev.next = node;
        size++;
    }

    /**
     *
     */
    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
        }
        DualNode node = new DualNode(val);

        //头节点指向元素尾戒点
        node.prev = next.prev;
        //元素尾节点指向头节点
        next.prev.next = node;
        next.prev = node;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) addAtHead(val);
        if (index == size) addAtTail(val);

        DualNode node = new DualNode(val);
        DualNode tempPrev = prev;
        DualNode tempNext = next;
        //头部插入
        for (int i = 0; i < index; i++) {
            tempPrev = tempPrev.next;
        }
        node.next = tempPrev.next;
        tempPrev.next = node;
        node.prev = tempPrev;
        tempPrev.next = node;
        //尾部插入
        for (int i = 0; i < size - index; i++) {
            tempNext = tempNext.prev;
        }
        node.next = tempNext;
        node.prev = tempNext.prev;
        tempNext.prev.next = node;
        tempNext.prev = node;
        size++;

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if(size == 1 && index != 0) {
            return;
        }
        if(size == 1 && index == 0) {
            prev.next = null;
            next.prev = null;
            size --;
            return;
        }
        if(index == 0) {
            prev.next.next.prev = null;
            prev.next = prev.next.next;
            size --;
            return;
        }
        if(index == size-1) {
            next.prev.prev.next=next.prev.next;
            next.prev = next.prev.prev;
            size --;
            return;
        }


        DualNode tempPrev = prev;
        //头部插入
        for (int i = 0; i <= index; i++) {
            tempPrev = tempPrev.next;
        }
        tempPrev.prev.next = tempPrev.next;
        tempPrev.next.prev = tempPrev.prev;
        tempPrev.next = null;
        size--;

    }


    public static void main(String[] args) {
        MyLinkedList m = new MyLinkedList();
        m.addAtHead(1);
        m.addAtTail(2);
        m.addAtTail(4);
        m.addAtIndex(2, 3);
        m.addAtTail(5);
//        m.deleteAtIndex(3);
        System.out.println(m.get(0));
        System.out.println(m.get(1));
        System.out.println(m.get(2));
        System.out.println(m.get(3));
        System.out.println(m.get(4));

    }


}

