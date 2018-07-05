public class Main {

    public static void main(String[] args) {
        //懒汉式单利(非线程安全)测试
        Runnable task= ()->{
          String  threadName = Thread.currentThread().getName();
          singletonA a = singletonA.getA();
            System.out.println("线程："+threadName+"\t =>"+a.hashCode());
        };
        for (int i = 0; i <100 ; i++) {
            new Thread(task,""+i).start();
        }
    }
}
