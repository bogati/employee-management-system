package com.cognixia.jump.team2.ems;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	/* EFFICIENCY hACKS 
	 * do not call writ function too often , call it once and pass the list of employees, not objects
	 * figure out when to append and when to replace 
	 * 
	 * 
	 */
	public static void main(String[] args)  {
		System.out.println("START OF THE MAIN");
		FileIO file = new FileIO();
		//create a list of employees here 
		Set<Employee> hash_Set = new HashSet<Employee>();

		Iterator value = hash_Set.iterator(); 
		Employee emp ;
		
		/*try {
			file.readFromFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
	
		 
		 Employee e1 = new Employee(1,1011,"bimala","bogati",21,"SWE",100,"abc@hotmail.com","510-345-6789","123harrisonstca");
		 Employee e2 = new Employee(2,1012,"bimala","bogati",21,"SWE",100,"abc@hotmail.com","510-345-6789","123harrisonstca");
		 Employee e3 = new Employee(3,1013,"bimala","bogati",21,"SWE",100,"abc@hotmail.com","510-345-6789","123harrisonstca");
		 
		 hash_Set.add(e1);
		 hash_Set.add(e2);
		 hash_Set.add(e3);
		 
		
		//WRITE THE CONTENTS TO THE CSV FILE 
		try {
			//how to insert the column values 
			//file.writeToFile(e1);
			file.replaceFileTest(hash_Set);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//READING THE CSV FILE AND STORING TO THE SET 
		
		try {
			file.saveToSet();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		file.printAll();
		

		 
		
	}//end of the Main function 

}
