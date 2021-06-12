package learning.designpatterns.Factory.modelFactory.modelFactoryImp;

import learning.designpatterns.Factory.modelFactory.Weapon;

/**
 * @description
 * @author:Alexius
 * @time: 13:53
 * @date: 2021-06-12
 */


public class AK47 extends Weapon {
    @Override
    public void fire() {
        System.out.println("fucking shooting");
    }
}
