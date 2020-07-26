public class Initialize {
    Moderator gui;
    Info info;
    int player_no;
    public Initialize(Moderator gui, Info info, int player_no){
        this.gui = gui;
        this.info = info;
        this.player_no = player_no;
        new ModeratorThread(this.info, this.gui).start();
        for(int i = 0; i<this.player_no; i++){
            new Player(this.info, i+1).start();
        }  
    }
}