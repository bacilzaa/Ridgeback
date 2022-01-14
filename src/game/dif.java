package gametest;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class dif {
	Timer loop;
	public dif() {
		loop = new Timer(2250,new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
			}   
	    }); 
			
		
	}
}
