package com.techelevator;


	public class MoneyCalculator {
		
		public double insertMoney(double insertedMoney, double balance) {
			balance += insertedMoney;
			return balance;
		}
		public double chargeMoney(double amountToCharge, double balance) {
			if(amountToCharge < balance) {
				balance -= amountToCharge;
			}
			return balance;
		}
		
		public String makeChange(double balance) {
			double quarter = 0.25;
			double dime = 0.10;
			double nickel = 0.05;
			
			int quarterCount = 0;
			int dimeCount = 0;
			int nickelCount = 0;
			 
			while(balance >= 0.05) {
				if (balance >= quarter) {
					balance -= quarter;
					quarterCount++;
				} else if (balance >= dime) {
					balance -= dime;
					dimeCount++;
				} else if (balance >= nickel) {
					balance -= nickel;
					nickelCount++;
				}
			} 
			// Change is off by a nickel when 5 cents is remaining due to rounding issues with doubles
			
			String yourChange = "Your change is: \n" + "Quarters: " + quarterCount + " Dimes: " + dimeCount + " Nickels: " + nickelCount;
			balance = 0;
			return yourChange;
			
		}

	}