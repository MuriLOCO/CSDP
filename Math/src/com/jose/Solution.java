package com.jose;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
		int lengh = in.nextInt();
		int[] numberArray = new int[lengh];
		
		for (int i = 0; i < lengh; i++) {
			numberArray[i] = in.nextInt();
			}	
		
		in.close();
						
		final Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < lengh; i++) {
			int count = 0;
			if (map.get(numberArray[i]) != null) {
				count = map.get(numberArray[i]) + 1;
				map.put(numberArray[i], count);
			} else {
				map.put(numberArray[i], 1);
			}
		}

		int major = 0;
		int number = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > major) {
				major = entry.getValue();
				number = entry.getKey();
			}
		}

		if (major > numberArray.length / 2) {
			System.out.println("Yes " + number);
		}else{
			System.out.println("No");
		}
	}
}