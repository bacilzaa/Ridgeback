package game.util;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import game.entity.Heart;

public class collectEn implements ActionListener {

	public static int hpcount;
	public static ArrayList<Heart> arrhp = new ArrayList<Heart>();
	Heart hp;
	Timer loop;
	EntityGroup cn;

	public collectEn() {

	}

	public void draw(Graphics2D g2) {
		for (int i = 0; i < arrhp.size(); i++) {
			hp = arrhp.get(i);
			hp.draw(g2);
		}
	}

	public void addhp(Heart ene) {
		arrhp.add(ene);
	}

	public void removehp(Heart ene) {
		arrhp.remove(ene);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (hpcount == 0) {
			addhp(new Heart(60, 0));
			addhp(new Heart(40, 0));
			addhp(new Heart(20, 0));
			hpcount++;
		}

	}*/
}
