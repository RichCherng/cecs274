package AssignmentSeven;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Assignment7 {
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner reader = new Scanner(new File(args[0]));
		String[] title = {"Doing %d Towers","%nDoing %d Factorials%n","Doing %d Palindromes%n","Doing %d Reverses%n"};
		for(int inCase = 0; inCase<4; inCase++)
		{
			int Case_num = Integer.parseInt(reader.nextLine());
			System.out.format(title[inCase], Case_num);
			
			for(int i=0; i < Case_num; i++)
			{
				switch(inCase)
				{
					case 0:
						int t = Integer.parseInt(reader.nextLine());
						Stack A = new Stack();
						for(int ii=t; ii > 0; ii--)
						{
							A.push(ii);
						}
						Stack B = new Stack();
						Stack C = new Stack();
						
						System.out.print("\nBefore\n"
								 + "Tower One " + printNum(t)
								 + "\nTower Two\n"
								 + "Tower Three");
						System.out.print("\nAfter\n"
								 + "Tower One" 
								 + "\nTower Two " + printNum(t)
								 + "\nTower Three\n");
						System.out.printf("For n = %d number of moves = %d",t,tower(t,A,B,C));
						
						/*while(!B.isEmpty())
						{
							System.out.println(B.pop());
						}*/
						break;
					case 1:
						int num = Integer.parseInt(reader.nextLine());
						System.out.format("%d factorial is %d%n",num,fac(num));
						break;
					case 2:
						String pal = "palindrome";
						String p = reader.nextLine();
						if(!checkPalindrome(p))
							pal = "not " +pal;
						System.out.format("%s is a %s%n",p,pal);
						break;
					case 3: 
						String in = reader.nextLine();
						System.out.format("%s reversed is %s%n",in,reverse(in));
						break;
				}
			}
			System.out.println();

		}
		
	}
	
	public static String printNum(int n)
	{
		String out ="";
		for(int i =1; i<=n; i++)
		{
			out += i+" ";
		}
		return out;
	}
	
	
	public static int tower(int disk, Stack A, Stack B, Stack C)
	{
		int count = 0;
		if(disk == 0)
		{
			//B.push(A.pop());
			//mMove ++;
		}
		else
		{
			count +=tower(disk - 1, A, C ,B);
			B.push(A.pop());
			count++;
			count +=tower(disk - 1, C, B, A);
		}
		return count;
	}
	/*
	public static int tower(int a)
	{
		//System.out.println(a);
		if(a==1)
		{
			return 1;
		}
		else
			return (int) (tower(a-1)+Math.pow(2,a-1));
	}*/
	
	public static int fac(int in)
	{
		if(in <= 1)
		{
			return 1;
		}
		else
		{
			return in * fac(in-1);
		}
	}
	
	public static boolean checkPalindrome(String in)
	{
		if(in.length() == 1 || in.length() == 0)
		{
			return true;
		}
		else
			if(in.charAt(0) == in.charAt(in.length()-1))
				return checkPalindrome(in.substring(1,in.length()-1));
		return false;
	}
	
	public static String reverse(String in)
	{
		if(in.length() <= 1)
			return in;
		else
			return reverse(in.substring(1)) +in.charAt(0);
	}
}
