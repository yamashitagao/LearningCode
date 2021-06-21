package learning.designpatterns.decorator.tanks;

/**
 * @description
 * @author:Alexius
 * @time: 8:33
 * @date: 2021-06-21
 */


public class Test {
    public static void main(String[] args) {
        GameObject tank =new Tank();
        GameObject tankPD = new TankPaintingDecorator(tank);
        tank.paint();
        tankPD.paint();
    }
}
