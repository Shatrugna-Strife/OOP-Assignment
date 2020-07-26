import java.awt.*;
import java.awt.event.*;


class Moderator extends Frame implements ActionListener {
    Info info;
    int range=0;
    Button temp;
    TextField enter_range;
    Label enter_value;
    Label timer;
    Label value;
    Moderator(Info info){
        this.info = info;
        temp = new Button("Submit");
        enter_range = new TextField();
        enter_value = new Label();
        timer = new Label();
        value = new Label();
        enter_value.setBounds(500/2-100/2, 500/2-100, 100, 30);
        timer.setBounds(450, 50, 50, 20);
        enter_range.setBounds(500/2 - 100/2, 500/2-50, 200, 20);
        value.setBounds(500/2, 500/2, 200, 200);
        temp.setBounds(500/2 - 100/2, 500/2, 100, 30);
        enter_value.setText("Enter an Integer.");
        value.setText("");
        add(enter_value);
        add(temp);
        add(enter_range);
        add(timer);
        add(value);
        // temp.addActionListner(this);
        temp.addActionListener(this);
        enter_range.addActionListener(this);
        setSize(500, 500);
        setLayout(null);
        setTitle("Kush Assignmnet");
        setBackground(Color.lightGray);
        setVisible(true);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
    }
    public void actionPerformed(ActionEvent event){
        try{
            range = Integer.parseInt(enter_range.getText());
        }catch(NumberFormatException e){
            System.out.println("Enter only Integer");
            return;
        }

        remove(temp);
        remove(enter_range);
        enter_value.setText("");
        // new ModeratorThread(info, this).start();
        new Initialize(this, info, range);
    }
    // public static void main(String args[]){
    //     new Moderator(new Info());
    // } 
}