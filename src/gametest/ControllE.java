package gametest;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

//��� object enermy
public class ControllE implements ActionListener{
  static ArrayList<Enermy> e =new ArrayList<Enermy>();
  Enermy em;
  private Timer loop;
  Player p;
  public static int count;
  public static int end,GO;
  

  public ControllE(int s) {
	  loop = new Timer(s, this);
	  loop.start();

  }
  
  public void draw(Graphics2D g2) {
	  for(int i = 0;i<e.size();i++) {
		  em =e.get(i);
		  em.draw(g2);
		  
	  }
  }
  
  public void updat(int s) {
	  for(int i = 0;i<e.size();i++) {
		  em = e.get(i);
		  em.update(s);
	  }
  
  }
  
  public void addEnemy(Enermy ene) {
	  e.add(ene);
  }
  
 
  
  public void removeEnemy(Enermy ene) {
	  e.remove(ene);
  }
  //get border enermy ���е��
  public static ArrayList<Enermy> getBorder(){
	  return e;
  }
  
  public void clear(){
	  e.clear();
  }
  
  


@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	  if(end > 0){
		  if(GO < 1) {
		  System.out.println("Game Over");
		  GO++;
		  }
	  }
	  else {
	  		addEnemy(new Enermy(new Random().nextInt(600),0));
	  		System.out.println("Count :"+count);
			 count += 1;
	  }
	  

	  
	}
}
