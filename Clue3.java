//Coding Assignment – SET A Intellyzen pune

import java.util.Scanner;
import java.util.ArrayList;

class Clue3 
{
	public static void main(String args[])
	{
		System.out.println("Give input");
		Scanner tempInput = new Scanner(System.in);
		
		int numberOfTestCases = tempInput.nextInt();
		if( !(1<=numberOfTestCases && numberOfTestCases <= 100))
		{
			System.out.println("No. of test cases allowed 1-100 (both inclusive) ");
			return;
		}
		
		ArrayList<TestCase> list_of_TestCases = new ArrayList<TestCase>();
		
		String c = tempInput.nextLine();// if this line is not put string 'a' inside for loop is not taking input for first test case. reason unknown
		for(int i=0;i<numberOfTestCases;i++)
		{
			
			String a = tempInput.nextLine();//Pattern
			if (!(1<=a.length() && a.length()<= 1000))
			{
				System.out.println("Pattern number of characters can be only 1-1000 (both inclusive) ");
				return;
			}
			
			String b = tempInput.nextLine();// Text String
			if (!(1<=b.length() && b.length()<= 100000))
			{
				System.out.println("Text String number of characters can be only 1-100000 (both inclusive) ");
				return;
			}
			
			//System.out.println("hello a= "+ a + " b="+b);
			list_of_TestCases.add(new TestCase(a,b));
			
		}
		
		for(TestCase t:list_of_TestCases)
		{
			
			FindAllPermutations.isPossible(t); 
			
		}
		
		for(TestCase t:list_of_TestCases)
		{
			System.out.println(t.getPatternExists()? "YES" : "NO") ;
		}
	}
	
}


class TestCase
{
	private String pattern;
	private String scribbledTextString;
	private boolean patternExists;
	/*private StringBuffer permutationFound;
	public ArrayList<String> allArrangements;
	*/
	 
	 TestCase(String inputPattern, String inputText)
	 {
		 this. pattern= new String(inputPattern);
		 this.scribbledTextString = new String(inputText);
		 this.patternExists=false;
		// this.permutationFound=new StringBuffer("");
		 
		 
	 }
	 
	 public String getPattern()
	 {
		 return pattern;
	 }
	 
	 public String getScribbledTextString()
	 {
		 return scribbledTextString;
	 }
	 
	 public boolean getPatternExists()
	 {
		 return patternExists;
	 }
	/*
	public String getPermutationFound()
	 {
		 return permutationFound.toString();
		 
	 }*/
	 public void setPatternExists(boolean a)
	 {
		 patternExists=a;
	 }
	 /*
	 public void setPermutationFound(String a)
	 {
		 if(this.permutationFound.toString().equals(""))
		 {
			permutationFound.append(a);
		 }
		else
		 {
			 // time insufficient & not required for current assignment set A
		 }
	 }*/
	 
	
	
}


class FindAllPermutations
{
	
	 public static void isPossible(TestCase testObj)
	 {
		 String str = testObj.getPattern();
		 String str2 = testObj.getScribbledTextString();
		 int a= testObj.getPattern().length();
		 int b= testObj.getScribbledTextString().length();
		 if(a>b)
		 {
			 return;
		 }
		 int[] array1  = new int[a] ;
		 int[] array2  = new int[a] ;
		 
		 for(int i=0;i<a;i++)
		 {
			 int count=0;
			for(int j=0;j<a;j++) 
			 {
				 if(str.charAt(i)==str.charAt(j))
				 {
					 count++;
				 }
			 }
			 array1[i]=count;
		
		 }
		 
		 
		 for(int i=0;i<a;i++)
		 {
			 int count=0;
			for(int j=0;j<b;j++) 
			 {
				 if(str.charAt(i)==str2.charAt(j))
				 {
					 count++;
				 }
			 }
			 array2[i]=count;
		
		 }
		 
		 boolean temp=true;
		 searchint:
		  for(int i=0;i<a;i++)
		 {
			 
			 if(array1[i]!=array2[i])
			 {
				 if(array2[i]>array1[i])
				 {
					 temp=true;
					 
					 
				 }
				 else
				 {
					temp=false;
					break searchint;
				}
			 }
		 }
		 
			 testObj.setPatternExists(temp);
		
		 
			 
		 
	 }
	

	  
}
	
	
