import javax.swing.JOptionPane; 

public class mainMethod {
	
public static ArrayStack s = new ArrayStack();
public static Queue q= new ArrayQueue();
public static boolean pali;
public static int count1;
public static int count2;
public static int count3;

	public mainMethod() {
	}

	public static void main(String[] args) {

		boolean palindrome1; boolean paliB1;
		boolean palindrome2; boolean paliB2;
		boolean palindrome3; boolean paliB3;
		int i=0; int k=0; 
		
		//Starts timer then iterates through loop from 0 to 1 million in both decimal and
		//binary form of the reverseCheck method
		long start1=System.currentTimeMillis();
		for (int j=0;j<=1000000;j++) {
			palindrome1=reverseCheck(Integer.toString(j));
			paliB1=reverseCheck(binaryConvert(Integer.toString(j)));
			
			//This loop checks if j is a multiple of 500000 and if it is it prints out the
			//number of operations count 1. This is used to test the efficiency.
			if (j%50000==0) {
				System.out.println(count1);
			}
			
		}
		//Timer ends and time is printed out with the number of operations
		long end1=System.currentTimeMillis();
		long time1= end1-start1;
		System.out.println("\nReverse time:"+time1);
		System.out.println("Number of operations:"+count1+"\n");
		
		//Starts timer then iterates through loop from 0 to 1 million in both decimal and
		//binary form of the indivCharacterCheck method
		long start2=System.currentTimeMillis();
		for (int j=0;j<=1000000;j++) {
			palindrome2=indivCharacterCheck(Integer.toString(j));
			paliB2=indivCharacterCheck(binaryConvert(Integer.toString(j)));
			
			//This loop checks if j is a multiple of 500000 and if it is it prints out the
			//number of operations count 1. This is used to test the efficiency.
			if (j%50000==0) {
				System.out.println(count2);
			}
		}
		//Timer ends and time is printed out with the number of operations
		long end2=System.currentTimeMillis();
		long time2= end2-start2;
		System.out.println("IndivChar time:"+time2);
		System.out.println("Number of operations:"+count2+"\n");
		
		//Starts timer then iterates through loop from 0 to 1 million in both decimal and
		//binary form of thestackQueueCheck method
		long start3=System.currentTimeMillis();
		for (int j=0;j<=1000000;j++) {
			palindrome3=stackQueueCheck(Integer.toString(j));
			paliB3=stackQueueCheck(binaryConvert(Integer.toString(j)));
			
			//This loop checks if j is a multiple of 500000 and if it is it prints out the
			//number of operations count 1. This is used to test the efficiency.
			if (j%50000==0) {
				System.out.println(count3);
			}
		}
		//Timer ends and time is printed out with the number of operations
		long end3=System.currentTimeMillis();
		long time3= end3-start3;
		System.out.println("Stack/Queue time:"+time3);
		System.out.println("Number of operations:"+count3+"\n");
		

		//This loop counts the number of palindromes that exist when they are in decimal and 
		//binary form
		for ( i=0;i<1000000;i++) {
			if (reverseCheck(Integer.toString(i)) && reverseCheck(binaryConvert(Integer.toString(i))))
					{
//				System.out.println(i);
				k++;
			}
		}
		System.out.println("Number of both palidromes:"+ k);
	}
	

