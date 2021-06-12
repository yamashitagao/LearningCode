package learning.designpatterns.Factory.modelFactory.modelFactoryImp;

import learning.designpatterns.Factory.modelFactory.Food;

/**
 * @description
 * @author:Alexius
 * @time: 13:52
 * @date: 2021-06-12
 */


public class Bread extends Food {
    @Override
    public void eat() {
        System.out.println("bread taste nice !");
    }
}
