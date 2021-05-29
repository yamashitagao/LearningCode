package learning.designpatterns.singleton;

/**
 * @description
 *      懒汉式:什么时候用什么时候初始化
 *      getInstanceNoSafe 缺点：线程不安全，多线程下 进程会抢new
 *      getInstance  加锁
 * @author:Alexius
 * @time: 17:22
 * @date: 2021/5/29
 */


public class LazySingleton {
    private static volatile LazySingleton lazySingleton;

    private LazySingleton() {

    }

    public static LazySingleton getInstanceNoSafe() {
        if (lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    public static LazySingleton getInstance() {
        if (lazySingleton == null){
            synchronized (LazySingleton.class){
                if (lazySingleton == null ) {
                    lazySingleton = new LazySingleton();
                }
            }

        }
        return lazySingleton;
    }
}
