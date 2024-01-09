public class ArrayOps {
    public static void main(String[] args) {
        // int missingIntArr[] = {1,2,3,4,0,0,0};
        // int checkEqual[] = {0,1,2,3,4};
        // System.out.println(findMissingInt(missingIntArr));
        // System.out.println(secondMaxValue(missingIntArr));
        // System.out.println(containsTheSameElements(missingIntArr, checkEqual));
        // System.out.println(isSorted(missingIntArr));
    }

    /*
     * This function gets an array that is bigger than 1. and check if in
     * a given series of integers from 0 to n, there is a missing integer.
     */
    public static int findMissingInt (int [] array) {
        int n = array.length;
        int expectedSum = n * (n + 1)/2;

        int actualSum = 0;
        for (int i = 0; i < array.length; i++) {
            int tmpNum = array[i] ;
            actualSum += tmpNum;
        }

        return expectedSum - actualSum; 
    }


    /*
     * This function takes an array of integers, and returns the second largest number in the array.
     * The numbers in the array may appear more than once
     */
    public static int secondMaxValue(int [] array) {
        int largest = array[1];
        int secondLargest = array[0];
        if (largest < secondLargest) {
            int tmpVal = largest;
            secondLargest = largest;
            largest = tmpVal;
        }
        for (int i = 0; i < array.length; i++) {
            int tmpNum = array[i];
            if (tmpNum > largest) {
                secondLargest = largest;
                largest = tmpNum;
            } else if ((tmpNum > secondLargest) && (tmpNum < largest)){
                secondLargest = tmpNum;
            }
        }
        return secondLargest;
    }

    /*
     * This function takes two arrays of integers, and returns true if both arrays contain the same
     * numbers. The number of occurrences of each number, and their order, are not important.
     */
    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        // checking the max value of both arrays
        int maxElement = Math.max(maxValue(array1), maxValue(array2));
        // creating two frequencies arrays to count the numbers incident relying on the indexes
        int freq1[] = new int[maxElement +1];
        int freq2[] = new int[maxElement +1];
        boolean isEqual = true;


        for (int i = 0; i < array1.length; i++) {
            if (freq1[array1[i]] == 0) {
                freq1[array1[i]]++;
            }
        }

        for (int j = 0; j < array2.length; j++) {
            if (freq2[array2[j]] == 0) {
                freq2[array2[j]]++;
            }
        }
        // Comparing the frequencies arrays
        for (int i = 0; i < freq1.length; i++) {
            if (freq1[i] != freq2[i]) {
                isEqual = false;
            }
        }
        return isEqual;
    }


    /*
     * This function takes an array of integers and checks if the array
     *  is sorted increasingly, or decreasingly.
     */
    public static boolean isSorted(int [] array) {
        // setting the boolean variables
        boolean isAscending = true;
        boolean isDecreasing = true;
        boolean isSorted = true;
        int oldVal = array[0];
        // Checking if the array is ascending
        for (int i = 1; i < array.length; i++) {
            int newVal = array[i];
            if (newVal >= oldVal) {
                isAscending = true;
            } else {
                isAscending = false;
                break;
            }
            oldVal = newVal;
        }
        // if it doesnt ascending it checks if its decreasing
        if (isAscending == false) {
            for (int i = 1; i < array.length; i++) {
            int newVal = array[i];
            if (newVal <= oldVal) {
                isDecreasing = true;
            } else {
                isDecreasing = false;
                break;
            }
            oldVal = newVal;
            }
        }

        if (isAscending == false && isDecreasing == false) {
            isSorted = false;
        }

        return isSorted;
    }

    /*
     * This function gets an array and return the max value in it.
     * please note that this is an helper function
     */
    public static int maxValue(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            max = Math.max(max, num);
        }
        return max;
    }

}
