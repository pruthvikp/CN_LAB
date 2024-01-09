// Write a program for error detecting code using CRC-CCITT (16- bits).

import java.util.*;

public class CRC{
	
	// This method performs polynomial division using XOR operation.
	public static String calCRC(String data, String poly, boolean errcheck){
		StringBuilder rem=new StringBuilder(data);
		if(!errcheck){
			for(int i=0;i<poly.length()-1;i++)
				rem.append("0");
		}
		for(int i=0;i<rem.length()-poly.length()+1;i++){
			if(rem.charAt(i)=='1'){
				for(int j=0;j<poly.length();j++){
					rem.setCharAt( i+j, rem.charAt(i+j)==poly.charAt(j)? '0':'1' );
				}
			}
		}
		return rem.substring(rem.length()-poly.length()+1);
	}	

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		CRC obj=new CRC();
		
		String poly="10000100010001010";
		
		System.out.println("Enter the data");
		String data=sc.nextLine();
		String rem=obj.calCRC(data,poly,false);
		String codeword=data+rem;
		System.out.println("Codeword: "+codeword);
		
		System.out.println("Enter the received word");
		String recdata=sc.nextLine();
		String recrem=obj.calCRC(recdata,poly,true);
		if(Integer.parseInt(recrem,2)==0)
			System.out.println("No error");
		else
			System.out.println("There is an error in the received codeword");
		// recRem is a binary string representing the remainder obtained after dividing the received code word by the polynomial.
        // Integer.parseInt(recRem, 2) converts this binary string to its equivalent integer value in base 10.
	}

}


/*
Output:
------------------------------------------
Enter the data
1234
Codeword: 12340111111111100110
Enter the received word
12340111111111100110
No error
-------------------------------------------
Enter the data
1234
Codeword: 12340111111111100110
Enter the received word
12340111111111100111    
There is an error in the received codeword
--------------------------------------------
*/
