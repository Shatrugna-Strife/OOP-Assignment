import java.util.ArrayList;
import java.util.Random;

class Player extends Thread {
    int playerNo;
    private Info info;
    int prev = 0;
    public Player(Info info, int playerNo){
        this.info = info;
        this.playerNo = playerNo;
    }
    ArrayList<Integer>card = new ArrayList<Integer>();
    ArrayList<Integer>temp = new ArrayList<Integer>();
    public void run(){
        Random rand = new Random();
        for(int i =0;i<10;i++){
            card.add(rand.nextInt(50 -1)+1);
            temp.add(card.get(i));
            // System.out.println(1+rand.nextInt(49));
        }
        while(true){
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){
                System.out.println("Interrupted");
            }
            if(info.val == -1)break;
            if(info.done == true)break;
            if(prev == info.val)continue;
            for(int i =0;i<temp.size();i++){
                if(card.get(i) == info.val)temp.set(i, 0);
            }
            int tmp = 0;
            for(int i =0;i<temp.size();i++){
                if(temp.get(i) == 0)tmp+=1;
                else tmp = 0;
                if(tmp == 3){
                    info.done = true;
                    info.done_array = card;
                    info.winner = playerNo;
                }
            }
            prev = info.val;
        }
        // System.out.println(card);
        // System.out.println(info.val);
        // info.val +=1;
    }
    public void start(){
        new Thread(this).start();
    }
}