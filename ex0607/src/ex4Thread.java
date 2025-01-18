public class ex4Thread extends Thread{
    public ex4Thread(String str){
        setName(str);
    }
    public void run(){
        for(int i = 1; i<5; i++){
            System.out.println(i + " " + getName() + " Priority : " + getPriority());
        }
    }
}
