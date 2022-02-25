package com.liuqiang.design.singleton;

/**
 * 线程不安全懒汉式
 * 1. 构造器私有化
 * 2. 类的内部创建对象
 * 3. 提供静态公有方法创建实例
 * @author yiche
 */
class LazySingleton{
    /** 构造器私有化 **/
    private LazySingleton() {
    }

    /** 类内部创建对象 **/
    private static LazySingleton Instances;

    /** 提供静态公有方法创建实例**/
    private static LazySingleton getInstance(){
        if (Instances == null) {
            return  new LazySingleton();
        }
        return Instances;
    }
}
public class LazySingleton01 {
}
