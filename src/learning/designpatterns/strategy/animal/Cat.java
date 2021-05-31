package learning.designpatterns.strategy.animal;

/**
 * @description
 * @author:Alexius
 * @date: 2021/5/31 21:40
 */


public class Cat {
    int weight,height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public  int compareTo(Object o){
        Cat c =(Cat)o;
        if (this.weight < c.weight)  return -1;
        else if (this.weight > c.weight) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
