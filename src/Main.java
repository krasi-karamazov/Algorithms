import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello Java");
        //int[] data = {4, 100, 1, 2, 890, 10, 3};
        int[] socksData = {1, 1, 3, 1, 2, 1, 3, 3, 3, 3};
        int[] cloudData = {0, 0, 1, 0, 0, 1, 0};
        //bubbleSort(data);

       // insertionSort(data);

       /* for(int i = 0; i < data.length; i++) {
           // System.out.print(data[i] + ", ");
        }*/

        //System.out.println(sockMerchant(10, socksData));
        //System.out.println(countingValleys(8, "DDUUDDUDUUUD"));
        //System.out.println(jumpOnClouds(cloudData));
        //System.out.println(repeatedString("aba",  10));
        //int[] storeLine = {2, 1, 5, 3, 4};
       // minimumBribes(storeLine);
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<>(new Node<>(7));
        integerBinaryTree.root.left = integerBinaryTree.newNode(1);
        integerBinaryTree.root.left.right = integerBinaryTree.newNode(3);
        integerBinaryTree.root.left.left = integerBinaryTree.newNode(0);
        integerBinaryTree.root.left.right.right = integerBinaryTree.newNode(5);
        integerBinaryTree.root.left.right.left = integerBinaryTree.newNode(2);
        integerBinaryTree.root.left.right.right.right = integerBinaryTree.newNode(6);
        integerBinaryTree.root.left.right.right.left = integerBinaryTree.newNode(4);
        integerBinaryTree.root.right = integerBinaryTree.newNode(9);
        integerBinaryTree.root.right.right = integerBinaryTree.newNode(10);
        integerBinaryTree.root.right.left = integerBinaryTree.newNode(8);

        //integerBinaryTree.performDFS();
        int[] arr = {3,3};
        int[] nums = twoSum(arr, 6);
        System.out.print("[");
        for(int i : nums) {
            System.out.print(i + ", ");
        }
        System.out.print("]");
    }



    private static void minimumBribes(int[] storeLine) {
        int bribes = 0;
        for(int i = 0; i < storeLine.length - 1; i++) {
            if(storeLine[i] > storeLine[i + 1]){
                bribes+=storeLine[i] - storeLine[i + 1];
            }
        }
        System.out.println(bribes);
        if(bribes > 3) {
            System.out.println("Too chaotic");
        }
    }


    public static int[] twoSum(int[] nums, int target) {
        //transform array to map with nums as keys
        //get first key
        //in order to get the needed second key we subtract the current key from the sum
        //this way we get the needed key
        //then we try and find the needed key using the subtraction
        //0(n) time for transofrming
        //0(1) for searching
        int[] indices = new int[2];
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int sumToLookFor = target - nums[i];

            if(numsMap.containsKey(sumToLookFor)) {
                int[] arr = {numsMap.get(sumToLookFor), i};
                return arr;
            }
            numsMap.put(nums[i], i);
        }

        return indices;
    }

    static long repeatedString(String s, long n) {
        int numOccurences = 0;
        StringBuilder builder = new StringBuilder();
        builder.append(s);
        while(builder.length() < n) {
            builder.append(s);
        }
        int currentIndex = 0;
        int index = 0;
        while(currentIndex != -1) {
            currentIndex = builder.indexOf("a", index);
            index += currentIndex + 1;
            numOccurences++;
        }

        return numOccurences;
    }

    static int jumpOnClouds(int[] ar) {
        int i = 0;
        int steps = 0;
        while(i < ar.length) {
            if(i + 2 < ar.length && ar[i + 2] != 1) {
                i += 2;
                steps++;
            }else if(i + 1 < ar.length && ar[i + 1] != 1){
                i++;
                steps++;
            }else{
                i++;
            }
        }


        return steps;
    }

    static int countingValleys(int n, String s) {
        int valleys = 0;
        boolean inValley = false;
        int currentLevel = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'D') {
                currentLevel--;
                if(currentLevel < 0 && !inValley){
                    valleys++;
                    inValley = true;
                }
            }else{
                currentLevel++;
                if(currentLevel == 0) {
                    inValley = false;
                }
            }
        }

        return valleys;
    }

    static int sockMerchant(int n, int[] ar) {
        int numPairs = 0;

        List<Integer> socks = new ArrayList<>();

        for(int i = 0; i < ar.length; i++) {
            if(socks.contains(ar[i])) {
                numPairs++;
                socks.remove(socks.indexOf(ar[i]));
            }else{
                socks.add(ar[i]);
            }
        }


        return numPairs;
    }

    private static void insertionSort(int[] data) {
        for( int i = 1; i < data.length; i++) {
            int current = data[i];
            int j = i - 1;

            while(j >= 0 && data[j] > current) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = current;
        }
    }

    private static void bubbleSort(int[] data) {
        boolean sorted = false;

        while(!sorted) {
            sorted = true;

            for(int i = 1; i < data.length; i ++) {
                if(data[i - 1] > data[i]) {
                    int temp = data[i - 1];
                    data[i - 1] = data[i];
                    data[i] = temp;
                    sorted = false;
                }
            }
        }
    }
}
