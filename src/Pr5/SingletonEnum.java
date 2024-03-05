package Pr5;

class SingletonLazy {

    private static volatile SingletonLazy instance;
    private SingletonLazy() {};
    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) instance = new SingletonLazy();
            }
        }
        return instance;
    }

}

class SingletonStaticBlock {
    private static final SingletonStaticBlock instance;
    static {
        try {
            instance = new SingletonStaticBlock();
        }catch (Exception e) {
            throw  new RuntimeException("Exc created due to creating singleton instance");
        }
    }
    private  SingletonStaticBlock() {}
    public static SingletonStaticBlock getInstance() {
        return instance;
    }
}

public enum SingletonEnum {
    INSTANCE;
}

class Main {
    public static void main(String[] args) {
        SingletonLazy i1 = SingletonLazy.getInstance();
        SingletonLazy i2 = SingletonLazy.getInstance();
        System.out.println(i1 == i2);

        SingletonStaticBlock i3 = SingletonStaticBlock.getInstance();
        SingletonStaticBlock i4 = SingletonStaticBlock.getInstance();
        System.out.println(i3 == i4);

        SingletonEnum i5 = SingletonEnum.INSTANCE;
        SingletonEnum i6 = SingletonEnum.INSTANCE;
        System.out.println(i5 == i6);
    }
}
