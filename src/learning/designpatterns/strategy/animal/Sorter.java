package learning.designpatterns.strategy.animal;

import java.util.Comparator;

/**
 * @description
 * @author:Alexius
 * @date: 2021/5/31 21:41
 */


public class Sorter<T> {
    public   void sort(T[] arr, ComparatorSelf<T> comparator){
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i+1; j <arr.length ; j++) {
                minPos = comparator.compare(arr[j],arr[minPos]) == -1 ? j : minPos;
            }
            swap(arr,i,minPos);
        }
    }

     void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
