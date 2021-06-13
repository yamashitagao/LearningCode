package learning.base.reflectandproxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @description
 * @author:Alexius
 * @time: 14:15
 * @date: 2021-06-13
 */


public class ProxyInvocationHandler implements InvocationHandler {

    private Object target;
    //代理角色在调度员实例化时传入
    public ProxyInvocationHandler(Object t) {

        target = t;
    }
    //获取代理角色
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces()
        ,this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {   System.out.print(target);

        return method.invoke(target, args);

    }


}
