import java.awt.color.ProfileDataException;


public class MainClass 
{
	
	
	public static void main(String[] args)
	{
		CoreParser cp = CoreParser.getInstance();
		HeaderParser hp = HeaderParser.getInstance();
		DeclarationsParser dp = DeclarationsParser.getInstance();
		DisplayParser disp = DisplayParser.getInstance();

		
		/*String input = 
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
				//System.out.println(prod.getEndGroup());
		}
		
		String i = "set somes2d  to  23$  someother";
		prod = AssignmentParser.getInstance().parse(i);
		System.out.println(prod.getEndGroup());
		
		String test = 
				"prog: name\n" +
			    "startDeclar asd$b$ abcde35$ aeight12$ endDeclar\n" +
			    "set some to 23$\n" + "set oth3 to some$\n" +
			    "endProg";
		//System.out.println(cp.parse(test).getEndGroup());
		
		//System.out.println(input);*/
		
		String input = "display{g-\"test\"-x-\"test\"-a}$";
		ProdResult prod = disp.parse(input);
		System.out.println(prod.getEndGroup());
	}

}
