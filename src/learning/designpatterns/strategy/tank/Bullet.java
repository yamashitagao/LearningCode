package learning.designpatterns.strategy.tank;

/**
 * @description
 * @author:Alexius
 * @date: 2021/5/31 22:02
 */


public class Bullet {
    String bulletType ;
    int damage , deep;
    int base_reload_time;

    public Bullet(String bulletType, int damage, int deep, int base_reload_time) {
        this.bulletType = bulletType;
        this.damage = damage;
        this.deep = deep;
        this.base_reload_time = base_reload_time;
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "bulletType='" + bulletType + '\'' +
                ", damage=" + damage +
                ", deep=" + deep +
                ", base_reload_time=" + base_reload_time +
                '}';
    }
}
