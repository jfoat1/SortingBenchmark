package driver;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int[] bubbleArray = generate_random_unique(1,300000,20000);
		int[] selectionArray = copyArray(bubbleArray); 
		//arrayPrint(bubbleArray);
		Long startBubble = System.currentTimeMillis();
		bubbleSort(bubbleArray);
		Long endBubble = System.currentTimeMillis();
		Long bubbleTime = endBubble - startBubble;
		//arrayPrint(selectionArray);
		Long startSelect = System.currentTimeMillis();
		selectionSort(selectionArray);
		Long endSelect = System.currentTimeMillis();
		Long selectTime = endSelect - startSelect;
		System.out.println("Sorting a random array size of 200000:");
		System.out.println("Bubble sort took " + bubbleTime + "ms to complete.");
		System.out.println("Selection sort took " + selectTime + "ms to complete.");
	}

	public static boolean Scan(int[] input, int target)
	{
		for(int i = 0; i < input.length; i++)
		{
			if(input[i] == target)
			{
				return true;
			}
		}
		return false;
	}
	
	public static int[] copyArray(int[] arr)
	{
		int[] result = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
		{
			result[i] = arr[i]; 
		}
		return result;
	}
	
	public static int[] generate_random_unique(int start, int end, int total)
	{
		int[] result = new int[total];
		for(int i = 0; i < total; i++)
		{
			while(result[i] == 0)
			{
				Random random = new Random();
				int number = random.nextInt(start, end + 1);
				if(!Scan(result, number))
				{
					result[i] = number; 
				}
			}
		}
		return result; 
	}
	
	public static void arrayPrint(int[] arr)
	{
		System.out.print(arr[0]);
		for(int i = 1; i < arr.length; i++)
		{
			System.out.print(", " + arr[i]);
		}
		System.out.println("");
	}
	
	public static int[] bubbleSort(int[] arr)
	{
		for(int i = 0; i < arr.length - 1; i++)
		{
			for(int j = 0; j < arr.length - 1 - i; j++)
			{
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	
	public static int[] selectionSort(int[] arr)
	{
		for(int i = 0; i < arr.length - 1; i++)
		{
			int smallestIndex = i;
			for(int j = i + 1; j < arr.length; j++)
			{
				if(arr[j] < arr[smallestIndex])
				{
					smallestIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[smallestIndex];
			arr[smallestIndex] = temp;
		}
		return arr; 
	}
}
