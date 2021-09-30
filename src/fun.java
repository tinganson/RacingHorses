/*fun = function, Library */
import java.awt.*;
import javax.swing.*;


public class fun
{
    public static int Rand(int n)
    {return((int)(Math.random()*n));}
    public static boolean checkInput(String B, String N,ImageIcon error)
    {
        if((Init.isNumeric(N)==false)&&(Init.isNumeric(B)==false))
        {
            JOptionPane.showMessageDialog(null, "請在賭金輸入 1-10 的整數\n且在馬號輸入 1-5  的整數", "賭金和號碼錯誤", JOptionPane.PLAIN_MESSAGE,error);
        }
        else if(Init.isNumeric(N)==false)
        {
            JOptionPane.showMessageDialog(null, "請在馬號輸入 1-5 的整數", "馬號錯誤", JOptionPane.PLAIN_MESSAGE,error);
        }
        else if(Init.isNumeric(B)==false)
        {
            JOptionPane.showMessageDialog(null, "請在賭金輸入 1-10 的整數", "賭金錯誤", JOptionPane.PLAIN_MESSAGE,error);
        }
        else if((B.equals(""))&&(N.equals("")))
        {
            JOptionPane.showMessageDialog(null, "請輸入賭金和馬號", "賭金和號碼錯誤", JOptionPane.PLAIN_MESSAGE,error);
        }
        else if(N.equals(""))
        {
            JOptionPane.showMessageDialog(null, "請輸入馬的號碼", "號碼錯誤", JOptionPane.PLAIN_MESSAGE,error);
        }
        else if(B.equals(""))
        {
            JOptionPane.showMessageDialog(null, "請輸入賭金", "賭金錯誤", JOptionPane.PLAIN_MESSAGE,error);
        }
        else
            {
                return true;
            }
        return false;
    }

    public static void reTrack( Graphics2D g2)
    {

        Color NRED = new Color(235, 0, 0);

        /*EndLine*/
        g2.setColor(NRED);
        g2.fillRect(910, 190, 50, 290);

        g2.setColor(Color.white);
        g2.fillRect(900, 190, 10, 290);

        /*Finish*/
        String[] str3={"F","I","N","I","S","H"," ","L","I","N","E"};
        g2.setColor(Color.white);
        g2.fillRect(900, 190, 10, 290);
        for(int i=0;i< str3.length;i++)
        {

            g2.setFont(new Font("GAMERIA", Font.PLAIN, 25));
            g2.drawString(str3[i],920,225+i*25);
        }

        /*Track*/
        for(int i=0;i<5;i++)
        {
            g2.setColor(NRED);
            g2.fillRect(90, 190+i*60, 810, 50);
        }

        /*TNum*/
        String[] str4={"1","2","3","4","5"};
        g2.setColor(Color.white);
        for(int j=0;j< str4.length;j++)
        {

            g2.setFont(new Font("GAMERIA", Font.PLAIN, 30));
            g2.drawString(str4[j],100,225+j*60);
        }

        /*StartLine*/
        g2.setColor(Color.white);
        g2.fillRect(190, 190, 10, 290);

    }


}
