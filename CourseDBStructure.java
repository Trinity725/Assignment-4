	import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface
{
	public int hashtableSize;
	public ArrayList<LinkedList<CourseDBElement>>hashTable;
	public final double loadFactor=1.5;
	
	
	public CourseDBStructure(int n)
	{
		int num=(int) (n/loadFactor);
		
		for(int i=0; i<num; i++)
		{
			if((4*i+3)>num)
			{
				if(isPrimeNumber(4*i+3))
				{
				 this.hashtableSize= 4*i+3;
					break;
				}
			}
		
		}
		
		hashTable= new ArrayList<LinkedList<CourseDBElement>>(hashtableSize);
		
		for(int k=0; k< hashtableSize; k++)
		{
		hashTable.add(new LinkedList<CourseDBElement>());
		}
	}
	
	
	public CourseDBStructure(String testing, int n)
	{
		hashtableSize =n;
		
		hashTable= new ArrayList<LinkedList<CourseDBElement>>(hashtableSize);
		for(int k=0; k< hashtableSize; k++)
		{
			hashTable.add(new LinkedList<CourseDBElement>());
		}
	}
	
	/**
	 * @param n - Takes parameter and checks if it is a prime number 
	 * @return true if is a prime number/ false not a prime number
	 */
    public boolean isPrimeNumber(int n)
    {
    	if(n<=1)
    	{
    		return false;
    	}
    	else {
    	for(int i=2; i<n; i++)
    	{
    		if(n%i==0)
    		{
    			return false;
    		}
    
    	}
    	return true;
    	}
    }
    
    
    /** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	@Override
	public void add(CourseDBElement element) 
	{
		int cds = element.getCRN() % hashtableSize;

		if (!(hashTable.get(cds).contains(element))) 
		{
			hashTable.get(cds).add(element);
		}

		for (int i = 0; i < hashTable.get(cds).size(); i++) 
		{
			
				if (((CourseDBElement) hashTable.get(cds).get(i)).getCRN() == element.getCRN()) 
				{
					hashTable.get(cds).remove(i);
					hashTable.get(cds).add(element);
				}
			}
		}
		
	
	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException 
	{
		int index = crn % hashtableSize;

		if (!(hashTable.get(index).isEmpty())) 
		{
			for (int i = 0; i < hashTable.get(index).size(); i++) 
			{
				if (((CourseDBElement) hashTable.get(index).get(i)).getCRN() == crn) 
				{
					return ((CourseDBElement) hashTable.get(index).get(i));
				}
			}
		}
		throw new IOException();
	}

	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	@Override
	public ArrayList<String> showAll() 
	{
		ArrayList<String> cds = new ArrayList<String>();

		for (int i = 0; i < hashtableSize; i++) 
		{
			if (!(hashTable.get(i).isEmpty())) 
			{
				cds.add(hashTable.get(i).toString().replace("[", "").replace("]", ""));
			}
		}
		return cds;
	}
	
	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	@Override
	public int getTableSize() 
	{
	 return hashtableSize;
	}
 
}
