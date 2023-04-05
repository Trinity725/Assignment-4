import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface
{
	private CourseDBStructure cds;
	
	public CourseDBManager() 
	{
		cds = new CourseDBStructure(100);
	}
	
	/**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	@Override
	public void add(String courseID, int crn, int credits, String roomNummber, String instructor) 
	{
			CourseDBElement cde = new CourseDBElement(courseID, crn, credits, roomNummber, instructor);
			cds.add(cde);
	}
	
	/**
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
	@Override
	public CourseDBElement get(int crn) 
	{
		try 
		{
			return cds.get(crn);
		} catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		
		Scanner keyboard = new Scanner(input);
		
		int credits, crn;
		CourseDBElement cde;
		
		String string;
		String[] course;

		while (keyboard.hasNextLine()) {
			string = keyboard.nextLine();
			course = string.split(" ", 5);
			crn = Integer.parseInt(course[1]);
			credits = Integer.parseInt(course[2]);
			cde = new CourseDBElement(course[0], crn, credits, course[3], course[4]);
			cds.add(cde);
		}
	}

	
	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	@Override
	public ArrayList<String> showAll() {
		return cds.showAll();
	}

}
