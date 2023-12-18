import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int[] newIntervals = {4,8};
        int[][] answer = insert(intervals, newIntervals);
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < answer.length; i++){
            builder.append("{" + answer[i][0] + ", " + answer[i][1] + "}");
        }
        System.out.println(builder.toString());
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            boolean doBreak = false;
            for(int j = 0; j < nums.length; j++){
                if((j != i) && (nums[i] + nums[j] == target)){
                    result[0] = i;
                    result[1] = j;
                    doBreak = true;
                    break;
                }
            }
            if(doBreak == true){
                break;
            }
        }
        return result;
    }

    private static String convert(String s, int numRows) {
        String[] rows = new String[numRows];
        for(int i = 0; i < rows.length; i++){
            rows[i] = "";
        }
        char[] sInCharArray = s.toCharArray();

        int countFirstStage = 0;
        int countSecondStage = numRows - 2;
        int whatStage = 1;
        for(int j = 0; j < sInCharArray.length; j++){
            if(whatStage == 1){
                rows[countFirstStage] = rows[countFirstStage] + sInCharArray[j];
                countFirstStage += 1;
                if((countFirstStage == numRows) && (numRows > 2)){
                    whatStage = 2;
                    countFirstStage = 0;
                }
                else if((countFirstStage == numRows) && (numRows <= 2)){
                    countFirstStage = 0;
                }
            }
            else if(whatStage == 2){
                if(countSecondStage > 1){
                    rows[countSecondStage] = rows[countSecondStage] + sInCharArray[j];
                    countSecondStage -= 1;
                }
                else if(countSecondStage == 1){
                    rows[countSecondStage] = rows[countSecondStage] + sInCharArray[j];
                    whatStage = 1;
                    countSecondStage = numRows - 2;
                }
            }
        }

        String result = "";
        for(int k = 0; k < rows.length; k++){
            result = result + rows[k];
        }
        return result;
    }

    private static boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        char[] xCharArray = xStr.toCharArray();
        String reversedX = "";
        for(int i = xCharArray.length - 1; i >= 0; i--){
            reversedX = reversedX + xCharArray[i];
        }
        return xStr.equals(reversedX);
    }

    static Map<Character, Integer> mapRomanSymbols = new HashMap<>();

    static
    {
        mapRomanSymbols.put('I', 1);
        mapRomanSymbols.put('V', 5);
        mapRomanSymbols.put('X', 10);
        mapRomanSymbols.put('L', 50);
        mapRomanSymbols.put('C', 100);
        mapRomanSymbols.put('D', 500);
        mapRomanSymbols.put('M', 1000);
    }
    private static int romanToInt(String s) {
        int result = 0;
        int last = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            int current = mapRomanSymbols.get(s.charAt(i));
            if(current >= last){
                result += current;
            }
            else{
                result -= current;
            }
            last = current;
        }
        return result;
    }

    private static String longestCommonPrefix(String[] strs) {
        int theShortiestStr = strs[0].length();
        String result = "";
        for(int i = 0; i < strs.length; i++){
            if(strs[i].length() < theShortiestStr){
                theShortiestStr = strs[i].length();
            }
        }

        for (int j = 0; j < theShortiestStr; j++){
            boolean isThisCharsEquals = true;
            for(int k = 0; k < strs.length; k++){
                if(strs[0].charAt(j) != strs[k].charAt(j)){
                    isThisCharsEquals = false;
                }
            }
            if(isThisCharsEquals){
                result = result + strs[0].charAt(j);
            }
            else{
                break;
            }
        }

        return result;
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultList = new HashSet<>();

        if (nums.length >= 3) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++){
                int left = i + 1;
                int rigth = nums.length - 1;
                while(left < rigth){
                    int sum = nums[i] + nums[left] + nums[rigth];
                    if(sum == 0){
                        resultList.add(Arrays.asList(nums[i], nums[left], nums[rigth]));
                        left++;
                        rigth--;
                    }
                    else if(sum < 0){
                        left++;
                    }
                    else{
                        rigth--;
                    }
                }
            }
        }

        return new ArrayList<>(resultList);
    }




    private static int searchInsert(int[] nums, int target) {
        int index = nums.length;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                index = i;
                break;
            }
            else if(target >= nums[i]){
                index = i;
                break;
            }
        }

        return index;
    }

    private static int[] plusOne(int[] digits) {
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 0;

        for(int j = 0; j < digits.length; j++){
            newDigits[j + 1] = digits[j];
        }
        for(int i = newDigits.length - 1; i >= 0; i--){
            if(newDigits[i] == 9){
                newDigits[i] = 0;
            }
            else{
                newDigits[i] = newDigits[i] + 1;
                break;
            }
        }

        if(newDigits[0] != 0){
            return newDigits;
        }
        else{
            int[] finalDigits = new int[digits.length];
            for(int k = 0; k < digits.length; k++){
                finalDigits[k] = newDigits[k + 1];
            }
            return finalDigits;
        }
    }

    private static int mySqrt(int x) {
        return (int)Math.floor(Math.sqrt(x));
    }

    private static int reverse(int x) {
        if((x >= Math.pow(-2, 31)) && (x <= Math.pow(2, 31))){
            int multiply;
            if(x >= 0){
                multiply = 1;
            }
            else{
                multiply = -1;
            }
            String xInStr = String.valueOf(abs(x));
            return reversAndParseInt(xInStr, multiply);
        }
        else{
            return 0;
        }
    }

    private static int reversAndParseInt(String str, int multiply){
        char[] strInChars = str.toCharArray();
        boolean isItStartZero = true;
        String finalStr = "";

        for(int i = strInChars.length - 1; i >= 0; i--){
            if((isItStartZero == true) && (strInChars[i] == 0)){
                continue;
            }
            else if((isItStartZero == true) && (strInChars[i] != 0)){
                finalStr = finalStr + strInChars[i];
                isItStartZero = false;
            }
            else if(isItStartZero == false){
                finalStr = finalStr + strInChars[i];
            }
        }

        try{
            return Integer.parseInt(finalStr) * multiply;
        }
        catch (Exception e){
            return 0;
        }
    }

    private static int removeElement(int[] nums, int val) {
        int read = 0;
        int write = 0;
        int countElementsRemove = 0;

        while(read < nums.length) {
            if (nums[read] == val) {
                ++read;
                ++countElementsRemove;
            } else {
                nums[write] = nums[read];
                ++read;
                ++write;
            }
        }

        return nums.length - countElementsRemove;
    }

    private static LinkedList<Integer> addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        String firstNum = "";
        String secondNum = "";
        LinkedList<Integer> resultList = new LinkedList();

        Iterator var5;
        int i;
        for(var5 = l1.iterator(); var5.hasNext(); firstNum = "" + i + firstNum) {
            i = (Integer)var5.next();
        }

        for(var5 = l2.iterator(); var5.hasNext(); secondNum = "" + i + secondNum) {
            i = (Integer)var5.next();
        }

        String resultStr = String.valueOf(Integer.parseInt(firstNum) + Integer.parseInt(secondNum));

        for(i = resultStr.length() - 1; i >= 0; --i) {
            resultList.add(Integer.parseInt(String.valueOf(resultStr.charAt(i))));
        }

        return resultList;
    }

    private static String countAndSay(int n) {
        if (n > 1 && n < 30) {
            StringBuilder builder = new StringBuilder("1");

            for(int i = 2; i <= n; ++i) {
                builder = appendNewNumsToBuilder(builder.toString());
            }

            return builder.toString();
        } else {
            return "1";
        }
    }


    private static StringBuilder appendNewNumsToBuilder(String previous) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while(i < previous.length()) {
            char num = previous.charAt(i);

            int count;
            for(count = 0; i < previous.length() && num == previous.charAt(i); ++i) {
                ++count;
            }

            result.append(count).append(num);
        }

        return result;
    }

    private static int majorityElement(int[] nums) {
        int n = nums.length / 2;
        int majorityElment = 0;

        for(int i = 0; i < nums.length; ++i) {
            int count = 0;
            int el = nums[i];

            for(int j = 0; j < nums.length; ++j) {
                if (el == nums[j]) {
                    ++count;
                }
            }

            if (count > n) {
                majorityElment = el;
                break;
            }
        }

        return majorityElment;
    }

    private static boolean isNumber(String s) {
        boolean thereIsDigit = false;
        boolean thereIsE = false;
        boolean thereIsDot = false;

        for(int i = 0; i < s.length(); ++i) {
            char charToCheck = s.charAt(i);
            if (Character.isDigit(charToCheck)) {
                thereIsDigit = true;
            } else if (charToCheck == '.') {
                if (i == s.length() - 1) {
                    return false;
                }

                if (!Character.isDigit(s.charAt(i + 1))) {
                    return false;
                }

                if (thereIsE) {
                    return false;
                }

                thereIsDot = true;
            } else if (charToCheck != '+' && charToCheck != '-') {
                if (charToCheck != 'e' && charToCheck != 'E') {
                    return false;
                }

                if (thereIsE || !thereIsDigit || i == s.length() - 1) {
                    return false;
                }

                thereIsE = true;
            } else {
                if (i == 2) {
                    return false;
                }

                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }

                if (i == s.length() - 1) {
                    return false;
                }
            }
        }

        if (thereIsDigit) {
            return true;
        } else {
            return false;
        }
    }


    private static int maxArea(int[] height) {
        int leftElement = 0;
        int rightElement = height.length - 1;
        int maxSize = 0;

        while(leftElement < rightElement){
            int size = 0;
            if(height[leftElement] < height[rightElement]){
                size = height[leftElement] * (rightElement - leftElement);
                leftElement++;
            }
            else{
                size = height[rightElement] * (rightElement - leftElement);
                rightElement--;
            }
            if(maxSize < size){
                maxSize = size;
            }
        }

        return maxSize;
    }


    private static void nextPermutation(int[] nums) {
        if(nums.length > 1) {
            int preElementIndex = 0;
            boolean thereIsPreElementIndex = false;

            int checkElementIndex = nums.length - 1;
            while (true) {
                if (nums[checkElementIndex] <= nums[checkElementIndex - 1]) {
                    if (checkElementIndex == 1) {
                        nums = bubbleSorting(nums);
                        break;
                    }
                    checkElementIndex--;
                } else {
                    preElementIndex = checkElementIndex - 1;
                    thereIsPreElementIndex = true;
                    break;
                }
            }

            if (thereIsPreElementIndex == true) {
                int[] podArray = new int[nums.length - (preElementIndex + 1)];
                for (int i = preElementIndex + 1; i < nums.length; i++) {
                    podArray[i - (preElementIndex + 1)] = nums[i];
                }
                podArray = bubbleSorting(podArray);

                for (int j = 0; j < podArray.length; j++) {
                    if (podArray[j] > nums[preElementIndex]) {
                        int intermediate = nums[preElementIndex];
                        nums[preElementIndex] = podArray[j];
                        podArray[j] = intermediate;
                        break;
                    }
                }

                for (int k = preElementIndex + 1; k < nums.length; k++) {
                    nums[k] = podArray[k - (preElementIndex + 1)];
                }
            }
        }
    }

    private static int[] bubbleSorting(int[] array){
        if(array.length == 1){
            return array;
        }
        else{
            int changes = 0;
            do{
                changes = 0;
                for(int i = 0; i < array.length - 1; i++){
                    if(array[i] > array[i + 1]){
                        changes++;
                        int intermediate = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = intermediate;
                    }
                }
            }while(changes > 0);
            return array;
        }
    }


    private static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        List<Integer> targetIndexes = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                targetIndexes.add(i);
            }
        }

        if(targetIndexes.size() == 0){
            return result;
        }
        else{
            result[0] = targetIndexes.get(0);
            result[1] = targetIndexes.get(targetIndexes.size() - 1);
            return result;
        }
    }


    private static String multiply(String num1, String num2) {
        return String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2));
    }

    private static void rotate(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                newMatrix[j][matrix.length - (i + 1)] = matrix[i][j];
            }
        }

        for(int k = 0; k < matrix.length; k++){
            for(int l = 0; l < matrix[0].length; l++){
                matrix[k][l] = newMatrix[k][l];
            }
        }
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.00;

        int[] unitedArray = new int[nums1.length + nums2.length];
        if(unitedArray.length < 1){
            return result;
        }
        for(int i = 0; i < nums1.length; i++){
            unitedArray[i] = nums1[i];
        }
        for(int j = 0; j < nums2.length; j++){
            unitedArray[j + (nums1.length)] = nums2[j];
        }
        unitedArray = bubbleSorting(unitedArray);

        if(unitedArray.length % 2 != 0){
            result = (double) unitedArray[(int) unitedArray.length / 2];
        }
        else{
            int firstEl = unitedArray[(int) (unitedArray.length / 2) - 1];
            int secondEl = unitedArray[(int) unitedArray.length / 2];
            result = (double) (firstEl + secondEl) / 2;
        }

        return result;
    }


    private static int strStr(String haystack, String needle) {
        int result = -1;
        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0) &&
                    haystack.length() - i >= needle.length()){
                boolean isItNeedle = true;
                for(int j = 0; j < needle.length(); j++){
                    if(needle.charAt(j) != haystack.charAt(i + j)) {
                        isItNeedle = false;
                    }
                }
                if(isItNeedle) {
                    result = i;
                    break;
                }
            }
            else if(haystack.length() - i < needle.length()) break;
            }
        return result;
    }


    private static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recursiveAlgoritmForParenthesis(result, 0, 0, "", n);
        return result;
    }

    private static void recursiveAlgoritmForParenthesis(List<String> result, int open, int close,
                                                        String str, int n){
        if(str.length() == n * 2){
            result.add(str);
            return;
        }
        if(open < n){
            recursiveAlgoritmForParenthesis(result, open + 1, close, str + "(", n);
        }
        if(close < open){
            recursiveAlgoritmForParenthesis(result, open, close + 1, str + ")", n);
        }
    }


    private static int firstMissingPositive(int[] nums) {
        Set<Integer> numsInSet = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            numsInSet.add(nums[i]);
        }
        int missingNum = 1;
        for(int num : numsInSet){
            if(num > 0){
                if(num == missingNum){
                    missingNum++;
                }
                else {
                    break;
                }
            }
        }

        return missingNum;
    }


    private static int lengthOfLastWord(String s) {
        String[] sAsArray = s.split(" ");
        return sAsArray[sAsArray.length - 1].length();
    }


    private static int jump(int[] nums) {
        int lengthOfNums = nums.length;
        if(lengthOfNums == 1){
            return 0;
        }
        int weAreInIndex = 0;
        int pointsWeCanJump = nums[weAreInIndex];
        int steps = 0;
        if(pointsWeCanJump == lengthOfNums - 1){
            return 1;
        }

        while(weAreInIndex < lengthOfNums - 1){
            int bestVariant = 0;
            int bestVariantIndex = weAreInIndex;
            for(int i = 1; i <= pointsWeCanJump; i++){
                int checkedNum = nums[weAreInIndex + i];
                if(weAreInIndex + i == lengthOfNums - 1){
                    bestVariantIndex = weAreInIndex + i;
                    bestVariant = nums[weAreInIndex + i];
                    break;
                }
                else if(weAreInIndex + i + checkedNum >= bestVariantIndex + bestVariant){
                    bestVariantIndex = weAreInIndex + i;
                    bestVariant = checkedNum;
                }
            }
            weAreInIndex = bestVariantIndex;
            pointsWeCanJump = bestVariant;
            steps++;
        }

        return steps;
    }


    private static int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        int maxProfit = 0;
        int maxProfitIndex = 0;

        for(int i = 0; i < prices.length - 2; i++){
            for(int j = prices.length - 1; j > i; j--){
                if(prices[j] - prices[i] > maxProfit){
                    maxProfitIndex = j + 1;
                }
            }
        }

        return maxProfitIndex;
    }


    private static String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();

        while(columnNumber > 0){
            int reminder = (columnNumber - 1) % 26;
            builder.append(Character.toString((char)(65+reminder)));
            columnNumber = (columnNumber - 1) / 26;
        }

        return builder.reverse().toString();
    }


    private static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            int[][] specialResult = {{newInterval[0], newInterval[1]}};
            return specialResult;
        }
        List<Integer> resultInList = new ArrayList<>();
        boolean isNewIntervalInRes = false;

        for(int i = 0; i < intervals.length; i++){
            for(int j = 0; j < intervals[0].length; j++){
                if(!(intervals[i][j] >= newInterval[0] && intervals[i][j] <= newInterval[1])){
                    resultInList.add(intervals[i][j]);
                }
                else{
                    if(isNewIntervalInRes == false) {
                        resultInList.add(newInterval[1]);
                        isNewIntervalInRes = true;
                    }
                }
            }
        }
        if(resultInList.size() % 2 != 0){
            int indexOfInterval = resultInList.indexOf(newInterval[1]);
            resultInList.remove(resultInList.get(indexOfInterval));
        }

        int[][] result = new int[resultInList.size() / 2][2];
        int firstIndex = 0;
        int secondIndex = 0;
        for(int a = 0; a < resultInList.size(); a++){
            if(secondIndex == 0){
                result[firstIndex][secondIndex] = resultInList.get(a);
                secondIndex = 1;
            }
            else if(secondIndex == 1){
                result[firstIndex][secondIndex] = resultInList.get(a);
                secondIndex = 0;
                firstIndex++;
            }
        }

        return result;
    }


}