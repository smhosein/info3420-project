import java.awt.color.ProfileDataException;


public class MainClass 
{
	
	
	public static void main(String[] args)
	{
		CoreParser cp = CoreParser.getInstance();
		HeaderParser hp = HeaderParser.getInstance();
		DeclarationsParser dp = DeclarationsParser.getInstance();
		String input = 
				"prog: name\n" +
		        "startDeclar asd$b$ abcde35$ aeight12$ endDeclar\n" +
				"something\n" + "endProg";
		ProdResult prod = hp.parse(input);
		if (prod.isSuccess() == false)
		{
			System.out.println(prod.getEndGroup());
		}
		else
		{
			prod = dp.parse(prod.getEndGroup());
				System.out.println(prod.getEndGroup());
		}
		
		//System.out.println(input);
	}

}
