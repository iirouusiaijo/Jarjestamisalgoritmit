import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
public class program {

    public static int[] makerandomArray(int n)
    {
        int[] array = new int[n];
        Random gen = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = gen.nextInt(n);
        }
        return array;
    }

    public static int[] CreateAscendingArray(int n)
    {
        int[] array = new int[n];
        Random gen = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = gen.nextInt(n);
        }
        Arrays.sort(array);
        return array;
    }

    public static int[] CreateDescendingArray(int n)
    {
        Integer[] array = new Integer[n];

        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        Arrays.sort(array, Collections.reverseOrder());

        int[] resultArray = Arrays.stream(array).mapToInt(Integer::intValue).toArray();

        return resultArray;
    }

    static void bubbleSort(int[] array)
    {   
        int n = array.length;
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                     
                    
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
 

            if (swapped == false)
                break;
        }
    }

    public static void InsertionSort(int[] arr)
        { 
            int n = arr.length; 
            for (int i = 1; i < n; ++i) { 
                int key = arr[i]; 
                int j = i - 1; 

                while (j >= 0 && arr[j] > key) { 
                    arr[j + 1] = arr[j]; 
                    j = j - 1; 
                } 
                arr[j + 1] = key; 
            } 
        } 
      

    public static void printArray(int[] array)
    {
        for (int i : array) {
            System.out.print(i + " ") ;
        }
        System.out.println();
    }

    public static void QuickSorttest (int[] arr){
        quickSort(arr ,0, arr.length -1);
    }

    public static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); 
        for (int j=low; j<high; j++)
        {
 
            if (arr[j] <= pivot)
            {
                i++;
 

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }

    public static void quickSort(int[] arr, int low, int high){
        if (low < high)
        {

            int pi = partition(arr, low, high);
 

            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
    }
    }

    public static void shellSort(int[] array) {
        int n = array.length;

 
        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;

                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }


                array[j] = temp;
            }
        }
    }
    public static void mergeSort(int[] array) {
        int n = array.length;
        if (n > 1) {
            int mid = n / 2;


            int[] leftArray = Arrays.copyOfRange(array, 0, mid);
            int[] rightArray = Arrays.copyOfRange(array, mid, n);


            mergeSort(leftArray);
            mergeSort(rightArray);


            merge(array, leftArray, rightArray);
        }
    }
    public static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0, j = 0, k = 0;


        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }


        while (i < leftSize) {
            array[k++] = leftArray[i++];
        }


        while (j < rightSize) {
            array[k++] = rightArray[j++];
        }
    }

    public static void selectionSort(int[] arr){
        int n = arr.length; 
  

        for (int i = 0; i < n - 1; i++) { 

            int min_idx = i; 
            for (int j = i + 1; j < n; j++) { 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
            } 
  
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp;
        }
    }


    
    public static void main(String[] args) {
        int[] array = CreateDescendingArray(500000);
        //int[] array = CreateAscendingArray(500000);
        //int[] array = makerandomArray(500000);
        // printArray(array);
        int[] arrayBubbleSort = array.clone();
        int[] arrayMergeSort = array.clone();
        int[] arrayQuickSort = array.clone();
        int[] arrayArraysSort = array.clone();
        int[] arraySelectionSort = array.clone();
        int[] arrayShellSort = array.clone();
        int[] arrayInsertionSort = array.clone();

        long startTime, endTime, duration;
        // Bubble Sort
        startTime = System.nanoTime();
        bubbleSort(arrayBubbleSort);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Bubble Sort Time: " + duration + " nanoseconds");

        // Merge Sort
        startTime = System.nanoTime();
        mergeSort(arrayMergeSort);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Merge Sort Time: " + duration + " nanoseconds");

         //Quick Sort
        startTime = System.nanoTime();
        quickSort(arrayQuickSort, 0, arrayQuickSort.length - 1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Quick Sort Time: " + duration + " nanoseconds");
        
        // Arrays.sort (Java's built-in sorting algorithm)
        startTime = System.nanoTime();
        Arrays.sort(arrayArraysSort);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Arrays.sort Time: " + duration + " nanoseconds");

        // Selection Sort
        startTime = System.nanoTime();
        selectionSort(arraySelectionSort);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Selection Sort: " + duration + " nanoseconds");

        // Shell Sort
        startTime = System.nanoTime();
        shellSort(arrayShellSort);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Shell Sort Time: " + duration + " nanoseconds");

        // InsertionSort
        startTime = System.nanoTime();
        InsertionSort(arrayInsertionSort);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Insertion Sort Time: " + duration + " nanoseconds");
        




    }
}
