package csd;

class App {
	public static void main(String [] args)
	{
		GetShortestPangramENTest.run();
	}
}

class GetShortestPangramENTest {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		
		for (;;) {
			System.out.print("input a text:");
			String s = kb.nextLine();
			
			if ("quit".equals(s))
				break;
			
			System.out.printf("Shortest Pangram:%s%n", StringUtil.getShortestPangramEN(s));			
		}			
	}
}


class StringUtil {	
	public static String getShortestPangramEN(String s)
	{
		String result = s;
		
		int end = s.length();
		
		while (end != 0) {
			int begin = 0;
			
			while (begin != end) {
				String str = s.substring(begin++, end);
				
				if (str.length() >= 26 && isPangramEN(str) && str.length() < result.length())
					result = str;	
			}
			--end;
		}
		return result;		
	}
	
	public static boolean isPangram(String s, String alphabet)
	{
		int len = alphabet.length();
		
		for (int i = 0; i < len; ++i)
			if (s.indexOf(alphabet.charAt(i)) == -1)
				return false;
		
		return true;
	}
	
	public static boolean isPangramEN(String s)
	{
		return isPangram(s.toLowerCase(), "abcdefghijklmnopqrstuwxvyz");
	}
	
	public static boolean isPangramTR(String s)
	{
		return isPangram(s.toLowerCase(), "abcçdefgğhıijklmnoöprsştuüvyz");
	}	
}


