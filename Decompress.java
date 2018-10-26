/**
 * This class will decompress the given file in the arguments. 
 * The characters and their corresponding codes are located in the codes file and are stored in an 
 * array. The array list is then used to convert the compressed code into text.
 * @author Zeel Shah
 * @date February 5 2018
 * @studentNumber 25090094
 *
 */
public class Decompress 
{

	static int numberOfCodes =0; // create a static variable to keep track on the number of codes the code file has
	static ArrayCode codeList = new ArrayCode(100);// create a static code list to keep track of the codes

	public static void main(String[] args) 
	{

		String compressedFileName=args[0]; // store the name of the compressed file in a variable
		String codeFileName = args [1]; // store the name of the code file in a variable

		//read in the file with all the codes
		TextFile codeFile = new TextFile(codeFileName,"read");
		char c = codeFile.readChar();
		String code = codeFile.readLine();


		//create and add CodePair objects to the array
		while (c!=(char)0)
		{			
			codeList.add(new CodePair(c,code));
			c=codeFile.readChar();
			code = codeFile.readLine();
			numberOfCodes++;

		}
		//close the codes file 
		codeFile.close();

		//open the compressed file to read from
		CompressedFile compressedFile = new CompressedFile(compressedFileName,"read");

		//create and open the output file
		String outputName = args[0].substring(0, args[0].length() - 3) + "dec";
		TextFile outputFile = new TextFile (outputName,"write");

		//read in the first binary digit of the file
		char digit = compressedFile.readBit();
		//convert the digit into a string
		String newCode=Character.toString(digit);
		System.out.println("Decompressing File...");

		//convert from compressed code to character and write to the file, loop until 
		//the end of the file
		boolean end = false;
		while (end==false)
		{

			if (digit==(char)0)
			{
				end = true;
			}
			else
			{	char character=findChar(newCode);//check if there is a character corresponding to the code

			//loop until a valid code is found
			while(character==(char)0&&end==false)

			{
				digit = compressedFile.readBit();
				newCode=(newCode+Character.toString(digit));//add the digits to the potential code
				character=findChar(newCode);
				//check if the end of the is reached
				if (digit==(char)0)
				{
					end=true;
				}


			}
			//write the character that corresponded to the valid character in the text file
			outputFile.writeChar(character);
			//reset digit variable to the next available binary digit
			digit=compressedFile.readBit();
			//reset code 
			newCode=Character.toString(digit);
			}


		}

		System.out.println("Decompression Complete!");

		//close compression and text files
		compressedFile.close();
		outputFile.close();

	}

	/**
	 * This method finds the character that corresponds to the potential code
	 * @param code
	 * @return character
	 */
	private static char findChar(String code)
	{
		final int NOT_FOUND = -1;
		int search = NOT_FOUND;
		String target = code;	


		// search the list for the specified code
		for (int i = 0; i < numberOfCodes && search == NOT_FOUND; i ++)

		{
			// determine the position of the found code
			if (codeList.getCode(i).equals(target))
			{
				search = i;

			}	
		}

		//return the character if valid position is found, or else return null ((char)0)
		if(search>=0)
		{
			return codeList.getCharacter(search);
		}	
		else
			return (char)0;


	}
}


