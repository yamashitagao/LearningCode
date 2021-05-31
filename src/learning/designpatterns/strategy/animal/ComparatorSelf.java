package learning.designpatterns.strategy.animal;

/**
 * @description
 * @author:Alexius
 * @date: 2021/5/31 21:48
 */


public interface ComparatorSelf<T> {
    int compare(T o1, T o2);
}
