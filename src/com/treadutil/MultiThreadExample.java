package com.treadutil;
import java.util.Scanner;

class UserThread extends Thread {
    private String name;
    private String email;
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter email: ");
        email = scanner.nextLine();
        System.out.println("User details: Name - " + name + ", Email - " + email);
    }
}
class SimpleInterestThread extends Thread {
    public void run() {
        double principalamount = 40000;
        double rate = 4;
        double time = 6;
        double simpleinterest = (principalamount * rate * time) / 100;
        System.out.println("Simple Interest: " + simpleinterest);
    }
}
public class MultiThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserThread userThread = new UserThread();
        SimpleInterestThread interestThread = new SimpleInterestThread();
        userThread.start();
        interestThread.start();
	}

}
