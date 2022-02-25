package com.liuqiang.design.singleton;

/**
 * 线程安全的懒汉式单例模式
 * 1. 构造器私有化
 * 2. 类的内部创建对象
 * 3. 提供静态公有方法双端检锁创建实例
 * @author yiche
 */

class LazySingleton2{

    /**构造器私有化**/
    private LazySingleton2() {
    }
    /** 类内部创建对象**/
    private static volatile LazySingleton2 Instance;
    /** 提供静态公有方法使用双端检索创建实例**/
    public static LazySingleton2 getInstance(){
        if (Instance == null) {
            synchronized (LazySingleton2.class){
                if (Instance == null) {
                    Instance =  new LazySingleton2();
                }
            }
        }
        return Instance;
    }
}
public class LazySingleton02 {
    public static void main(String[] args) {
        LazySingleton2 instance = LazySingleton2.getInstance();
        System.out.println(instance.hashCode());
       new Thread(()->{
           for (int i = 0; i < 10; i++) {
               LazySingleton2 instance1 = LazySingleton2.getInstance();
               System.out.println(instance1.hashCode());
           }

       },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                LazySingleton2 instance2 = LazySingleton2.getInstance();
                System.out.println(instance2.hashCode());
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                LazySingleton2 instance3 = LazySingleton2.getInstance();
                System.out.println(instance3.hashCode());
            }
        },"C").start();
    }
}
