package com.liuqiang.design.singleton;

/**
 * 静态变量饿汉式单例模式
 * 1. 构造器私有化
 * 2. 类的内部创建对象
 * 3. 向外暴露一个静态的公共方法
 * 4. 代码实现
 * @author yiche
 */

class SingletonTest{

    /**私有化构造器**/
    private SingletonTest() {
    }
    /** 类的内部创建对象**/
    private final static SingletonTest SINGLETON_TEST = new SingletonTest();

    /**向外暴露一个静态的公共方法**/
    public static SingletonTest getInstance(){
        return SINGLETON_TEST;
    }

}


public class HungrySingleton01 {
    public static void main(String[] args) {

        // 证明
        SingletonTest instance = SingletonTest.getInstance();
        SingletonTest instance1 = SingletonTest.getInstance();
        System.out.println(instance.hashCode());  // 1846274136
        System.out.println(instance1.hashCode()); // 1846274136

    }
}
