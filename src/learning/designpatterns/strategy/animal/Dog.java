package learning.designpatterns.strategy.animal;

/**
 * @description
 * @author:Alexius
 * @date: 2021/5/31 21:51
 */


public class Dog {
    int Food;

    public Dog(int food) {
        Food = food;
    }

    public  int compareTo(Object o){
        Dog d =(Dog)o;
        if (this.Food < d.Food)  return -1;
        else if (this.Food > d.Food) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "Food=" + Food +
                '}';
    }
}
