package learning.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @description
 * @author:Gjc
 * @time: 12:40
 * @date: 2021-06-26
 */


public class MyHashSet {

    // 使用链表实现 HashSet
    private List<List<Integer>> list;

    public MyHashSet() {
        this.list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new ArrayList<Integer>());
        }
    }
    // 插入数据
    public void add(int key) {
        // HashSet 不允许重复，所以 插入之前判断是否包含该数据，如果包含则直接返回
        if(contains(key)){
            return;
        }
        // 不包含，则继续插入

        // 插入思路
        // 1. 插入时  进行散列函数判断，确定合适的桶
        // 2. 找到合适的捅，后向内插入 键值

        // 散列函数，y = x % 5  y为链表的下标
        int index = key % 5;
        if(index < 0){
            index = -index;
        }
        list.get(index).add(key);
    }

    public void remove(int key) {
        // 如果 不存在 则删除失败
        if(!contains(key)){
            return;
        }

        // 删除思路
        // 1. 判断桶子， 桶子不存在 直接返回
        // 2. 找到桶子， 确定桶子是否为空， 为空直接返回
        // 3. 找到桶子， 确定桶子不为空， 查询比对桶子内的键值,删除
        int index = key % 5;
        if(index < 0){
            index = -index;
        }
        if(index > list.size()){
            return;
        }
        List<Integer> temp = list.get(index);
        if(temp.size() == 0){
            return;
        }
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i) == key){
                temp.remove(i);
                break;
            }
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        // 验重思路
        // 1. 判断桶子， 桶子不存在 直接返回
        // 2. 找到桶子， 确定桶子是否为空， 为空直接返回
        // 3. 找到桶子， 确定桶子不为空， 查询比对桶子内的键值,返回
        int index = key % 5;
        if(index < 0){
            index = -index;
        }
        if(index >= list.size()){
            return false;
        }
        List<Integer> temp = list.get(index);
        if(temp.size() == 0){
            return false;
        }
        Boolean flag = false;
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i) == key){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        MyHashSet ms =new MyHashSet();
        ms.add(1);
        ms.add(6);
        ms.add(1);
        HashSet<Integer> s =new HashSet<>();
        s.add(1);

    }
}