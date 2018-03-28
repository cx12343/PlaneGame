package plane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import GameUtil.*;


public class PlaneFrame extends JiaZai {
	Image bj = GameUtil.getImages("img/bj.jpg");
	Plane me = new Plane("img/01.jpg", 50, 50);
	ArrayList bulletlist =new ArrayList();
	boolean live=true;
	int jishi;
	 Date  start;
	 Date   end;
	
	public void paint(Graphics g) {
		g.drawImage(bj, 0, 0, null);
		if(live==true) {
		me.draw(g);
		}
		for(int i=0;i<bulletlist.size();i++) {
			Bullet b = (Bullet)bulletlist.get(i);
			b.draw(g);
			
			//检查和飞机的碰撞
		boolean peng=	b.getRect().intersects(me.getRect());
			if(peng) {
				live =false;
				jishi++;
				if(jishi==1) {
				 end= new Date();
				
				}
			}
		}
		if(live==false) {
			long t= (end.getTime()-start.getTime())/1000;
			//System.out.println(end);
			//System.out.println(start);
			print(g,"GAME OVER",50,Constant.GAME_WIDTH/2-125,Constant.GAME_HIHGT/2-5);
			print(g,"存活时间："+t+"秒",20,Constant.GAME_WIDTH/2-75,Constant.GAME_HIHGT/2+20);
		}
	}
	
	public void print(Graphics g,String str,int size,int x,int y){
		Font f= new Font("宋体", Font.BOLD, size);
		
		g.setFont(f);
		g.drawString(str, x, y);
	}
	
	public static void main(String[] args) {
		
	new PlaneFrame().JiaZai();

		
	}
	public  void JiaZai(){
		super.launchFrame();
		start= new Date();
		
		addKeyListener(new K());
		//生产子弹
		System.out.println("666");
		for (int i=0;i<50;i++) {
			Bullet b= new Bullet();
			bulletlist.add(b);
		}
		
	}
	//内部类方便使用外部类的普通属性
	class K extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("按下："+e.getKeyCode() );
		 me.addfangxiang02(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("释放：" +e.getKeyCode());
			  me.addfangxiang(e);
		}
		
	}
			
			
			
			
	 
}
