package learning.designpatterns.singleton;

/**
 * @description
 *      通过静态内部类去new
 *      相对完美
 *      线程安全有jvm类保证
 * @author:Alexius
 * @time: 17:42
 * @date: 2021/5/29
 */


public class InnerClassSIngleton {

    private InnerClassSIngleton() {

    }

    private static class InnerClass{
        private static final InnerClassSIngleton InnerClassSIngleton = new InnerClassSIngleton();
    }
    public static InnerClassSIngleton getInstance() {
        return InnerClass.InnerClassSIngleton;
    }
}
