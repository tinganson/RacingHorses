import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Racing extends Frame implements Runnable

{
    Image[] img=new Image[5];
    Graphics g=getGraphics();
    Color NRED = new Color(235, 0, 0);

    ImageIcon error = new ImageIcon(getToolkit().getImage("images\\error.png"));
    ImageIcon thank = new ImageIcon(getToolkit().getImage("images\\thank.png"));
    ImageIcon wait = new ImageIcon(getToolkit().getImage("images\\wait.png"));
    ImageIcon bye = new ImageIcon(getToolkit().getImage("images\\bye.png"));
    ImageIcon wing = new ImageIcon(getToolkit().getImage("images\\win.png"));
    ImageIcon loseg = new ImageIcon(getToolkit().getImage("images\\lose.png"));
    ImageIcon remain = new ImageIcon(getToolkit().getImage("images\\remain.png"));

    Button[] bt = new Button[5];
    Label[] score=new Label[2];
    boolean fg=true;
    int px,py=0;
    int win=0;
    double sum=0;
    int betSum=0;
    int a,b;
    int chance=3;

    Racing(){

        Init.InitWin(this);

        /*horse pic*/
        img[0]=getToolkit().getImage("images\\horse2.png");
        img[1]=getToolkit().getImage("images\\horse2.png");
        img[2]=getToolkit().getImage("images\\horse2.png");
        img[3]=getToolkit().getImage("images\\horse2.png");
        img[4]=getToolkit().getImage("images\\horse2.png");

        /*g.drawImage(img[0],100+x,110,80,40,this);*/


        /*Button*/

        for(int i=0;i<5;i++){
            bt[i] = new Button("Horse["+(i+1)+"]");
            Init.setButton(bt[i], 80, 40, 100, 195+i*60);

            px=0;
            py=0;
        }
        Button start = new Button("開始");
        start.setBounds(275,700,80,40);







        /* Label */

        Label   bet         = new Label("賭金 : ");
        Label   horse       = new Label("號碼 : ");
                score[0]    = new Label();
                score[1]    = new Label();


        /*TextField*/

        final TextField gethorse   = new TextField("");
        final TextField getbet     = new TextField("");

        /*setLabel*/

        bet.setBounds(235,600,50,20);
        getbet.setBounds(285,600,100,20);

        horse.setBounds(235,650,50,20);
        gethorse.setBounds(285,650,100,20);

        Init.setLabelText(score[0],betSum,720,650,100,20);
        Init.setLabelText(score[1],sum,720,700,100,20);


        /*add*/

        add(bet);
        add(getbet);
        add(horse);
        add(gethorse);
        add(start);
        add(score[0]);
        add(score[1]);


        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                if(chance==0)
                {
                    JOptionPane.showMessageDialog(null, "先別關掉，恭喜你們達成隱藏成就\n獲得模型組件*1", "遊戲結束", JOptionPane.PLAIN_MESSAGE,wait);
                    chance=-1;
                }
                else if(chance>=1)
                {
                    JOptionPane.showMessageDialog(null, "先別關掉，關主幫你們統計分數", "遊戲結束", JOptionPane.PLAIN_MESSAGE,wait);
                    chance=-1;
                }
                else
                {
                    System.exit(0);
                }

            }
        });



        start.addActionListener(
                new ActionListener()
                {

                    public void actionPerformed(ActionEvent e)
                    {
                        String  betnum   = getbet.getText();
                        String  No       = gethorse.getText();
                        String  s1       = score[0].getText();
                        String  s2       = score[1].getText();
                        String  str      = s1.replace("已使用積分 ","");
                        String  str2     = s2.replace("總獲得積分 ","");
                                betSum   = Integer.parseInt(str);
                                sum      = Double.parseDouble(str2);

                        if(fun.checkInput(betnum,No,error)==false)
                        {

                        }
                        else
                        {
                            a=Integer.parseInt(betnum);
                            b=Integer.parseInt(No );

                            if ((a>=1)&&(a<=500)&&(b>=1)&&(b<=5))
                            {

                                fg=true;

                                if(chance>0)
                                {
                                    Thread h1;
                                    h1 = new Thread(Racing.this::run);
                                    h1.start();//起動執行緒
                                }
                                if(chance<1)
                                {
                                    /*if(sum==0)
                                    {
                                        JOptionPane.showMessageDialog(null, "先別關掉，恭喜你們達成隱藏成就\n獲得模型組件*1", "遊戲結束", JOptionPane.PLAIN_MESSAGE,wait);
                                    }*/
                                    JOptionPane.showMessageDialog(null, "機會已歸零，總共使用"+betSum+"\n且總積分獲得"+sum+"分", "遊戲結束", JOptionPane.PLAIN_MESSAGE, bye);
                                    JOptionPane.showMessageDialog(null, "祝你迎新玩得開心呦\n\nby大三全體工作人員", "遊戲結束", JOptionPane.PLAIN_MESSAGE,thank);
                                }
                                chance--;
                            }
                            else if ((a>=1)&&(a<=10))
                            {
                                if ((b<1)||(b>5))
                                {
                                    JOptionPane.showMessageDialog(null, "請在 1 ~ 5 號做選擇", "號碼錯誤", JOptionPane.PLAIN_MESSAGE,error);
                                }
                            }
                            else if ((b>=1)&&(b<=5))
                            {
                                if ((a<1)||(a>500))
                                {
                                    JOptionPane.showMessageDialog(null, "賭金不得超過 500 ", "賭金錯誤", JOptionPane.PLAIN_MESSAGE,error);
                                }

                            }
                            else if(((a<1)||(a>500))&&((b<1)||(b>5)))
                            {
                                JOptionPane.showMessageDialog(null, "賭金不得超過 500 積分且請在 1 ~ 5 號做選擇", "賭金和號碼錯誤", JOptionPane.PLAIN_MESSAGE,error);
                            }

                        }
                    }
                }
        );


    }


    @Override
    public void run() {
        while(fg){
            g=getGraphics();
            Graphics2D g2=(Graphics2D) g;
            for(int i=0;i<5;i++)
            {

                g2.setColor(NRED);
                g2.fillRect(bt[i].getX(),bt[i].getY(),80,45);

                px = bt[i].getX()+fun.Rand(10);
                py = bt[i].getY();
                bt[i].setLocation(px,py);
                g2.drawImage(img[i],px,py,80,40,this);

                g2.setColor(Color.white);
                g2.fillRect(190, 190, 10, 290);
                //g.fillRect(900, 190, 10, 290);



                String[] str4={"1","2","3","4","5"};
                for(int j=0;j< str4.length;j++)
                {

                    g2.setFont(new Font("GAMERIA", Font.PLAIN, 30));
                    g2.drawString(str4[j],100,225+j*60);
                }



                if(px>830)
                {

                    win=i+1;
                    betSum=betSum+a;
                    if(win!=b)
                    {
                        JOptionPane.showMessageDialog(null, win+"號獲勝，你輸了", "結果", JOptionPane.PLAIN_MESSAGE,loseg);
                        JOptionPane.showMessageDialog(null, "本次賭金 "+a+" 歸零", "積分", JOptionPane.PLAIN_MESSAGE,loseg);
                    }
                    else
                    {
                        sum=sum+(a*1.5);
                        JOptionPane.showMessageDialog(null, win+"號獲勝，你贏了","結果", JOptionPane.PLAIN_MESSAGE,wing);
                        JOptionPane.showMessageDialog(null, "本次賭金 "+a+"，獲得"+a*1.5+"分", "積分", JOptionPane.PLAIN_MESSAGE,wing);
                    }
                    Init.setLabelText(score[0],betSum,720,650,100,20);
                    Init.setLabelText(score[1],sum,720,700,100,20);
                    if(chance>0)
                    {
                        JOptionPane.showMessageDialog(null, "剩下"+chance+"次機會", "機會", JOptionPane.PLAIN_MESSAGE,remain);
                    }
                    if(chance==0)
                    {
                        JOptionPane.showMessageDialog(null, "機會已用盡", "機會", JOptionPane.PLAIN_MESSAGE,remain);
                    }

                    fun.reTrack(g2);
                    for(int j=0;j<5;j++)
                    {

                        Init.setButton(bt[j], 80, 40, 100, 195+j*60);
                        g2.drawImage(img[j],100,195+j*60,80,40,this);
                        px=0;
                        py=0;
                    }
                    fg=false;
                    break;
                }
            }
            try
            {
                Thread.sleep(10);
            }
            catch(Exception e){
            }
        }
    }


    public void paint(Graphics g)
    {
        Graphics2D g2=(Graphics2D) g;
        Image back=getToolkit().getImage("images\\back.png");
        g2.drawImage(back,0,20,this.getWidth(),this.getHeight(),this);

        fun.reTrack(g2);

        for(int i=0;i<5;i++)
        {
            g2.drawImage(img[i],100,195+i*60,80,40,this);
        }



    }

}