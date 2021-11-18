package learning.base.throwLearn;

/**
 * @description
 * @author:Gjc
 * @time: 15:59
 * @date: 2021-11-08
 */


public class Ticket implements Runnable{
    private  int  tickets = 100;

    @Override
    public void run() {
       while (tickets>0){
           synchronized (this){
               if (tickets>0){
//                   try {
//                       Thread.sleep(100);
//                   } catch (InterruptedException e) {
//                       e.printStackTrace();
//                   }
                   this.sell();

               }
           }

       }
    }

    public synchronized void sell(){
        if (tickets>0){
            System.out.println(Thread.currentThread().getName()+"正在出售第 "+tickets+" 张票");
            tickets--;
        }
    }

    public static void main(String[] args) {
        Ticket t = new Ticket();
        Thread t1= new Thread(t,"窗口1");
        Thread t2= new Thread(t,"窗口2");
        Thread t3= new Thread(t,"窗口3");
        Runnable runnable = () -> {
            System.out.println("im"+Thread.currentThread().getName());
        };
        Thread t4 = new Thread(runnable,"lambda");
        t4.start();
        t1.start();
        t2.start();
        t3.start();
    }
}
