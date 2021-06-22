package learning.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description
 * 数组实现
 * 简单的插入int类型的队列
 * 队列不用删除 直接覆盖头指针位置
 * @author:Alexius
 * @time: 8:06
 * @date: 2021-06-22
 */


public class MyCircularQueue {
    private int[] queue;
    private int headIndex;
    //当前数量 （尾指针）
    private int count;
    //队列大小
    private int capacity;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.headIndex = 0;
        this.count = 0;
    }

    /** 核心实现
     *
     *      头指针 headIndex  + 尾指针 count %(取余) capacity 总容量
     *
     * */
    public boolean enQueue(int value) {
        //队列是否满
        if (this.count == this.capacity)
            return false;
        /** 核心 数组实现核心
         *  头指针*队列总数  除 体积 取余
         * */
        this.queue[(this.headIndex + this.count) % this.capacity] = value;
        this.count += 1;
        return true;
    }

    /**  */
    public boolean deQueue() {
        //队列是否空
        if (this.count == 0)
            return false;
        //头指针计算 除10取余
        this.headIndex = (this.headIndex + 1) % this.capacity;
        this.count -= 1;
        return true;
    }

    /** 获得最前面的元素. */
    public int Front() {
        if (this.count == 0)
            return -1;
        return this.queue[headIndex];
    }

    /**获得最后的元素e. */
    public int Rear() {
        if (this.count == 0)
            return -1;
        int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
        return this.queue[tailIndex];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return (this.count == 0);
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (this.count == this.capacity);
    }

    public static void main(String[] args) {
//        MyCircularQueue q = new MyCircularQueue(10);
//        q.enQueue(1);
//        q.enQueue(2);
//        q.enQueue(3);
//        q.enQueue(4);
//        q.enQueue(5);
//        q.enQueue(6);
//        q.enQueue(7);
//        q.enQueue(8);
//        q.enQueue(9);
//        q.enQueue(10);
//        q.enQueue(11);
//        for (int i :
//                q.queue) {
//            System.out.println(i);
//        }
        Queue<Integer> q = new LinkedList();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + q.peek());
        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        // 4. Pop an element.
        q.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + q.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + q.size());
    }
}
