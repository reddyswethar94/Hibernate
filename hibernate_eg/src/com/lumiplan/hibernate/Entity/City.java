package com.lumiplan.hibernate.Entity;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="city")
public class City implements Serializable
{
	private String city_id, city_name;
    private State state;
 
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id")
    public State getState() {
        return state;
    }
 
    @Id
    @Column(name = "city_id", length = 20)
    public String getCityId() {
        return city_id;
    }
 
    @Column(name = "city_name", length = 20, nullable = false)
    public String getCityName() {
        return city_name;
    }
 
    public void setCityName(String city_name) {
        this.city_name = city_name;
    }
 
    public void setCityId(String city_id) {
        this.city_id = city_id;
    }
 
    public void setState(State state) {
        this.state = state;
    }
 
    public City(String city_id, String city_name, State state) {
        this.city_id = city_id;
        this.city_name = city_name;
        this.state = state;
    }
 
    public City() {
    }
		
}
