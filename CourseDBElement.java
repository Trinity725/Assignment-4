
public class CourseDBElement implements Comparable<CourseDBElement>{
	
	String courseID, roomNumber, instructor;
	int crn, credits;
	
    /**
     * constructor to initialize variables
     * @param courseID- identification of the course
     * @param crn- corresponding course number
     * @param credits - amount of credits the class provides
     * @param roomNumber - Room number of the class
     * @param instuctor - name of instructor of the course
     */
public CourseDBElement (String id, int crn, int credits, String roomNum, String instName)
{
	this.courseID= id;
	this.crn=crn;
	this.credits=credits;
	this.roomNumber=roomNum;
	this.instructor=instName;
}

public CourseDBElement() 
{
	this.courseID=null;
	this.crn=0;
	this.credits=0;
	this.roomNumber=null;
	this.instructor=null;
}

/**
 * @return hashcode from crn
 */
  public int getHash() 
  {
	int a = 31;
	int hash = 0;
	
	String string = String.valueOf(getCRN());
	
	for (int i = 0; i < string.length(); i++) 
	{
		hash = a * hash + string.charAt(i);
	}
	
	return hash;
}
 
  public void setId(String courseId)
  {
	this.courseID=courseId;
  }

  public String getID()
  {
	return courseID;
  }

  public void setCRN(int crn)
  {
	this.crn=crn;
  }

  public int getCRN()
  {
	return crn;
  }

  public void setCredits(int credits)
  {
	this.credits=credits;
  }

  public int getCredits()
  {
	return credits;
  }

  public void setRoomNum(String roomNum)
  {
	this.roomNumber=roomNum;
  }

  public String getRoomNum()
  {
	return roomNumber;
  }

  public void setInstructorName(String name)
  {
	this.instructor=name;
  }	

  public String getInstructorName()
  {
	return instructor;
  }


  @Override
  public String toString() 
  {
	String string = "\nCourse:" + courseID + " CRN:" + crn + " Credits:" + credits + " Instructor:" + instructor
			+ " Room:" + roomNumber;
	return string;
  }
  
  
  @Override
	public int compareTo(CourseDBElement o) 
  {
		if (o.crn == crn) 
		{
			return 0;
		} else if (o.crn < crn) 
		{
			return -1;
		} else 
		{
			return 1;
		}
	}
 
}
