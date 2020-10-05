package com.cognixia.jump.javafinalproject.console;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cognixia.jump.javafinalproject.model.Company; 

public class ConsoleManagerTest {

	Scanner scan = new Scanner(System.in);
	ConsoleManager consoleManager = 
			new ConsoleManager(scan, new Company("Test"));
	
	
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testCase1() {
        final String testString = "Hello!";
        provideInput(testString);

        ConsoleMain.main(new String[0]);

        assertEquals(testString, getOutput());
    }
    
	@Test
	void addDepartment() {
		
		consoleManager.add();
	}
}
