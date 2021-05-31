package learning.designpatterns.strategy.animal;

import java.util.Arrays;

/**
 * @description
 * @author:Alexius
 * @date: 2021/5/31 21:51
 */


public class Main {
    public static void main(String[] args) {
        Cat[] c ={new Cat(3,3 ),new Cat(4,4 ),new Cat(1,1 )};
        Dog[] d ={new Dog(1),new Dog(5),new Dog(9)};
        Sorter<Dog> sorter = new Sorter<>();
        sorter.sort(d,new DogComparator());
        System.out.println(Arrays.toString(d));
    }
}
