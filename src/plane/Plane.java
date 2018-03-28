package plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import GameUtil.GameUtil;

public class Plane {
	double x,y;
	Image plane;
	boolean left,up,right,down;
	int speed=6;
	int width,height;
	
	public Rectangle getRect() {
		return new Rectangle((int)x/2,(int)y/2,width/2,height/2);
		
	}
	
		public Plane ( String path,double x,double y) {
		super();
		this.x=x;
		this.y=y;
		this.plane=GameUtil.getImages(path);
		this.width=plane.getWidth(null);
		this.height=plane.getHeight(null);
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(plane,(int)x,(int)y, null);
		move();
		
	}
	public void move() {
		if(left) {
			x-=speed;
		}
		if(right) {
			x+=speed;
		}
		if(up) {
			y-=speed;
		}
		if(down) {
			y+=speed;
		}
		
	}
	public void addfangxiang(KeyEvent e){
		 switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				left=false;
				break;
			case KeyEvent.VK_UP:
				up=false;
				break;
			case KeyEvent.VK_RIGHT:
				right=false;
				break;
			case KeyEvent.VK_DOWN:
				down=false;
				break;
			default:
				break;
			}
	}
	public void addfangxiang02(KeyEvent e){
		  switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				left=true;
				break;
			case KeyEvent.VK_UP:
				up=true;
				break;
			case KeyEvent.VK_RIGHT:
				right=true;
				break;
			case KeyEvent.VK_DOWN:
				down=true;
				break;
			default:
				break;
			}
	}
	
}
