package com.cognixia.jump.team2.ems;

public interface CRUDable<T> {
	
	//override these methods in the Department and Employees 
	public void add(T entity);
	public void remove(T entity);
	public void update(T entity);
	public void list();
	

}
