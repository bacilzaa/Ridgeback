package gametest;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class collectEn implements ActionListener{
	
	public static int hpcount ;
	public static ArrayList<HS> arrhp = new ArrayList<HS>();
	HS hp;
	Timer loop;
	ControllE cn;
	
	public collectEn() {
		loop = new Timer(100,this);
		loop.start();
	}
	
	public void draw(Graphics2D g2){
		for(int i = 0 ; i<arrhp.size();i++){
			hp = arrhp.get(i);
			hp.draw(g2);
		}
	}
	
	 public void addhp(HS ene) {
		  arrhp.add(ene);
	  }
	  
	  public void removehp(HS ene) {
		  arrhp.remove(ene);
	  }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
			if(hpcount == 0){
		addhp(new HS(60,0));
		addhp(new HS(40,0));
		addhp(new HS(20,0));
		hpcount++;
			}
		
	}
}
