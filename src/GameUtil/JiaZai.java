package GameUtil;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import plane.PlaneFrame;


import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

public class JiaZai extends Frame {
	
	public void launchFrame() {//设置窗口
		setSize(Constant.GAME_HIHGT,Constant.GAME_HIHGT);//窗口大小
		setLocation(100,100);//窗口起点
		setVisible(true);//窗口可视化
		
		
		new PaintThread().start();//调用线程
		/**
		 * 关闭窗口按键
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
	///重画窗口的线程类，是一个内部类
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
