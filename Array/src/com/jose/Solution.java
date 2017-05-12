package com.jose;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

		final Scanner in = new Scanner(System.in);

		final int lenghArray1 = in.nextInt();
		final int[] intArray1 = new int[lenghArray1];

		for (int i = 0; i < lenghArray1; i++) {
			intArray1[i] = in.nextInt();
		}

		final int lenghArray2 = in.nextInt();
		final int[] intArray2 = new int[lenghArray2];

		for (int i = 0; i < lenghArray2; i++) {
			intArray2[i] = in.nextInt();
		}

		in.close();

		int[] finalArray = new int[intArray1.length + intArray2.length];
		System.arraycopy(intArray1, 0, finalArray, 0, intArray1.length);
		System.arraycopy(intArray2, 0, finalArray, intArray1.length, intArray2.length);

		bubbleSort(finalArray);		
		
		final int[] intersection = calculateIntersection(intArray1, intArray2);	
		
		bubbleSort(intersection);
		
		final int[] treatedArray = eliminateDuplicates(finalArray);
		
		
		
		for (int i = 0; i < treatedArray.length; i++) {
			System.out.print(treatedArray[i] + " ");
		}
        
		System.out.print("\n");
        
		for (int i = 0; i < intersection.length; i++) {
			System.out.print(intersection[i] + " ");
		}
		

	}

	private static void bubbleSort(int[] array) {
		boolean flag = true;
		while (flag) {
			flag = false;
			int temp = 0;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					flag = true;
				}
			}
		}
	}

	public static int[] eliminateDuplicates(final int[] array) {
		int newLength = array.length;
		// find length w/o duplicates:
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) { // if duplicate founded then
											// decrease length by 1
					newLength--;
					break;
				}
			}
		}

		int[] newArray = new int[newLength]; // create new array with new length
		newArray[0] = array[0]; // 1st element goes to new array
		int inx = 1; // index for 2nd element of new array
		boolean isDuplicate;

		for (int i = 1; i < array.length; i++) {
			isDuplicate = false;
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) { // if duplicate founded then change
											// boolean variable and break
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) { // if it's not duplicate then put it to new
								// array
				newArray[inx] = array[i];
				inx++;
			}
		}
		return newArray;
	}

	private static int[] calculateIntersection(final int[] array1, final int[] array2) {

		bubbleSort(array2);
		final int[] treatedArray2 = eliminateDuplicates(array2);
		int count = 0;		
		for(int i = 0; i < array1.length; i ++){
			for(int j = 0; j < treatedArray2.length; j++){
				if(array1[i] == treatedArray2[j]){					
					count++;					
				}
			}
		}
				
		final int[] intersectionArray = new int[count];
		int popCount = 0;
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < treatedArray2.length; j++) {
				if (array1[i] == treatedArray2[j]) {
					intersectionArray[popCount] = treatedArray2[j];
					popCount++;
				}
			}
		}
		return intersectionArray;
	}

   }