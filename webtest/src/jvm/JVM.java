package jvm;

public class JVM {
	public static void main(String[] args) {
		System.out.println(System.getProperty("sun.boot.class.path"));;
		System.out.println(System.getProperty("java.ext.dirs"));;
		
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
		System.out.println(System.getProperty("java.class.path"));;
	}
}
