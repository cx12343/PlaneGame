package plane;

import java.awt.*;  
import java.awt.event.*;  
  
public class Test {  
  
    Frame fr = new Frame("KeyEvent...");  
    public Test(){  
        fr.setLocation(300, 300);  
        fr.setVisible(true);  
        fr.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e){  
                System.exit(0);  
                fr.setVisible(false);  
            }  
        });  
        fr.addKeyListener(new KeyAdapter(){  
            public void keyPressed(KeyEvent e){  
                int keycode = e.getKeyCode();  
                if(keycode == KeyEvent.VK_UP){  
                    System.out.println("UP");  
                }  
            }  
        });  
    }  
    public static void main(String[] args) {  
          
        new Test();  
  
    }  
  
}  