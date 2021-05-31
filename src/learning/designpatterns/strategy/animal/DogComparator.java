package learning.designpatterns.strategy.animal;

/**
 * @description
 * @author:Alexius
 * @date: 2021/5/31 21:56
 */


public class DogComparator implements ComparatorSelf<Dog>{
    @Override
    public int compare(Dog o1, Dog o2) {
        if (o1.Food < o1.Food)  return -1;
        else if (o1.Food > o2.Food) return 1;
        return 0;
    }
}
