package com.firas.Zookeeper;

public class Mammal {
	private int energyLevel;
	
	public int displayEnergy() {
		System.out.println("Energy Level :" + this.energyLevel);
		return this.energyLevel;
		
	}
	
	
	
	
	
	

	public Mammal() {
		this.energyLevel = 100;
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

}
