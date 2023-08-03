package com.firas.car;

public class Car {
	private int gas;
    private boolean gameOver;
    
    
    
    
    
	public Car() {
		  super();
		  this.gas = 10;
	      this.gameOver = false;
	}
	
    public void status() {
        if (gas <= 0) {
            gameOver = true;
            System.out.println("Game Over - Out of gas!");
        } else {
            System.out.println("Gas remaining: " + gas + "/10");
        }        
    }
	
	
	
	public int getGas() {
		return gas;
	}
	public void setGas(int gas) {
		this.gas = gas;
	}
	public boolean isGameOver() {
		return gameOver;
	}
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

}
