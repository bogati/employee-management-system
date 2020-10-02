package com.cognixia.jump.team2.project1.ems.javaproject;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;



public class App {
	
	public static void main(String[] args)
	{
		
		//things to ask : is Object fine for tradesoff with having different functions 
		
		
		FileIOJSON file = new FileIOJSON();
		//create a list of employees here 
		Map<Long,Employee> treeMap = new TreeMap<Long,Employee>();

		//create the employee object to put in the hashmap 
		
		
		Employee e1 = new Employee(1,1011,"bimala","bogati",21,"SWE",100,"abc@hotmail.com","510-345-6789","123harrisonstca");
		Employee e2 = new Employee(2,1012,"bimala","bogati",21,"SWE",100,"abc@hotmail.com","510-345-6789","123harrisonstca");
		Employee e3 = new Employee(3,1013,"bimala","bogati",21,"SWE",100,"abc@hotmail.com","510-345-6789","123harrisonstca");
		
		//put key value pair in the hash map 
		treeMap.put(e1.getEmployeeId(),e1);
		treeMap.put(((Employee) e2).getEmployeeId(),e2);
		treeMap.put(((Employee) e3).getEmployeeId(),e3);
		
		
		//write contents to the JSON file 
		
		try {
			file.writeToJSONFile(treeMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//read contents from JSON file 
		
		
		
		
		
		
		
		
		
		
		

		
	}
	
	

} //end of the App class 
