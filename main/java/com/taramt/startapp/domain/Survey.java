package com.taramt.startapp.domain;

import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.ApiResourceProperty;
import com.google.appengine.api.search.checkers.Preconditions;
import com.google.apphosting.utils.remoteapi.RemoteApiPb.TransactionRequest.Precondition;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Parent;
import com.taramt.startapp.forms.SurveyForm;

@Entity
@Cache
public class Survey {
	@Id  private long id;
	
	 /**
     * Holds SarpanchProfile key as the parent.
     */
    @Parent
    @ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
    private Key<SarpanchProfile> SarpanchProfileKey;
    
    /**
     * The userId of the Sarpanch.
     */
    @ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
    private String sarpanchUserId;
    
    /**
     * defining Issues list
     */
    
    private int education;
    private int transport;
    private int food;
    private int crops;
    private int water;
    private int power;
    
    private Survey() {
    	
    }

	public Survey(final long id, String sarpanchUserId, SurveyForm surveyForm) {
		Preconditions.checkArgument(getSum(surveyForm) != 100, "you need to distrubute exactly 100 points");
		this.id = id;
		this.SarpanchProfileKey = Key.create(SarpanchProfile.class, sarpanchUserId);
		this.sarpanchUserId = sarpanchUserId;
		updatewithSurveyForm(surveyForm);
	}

	public void updatewithSurveyForm(SurveyForm surveyForm) {
	
		this.education = surveyForm.getEducation();
		this.transport = surveyForm.getTransport();
		this.food = surveyForm.getFood();
		this.crops = surveyForm.getCrops();
		this.water = surveyForm.getWater();
		this.power = surveyForm.getTransport();
	}
	
	public int getSum(SurveyForm surveyForm) {
		return surveyForm.getCrops() + surveyForm.getEducation()
				+ surveyForm.getFood() + surveyForm.getPower()
				+ surveyForm.getTransport() + surveyForm.getWater();
	}

	public long getId() {
		return id;
	}


	public Key<SarpanchProfile> getSarpanchProfileKey() {
		return SarpanchProfileKey;
	}

	public String getSarpanchUserId() {
		return sarpanchUserId;
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
	
	
	
	
	