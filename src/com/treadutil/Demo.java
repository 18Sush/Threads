package com.treadutil;
class PrintNames implements Runnable {
	private String[] names = {"Peter", "Sam", "Edgar", "Mathew", "Simond"};
	public synchronized void printArray() {
        for (String s : names) {
            System.out.println(s);
        }
    }
	public void run() {
        printArray();
    }
}
public class Demo {
	public static void main(String[] args) {
		PrintNames pn = new PrintNames();
        Thread th1 = new Thread(pn);
        Thread th2 = new Thread(pn);
        th1.start();
        th2.start();
    }
}
