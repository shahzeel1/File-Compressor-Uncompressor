/** 
 * This class will create an array with CodePairs as its values. The class
 * will help isolate every character and their codes.
 * @author Zeel
 */
public class ArrayCode 
{
	private CodePair []codeLists;
	private int numPairs=0;
	/**
	 * @param size of the array needed to store the code pairs
	 */
	public ArrayCode (int size)
	{
		this.codeLists = new CodePair [size];
	}

	/**
	 *This method adds the code pair element to the array, 
	 * if the array is full it is expanded
	 * @param pair
	 */
	public void add(CodePair pair)
	{
		// add it to the array of friends
		// if array is not big enough, double its capacity automatically
		if (numPairs == codeLists.length)
		{

			expandCapacity();//creates  new array of code pairs double the size, puts the reference to this new array

		}
		// add reference to pair at first free spot in array
		codeLists[numPairs] = pair;
		numPairs++;
	}
	/**
	 * this method removes the specific CodePair element from the array,
	 * then it checks if the array is over 4x as big as the number of pairs 
	 * if the size is too big, the array size will be decreased
	 * @param pairToRemove
	 */
	public void remove (CodePair pairToRemove)
	{
		final int NOT_FOUND=-1;
		int search = NOT_FOUND ;
		CodePair target = pairToRemove;	

		// search the list for the specified friend
		for (int i = 0; i < numPairs && search == NOT_FOUND; i ++)
			if (codeLists[i].equals(target))
				search = i;

		// target code found, remove by replacing with last one in list
		
		if (search>=0)
		{
			codeLists[search]=codeLists[numPairs - 1];
			codeLists[numPairs - 1] = null;
			numPairs --;
		}
		//check if the number of pairs is less than a quarter of the size of the array
		if (numPairs<(codeLists.length/4))
		{
			decreaseCapacity();
		}
	}
	/**
	 * This method finds the place in the array where the code occurs
	 * @param code
	 * @return the position of the object in the array, if the code does not 
	 * exist in the array then -1 will be returned
	 */
	public int findCode (String code)
	{
		for (int i=0; i<numPairs;i++)
		{
			if (codeLists[i].getCode().equals(code))
			{
				return i;
			}
		}
		return -1;
	}
	/**
	 * This method finds the place in the array where the character occurs
	 * @param character
	 * @return the position of the object in the array, if the character does not 
	 * exist in the array then -1 will be returned
	 */
	public int findCharacter(char c)
	{
		for (int i=0; i<numPairs;i++)
		{
			if (codeLists[i].getCharacter()==c)
			{
				return i;
			}
		}
		return -1;
	}
	/**
	 * The method retrieves what the code is in the position specified
	 * @param array position 
	 * @return code corresponding to the position
	 */
	public String getCode(int i)
	{
		if (i<0 || i>numPairs)
		{
			return null;
		}
		else 
		{
			return codeLists[i].getCode();
		}
	}
	/**
	 * This method retrieves the character that is in the position specified
	 * @param array position
	 * @return code corresponding to the position 
	 */
	public char getCharacter (int i)
	{
		if (i<0 || i>numPairs)
		{
			return 0;
		}
		else 
		{
			return codeLists[i].getCharacter();
		}

	}
	/**
	 * getter method to get the size of the array
	 * @return size of the array
	 */
	public int getSize()
	{
		return codeLists.length;
	}
	/**
	 * getter method to get the number of pairs in the array
	 * @return number of pairs in the array 
	 */
	public int getNumPairs()
	{
		return numPairs;
	}
	/**
	 * This method expands the capacity of an array
	 *  depending on the original size of the array 
	 */
	private void expandCapacity()
	{
		CodePair [] largerList;
		if (codeLists.length<=100)
		{
			largerList = new CodePair[codeLists.length * 2];
			
		}
		else 
		{
			largerList = new CodePair[codeLists.length + 20];
			
		}
		for (int i = 0; i < codeLists.length; i++)
			largerList[i] = codeLists[i];

		codeLists = largerList;
	}
	/**
	 * This method decreases the capacity of the array by half 
	 */
	private void decreaseCapacity()
	{
		CodePair [] smallerList = new CodePair[codeLists.length /2];
		for (int i = 0; i < numPairs; i++)
		{
			smallerList[i] = codeLists[i];
		}
		codeLists = smallerList;
	}


}
