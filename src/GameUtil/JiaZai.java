package GameUtil;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import plane.PlaneFrame;


import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

public class JiaZai extends Frame {
	
	public void launchFrame() {//���ô���
		setSize(Constant.GAME_HIHGT,Constant.GAME_HIHGT);//���ڴ�С
		setLocation(100,100);//�������
		setVisible(true);//���ڿ��ӻ�
		
		
		new PaintThread().start();//�����߳�
		/**
		 * �رմ��ڰ���
		 */
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	 Image offScreenImge=null;
	public void update(Graphics g) {
		if(offScreenImge==null)
	offScreenImge=this.createImage(Constant.GAME_WIDTH,Constant.GAME_HIHGT);
	   Graphics gOff= offScreenImge.getGraphics();
	   paint(gOff);
	   g.drawImage(offScreenImge, 0, 0, null);
			
	}
	///�ػ����ڵ��߳��࣬��һ���ڲ���
 class PaintThread extends Thread{
	 public void run() {
		 while(true) {
			 repaint();
			 try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
	 }
 }
public void jiaZai() {
	// TODO Auto-generated method stub
	
}
}
