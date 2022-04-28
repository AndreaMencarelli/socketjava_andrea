/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author Andrea
 */
public class Countdown extends Thread{ 
    int time;
    
    public Countdown(int time) { 
        this.time=time;
        
    }
    public void run() {
      
        for(int c=time;c>0;c--) {
            System.out.println(c);
  
           
        }
    }
}
