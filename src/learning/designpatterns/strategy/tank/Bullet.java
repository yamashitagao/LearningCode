package learning.designpatterns.strategy.tank;

/**
 * @description
 * @author:Alexius
 * @date: 2021/5/31 22:02
 */


public class Bullet {
    String bulletType ;
    Tank tank;
    int damage , deep;

    public Bullet(String bulletType, Tank tank, int damage, int deep) {
        this.bulletType = bulletType;
        this.tank = tank;
        this.damage = damage;
        this.deep = deep;
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "bulletType='" + bulletType + '\'' +
                ", tank=" + tank +
                ", damage=" + damage +
                ", deep=" + deep +
                '}';
    }
}
