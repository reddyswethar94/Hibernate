package com.lumiplan.hibernate.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="state")
public class State implements Serializable
 {
	private String state_id, state_name;
    private Country country;
	private List<City> cities = new ArrayList<City>();
 
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    public Country getCountry() {
        return country;
    }
   
    @Id
    @Column(name = "state_id", length = 20)
    public String getStateId() {
        return state_id;
    }
 
    @Column(name = "state_name", length = 20, nullable = false)
    public String getStateName() {
        return state_name;
    }
 
    public void setStateName(String state_name) {
        this.state_name = state_name;
    }
 
    public void setStateId(String state_id) {
        this.state_id = state_id;
    }
 
    public void setCountry(Country country) {
        this.country = country;
    }
 
    public State(String state_id, String state_name, Country country) {
        this.state_id = state_id;
        this.state_name = state_name;
        this.country = country;
    }
 
    public State() {
    }

	
     public void setCities(List<City> cities) {
		this.cities= cities;
		
	}
    
 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* @Id
	 @GeneratedValue
	 @Column(name="state_id")
	 int state_id;
	 
	 @Column(name="state_name")
	 String state_name;
	 
	//@Column(name="country_id")
	//int country_id;                 
	
	
	   @ManyToOne
	   @JoinColumn(name="country_id")
	    private Country country;
	    public State() {
	    }
	   public State(Country country,int state_id,String state_name) {
	        this.country = country;
	        this.state_id = state_id;
	        this.state_name = state_name;
	    }
	 
	 public Country getCountry() 
	    {
	        return country;
	    }
	 public void setCountry(Country country) {
	        this.country = country;
	    }
	
	
	public int getstate_id()
	{
		return state_id;
	}
	
	public String getstate_name()
	{
		return state_name;
	}
	
	/*  // public int getcountry_id()
	{
		return country_id;
	}*/
	
/*	public void setstate_id(int state_id) 
	{
		this.state_id = state_id;
	}
	
	public void setstate_name(String state_name) 
	{
		this.state_name = state_name;
	}*/
	
/*//	public void setcountry_id(int country_id) 
	{
		this.country_id = country_id;
	}*/
	
	

