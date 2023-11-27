import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String answer = countAndSay(4);
        System.out.println(answer);
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
            String xInStr = String.valueOf(Math.abs(x));
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
}