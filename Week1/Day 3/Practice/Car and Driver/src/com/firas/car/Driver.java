package com.firas.car;

public class Driver extends Car {
	public void driving() {
	    if (!isGameOver()) {
            setGas(getGas() - 1);
            System.out.println("You drive the car.");
            status();
        }
	}
	public void boosters() {
	     if (!isGameOver()) {
	            if (getGas() >= 3) {
	                setGas(getGas() - 3);
	                System.out.println("You use boosters.");
	                status();
	            } else {
	                System.out.println("Not enough gas to use boosters.");
	            }
	        }
	}
	public void Refueling() {
	     if (!isGameOver()) {
	            if (getGas() <= 8) {
	                setGas(getGas() + 2);
	                System.out.println("You refuel the car.");
	                status();
	            } else {
	                System.out.println("Gas tank is already full, cannot refuel further.");
	            }
	        }
	}

}
