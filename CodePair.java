
public class CodePair 
{

	private char character;
	private  String code;

	/**
	 * Constructor returns a new CodePair object.
	 * @param character 
	 * @param the byte code translation of the character
	 */
	public CodePair(char c, String code)
	{
		this.character = c; // initialize the variable where the character of each pair will be stored
		this.code= code; //initialize the variable where the code of each pair will  be stored
	}
	/**
	 * @return the compression code in the CodePair object
	 */
	public String getCode()
	{
		return this.code;
	}
	/**
	 * @return the character in the CodePair object 
	 */
	public char getCharacter()
	{
		return this.character;
	}
	/**
	 * @param the new character that needs to be changed 
	 */
	public void setCharacter (char c)
	{
		this.character=c;
	}
	/**
	 * @param the new code that needs to be changed 
	 */
	public void setCode (String code)
	{
		this.code=code;
	}
	/**
	 * @param anotherPair
	 * @return true if the character from this object  is equal to the character from the 
	 * other object
	 */
	public boolean equals (CodePair anotherPair)
	{
		if (this.character==anotherPair.character)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
