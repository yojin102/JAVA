public class Main {
    public static void main(String[] args){
        ex4Thread t1 = new ex4Thread("A");
        ex4Thread t2 = new ex4Thread("B");
        ex4Thread t3 = new ex4Thread("C");
        int priority_t1 = Integer.parseInt(args[0]);
        int priority_t2 = Integer.parseInt(args[1]);
        t1.setPriority(priority_t1);
        t2.setPriority(priority_t2);
        t3.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
