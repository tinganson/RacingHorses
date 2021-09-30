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
        Button start = new Button("�_ʼ");
        start.setBounds(275,700,80,40);







        /* Label */

        Label   bet         = new Label("ـ�� : ");
        Label   horse       = new Label("̖�a : ");
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
                    JOptionPane.showMessageDialog(null, "�Ȅe�P������ϲ�ゃ�_���[�سɾ�\n�@��ģ�ͽM��*1", "�[��Y��", JOptionPane.PLAIN_MESSAGE,wait);
                    chance=-1;
                }
                else if(chance>=1)
                {
                    JOptionPane.showMessageDialog(null, "�Ȅe�P�����P�����ゃ�yӋ�֔�", "�[��Y��", JOptionPane.PLAIN_MESSAGE,wait);
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
                        String  str      = s1.replace("��ʹ�÷e�� ","");
                        String  str2     = s2.replace("���@�÷e�� ","");
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
                                    h1.start();//���ӈ��оw
                                }
                                if(chance<1)
                                {
                                    /*if(sum==0)
                                    {
                                        JOptionPane.showMessageDialog(null, "�Ȅe�P������ϲ�ゃ�_���[�سɾ�\n�@��ģ�ͽM��*1", "�[��Y��", JOptionPane.PLAIN_MESSAGE,wait);
                                    }*/
                                    JOptionPane.showMessageDialog(null, "�C���њw�㣬����ʹ��"+betSum+"\n�ҿ��e�֫@��"+sum+"��", "�[��Y��", JOptionPane.PLAIN_MESSAGE, bye);
                                    JOptionPane.showMessageDialog(null, "ף��ӭ������_����\n\nby����ȫ�w�����ˆT", "�[��Y��", JOptionPane.PLAIN_MESSAGE,thank);
                                }
                                chance--;
                            }
                            else if ((a>=1)&&(a<=10))
                            {
                                if ((b<1)||(b>5))
                                {
                                    JOptionPane.showMessageDialog(null, "Ո�� 1 ~ 5 ̖���x��", "̖�a�e�`", JOptionPane.PLAIN_MESSAGE,error);
                                }
                            }
                            else if ((b>=1)&&(b<=5))
                            {
                                if ((a<1)||(a>500))
                                {
                                    JOptionPane.showMessageDialog(null, "ـ�𲻵ó��^ 500 ", "ـ���e�`", JOptionPane.PLAIN_MESSAGE,error);
                                }

                            }
                            else if(((a<1)||(a>500))&&((b<1)||(b>5)))
                            {
                                JOptionPane.showMessageDialog(null, "ـ�𲻵ó��^ 500 �e����Ո�� 1 ~ 5 ̖���x��", "ـ���̖�a�e�`", JOptionPane.PLAIN_MESSAGE,error);
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
                        JOptionPane.showMessageDialog(null, win+"̖�@�٣���ݔ��", "�Y��", JOptionPane.PLAIN_MESSAGE,loseg);
                        JOptionPane.showMessageDialog(null, "����ـ�� "+a+" �w��", "�e��", JOptionPane.PLAIN_MESSAGE,loseg);
                    }
                    else
                    {
                        sum=sum+(a*1.5);
                        JOptionPane.showMessageDialog(null, win+"̖�@�٣����A��","�Y��", JOptionPane.PLAIN_MESSAGE,wing);
                        JOptionPane.showMessageDialog(null, "����ـ�� "+a+"���@��"+a*1.5+"��", "�e��", JOptionPane.PLAIN_MESSAGE,wing);
                    }
                    Init.setLabelText(score[0],betSum,720,650,100,20);
                    Init.setLabelText(score[1],sum,720,700,100,20);
                    if(chance>0)
                    {
                        JOptionPane.showMessageDialog(null, "ʣ��"+chance+"�ΙC��", "�C��", JOptionPane.PLAIN_MESSAGE,remain);
                    }
                    if(chance==0)
                    {
                        JOptionPane.showMessageDialog(null, "�C�����ñM", "�C��", JOptionPane.PLAIN_MESSAGE,remain);
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