package learning.designpatterns.strategy.tank;

/**
 * @description
 * @author:Alexius
 * @date: 2021/5/31 22:04
 */


public class Tank extends Vehicle{

    public Tank(String name, int healthPower, int speed, int position_x, int position_y, int ammunition, Bullet bullet) {
        super(name, healthPower, speed, position_x, position_y, ammunition, bullet);
    }

    @Override
    public String toString() {
        return "Tank{" +
                "name='" + name + '\'' +
                ", healthPower=" + healthPower +
                ", speed=" + speed +
                ", position_x=" + position_x +
                ", position_y=" + position_y +
                ", Ammunition=" + Ammunition +
                ", bullet=" + bullet +
                '}';
    }
}
