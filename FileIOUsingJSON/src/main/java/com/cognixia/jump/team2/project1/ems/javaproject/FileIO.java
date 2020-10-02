package com.cognixia.jump.team2.project1.ems.javaproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

/*Things to do :
 * Access the file from the resources folder 
 * put two files in the resources folder 
 * 
 */



public class FileIO {
	
// use FileIO.departmentFile and FileIO.employeeFile
final static String departmentFile = "/Users/himalyas/Desktop/departmentFile.csv";
final static String employeeFile =  "/Users/himalyas/Desktop/employeeFile.csv"; 
Set<Employee> hash_Set = new HashSet();

	//class or interface ??
	//how many files will we have ? 2 
	
	//read the file from the system and upload it to our data structure 
		public void saveToSet( ) throws FileNotFoundException {
			
			File file = new File(employeeFile);
			FileReader in = new FileReader(file);
			BufferedReader reader = new BufferedReader(in);
			
			Scanner inputStream= new Scanner(reader);
			Employee emp;
			int i=0;
			//getting rid of the columns 
			inputStream.next();
				
				while(inputStream.hasNext()) {
					//data = 1 row 
					String data = inputStream.next();
					//use split that returns string of arrays 
					String row_values[] = data.split(",");
					long employeeId; 
					try {
						employeeId = Long.parseLong(row_values[0]);
						}
						catch (NumberFormatException e)
						{
							employeeId = 00000;
						}
					long departmentId;
					try {
						departmentId = Long.parseLong(row_values[1]);
						}
						catch (NumberFormatException e)
						{
							departmentId = 00000;
						}
					
					String firstName = row_values[2];
					String lastName = row_values[3];
					int age ;
					try {
						age = Integer.parseInt(row_values[4]);
						}
						catch (NumberFormatException e)
						{
							age = 00000;
						}
					String position = row_values[5];
					int salary;
					try {
						salary = Integer.parseInt(row_values[6]);
						}
						catch (NumberFormatException e)
						{
							salary = 00000;
						}
					String email= row_values[7];
					String phone = row_values[8];
					String address = row_values[9];
					
					emp = new Employee(employeeId,departmentId,firstName,lastName,age,position,salary,email,phone,address);
					System.out.println(data + "****");
					System.out.println("employee "+i+" emp id "+emp.getEmployeeId());
			    	System.out.println("employee "+i+" dep id "+emp.getDepartmentId());
			    	System.out.println("employee "+i+" fname "+emp.getFirstName());
			    	System.out.println("employee "+i+" lname "+emp.getLastName());
			    	System.out.println("employee "+i+"age"+emp.getAge());
			    	System.out.println("employee "+i+"position"+emp.getPosition());
			    	System.out.println("employee "+i+"salary"+emp.getSalary());
			    	System.out.println("employee "+i+"email"+emp.getEmail());
			        System.out.println("employee "+i+"phone"+emp.getPhone());
			    	System.out.println("employee "+i+"address"+emp.getAddress());
			    	i++;
					
					hash_Set.add(emp);
					//can parse the way you want 
					
				}
				inputStream.close();
				//System.out.println("THE LENGTH OF THE SET IS"+hash_Set.size());
			
			
			
			
		}
	public void readFromFile() throws FileNotFoundException {
		
		String fileName = employeeFile;
		File file = new File(fileName);
		FileReader in = new FileReader(file);
		BufferedReader reader = new BufferedReader(in);
		
		
	
			Scanner inputStream= new Scanner(reader);
			while(inputStream.hasNext()) {
				//data = 1 row 
				String data = inputStream.next();
				//use split that returns string of arrays 
				String row_values[] = data.split(",");
				// System.out.println(row_values[4]);
				//can parse the way you want 
				System.out.println(data + "****");
			}
			inputStream.close();
			
	
		
	}
	
	public void writeToFileConsole(int employeeId, String name, String email, String phone) throws IOException {
		
		// These are just the example values 
		//later read the csv file and write to it 
		//read it from console and insert it in the csv file
		String fileName = employeeFile;
		File file = new File(fileName);
		FileWriter out = new FileWriter(file,true);
		BufferedWriter writer = new BufferedWriter(out);
		//to acces some of the printing functions 
		PrintWriter pWriter = new PrintWriter(writer);
		
		pWriter.println(employeeId+","+name+","+email+","+phone);
		pWriter.flush();
		pWriter.close();
		
		JOptionPane.showMessageDialog(null, "Record saved");
		
	}
	
