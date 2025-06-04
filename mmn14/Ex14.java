/**
 * Exm14, each method describing in details the question
 * @author - Eyal Haimov
 * @version - 316316868
 */
public class Ex14 {
    /**
     * This method is Given Array full with numbers each number appears twice
     * For example {6,6,18,18,-4,-4,12,9,9} - two indexes [i] and [i+1] are equals 
     * The method finds and output the Single element in the array
     * @param first - first index
     * @param last - the last index
     * @param middle - the middle index
     * @return - The number that appears once in the array
     */
    public static int findSingle (int[] a) // 
    {
        int first = 0; 
        int last = a.length - 1; // length of array - first index[0]-> length-0, [last index] -> a.length-1
        while (first <= last) // (loop) from first index - to last index
        {
            int middle = first + (last - first) / 2; // divided the index by 2 - to get the [middle] index array
            if(first == last) // first index = last index -> 
            {
                return a[first]; // returning the element that appears once
            } else if (middle % 2 == 0) {  // odd number of elemnent 
                if(a[middle] == a[middle+1]){  // if two index are equal to each other 
                    first = middle + 2; // go to the next index - [i+2]
                } else { 
                    last = middle; // if they aren't equal -> last = middle -> returning the number 
                }
            } else{  // even number of elements
                if (a[middle] == a[middle-1]){  // if two index are equal to each other 
                    first = middle + 1; // go to the next index - [i+1]
                } else { // if they are not equal to each other
                    last = middle - 1; // last = middle-1 (the one that is different) -> returning the number
                }
            }
        }
        return -1;
    }
    /** (Question 1) Explanation: divided the amount of number by two to see if there is even or odd number elements
     * from there I checked each two index to see if one two only appearing once.
     * I used arithmetic progression as a solution to improve the time efficiency, the program is similiar to binary search but without sorting it.
     * if one is found returns it: line - (return a[first])
     * time complexity - o(logn), space complexity - o(1) **log base = 2
     * time complexity: there is 1 loop that runs (n) amount of times
     * space complexity: 2 (int) - first is index for loop, last - is length, 3 (int) middle inside the loop
     */ 
    /**
     * This method inputting array of positive numbers and Positive number (x)
     * The method finds the size of smallest sum of sub array that is greater than (x), and output his size
     * @param arr - array
     * @param length - length of the sub array (=max value of integer)
     * @param left - left side of the array
     * @param right - first index
     * @param x - the number we are comparing the sum with
     * @return - the size of smallest sum of sub array that is bigger than (x)
     */
    public static int smallestSubSum(int arr[], int x)  
    {
        int Sum = 0;
        int left = 0; // current sum, left side
        int length = Integer.MAX_VALUE; // length to compare with - ׳©׳•׳׳£ ׳׳׳™׳ ׳¡׳•׳£ - ׳¢׳¨׳ ׳׳§׳¡׳™׳׳׳™ ׳”׳׳₪׳©׳¨׳™ ׳׳׳©׳×׳ ׳”
        if(arr.length == 0){ // if array is empty returns -1
            return -1; 
        }
        for (int right = 0; right < arr.length; right++) // running from first indes to last
        {
            Sum += arr[right]; // adding the first index to sum
            while (Sum > x && left <= right) // while sum is greater than x and left is less or equal to right
            {
                length = Integer.min(length, right - left + 1); // min (max integer, right(index of array) - left + 1)
                Sum -= arr[left];
                left++;
            }
        }
        if(length == Integer.MAX_VALUE){ // if the sum is smaller than x after all the number in the array are used, returns -1
            return -1;
        }
        // return result
        return length;
    }
    /** (Question 2): for loop to start from the first index until we get to the required sum we wanted,
     * each time in a while it is comparing to sum we want (the length is equal to the maxium amount of integer - it is Striving for infinity)
     * if the sum is bigger than x, while loop will stop working and report the size of subarray
     * time complexity - o(n), space complexity - o(1)
     * time complexity: 1 loop that runs (n) amount of times, two booleans outside the loop
     * space complexity: 3 (int), right defines loop, the space for the array comes from calling the method
     * */ 

    /**
     * Static recursive method that accepting (num) as positive number,
     * and return the solutions to equation (x1+x2+x3=num), each x: is (x>0) && (1-10)
     * The output (num) prints the solutions each one seperated line
     * Private method to calculate the sum using x1,x2,x3
     * @param num - the sum of (x1+x2+x3): positive parameter between 3-30
     * @param x1 - positive parameter between 1-10
     * @param x2 - positive parameter between 1-10
     * @param x3 - positive parameter between 1-10
     * @return - (if num>30 || num<3) - returns 0, otherwise - the amount of solutions possible to get to num
     */
    public static int solutions(int num)
    {
        if(num < 3 || num > 30){ // returns 0 -> a>0
            return 0;
        }else{
            return solutions(num, 1, 1, 1); // inputting the numbers = 1, 1, 1 as starting values until getting to acquired result
        }
    }
    private static int solutions(int num, int x1, int x2, int x3)
    {
        int correct = 0;
        if(x1 + x2 + x3 == num) // (x1+x2+x3=num)
        {
            correct = 1;
            System.out.println(x1 + "+" + x2 + "+" + x3 + "=" + num); // output: 1+1+1=3
        }
        if((x3 < 10) && (x1 + x2 + x3 < num)) // [x3 - 1-10] x3<10 && x3>0 and x1+x2+x3 is smaller than num, we are increasing the value of x3
        {
            return correct + solutions(num, x1, x2, ++x3);
        }
        else if ((x2 < 10) && (x1 + x2 < num)) // if x2<10 and x1+x2 is smaller than num, we are increasing the value of x2
        {
            return correct + solutions(num, x1, ++x2, 1);
        }
        else if ((x1 < 10) && (x1 < num)) // if x1<10 and x1 is smaller than num, we are increasing the value of x1
        {
            return correct + solutions(num, ++x1, 1, 1);
        }  
        else
        {
            return correct;
        }
    }
/**
 * Given a square boolean matrix, this method counts how many separated
 * regions contain {@code true} values. Two cells belong to the same region
 * if they share a horizontal or vertical side.
 *
 * @param mat the matrix of areas (true/false)
 * @return the number of separated true areas
 */
    public static int cntTrueReg(boolean[][] mat) {
        if (mat == null || mat.length == 0 || mat.length != mat[0].length) {
            return 0;
        }

        boolean[][] visited = new boolean[mat.length][mat.length];
        int count = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] && !visited[i][j]) {
                    markRegion(mat, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void markRegion(boolean[][] mat, boolean[][] visited, int i, int j) {
        if (!isValid(mat.length, i, j) || visited[i][j] || !mat[i][j]) {
            return;
        }

        visited[i][j] = true;

        markRegion(mat, visited, i + 1, j);
        markRegion(mat, visited, i - 1, j);
        markRegion(mat, visited, i, j + 1);
        markRegion(mat, visited, i, j - 1);
    }

    private static boolean isValid(int arrayLen, int i, int j) {
        return i > -1 && j > -1 && i < arrayLen && j < arrayLen; // the boundaries we are checking in the array, if it negative i or j
    }
}
