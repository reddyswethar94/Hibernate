package com.lumiplan.hibernate.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="country")

public class Country implements Serializable
  { 
	 private String country_id;
	 private String  country_name;
	    private List<State> states = new ArrayList<State>();
	 
	    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinColumn(name="country_id")
	    public List<State> getStates() {
	        return states;
	    }
	 
	    @Column(name = "country_name", length = 20, nullable = false)
	    public String getCountryName() {
	        return country_name;
	    }
	 
	    @Id
	    @Column(name = "country_id", length = 20)
	    public String getCountryId() {
	        return country_id;
	    }
	 
	    public void setCountryName(String country_name) {
	        this.country_name = country_name;
	    }
	 
	    public void setStates(List<State>states) {
	        this.states = states;
	    }
	 
	    public void setCountryID(String country_id) {
	        this.country_id = country_id;
	    }
	    
	    public Country() {
	    	
	    }
	    
	    public Country(String country_id, String country_name)
	    {
	    	this.country_id = country_id;
	    	this.country_name = country_name;
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
     /*   @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
	    @Column(name="country_id")
	    private int country_id;
	    
	    @Column(name="country_name")
		private String country_name;
		
	    @OneToMany(mappedBy="country")
	    
	    private Set<State>state;
		public Country()
		{}
		 public Country(String country_name)
		    {
		        this.country_name = country_name;
		    }
		    public Country(String country_name, Set<State>state)
		    {
		        this.country_name = country_name;
		        this.state = state;
		    }
		     
		    
		    
		
		public int getcountry_id() {
			return country_id;
		}
		
		public String getcountry_name() {
			return country_name;
		}
		
		public void setcountry_id(int country_id)
		{
			this.country_id = country_id;
        }
		
		public void setcountry_name(String country_name)
		{
			this.country_name = country_name;
		}
		
		public Set<State> getState() {
	        return state;
	    }
	    public void setState(Set<State>state) {
	        this.state = state;
	    } */
		
	


