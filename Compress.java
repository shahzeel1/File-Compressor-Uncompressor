/**
 * This class compresses any text file entered in the arguments of the program.
 * The characters and their corresponding codes are located in the codes file and are stored in an 
 * array. The array list is then used to convert the text into an compressed text.
 * @author Zeel Shah
 * @date February 5 2018
 * @studentNumber 250970094
 */
public class Compress 
{
	private static int numberOfCodes=0;// create a static variable to keep count on the amount of codes in the array.
	private static ArrayCode codeList = new ArrayCode (100);//create an array with 100 spots to store the character and the code associated with it

	public static void main(String[] args) 

	{

		String fileName=args[1];//create a variable and store in the codes file
		//open file the file with all the codes
		TextFile codeFile = new TextFile(fileName,"read");
		//read in the first character of the file
		char character = codeFile.readChar();
		//read in the rest of the line in the file which will be the code
		String code = codeFile.readLine();

		//create and add CodePair objects to the array
		while (character!=(char)0&&code!=null)
		{			
			codeList.add(new CodePair(character,code));
			character=codeFile.readChar();
			code = codeFile.readLine();
			numberOfCodes++;

		}
		//close the code file
		codeFile.close();

		String textName=args[0];//get the name of the text file
		//open the text file that needs to be converted.
		TextFile textFile = new TextFile(textName,"read");
		//create and open file to write to
		String outputName = args[0].substring(0, args[0].length() - 3) + "zzz";
		CompressedFile outFile=new CompressedFile(outputName,"write");


		String codeFound;//initialize the variable where the code found will be stored
		char digit;//each digit of the binary code will be stored here
		char letter = textFile.readChar();// read in the first character of the text file

		System.out.println("Compressing File...");
		//loops through the text and transfers each character to it's 
		//compressed version in the compressed file
		while (letter!=(char)0)
		{
			//find the character in the array 
			codeFound=findCode(letter);
			//check if there is a code for the character
			if (codeFound==null)
			{
				System.out.println("There was no code for the '"+letter+"' character");
				System.exit(0);
			}
			else
			{
				//break up code and write one binary digit at a time to the file. 
				for (int i=0;i<codeFound.length();i++)
				{					
					digit=codeFound.charAt(i);
					outFile.writeBit(digit);
				}
				//read next character in the file	
				letter= textFile.readChar();

			}
		}
		
		System.out.println("Compression Complete!");
		// close the text and compressed files
		outFile.close();
		textFile.close();


	}
	/**
	 * This method finds the code that corresponds to the given character
	 * @param character
	 * @return code
	 */
	private static String findCode(char character)
	{
		final int NOT_FOUND = -1;
		int search = NOT_FOUND;
		char target = character;	

		// if array is empty, can't search for code
		if (numberOfCodes == 0)
		{
			return "code list is empty";
		}
		// search the list for the specified character
		for (int i = 0; i < numberOfCodes && search == NOT_FOUND; i ++)

		{
			if (codeList.getCharacter(i)==target)
			{
				search = i;
			}	
		}

		//return the character that is at the target position.
		return codeList.getCode(search);

	}

}
