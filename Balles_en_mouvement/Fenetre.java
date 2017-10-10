import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Fenetre extends JPanel{
	Ball[] Bac = new Ball[20];
	JButton startButton = new JButton("start");
	JButton stopButton = new JButton("stop");
	JButton plusButton = new JButton("+");
	JButton moinsButton = new JButton("-");
	JLabel horloge = new JLabel(" Temps: 0 s");
	JLabel score = new JLabel(" Score : 0 ");
	Animation anim = new Animation(Bac,score,100);
	Horloge hor = new Horloge(horloge);
	public Fenetre() {
		JFrame frame = new JFrame("Balles en mouvement");
		this.setPreferredSize(new Dimension(600, 800));
		this.setIgnoreRepaint(true);
		this.setLayout(new BorderLayout());
		JPanel flowpane = new JPanel(new FlowLayout());
		
		flowpane.add(startButton);
		flowpane.add(stopButton);
		flowpane.add(plusButton);
		flowpane.add(moinsButton);
		flowpane.add(horloge);
		flowpane.add(score);
		
		this.add(flowpane,BorderLayout.PAGE_END);
		ButtonHandler buttonHandler = new ButtonHandler();
		startButton.addActionListener(buttonHandler);
		stopButton.addActionListener(buttonHandler);
		plusButton.addActionListener(buttonHandler);
		moinsButton.addActionListener(buttonHandler);
		
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true){repaint();}
		
	}
	public void paint(Graphics g){
		super.paint(g);
		for(int i=0;i<Bac.length;i++){
			if(Bac[i]!=null){
				Graphics2D ball = (Graphics2D) g;
				ball.setColor(new Color((int) (Math.random() * 255),(int) (Math.random() * 255),(int) (Math.random() * 255)));
				ball.fillOval(Bac[i].x, Bac[i].y, 50, 50);
				}
			}
	}
	public void ajouterBall(){
		Ball b=new Ball((int) (Math.random() * 600), (int)( Math.random() * 800), 50);
		for(int i=0;i<Bac.length;i++){
			if(Bac[i]==null){
				Bac[i]=b;
				break;
			}
		}
	}
	public void supprimerBall(){
		for(int i=0;i<Bac.length;i++){
			if(Bac[i]!=null){
				Bac[i]=null;
				break;
			}
		}
	}
	private class ButtonHandler implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			JButton source = (JButton)e.getSource();
			
			if (source == startButton )
			{
				anim.start();
				hor.start();
			}
			if (source == stopButton )
			{
				anim.interrupt();
				hor.interrupt();
			}
			if (source == plusButton)
			{
				ajouterBall();
			}
			
			if (source == moinsButton)
			{
				supprimerBall();
			}
			
			
		}
	}
}
