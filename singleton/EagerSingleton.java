package singleton;

//饿汉单例模式
public class EagerSingleton {
    //保证一个类只有一个实例
    private final static EagerSingleton instance = new EagerSingleton();

    //私有构造器，只能自行创建实例
    private EagerSingleton() {
    }

    //必须向系统提供这个实例
    public static EagerSingleton getInstance(){
        return instance;
    }


}
