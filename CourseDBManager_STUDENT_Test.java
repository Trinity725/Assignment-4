import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CourseDBManager_STUDENT_Test 
{

	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC204",30416,4,"Distance Learning","Khandan Monshi");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataMgr.add("CMSC140",20112,4,"Distance Learning","David Laratta");
		dataMgr.add("CMSC203",21825,4,"SC225","Khandan Monshi");
		dataMgr.add("CMSC204",30416,4,"Distance Learning","Khandan Monshi");
		ArrayList<String> list = dataMgr.showAll();
		assertEquals(list.get(0),"\nCourse:CMSC140 CRN:20112 Credits:4 Instructor:David Laratta Room:Distance Learning");
	 	assertEquals(list.get(1),"\nCourse:CMSC203 CRN:21825 Credits:4 Instructor:Khandan Monshi Room:SC225");
		assertEquals(list.get(2),"\nCourse:CMSC204 CRN:30416 Credits:4 Instructor:Khandan Monshi Room:Distance Learning");
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 30416 4 Distance Learning Khandan Monshi");
			inFile.print("MATH182 30606 4 260 Yan Zhao");
			
			inFile.close();
			dataMgr.readFile(inputFile);
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
