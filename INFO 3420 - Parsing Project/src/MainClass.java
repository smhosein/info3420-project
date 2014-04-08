import java.awt.color.ProfileDataException;


public class MainClass 
{
	
	
	public static void main(String[] args)
	{
		CoreParser cp = CoreParser.getInstance();
		HeaderParser hp = HeaderParser.getInstance();
		String input = 
				"prog: name\n" +
		        "startDeclar endDeclar\n" +
				"something\n" + "endProg";
		ProdResult prod = hp.parse(input);
		System.out.println(prod.getEndGroup());
		//System.out.println(input);
	}

}
