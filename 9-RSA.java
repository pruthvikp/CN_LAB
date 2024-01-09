// Write a program for simple RSA algorithm to encrypt and decrypt the data.

import java.util.*;
import java.io.*;
import java.math.*;

public class RSA{
	
	private BigInteger p,q,N,phi,e,d;
	private int bitLength=1024;
	private Random r;
	
	public RSA(){
		r=new Random();
		
		p=BigInteger.probablePrime(bitLength,r);
		q=BigInteger.probablePrime(bitLength,r);
		N=p.multiply(q);
		phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		e=BigInteger.probablePrime(bitLength/2,r);
		while(phi.gcd(e).compareTo(BigInteger.ONE)>0 && e.compareTo(phi)<0){
			e=e.add(BigInteger.ONE);
		}
		d=e.modInverse(phi);
		System.out.println("Public key is: "+e);
		System.out.println("Private key is: "+d);
	}
	
	public static void main(String[] args) throws IOException{
		RSA rsa=new RSA();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the plaintext");
		String str=sc.nextLine();
		System.out.println("Encrypting string: "+str);
		byte[] encrypted=rsa.encrypt(str.getBytes());
		byte[] decrypted=rsa.decrypt(encrypted);
		System.out.println("Encrypted Byte Array: "+Arrays.toString(encrypted));
		System.out.println("Decrypted Byte Array: "+Arrays.toString(decrypted));
		String decryptedString=new String(decrypted);
		System.out.println("Decrypted string: "+decryptedString);
	}
	
	public byte[] encrypt(byte[] message){
		return (new BigInteger(message)).modPow(e,N).toByteArray();
	}
	
	public byte[] decrypt(byte[] message){
		return (new BigInteger(message)).modPow(d,N).toByteArray();
	}

}
		
		
/*
Output:
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Public key is: 8689282368396274183128696766333299772535161243290220171489089949566653273158848830070828776507185714064525142254575274263976809975747569319476703576757923
Private key is: 103999618545020351777274300148301460168270283307181034631766456711882342609746961370467118123752898822937788791286110574914403584810299764479190945832225
6190518440167472622580129053971415474093313678059366139108107121426614759365938201674087412497636085577182577440475501052435624714476857885447194727367373535737287897439
8508747824421972465097313184118556521347815943412550855525709499361366205651739116197306520036871004120642796256056178787942910487919622618812441333025673685646030001881
262843236781479284712830745786417952332836898595254892710304399927687270106432304759679953561163852991659737210461650020811787
Enter the plaintext
pruthvi
Encrypting string: pruthvi
Encrypted Byte Array: [90, -117, 58, 71, -118, 95, 0, -56, 28, 48, 43, -2, -104, -98, -98, -34, -102, -62, 8, -65, 44, 67, -81, -126, -5, 46, 78, -37, -109, 55, 74, 127, 
    -125, 18, -111, -53, 104, 29, 102, -120, -56, -35, -1, 3, -74, 58, 17, -120, -52, 76, 4, -84, -27, 21, 71, -80, 28, -16, -61, -103, -18, 117, 105, 71, -12, -74, 63, 
    -89, 50, 7, -90, -94, -125, -23, -89, -59, -4, 88, 11, -89, 32, -105, 5, -117, 85, -49, -56, 34, 119, -14, -53, -93, -103, -62, -103, 101, 94, 10, 109, 6, -16, 61, 
    -95, -32, -71, -31, -96, 99, -47, 110, -34, -83, 85, -116, 105, 8, -6, -71, -75, 47, -39, -109, -80, -14, 24, -1, 17, -34, -71, 8, 87, 54, -12, 21, -108, 116, 29, 
    -35, 98, -12, 0, 65, -120, -60, 75, -102, 115, -123, 79, -41, 95, 18, -104, 14, 123, 50, -112, -110, -95, 9, 52, 33, -51, 102, -25, 62, 58, 70, -54, -71, -71, 85, 
    78, -122, -75, -65, 59, -32, 95, -21, -52, -24, -60, 124, -123, 34, -3, -67, -90, -69, -101, 99, -2, 28, -32, 0, -33, 104, 24, 81, -35, 85, 102, -104, 62, -115, 
    -53, -117, -113, -18, -37, -56, -41, 96, -97, 78, 37, 108, 64, -92, 54, -53, -79, -124, -43, 16, -33, 49, -16, 73, 93, -3, -65, -75, -115, -81, -22, 51, 33, -72, 
    -69, 125, -6, -16, 2, 35, 41, -103, -10, 45, -2, 108, -26, -58, -42, -36]
Decrypted Byte Array: [112, 114, 117, 116, 104, 118, 105]
Decrypted string: pruthvi
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// If the bitlength is reduced to 128
Public key is: 17679204201156744409
Private key is: 289688862973708347995515081847690290538395934126424155027133997521550360789
Enter the plaintext
pruthvi
Encrypting string: pruthvi
Encrypted Byte Array: [13, 22, -88, 75, -2, -62, -95, 115, 30, -64, 34, -96, 64, -89, 73, -112, -115, 11, -37, -86, 104, -34, -39, -128, 100, -44, 13, -103, 101, 1, -8, -5]
Decrypted Byte Array: [112, 114, 117, 116, 104, 118, 105]
Decrypted string: pruthvi
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
