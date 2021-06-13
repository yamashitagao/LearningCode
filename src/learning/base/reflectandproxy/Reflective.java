package learning.base.reflectandproxy;

import java.lang.reflect.*;

/**
 * @description
 * @author:Alexius
 * @time: 9:33
 * @date: 2021-06-13
 */


public class Reflective {

    private Object target;

    public void add(){
        System.out.println("add");
    };
    public void update(){
        System.out.println("update");
    };

    public Reflective(){
        System.out.println("无参构造！");
    }
    private Reflective(String a , int b ){
        System.out.println("有参构造！");
    }

    private void print(String msg){
        System.out.println(msg);
    }
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("learning.base.reflectandproxy.Reflective");
        //有参构造器
        Class[] p = new Class[]{String.class,int.class};
        System.out.println(aClass.getDeclaredConstructor(p));
        Constructor declaredConstructor = aClass.getDeclaredConstructor(p);
        declaredConstructor.newInstance("a",1);

        Class[] p1 = {String.class};
        Method method = aClass.getDeclaredMethod("print",p1);
        method.setAccessible(true);
//        method.invoke(aClass.newInstance(),"fkfkfkfk");// 1.9启用newInstance
        //有参构造器实例化
        method.invoke(aClass.getDeclaredConstructor(p).newInstance("a",1),"fk");
    }
}
