package learning.designpatterns.Factory.modelFactory.modelFactoryImp;

import learning.designpatterns.Factory.modelFactory.AbstractFactory;
import learning.designpatterns.Factory.modelFactory.Food;
import learning.designpatterns.Factory.modelFactory.Vehicle;
import learning.designpatterns.Factory.modelFactory.Weapon;

/**
 * @description
 * @author:Alexius
 * @time: 13:54
 * @date: 2021-06-12
 */


public class HunmanbehaveFactory extends AbstractFactory {
    @Override
    public Vehicle getVehicle() {
        return new Car();
    }

    @Override
    public Food getFood() {
        return new Bread();
    }

    @Override
    public Weapon getWeapon() {
        return new AK47();
    }

}
