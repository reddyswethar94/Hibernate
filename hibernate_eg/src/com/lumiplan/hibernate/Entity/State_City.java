package com.lumiplan.hibernate.Entity;

import java.util.ArrayList;
import java.util.List;

import com.lumiplan.hibernate.DAO.DAO;

public class State_City extends DAO {
		 private List<City> cities = new ArrayList<City>();
		    private State state = new State();
		    private City city1 = new City();
		    private City city2 = new City();
		 
		    public void save() throws Exception {
		        try {
		            begin();
		            
		            city1.setCityId("CI001");
		            city1.setCityName("Bengaluru");
		            
		          
		            city2.setCityId("CI002");
		            city2.setCityName("tiruvananthapuram");
		            
		            cities.add(city1);
		            cities.add(city2);
		            state.setStateName("Karnataka");
		            state.setStateId("S001");
		            state.setCities(cities);
		            getSession().save(state);
		            commit();
		        } catch (Exception e) {
		            rollback();
		            throw new Exception("Exception in save." + e.getMessage());
		            
		        } finally {
		            flush();
		            close();
		        }
		    }
		 
		  }



