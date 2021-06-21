package learning.designpatterns.factory.modelFactory.modelFactoryImp;


import learning.designpatterns.factory.modelFactory.Vehicle;

/**
 * @description
 * @author:Alexius
 * @time: 13:48
 * @date: 2021-06-12
 */


public class Car extends Vehicle {
    @Override
    public void go() {
        System.out.println("car driving !");
    }
}
