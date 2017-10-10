import java.awt.Color;

import javax.swing.JLabel;

public class Animation extends Thread{
	public Ball[] Bac;
	public JLabel score;
	private int time;
	public int n;
	
	public Animation(Ball[] Bac,JLabel score, int time){
		this.Bac = Bac;
		this.time = time;
		this.score=score;
		this.n=0;
	}
	
	public void run(){
		while(!interrupted()){
			this.moveBall();
			this.ballCollision();
			try {
				sleep(10);
			} catch (InterruptedException e) {}
		}
	}
	
	
	public void movement() throws InterruptedException{
		while(true){
			this.moveBall();
			//this.repaint();
			this.ballCollision();
			sleep(this.time);
		}
	}
	public void moveBall(){
		for(int i=0;i<Bac.length;i++){
			if(Bac[i]!=null){
				Bac[i].x = Bac[i].x + Bac[i].speedX;
				Bac[i].y = Bac[i].y + Bac[i].speedY;
			}
		}
	}
	
	public void ballCollision(){
		for(int i=0;i<Bac.length;i++){
			if(Bac[i]!=null){
				if(Bac[i].x + 50 > 600){
					Bac[i].speedX = Bac[i].speedX > 0 ? -Bac[i].speedX : Bac[i].speedX;
					n=n+1;
					score.setText(" Score : "+n);
				}
			
				if(Bac[i].x < 0){
					Bac[i].speedX = Bac[i].speedX < 0 ? -Bac[i].speedX : Bac[i].speedX;
					n=n+1;
					score.setText(" Score : "+n);
				}
				if(Bac[i].y + 50 > 800){
					Bac[i].speedY = Bac[i].speedY > 0 ? -Bac[i].speedY : Bac[i].speedY;
					n=n+1;
					score.setText(" Score : "+n);
				}
				if(Bac[i].y < 0){
					Bac[i].speedY = Bac[i].speedY < 0 ? -Bac[i].speedY : Bac[i].speedY;
					n=n+1;
					score.setText(" Score : "+n);
				}
			}
		}
	}
	
}
