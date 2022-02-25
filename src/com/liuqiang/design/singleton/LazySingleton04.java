package com.liuqiang.design.singleton;

/**
 * 使用枚举类的方式创建单例，不仅能避免线程同步，而且还能防止反序列化重新创建新的对象
 * @author yiche
 */
enum LazySingle4{
    /** 创建实例**/
    INSTANCE;


}
public class LazySingleton04 {
    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                LazySingle4 instance = LazySingle4.INSTANCE;
                System.out.println(instance.hashCode());
            }

        },"A").start();
    }
}
