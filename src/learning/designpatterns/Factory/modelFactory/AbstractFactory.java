package learning.designpatterns.Factory.modelFactory;

/**
 * @description
 *      任何可生产对象的方法或者类都可以称之为厂工。
 * @author:Alexius
 * @time: 13:39
 * @date: 2021-06-12
 */


public abstract class AbstractFactory  {
        public abstract Vehicle getVehicle();
        public abstract Food getFood();
        public abstract Weapon getWeapon();
}
