public class singletonA {
    //懒汉式单例模式（线程不安全）
    private static singletonA instance;
    //增加一个记录对象次数的变量
    private static int count;
    private singletonA(){

        System.out.println("singletonA私有的构造方法被实例化"+ (++count) +"次");
    }
    public static singletonA getA( ){
            if(instance==null){
                instance = new singletonA();
            }
        return instance;
    }

}
