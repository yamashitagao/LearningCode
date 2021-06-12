package learning.designpatterns.Factory;

import learning.designpatterns.Factory.modelFactory.AbstractFactory;
import learning.designpatterns.Factory.modelFactory.modelFactoryImp.HunmanbehaveFactory;

/**
 * @description
 * @author:Alexius
 * @time: 13:59
 * @date: 2021-06-12
 */


public class Main {
    public static void main(String[] args) {
        AbstractFactory human = new HunmanbehaveFactory();
        human.getFood().eat();
        human.getWeapon().fire();
        human.getVehicle().go();
    }
}
