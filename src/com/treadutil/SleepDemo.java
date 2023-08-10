package com.treadutil;

class UserDetailsThread extends Thread {
    public void run() {
        try 
        {
            Thread.sleep(5000);
            System.out.println("Hello user");
        } 
        catch (InterruptedException e) 
        {
        	System.out.println("Sleep interrupted");
        }
    }
}

class CountThread extends Thread {
    public void run() {
        while (UserDetailsThread.currentThread().isAlive()) {
            System.out.println("Count:...... ");
            try 
            {
                Thread.sleep(2000);
            } 
            catch (InterruptedException e) {
                System.out.println("Sleep interrupted");
            }
        }
    }
}
public class SleepDemo {

	public static void main(String[] args) {
		    UserDetailsThread userDetailsThread = new UserDetailsThread();
	        CountThread countThread = new CountThread();
	        
	        
	        countThread.start();
	        userDetailsThread.start();
	        try {
	        countThread.join();
	        userDetailsThread.join();
	        }catch(Exception e) {
	        	System.out.println("Ended");
	        }
	}

}
