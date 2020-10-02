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
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileIOJSON implements Comparable<Employee>  {
	final static String departmentFile = "/Users/himalyas/Desktop/departmentFile.csv";
	final static String employeeFile =  "/Users/himalyas/Desktop/employeeFile.JSON"; 
	
	Map<Long,Employee> treeMap = new TreeMap<Long,Employee>();
	Employee emp;
	Scanner inputStream ;
	
	@SuppressWarnings("unchecked")
	public void writeToJSONFile(Map<Long, Employee> treeMap) throws IOException {
		// TODO Auto-generated method stub
		
		JSONObject employeeObject;
		JSONArray employeeList = new JSONArray();
		
		//iterate the hasmap using entryobject to convert to JSON objects
		
		for (Entry<Long, Employee> entry : treeMap.entrySet()) {  
            /*System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue());*/
			
			employeeObject = new JSONObject();
			employeeObject.put( entry.getKey(),entry.getValue());
			employeeList.add(employeeObject);
		}
		
		//write to JSON file 
		
		
		File file = new File(employeeFile);
		
		FileWriter out = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(out);
		
		//to access some of the printing functions 
		PrintWriter pWriter = new PrintWriter(writer);
		
		pWriter.println(employeeList.toJSONString());
		pWriter.flush();
		pWriter.close();
		
	}
	
	public void readFromJSONFile() throws IOException, ParseException {
		//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        
        String fileName = employeeFile;
		File file = new File(fileName);
		FileReader in = new FileReader(file);
		BufferedReader reader = new BufferedReader(in);
		
		
		
		 //Read JSON file
        Object obj = jsonParser.parse(reader);
        JSONArray employeeList = (JSONArray) obj;
        
      //Iterate over employee array
      //  employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

       
		
		

           
		
		
	}
	
	public void parseEmployeeObject(JSONObject jsonobj) {
		JSONObject employeeObject = (JSONObject) jsonobj.get(emp.getEmployeeId());
		
	}
		
		
	
	

	
	public void readFromFile() throws FileNotFoundException {

		//JSON parser object to parse read file
	    JSONParser jsonParser = new JSONParser();
		File file = new File(employeeFile);
		FileReader in = new FileReader(file);
		BufferedReader reader = new BufferedReader(in);
		
		
		
	}

	public int compareTo(Employee emp) {
		// TODO Auto-generated method stub
		return (int)(emp.getEmployeeId() - emp.getDepartmentId());
	}
 
	//Refrences: https://howtodoinjava.com/java/library/json-simple-read-write-json-examples/#:~:text=Read%20JSON%20from%20file%20in%20Java%20with%20json%2Dsimple&text=First%20of%20all%2C%20we%20will,type%20i.e.%20JSONArray%20and%20JSONObject%20.

	

} //end of the file 
