import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Init {

    public static void InitWin(Frame v)
    {
        v.setTitle("2020迎新賭馬");
        v.setIconImage(v.getToolkit().getImage("images\\icon.jpg"));
        //v.setUndecorated(true);
        v.setResizable(false);
        v.setSize(1050,800);
        v.setLocation(300,10);
        v.setLayout(null);
        v.setVisible(true);

    }
    public static void setButton(Button b, int weigh, int height, int x, int y)
    {
        b.setSize(weigh,height);
        b.setLocation(x,y);
    }

    public static void setLabelText(Label b1, int a, int x, int y,int weigh, int height)
    {
        b1.setBounds(x,y,weigh,height);
        b1.setText("已使用積分 "+a);
    }
    public static void setLabelText(Label b2, double a, int x, int y,int weigh, int height)
    {
        String str=Double.toString(a);
        b2.setText("總獲得積分 "+str);
        b2.setBounds(x,y,weigh,height);
    }

    public  static  boolean isNumeric(String str)
    {
        for ( int i=str.length();--i>=0 ;)
        {
            int chr= str.charAt(i);
            if (chr <48 || chr>57 )
            {
                return  false ;
            }
        }
        return  true ;
    }
}