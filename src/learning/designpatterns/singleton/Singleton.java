package learning.designpatterns.singleton;

/**
 * @description
 *      饿汉式
 *      最简单的单例模式
 *      缺点：无论用到与否 类架加载时就实例化
 * @author:Alexius
 * @time: 16:54
 * @date: 2021-05-29
 */


public class Singleton {
    private static final Singleton singleton = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return singleton;
    }

}
