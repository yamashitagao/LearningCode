package learning.designpatterns.strategy.tank;

/**
 * @description
 *      策略模式：
 *        策略模式就是定义一系列的算法(方法)，把他们一个个封装起来，并且使他们可相互替换，Strategy模式使算法可独立于使用它的客户而变化。
 *      策略模式的优点：
 *          提供管理相关算法族的办法
 *          提供可替代继承关系的办法
 *          避免了使用多重条件判断语句
 *      策略模式的缺点：
 *          客户端必须知道所有的策略类，自己去决定使用哪一个
 *      模拟开火场景
 *      坦克使用坦克策略
 *      火炮使用火炮策略
 * @author:Alexius
 * @time: 8:55
 * @date: 2021-06-01
 */


public class Main {
    public static void main(String[] args) {
        Bullet bullet =new Bullet("AP",400,250,2);
        Tank tank_stb_1 = new Tank("STB-1",1800, 60, 100, 100, 60,bullet);
    }
}
