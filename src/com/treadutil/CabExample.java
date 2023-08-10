package com.treadutil;

class cabDriverName{
	
}
class FirstCab implements Runnable {
	String cabDriverName;
    public FirstCab(String cabDriverName) {
        this.cabDriverName = cabDriverName;
    }
	public void run() {
		synchronized(cabDriverName) {
    		
            try {
            	System.out.println(cabDriverName + " is waiting for passenger...");
                cabDriverName.wait(5000);
                System.out.println(cabDriverName + " is done waiting.");
            } 
            catch (InterruptedException e) {
                System.out.println(e);
            }
		}
	}
}
class NewCab implements Runnable{
	String cabDriverName;
	public NewCab(String cabDriverName){
		this.cabDriverName = cabDriverName;
	}
		public void run() {
			synchronized(cabDriverName){
				try {
					Thread.sleep(2000);
					cabDriverName.notifyAll();
				}catch(Exception e) {
					System.out.println(e);
					
				}
			}
		}
	}

public class CabExample {
	public static void main(String[] args) {
		cabDriverName obj=new cabDriverName();
		 FirstCab firstcab = new FirstCab("Erric");
		 NewCab newcab = new NewCab("Peter");
	     Thread th1 = new Thread(firstcab);
	     Thread th2 = new Thread(newcab);
	     th1.start();
	     th2.start();
	}
}
