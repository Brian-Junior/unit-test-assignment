package com.promineotech;

import java.util.Random;

public class TestDemo {

	
	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return (a+b);
		}else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}

		
		
		
		
		
		public boolean equalsOneHundred(int a, int b) {
			if ((a + b) == 100) {
			return true;
			}else {
				throw new IllegalArgumentException("Not Equal to 100!");
			
		
	}
		}

		public int getRandomInt(){
			Random random = new Random();
			return random.nextInt(10) + 1;
			}

		
		public int randomNumberSquared(){
		  int number = getRandomInt();
          return number*number;
}
}


		



