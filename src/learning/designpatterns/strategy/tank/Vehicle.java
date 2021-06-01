package learning.designpatterns.strategy.tank;

/**
 * @description
 * @author:Alexius
 * @time: 15:52
 * @date: 2021-06-01
 */


public class Vehicle{
    String name;
    int healthPower;
    int speed;
    int position_x;
    int position_y;
    int Ammunition;     //载弹量
    Bullet bullet;

    public Vehicle(String name, int healthPower, int speed, int position_x, int position_y, int ammunition, Bullet bullet) {
        this.name = name;
        this.healthPower = healthPower;
        this.speed = speed;
        this.position_x = position_x;
        this.position_y = position_y;
        Ammunition = ammunition;
        this.bullet = bullet;
    }

    public boolean fire(VehicleStrategy vehicleStrategy,Vehicle desVehicle){
        return  vehicleStrategy.fire(this , desVehicle);
    }

}
