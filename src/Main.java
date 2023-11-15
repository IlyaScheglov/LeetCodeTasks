import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        int target = 4;
        int answer = searchInsert(ints, target);
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
}