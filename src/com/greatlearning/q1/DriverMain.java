package com.greatlearning.q1;

import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class DriverMain {

	static Scanner scan = new Scanner(System.in);
	static int size;
	static int[] floors;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Deque<Integer> lowerValuesStack = new ArrayDeque<>();
				
		inputValues();
		int maxValue;
		int lastPoppedValue;
		
		for(int i=0;i<floors.length;i++) {
			
			maxValue = Arrays.stream(floors).max().getAsInt();
			lastPoppedValue = maxValue;
			
			if (floors[i] == maxValue) {
				
				System.out.println("Day: "+(i+1));
				System.out.print(maxValue);
																
				for (Integer element : lowerValuesStack) {					
					
					if ((lastPoppedValue - lowerValuesStack.peek()) == 1) {
						
						lastPoppedValue = lowerValuesStack.pop();
						System.out.print(" "+lastPoppedValue);
						
						int foundIndex = searchValue(floors, lastPoppedValue);
						
						if (foundIndex >= 0) {
							floors[foundIndex] = -1;
						}
					}
                }
				
				floors[i] = -1;
				
			} else {
				
				lowerValuesStack.push(floors[i]);
				System.out.println("Day: "+(i+1));
				floors[i] = -1;
			}
			
			System.out.println();
		}
		
	}
	
	public static void inputValues()
	{
		System.out.println("enter the total no of floors in the building");
		
		size = scan.nextInt();
		floors = new int[size];
		int index;
		
		for(int i=0;i<size;i++) {
			
			System.out.println("enter the floor size given on day : "+(i+1));
			
			int enteredValue = scan.nextInt();
			
			index = searchValue(floors, enteredValue);			
			if (index >= 0) {
				
				System.out.println("The floor size should be distinct, please enter a unique value");
				break;
			} else {
				
				floors[i] = enteredValue;
			}
		}
	}
	
	public static int searchValue(int[] array, int targetValue)
	{
		for(int i=0; i<array.length;i++) {
			
			if (array[i] == targetValue) {
				
				return i;
			}
		}
		
		return -1;
	}
}
