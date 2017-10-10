import javax.swing.JLabel;

public class Horloge extends Thread{
	public int time;
	public JLabel hor;
	public Horloge(JLabel hor){
		this.time = 0;
		this.hor=hor;
	}
	public void run(){
		while(!interrupted()){
			try {
				sleep(1000);
			} catch (InterruptedException e) {}
			time = time +1;
			hor.setText(" Temps : "+time+" s");
		}
	}
}
