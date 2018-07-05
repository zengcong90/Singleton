public class Singleton {
    //懒汉式单例模式（线程不安全）
    private static Singleton instance;
    //增加一个记录对象次数的变量
    private static int count;
    private Singleton(){

        System.out.println("Singleton私有的构造方法被实例化"+ (++count) +"次");
    }
    public static Singleton getA( ){
            if(instance==null){
                instance = new Singleton();
            }
        return instance;
    }

}
