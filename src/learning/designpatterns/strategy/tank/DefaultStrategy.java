package learning.designpatterns.strategy.tank;

/**
 * @description
 * @author:Alexius
 * @time: 13:53
 * @date: 2021-06-01
 */


public class DefaultStrategy implements VehicleStrategy<Tank> {
    static double load_buff = 1.5;
    Boolean reload = false;

    @Override
    public int drive(int speed) {
        return speed;
    }


    @Override
    public  boolean reloading(Bullet bullet) {
        try {
            if (reload == false) {
                double loadTime = (bullet.base_reload_time * load_buff);
                System.out.println("装填需要" + loadTime + "秒");

                Thread.sleep((long) (1000*loadTime));
                System.out.println("装弹完毕");
                return reload = true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return reload;
        }
        return reload;
    }

    @Override
    public boolean fire(Vehicle myVehicle, Vehicle DVehicle) {
        if (!reload){
            reloading(myVehicle.bullet);
        }
        System.out.println("目标方位（X轴："+DVehicle.position_x+"Y轴："+DVehicle.position_y+"）");
        System.out.println("射击");
        int hp = DVehicle.healthPower - myVehicle.bullet.damage;
        reload = false;
        if (hp <= 0 ){
            System.out.println("载具已摧毁");
        }else {
            System.out.println("击中！"+DVehicle.name+" HP:"+hp);
        }

        return true;
    }


}
