import java.util.ArrayList;

import org.testng.annotations.Test;

public class JavaStream {

	//Count the number of words starting with a
	 @Test
	public void regular()
	{
		ArrayList<String> names = new ArrayList<String>(); 
		names.add("Abhijeet");
		names.add("Bharati");
		names.add("Alekhya");
		names.add("Ram");
		names.add("Don"); 
		
		int count = 0;
		for(int i=0;i<names.size();i++)
		{
			String actual = names.get(i); 
			if(actual.startsWith("A"))
				count++;
		} 
		System.out.println("Number of names starting with A "+ count);
	}
}
