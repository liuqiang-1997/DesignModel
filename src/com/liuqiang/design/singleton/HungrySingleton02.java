package com.liuqiang.design.singleton;

/**
 * 静态代码块饿汉式单例模式
 1. 构造器私有化
 2. 类的内部创建对象
 3. 静态代码块中创建单例对象
 4. 向外暴露一个静态的公共方法
 * @author yiche
 */

class SingletonTest2{

    /**私有化构造器**/
    private SingletonTest2() {
    }
    /** 类的内部创建对象**/
    private final static SingletonTest2 SINGLETON_TEST;

    /** 静态代码块中创建单例对象**/
    static {
        SINGLETON_TEST = new SingletonTest2();
    }
    /**向外暴露一个静态的公共方法**/
    public static SingletonTest2 getInstance(){
        return SINGLETON_TEST;
    }

}


public class HungrySingleton02 {
    public static void main(String[] args) {

    }
}
