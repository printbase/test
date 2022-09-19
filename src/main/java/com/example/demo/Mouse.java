package com.example.demo;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

public class Mouse extends JFrame  {
	boolean active=true;
	Rectangle b;
   public static void main(String[] args) {
	Mouse m = new Mouse();
	
	 
	m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
     
    m.setSize(200, 200);
    m.addWindowStateListener(new WindowStateListener() {

		@Override
		public void windowStateChanged(WindowEvent e) {
			System.out.println(e.getID());
			if(e.getID()==WindowEvent.WINDOW_STATE_CHANGED) {
				m.active=m.getState()!=Frame.ICONIFIED;
				if(m.active)m.b=new Rectangle( m.getBounds());
				System.out.println(m.active);
			}
		} 
      
    });
    m.show();
    m.b=m.getBounds();
     new Thread(()->{
    	 while(true) {
    		 try {
    			 if(m.active) {
	    		 Robot r= new Robot();
	    		 r.mouseMove(
	    				 m.b.x + (int)(Math.random()*m.b.width),
	    				 m.b.y + (int)(Math.random()*m.b.height)
	    				 );
    		   
    			 }
				Thread.sleep(30000);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	 }
    	 
     }).start();  ;
}

}
