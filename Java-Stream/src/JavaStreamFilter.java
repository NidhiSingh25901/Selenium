import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreamFilter {

	@Test
	public void StreamFilter()

	{

			ArrayList<String> names = new ArrayList<String>(); 
			names.add("Abhijeet");
			names.add("Bharati");
			names.add("Alekhya");
			names.add("Ram");
			names.add("Don");  
			
			//There is no life for immediate operation if there is no life for terminal operation
			//terminate operation will execute only if inter (filter) operation is true 
			//We can create Stream
			long namecount = names.stream().filter(s->s.startsWith("A")).count();
			
			System.out.println(namecount); 
			
			long d = Stream.of("Ajay", "Sushant", "Ankita", "Priyanshi","Abhijeet").filter(s->
			{
				s.startsWith("A"); 
				return true;
			}).count(); 
			System.out.println(d); 
			
			names.stream().filter(s->s.length()>4).forEach(s-> System.out.println(s));  // Printing names whose length is greater than 4 
			names.stream().filter(s->s.length()>4).limit(1).forEach(s-> System.out.println(s)); // Printing first name whose length is greater than 4
			
	} 
	
	@Test
	public void StreamMap()
	{  
		
		ArrayList<String> names = new ArrayList<String>(); 
		names.add("Abhijeet");
		names.add("Bharati");
		names.add("Alekhya");
		names.add("Ram");
		names.add("Don");   
		
		//Printing names whose last letter is a 
		 Stream.of("Ajay", "Sushant", "Ankita", "Priyanshi","Abhijeet").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		 .forEach(s->System.out.println(s));	 
		 
		 //Printing names whose names starts with A in uppercase and in sorted way
		 List<String> names1 = Arrays.asList("Ajay", "Sushant", "Ankita", "Priyanshi","Abhijeet");
		 names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		 
		 Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		 newStream.sorted().forEach(s->System.out.println(s));
		 boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Ajay")); 
		 System.out.println(flag);
		 Assert.assertTrue(flag);
	} 
	
	@Test
	public void StreamCollect() 
	{
		ArrayList<String> names = new ArrayList<String>(); 
		names.add("Abhijeet");
		names.add("Bharati");
		names.add("Alekhya");
		names.add("Ram");
		names.add("Don");
		
		List<String> newList= names.stream().filter(s->s.startsWith("A")).collect(Collectors.toList());
		newList.stream().forEach(s->System.out.println(s+"; "));
		 
	} 
	
    @Test
    public void StreamUnique() 
    {
    	//To print unique number, sort and print
		List<Integer> val= Arrays.asList(1,5,6,7,4,6,8,8,3,9,2,0,2,4,7,9,2,3,3,8,9,9,6,3,2,0);
		List<Integer> unique=val.stream().distinct().collect(Collectors.toList());
		unique.stream().sorted().forEach(s->System.out.print(s+"; "));
		System.out.println();
		
    }
	 
}
