package com.lumiplan.hibernate.Entity;

import java.util.ArrayList;
import java.util.List;

import com.lumiplan.hibernate.DAO.DAO;

public class Country_State extends DAO {
	 private List<State> states = new ArrayList<State>();
	    private Country country = new Country();
	    private State state1 = new State();
	    private State state2 = new State();
	   
	    public void save() throws Exception {
	        try {
	            begin();
	            //state1.setCountry(country);
	            state1.setStateId("S001");
	            state1.setStateName("Karnataka");
	            
	            //state2.setCountry(country);
	            state2.setStateId("S002");
	            state2.setStateName("Kerala");
	            states.add(state1);
	            states.add(state2);
	            country.setCountryName("India");
	            country.setCountryID("C001");
	            country.setStates(states);
	            getSession().save(country);
	             commit();
	        } catch (Exception e) {
	            rollback();
	            throw new Exception("Exception in save." + e.getMessage());
	            
	        } finally {
	            flush();
	            close();
	        }
	    }
	 
	    public static void main(String[] args) {
	        try {
	            Country_State cs = new Country_State();
	            cs.save();
	            State_City sc = new State_City();
	            sc.save();
	            
	           } catch (Exception e) {
	            //System.out.println("Exception : " + e.getMessage() + "Cause : " + e.getCause());
	        	 System.out.println("Exception in main." + e.getMessage());
	        }
	    }

}
