import java.util.ArrayList;
import java.util.Random;

public class ModeratorThread extends Thread{
    private Info info;
    private Moderator gui;
    public ModeratorThread(Info info, Moderator gui){
        this.info = info;
        this.gui = gui;
    }
    public void run(){
        Random rand = new Random();
        // for(int i =0;i<10;i++){
        //     card.add(rand.nextInt(50 -1)+1);
        //     // System.out.println(1+rand.nextInt(49));
        // }
        for(int i= 0;i<10;i++){
            int tmp = rand.nextInt(50 -1)+1;
            info.val = tmp;
            gui.value.setText(Integer.toString(tmp));
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                System.out.println("Interrupted");
            }
            if(info.done == true)break;
            
            // System.out.println(info.winner);
        }
        System.out.println(info.winner);
        System.out.println(info.done_array);
        // System.out.println(card);
    }
    public void start(){
        new Thread(this).start();
    }
}