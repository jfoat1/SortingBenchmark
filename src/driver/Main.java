package driver;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int[] selectionArray = generate_random(1, 1000000000, 100000000);
		int[] bubbleArray = copyArray(selectionArray);
		int[] insertionArray = copyArray(selectionArray);
		int[] shellArray = copyArray(selectionArray);
		int[] quickArray = copyArray(selectionArray);
		int[] mergeArray = copyArray(selectionArray);
		//arrayPrint(bubbleArray);
		
		/*
		Long startBubble = System.currentTimeMillis();
		bubbleSort(bubbleArray);
		Long endBubble = System.currentTimeMillis();
		Long bubbleTime = endBubble - startBubble;
		
		//arrayPrint(selectionArray);
		Long startSelect = System.currentTimeMillis();
		selectionSort(selectionArray);
		Long endSelect = System.currentTimeMillis();
		Long selectTime = endSelect - startSelect;
		
		//arrayPrint(insertionArray);
		//insertionSort(insertionArray);
		//arrayPrint(insertionArray);
		
		Long startInsert = System.currentTimeMillis();
		insertionSort(insertionArray);
		Long endInsert = System.currentTimeMillis();
		Long insertTime = endInsert - startInsert;
		
		
		//arrayPrint(shellArray);
		Long startShell = System.currentTimeMillis();
		shellSort(shellArray);
		Long endShell = System.currentTimeMillis();
		Long shellTime = endShell - startShell;
		//arrayPrint(shellArray);
		 */
		
		//arrayPrint(quickArray);
		Long startQuick = System.currentTimeMillis();
		quickSort(quickArray, 0, quickArray.length - 1);
		Long endQuick = System.currentTimeMillis();
		Long quickTime = endQuick - startQuick;
		//arrayPrint(quickArray);
		
		//arrayPrint(mergeArray);
		Long startMerge = System.currentTimeMillis();
		mergeSort(mergeArray, 0, mergeArray.length - 1);
		Long endMerge = System.currentTimeMillis();
		Long mergeTime = endMerge - startMerge;
		//arrayPrint(mergeArray);
		
		
		
		System.out.println("Sorting a random array size of 100,000,000:");
		//System.out.println("Bubble sort took " + bubbleTime + "ms to complete.");
		//System.out.println("Selection sort took " + selectTime + "ms to complete.");
		//System.out.println("Insertion sort took " + insertTime + "ms to complete.");
		//System.out.println("Shell sort took " + shellTime + "ms to complete.");
		System.out.println("Quick sort took " + quickTime + "ms to complete.");
		System.out.println("Merge sort took " + mergeTime + "ms to complete.");
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
	
	public static int[] generate_random(int start, int end, int total)
	{
		int[] result = new int[total];
		Random random = new Random(); 
		for(int i = 0; i < total; i++)
		{
			result[i] = random.nextInt(start, end + 1);
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
	
	public static int[] insertionSort(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			int j = i; 
			while(j > 0 && arr[j] < arr[j - 1])
			{
				int temp = arr[j - 1];
				arr[j - 1] = arr[j];
				arr[j] = temp;
				j--;
			}
		}
		return arr;
	}
	
	public static void insertionSort(int[] arr, int range) 
	{
		for(int k = 0; k < range; k++) 
		{
		    for (int i = k; i < arr.length; i = i + range) 
		    {
		        int current = i;
		        while ((current - range) >= 0 && arr[current] < arr[current-range]) 
		        {
		            int temp = arr[current];
		            arr[current] = arr[current - range];
		            arr[current - range] = temp;
		            current = current - range;
		        }
		    }
		}
	}
	
	public static void shellSort(int[] arr, int[] intervals) 
	{
		for(int k : intervals) 
		{
			insertionSort(arr, k);
		}
	}
	
	public static void shellSort(int[] arr)
	{
		double log2 = Math.log(arr.length) / Math.log(2);
		for(int k : twoIntervals(log2))
		{
			insertionSort(arr, k);
		}
	}
	
	public static int[] twoIntervals(double number)
	{
		int intNumber = (int) number;
		int[] answer = new int[intNumber + 1];
		for(int i = 0; i < answer.length; i++)
		{
			answer[i] = (int) Math.pow(2, (double) intNumber); 
			intNumber--; 
		}
		return answer; 
	}
	
	public static int partition(int[] arr, int low, int high)
	{
		int pivot = (low + high)/2;
		int pivotv = arr[pivot];
		
		boolean done = false;
		
		while(!done)
		{
			while(arr[low] < pivotv)
			{
				low++; 
			}
			
			while(arr[high] > pivotv)
			{
				high--;
			}
			
			if(low >= high)
			{
				done = true;
			}
			else
			{
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp; 
				
				low++; 
				high--; 
			}
		}
		return high;
	}
	
	public static void quickSort(int[] arr, int start, int end)
	{
		if(start >= end)
		{
			return;
		}
		
		int lowEnd = partition(arr, start, end);
		
		quickSort(arr, start, lowEnd);
		quickSort(arr, lowEnd + 1, end);
	}
	
	public static void merge(int[] arr, int leftmost, int leftlast, int rightlast)
	{
		int mergedSize = rightlast - leftmost + 1;
		int[] mergedArray = new int[mergedSize];
		int leftPos = leftmost;
		int rightPos = leftlast + 1;
		int mergePos = 0;
		
		while(leftPos <= leftlast && rightPos <= rightlast)
		{
			if(arr[leftPos] <= arr[rightPos])
			{
				mergedArray[mergePos] = arr[leftPos];
				leftPos++;
			}
			else
			{
				mergedArray[mergePos] = arr[rightPos];
				rightPos++;
			}
			mergePos++;
		}
		
		while(leftPos <= leftlast)
		{
			mergedArray[mergePos] = arr[leftPos];
			leftPos++;
			mergePos++;
		}
		
		while(rightPos <= rightlast)
		{
			mergedArray[mergePos] = arr[rightPos];
			rightPos++;
			mergePos++;
		}
		
		for(int i = 0; i < mergedSize; i++)
		{
			arr[leftmost + i] = mergedArray[i];
		}
	}
	
	public static void mergeSort(int[] arr, int startIndex, int endIndex)
	{
		if(startIndex < endIndex)
		{
			int mid = (startIndex + endIndex)/2;
			
			mergeSort(arr, startIndex, mid);
			mergeSort(arr, mid + 1, endIndex);
			
			merge(arr, startIndex, mid, endIndex);
		}
	}
}
