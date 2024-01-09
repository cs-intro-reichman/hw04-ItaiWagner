public class ArrayOps {
    public static void main(String[] args) {
        // int missingIntArr[] =  {2, 2, 3, 7, 8, 3, 2, 8};
        // int checkEqual[] =  {8, 2, 7, 7, 3};
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
            } else if ((tmpNum > secondLargest) && (tmpNum <= largest)){
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
        // Deduping both arrays to compare them
        int[] dedupedArray1 = dedupArray(array1);
        int[] dedupedArray2 = dedupArray(array2);


        boolean areEqual = true;

        // iterate through both  deduped arrays to compare them
        if (dedupedArray1.length == dedupedArray2.length) {
            for (int i = 0; i < dedupedArray1.length; i++) {
                int tmpNum = dedupedArray1[i];
                boolean isNumExists = false;
                for (int j = 0; j < dedupedArray2.length; j++) {
                    if (tmpNum == dedupedArray2[j]) {
                        isNumExists = true;
                        break;
                    }
                }
                if (isNumExists == false) {
                    areEqual = false;
                    break;
                }
            }
        } else {
            areEqual = false;
        }
        return areEqual;
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


    /*
     * This function deduplicate a given int array. Note its a helper function.
     */
    public static int[] dedupArray(int[] array) {
        int[] uniqueArray = new int[array.length];
        int uniqueIndex = 0;

        for (int i = 0; i < array.length; i++) {
            boolean isUnique = true;
            // Checks if the current element is already in the uniqueArray
            for (int j = 0; j < uniqueIndex; j++) {
                if (array[i] == uniqueArray[j]) {
                    isUnique = false;
                    break;
                }
            }
            // If the element is unique it adds it to the uniqueArray
            if (isUnique) {
                uniqueArray[uniqueIndex] = array[i];
                uniqueIndex++;
            }
        }

        // Create a new array with the correct size
        int[] resultArray = new int[uniqueIndex];
        
        // coying the elements from uniqueArray to resultArray
        for (int i = 0; i < uniqueIndex; i++) {
            resultArray[i] = uniqueArray[i];
        }

        return resultArray;
    }
}