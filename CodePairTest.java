
public class CodePairTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextFile theFile = new TextFile("codes.txt","read");
// print code file
		boolean end=false;
		int numLine=0;
		while (end!=true)
		{
			if (theFile.readLine()==null)
				end=true;
			else
			{
				System.out.println(theFile.readLine());
			}
		}
		
	CodePair pairOne = new CodePair('a',"010010");
	//System.out.println(pairOne);
	System.out.println(pairOne.getCode());
	pairOne.setCharacter('b');
	System.out.println(pairOne.getCharacter());
	pairOne.setCode("0100101010");
	System.out.println(pairOne.getCode());
	CodePair pairTwo = new CodePair ('b',"0100101010");
	char c = 'a';
	char c2 ='b';
	if (pairOne.equals(pairTwo))
	{
		System.out.println("true");
	}
	if (pairOne.getCharacter()==(c))
	{
		System.out.println("a");
	}
	else
		System.out.println("b");
	if (pairOne.getCharacter()==c2)
		System.out.println(1);
	else
		System.out.println(2);

	}

}
