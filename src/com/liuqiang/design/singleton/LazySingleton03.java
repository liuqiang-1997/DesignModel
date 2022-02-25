package com.liuqiang.design.singleton;

/**
 * 使用静态内部类创建单例模式
 * 在类加载过程中，静态内部类不会被加载，
 * 只有当外部类调用获取实例对象方法时才会装载静态内部类，而且只装载一次，
 * 保证了懒加载，
 * 同时，在类加载过程中线程安全。
 * @author yiche
 */
class LazySingleton3{

    /** 私有构造方法**/
    private LazySingleton3(){}

    /** 静态内部类创建实例对象**/
    private static class GetLazy{
        private static final LazySingleton3 INSTANCE = new LazySingleton3();
    }

    /** 创建公有方法获取实例**/
    public static LazySingleton3 getInstance(){
        return GetLazy.INSTANCE;
    }
}
public class LazySingleton03 {
    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                LazySingleton3 instance1 = LazySingleton3.getInstance();
                System.out.println(instance1.hashCode());
            }

        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                LazySingleton3 instance1 = LazySingleton3.getInstance();
                System.out.println(instance1.hashCode());
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                LazySingleton3 instance1 = LazySingleton3.getInstance();
                System.out.println(instance1.hashCode());
            }
        },"C").start();
    }
}
