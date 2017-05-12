package com.jose;
import java.util.Scanner;

public class Solution {
public static void main(String[] args) {

		final Scanner in = new Scanner(System.in);
		final int lengh = in.nextInt();
		final byte[] byteArray = new byte[lengh];

		
		for (int i = 0; i < lengh; i++) {
			byteArray[i] = in.nextByte();
		}
		in.close();
	
		int maxZero = 0;
		int positionZero = 0;
		int maxOne = 0;
		int positionOne = 0;
		
		for(int i = 0; i < byteArray.length; i++){		
			int counter = 0;
			while(i + 1 < byteArray.length && byteArray[i] == byteArray[i + 1] && byteArray[i] == 0){
				counter++;				
				i++;
			}
			if(maxZero < counter && byteArray[i - 1] == 0){
				maxZero = counter + 1;	
				positionZero = i - counter;
			}
			
			while(i + 1 < byteArray.length && byteArray[i] == byteArray[i + 1] && byteArray[i] == 1){
				counter++;				
				i++;
			}
			if(maxOne < counter && byteArray[i - 1] == 1){
				maxOne = counter + 1;	
				positionOne = i - counter;
			}
			
		}
				
		System.out.println(positionZero + " " + maxZero + "\n" + positionOne + " " + maxOne);

	}

}