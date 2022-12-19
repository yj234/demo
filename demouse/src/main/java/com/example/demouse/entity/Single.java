package com.example.demouse.entity;

import ch.qos.logback.core.encoder.EchoEncoder;

/**
 * 单例模式
 */
public class Single {

    /**
     * 1
     *  该方式是使用synchronized关键字进行加锁，保证了线程安全性。
     *  优点：在第一次调用才初始化，避免了内存浪费。
     *  缺点：对获取实例方法加锁，大大降低了并发效率。
     *  由于加了锁，对性能影响较大，不推荐使用。
     *
     private static Single single;
     private Single(){};
     public static synchronized Single getSingle(){
     if (single == null){
     return single;
     }
     return single;
     }

     */

    /**
     * 2
     * 饿汉式是利用类加载机制来避免了多线程的同步问题，所以是线程安全的。
     * 优点：未加锁，执行效率高。
     * 缺点：类加载时就初始化实例，造成内存浪费。
     * 如果对内存要求不高的情况，还是比较推荐使用这种方式。

     private static final Single single = new Single();
     private Single() {
     }
     public static Single getSingle() {
     return single;
     }
     */


    /**
     * 3
     利用了volatile修饰符的线程可见性（被一个线程修改后，其他线程立即可见），即保证了懒加载，又保证了高性能，所以推荐使用。

     private static volatile Single single;
     private Single() { }
     public static Single getSingle() {
     if (single == null){
     synchronized (Single.class){
     if (single == null){
     single = new Single();
     }
     }
     }
     return  single;
     }
     */

    /**
     * 4
     * 该模式利用了静态内部类延迟初始化的特性，来达到与双重校验锁方式一样的功能。由于需要借助辅助类，并不常用。
     */
    private Single() {
    }

    public static Single getInstance() {
        return InnerClass.single;
    }

    private static class InnerClass {
        private static final Single single = new Single();
    }
}
