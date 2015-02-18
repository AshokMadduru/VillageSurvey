package com.taramt.startapp.forms;

public class SurveyForm {
    
    private int education;
    private int transport;
    private int food;
    private int crops;
    private int water;
    private int power;
    
    public SurveyForm() {
    	
    }
	public SurveyForm(int education, int transport, int food, int crops,
			int water, int power) {
		this.education = education;
		this.transport = transport;
		this.food = food;
		this.crops = crops;
		this.water = water;
		this.power = power;
	}

	public int getEducation() {
		return education;
	}

	public int getTransport() {
		return transport;
	}

	public int getFood() {
		return food;
	}

	public int getCrops() {
		return crops;
	}

	public int getWater() {
		return water;
	}


	public int getPower() {
		return power;
	}

}
