package com.imranmadbar;

public class OperationTimeCheck {
	
	public static void main(String[] args) {

        System.out.println("JavaMysqlApplication starting.");
        
        long startTime = System.currentTimeMillis();

        long total = 0;
        for (int i = 0; i < 10000000; i++) {
           total += i;
        }

        long stopTime = System.currentTimeMillis();
        
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
        
        

	}

}
