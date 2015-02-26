
public class test {
	public static void main(String[] args)
	{
		int num1 = 5;
		int num2 = 10;
		int value = 0;
		double value2 = 0;
		value = num2 -num1;
		System.out.println("value = "+value);
		value = ++num1;
		System.out.println("value = "+value);
		value = num2++;
		System.out.println("value = "+value);
		value = num2/num1;
		System.out.println("value = "+value);
		value = num2%num1;
		System.out.println("value = "+value);
		value = num2+num1*3;
		System.out.println("value = "+value);
		value = (num2+num1)*3;
		System.out.println("value = "+value);
		value += num1;
		System.out.println("value = "+value);
		//value = (double)value/num1;
		//System.out.println("value = "+value);
		value2 = num2/num1;
		System.out.println("value2 = "+value2);
		value2 = (double)(num2/num1);
		System.out.println("value2 = "+value2);
		value2 = (double)num2/num1;
		System.out.println("value2 = "+value2);
		value2 = value2--;
		System.out.println("value2 = "+value2);
		
		}
	
}
