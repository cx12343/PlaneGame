package plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import GameUtil.Constant;



public class Bullet {
	Image img;
	double x,y;
	int speed=3;
	double degree;
	int width=10;
	int height=10;		
	
	public Rectangle getRect() {
		return new Rectangle((int)x/2,(int)y/2,width/2,height/2);
		
	}
	
	public Bullet() {
		degree = Math.random()*Math.PI*2;
		x=Constant.GAME_HIHGT/2;
		y=Constant.GAME_WIDTH/2;
	}
	
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		g.fillOval((int)x, (int)y, width, height);
		x +=speed*Math.cos(degree);
		y +=speed*Math.sin(degree);
		
		if (y>Constant.GAME_HIHGT-height) {
			degree=-degree;
		}
		if(y<height){
			degree =-degree;
		}
		if(x<width) {
			degree=Math.PI-degree;
		}
		if(x>Constant.GAME_HIHGT-width) {
			degree= Math.PI -degree;
		}
		
		g.setColor(c);
	}
}
