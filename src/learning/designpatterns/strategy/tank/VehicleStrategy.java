package learning.designpatterns.strategy.tank;

/**
 * @description
 *      载具策略
 *      载具可以是 坦克，装甲车，防空车，火炮 等等
 *
 * @author:Alexius
 * @time: 10:25
 * @date: 2021-06-01
 */


public interface VehicleStrategy<T> {

    int drive(int speed);

    boolean reloading(Bullet bullet);

    boolean fire(Vehicle vehicle,Vehicle desVehicle);
}
