# Singleton
单例模式分为懒汉式和恶汉式

##懒汉式
public class Singleton{
  private static Singleton instance;
  //设置一个私有属性记录Singleton实例化次数
  private static int count;
  //私有构造器
  private Singleton(){
    System.out.println("Singleton被初始化："+(++count)+"次");
  }
  //公开对外的方法
  public static Singleton getInstance(){
         if(instance==null){
            instance = new Singleton();
        }
        return instance;
     }
  }
 
 ==================多线程环境测试线程安全性===================
 public class  text{
    public static void main(String[] args){
          Runnable task = ()->{
              String  threadName =Thread.currentThread().getName();//获取线程的名字
              Singleton singleton =Singleton.getInstance();
              System.out.println("线程："+threadName+"\t =>"+singleton.hashCode()); //这里hashCode()是为了证明确实生成了不同的对象，因为每一                                                                                       个对象都会拥有一个唯一的hash值
          }
          for(int i=0;i<100;i++){//遍历一百次
              new Thread(task,""+i);//创建一个线程
          }
   }
 
 }
 ===============测试结果===================
 singletonA私有的构造方法被实例化1次
线程：0	 =>1460671721
线程：4	 =>1460671721
线程：2	 =>1460671721
singletonA私有的构造方法被实例化4次
线程：5	 =>524254826
singletonA私有的构造方法被实例化2次
线程：8	 =>524254826
singletonA私有的构造方法被实例化3次
线程：3	 =>956261507
线程：6	 =>166474485
线程：9	 =>956261507
线程：1	 =>1460671721
线程：10	 =>956261507
线程：7	 =>956261507
线程：12	 =>956261507
线程：11	 =>956261507
线程：13	 =>956261507
线程：14	 =>956261507
线程：16	 =>956261507
。
。（下面都一样的hash值就省略不写了）
。
、
##加锁解决线程安全问题
要想线程安全可以在getInstance()前加上synchronized 一把锁，这样可以解决线程安全问题，但是随之而来的是对每一个执行该代码的线程都会加锁，实际开发中90%的情况时不需要同步的，这样反而效率太低了，安全但是效率太低这是硬伤
、
    public static synchronized singletonA getA( ){
            if(instance==null){
                instance = new singletonA();
            }
        return instance;
    }
、
    
##恶汉式
public class Singleton {
    // 把"唯一的"对象保存在单例类的属性里
    private static Singleton instance = new Singleton();

    // 构造器私有化,不能在类的外部随意创建对象
    private Singleton(){}

    // 提供一个全局的访问点来获得这个"唯一"的对象
    public static Singleton getInstance(){
        return instance;
    }
}