	//This method checks if the string is a palindrome by reversing the string and checking against original string
	public static boolean reverseCheck(String input)
	{
		
		int j=0; 
		count1++;
// Firstly I tried looping through the input string to reverse it using a for loop. This 
// worked well for small numbers, however when I looped from 0 to 1 million it would not execute
// in sufficient time.
		
//		for (int i =input.length()-1;i>=0;i--)
//		{
//			backwards=backwards+input.charAt(i);
//		}
		
// I then tried a while loop but this would not execute on loops greater than 0 to 100,000	
		
//		while (i<=input.length()-1) {
//			char number=input.charAt(input.length()-(i+1));
//			backwards += Character.toString(number);
//			i++;
//		}

// I then combined the reverse and check steps into this single while loop but this would not
// run well either
		
//		while(i<=input.length()-1) {
//			char number= input.charAt(input.length()-(i+1));
//			backwards+=Character.toString(number);
//			if (input.charAt(i)==backwards.charAt(i)) 
//			{
//				pali=true;
//			}
//			else return pali=false;
//			i++;
//		}
//		return pali;
//	}


// Finally I had to use the reverse function to reverse the string 		
		String backwards="";
		count1++;
		backwards= new StringBuffer(input).reverse().toString();
		count1=count1+4;
		
// while loop compares each character of 2 strings and returns true/false
		while(j<input.length()) {
			count1=count1+2;
			if (input.charAt(j) == backwards.charAt(j))
			{
				count1=count1+4;
				pali=true;
			}
			
			else {
				count1=count1+2;
				pali=false;
				return false;
				}
			count1++;
			j++;
		}
		count1++;
		return pali;	
	}
	
	
	//This method checks start of string against end of the string and returns true/false
	public static boolean indivCharacterCheck(String input ) {
		count2++;
		int k=0;
		
		//if string is length 1 it has to be a palindrome so return true
		if (input.length()==1) {
			count2=count2+2;
			return pali=true;
		}
		
		//loops through string and checks front and back of the stack. If not the same immediately
		//return false. Otherwise return true.
		while (k<input.length()-1) {
			count2=count2+2;
			
			if (input.charAt(k) == input.charAt(input.length()-(k+1))){
				count2=count2+7;
				pali=true;
			}
			else {
				count2++;
				return pali=false;
			}
			count2++;
			k++;
		}
		count2++;
		return pali;
	}
	
	//This method implements stacks and queues. It adds each number to both the stack and the queue
	//and then pops/dequeues each number and compares. It returns true/false
	public static boolean stackQueueCheck(String input) {
		count3=count3+2;
		int l=0; 
		boolean ok=false;
		
		//if string is length 1 it has to be a palindrome so return true
		if (input.length()==1) {
			count3=count3+3;
			return ok=true;
		}
		
		//pushes/enqueues all numbers in the string
		while (l<input.length()) {
			count3=count3+7;
			s.push(input.charAt(l));
			q.enqueue(input.charAt(l));
			l++;
		}
		
		//pops/dequeues the stack and queue and compares the two. If not the same immediately 
		// return false. else return true.
		while (!s.isEmpty()) 
		{
			count3=count3+2;
			if (s.pop() == (q.dequeue()))	
			{
				count3=count3+5;
				ok=true;
				return ok;
			}
			else
			{
				count3=count3+2;
				ok=false;
				return ok;
			}
		}
		count3++;
		return ok;
		
	}
	

	
	// This method converts decimal numbers to binary form and returns it in the form of a string
	public static String binaryConvert(String input) {
		int i=0; int j=0; int k=0;
		String binaryForm="";
		// converts the string into an integer value
		int val=Integer.parseInt(input);
		int backwardsString[]= new int[100];
				
		// while loop keep dividing by 2 until the value is less than 0. If there is a remainder
		//in the division a 1 will be added to the array. Otherwise a 0 is added.
		while (val>0) {
			backwardsString[i]=val%2;
			i++;
			val=val/2;
			k++;
		}
		
		// This while loop converts the array to a string
		String temp="";
		while(j<k) {
			temp+=backwardsString[j];
			j++;
		}
		
		//Firstly I tried reversing the string and adding it to the binaryform string with a for loop, however,
		// this would not complete on my laptop on numbers for backwardsString length greater than
		// 100,000. For this reason I had to use the inbuilt reverse function.
		
		
//		for (int j=i-1; j>=0;j--) {
//			binaryForm +=backwardsString[j];
//		}
//		System.out.println(binaryForm);
		
		binaryForm= new StringBuffer(temp).reverse().toString();

		return binaryForm;
	}
}