	public void writeToFile(Employee emp) throws IOException {
		String fileName = employeeFile;
		File file = new File(fileName);
		//append 
		FileWriter out = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(out);
		//to access some of the printing functions 
		PrintWriter pWriter = new PrintWriter(writer);
		
		pWriter.println(emp.getEmployeeId()+","+
				        emp.getDepartmentId()+","+
				        emp.getFirstName()+","+
				        emp.getLastName()+","+
				        emp.getAge()+","+
				        emp.getPhone()+","+
				        emp.getSalary()+","+
				        emp.getEmail()+","+
				        emp.getPhone()+","+
				        emp.getAddress()
						);
		pWriter.flush();
		pWriter.close();
		
		
		
	}
	public void addColumns() throws IOException {
		
		File file = new File(employeeFile);
		//append 
		FileWriter out = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(out);
		//to access some of the printing functions 
		PrintWriter pWriter = new PrintWriter(writer);

		pWriter.println("EmployeeId"+","+
				        "DepartmentId"+","+
				        "FirstName"+","+
				        "LastName"+","+
				        "Age"+","+
				        "Phone"+","+
				        "Salary"+","+
				        "Email"+","+
				        "Phone"+","+
				        "Address"
						);
		pWriter.flush();
		pWriter.close();
		
	}
	
	public void replaceFileTest(Set<Employee> set) throws IOException {
		
		
		File file = new File(employeeFile);
		//append + replace 
		FileWriter out = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(out);
		//to access some of the printing functions 
		PrintWriter pWriter = new PrintWriter(writer);
		
		
		//ADD THE COLUMNS OF THE FILES /TITLES 
		pWriter.println("EmployeeId"+","+
		        "DepartmentId"+","+
		        "FirstName"+","+
		        "LastName"+","+
		        "Age"+","+
		        "Phone"+","+
		        "Salary"+","+
		        "Email"+","+
		        "Phone"+","+
		        "Address"
				);
		//pWriter.flush();
		
		Iterator value = set.iterator(); 
		Employee emp; 
		while(value.hasNext())
		{
			emp = (Employee) value.next();
		
		
		pWriter.println(emp.getEmployeeId()+","+
				        emp.getDepartmentId()+","+
				        emp.getFirstName()+","+
				        emp.getLastName()+","+
				        emp.getAge()+","+
				        emp.getPhone()+","+
				        emp.getSalary()+","+
				        emp.getEmail()+","+
				        emp.getPhone()+","+
				        emp.getAddress()
						);
		//pWriter.flush();
		}
		pWriter.flush();
		pWriter.close();
		
		
	}
	
	public void printAll() {
		System.out.println("INSIDE THE PRINT FUNCTION");
		 
		 //insert the values to the hashset using the read 
		 
		Iterator value = hash_Set.iterator(); 
		Employee emp;
		 
		 //check if the value is stored in the set 
	      
	    
	      
	      System.out.println("The iterator values are: ");
	      int i=0; 
	      while(value.hasNext()) {
	    	  emp = (Employee) value.next();
	    	  System.out.println("employee "+i+" emp id "+emp.getEmployeeId());
	    	  System.out.println("employee "+i+" dep id "+emp.getDepartmentId());
	    	  System.out.println("employee "+i+" fname "+emp.getFirstName());
	    	  System.out.println("employee "+i+" lname "+emp.getLastName());
	    	  System.out.println("employee "+i+"age"+emp.getAge());
	    	  System.out.println("employee "+i+"position"+emp.getPosition());
	    	  System.out.println("employee "+i+"salary"+emp.getSalary());
	    	  System.out.println("employee "+i+"email"+emp.getEmail());
	    	  System.out.println("employee "+i+"phone"+emp.getPhone());
	    	  System.out.println("employee "+i+"address"+emp.getAddress());
	    	  i++;
	      }
	}
	
	
	
	
} //end of the function