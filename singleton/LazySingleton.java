package singleton;

public class LazySingleton {
    private volatile static LazySingleton instance = null;

    private LazySingleton() {
    }

    //为了避免多个线程同时调用getInstance方法
//    synchronized public static LazySingleton getInstance() {
//        if (instance == null) {
//            instance = new LazySingleton();
//        }
//        return instance;
//    }

    //但是这种方式仍然会有线程不安全问题，假如现在同时有两个线程A和线程B调用getInstance()方法，此时instance为空止，
    // 因此两个线程都可通过if (instance == null)判断。加入线程A先获得锁进入执行，
    // 但是此时线程B只需等待A释放锁后获取锁即可再次创建实例。因此，我们需要在获得锁后再次进行检查判断，也就是双重检查锁。
//    public static LazySingleton getInstance() {
//        if (instance == null) {
//            synchronized (LazySingleton.class) {
//                instance = new LazySingleton();
//            }
//        }
//        return instance;
//    }

    //双重检查锁
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

}
