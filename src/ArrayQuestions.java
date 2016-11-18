import java.util.*;

public class ArrayQuestions {

    public ArrayQuestions() {};

    public int[] plusOne(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }

    public List<Integer> getRows(int rowIndex){
        List<Integer> row = new ArrayList<Integer>();

        for (int i=0; i < rowIndex + 1; ++i) {
            row.add(0, 1);

            for (int j=1; j < i; ++j) {
                int sum = row.get(j) + row.get(j+1);
                row.set(j, sum);
            }
        }

        return row;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[n+m];
        int i=0, j=0, index=0;

        while (i<m && j<n) {
            if (nums1[i] < nums2[j]) {
                result[index++] = nums1[i++];
            } else {
                result[index++] = nums2[j++];
            }
        }

        for (; i<m; i++) {
            result[index++] = nums1[i];
        }

        for (; j<n; j++) {
            result[index++] = nums2[j];
        }

        System.arraycopy(result, 0, nums1, 0, n+m);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> openC = new HashMap<Character, Character>();
        openC.put('(', ')');
        openC.put('[', ']');
        openC.put('{', '}');
        char search = '\u0000';

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && search == '\u0000') {
                search = stack.peek();
            } else if (openC.containsKey(c)) {
                stack.push(c);
                search = c;
            } else if (c == ')' || c == ']' || c == '}') {
                if (search != '\u0000' && openC.get(search) == c) {
                    stack.pop();
                    search = stack.isEmpty() ? '\u0000' : stack.peek();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public int myAtoi(String s) {
        char[] myArray = s.trim().toCharArray();
        int mult=1, result=0;

        for (int i=0; i < myArray.length; i++) {
            if (i==0 && myArray[i] == '-') {
                mult = -1;
            } else if (i==0 && myArray[i] == '+') {
                continue;
            } else if (myArray[i] - '0' >= 0 && myArray[i] - '0' <= 9) {
                result = myArray[i] - '0' + result * 10;
            } else {
                return 0;
            }
        }

        return result * mult;
    }

    public String reverseVowels(String s) {
        int i=0, j=s.length()-1;
        char[] array = s.toCharArray();
        String vowels = "aeiouAEIOU";

        while (i<j) {
            while (i<j&& !vowels.contains("" + array[i])) i++;
            while (j>i && !vowels.contains("" + array[j])) j--;
            char temp = array[i];
            array[i++] = array[j];
            array[j--] = temp;
        }

        return String.valueOf(array);
    }

    public String commonChars(String s1, String s2, int max) {
        int i= 0;
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        for(; i < max && i < s1Array.length && i < s2Array.length; i++) {
            if (s1Array[i] != s2Array[i])
                break;
        }

        return s1.substring(0, i);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        int maxLength = strs[0].length();
        String prefix = strs[0];

        for (String s : strs) {
            if (s.length() < maxLength) {
                maxLength = s.length();
            }
        }

        for (int i=1; i < strs.length; i++) {
            prefix = commonChars(prefix, strs[i], maxLength);
        }

        return prefix;
    }

//    public int strStr(String haystack, String needle) {
//        if (haystack == null || needle == null) return 0;
//        if (needle.length() == 0) return 0;
//
//        for (int i=0; i < haystack.length(); i++) {
//            if (i + needle.length() > haystack.length())
//                return 0;
//
//            int m = i;
//            for (int j=0; j < needle.length(); j++) {
//                if (needle.charAt(j) == haystack.charAt(m)) {
//                    if (j == needle.length() - 1)
//                        return i;
//                    m++;
//                } else {
//                    break;
//                }
//            }
//        }
//
//        return 0;
//    }

    public int strStr(String haystack, String needle) {
        if(haystack==null || needle==null)
            return 0;

        int h = haystack.length();
        int n = needle.length();

        if (n > h)
            return -1;
        if (n == 0)
            return 0;

        int[] next = getNext(needle);
        int i = 0;

        while (i <= h - n) {
            int success = 1;
            for (int j = 0; j < n; j++) {
                if (needle.charAt(0) != haystack.charAt(i)) {
                    success = 0;
                    i++;
                    break;
                } else if (needle.charAt(j) != haystack.charAt(i + j)) {
                    success = 0;
                    i = i + j - next[j - 1];
                    break;
                }
            }
            if (success == 1)
                return i;
        }

        return -1;
    }

    //calculate KMP array
    public int[] getNext(String needle) {
        int[] temp = new int[needle.length()];
        temp[0] = 0;

        for (int i = 1; i < needle.length(); i++) {
            int index = temp[i - 1];
            while (index > 0 && needle.charAt(index) != needle.charAt(i)) {
                index = temp[index - 1];
            }

            if (needle.charAt(index) == needle.charAt(i)) {
                temp[i] = temp[i - 1] + 1;
            } else {
                temp[i] = 0;
            }
        }

        return temp;
    }

    public boolean isPalindrome(String s) {
        String newS = s.toLowerCase().replaceAll("\\s", "");
        int front = 0, back = newS.length()-1;
        while (front < back) {
            char fChar = newS.charAt(front), bChar = newS.charAt(back);
            if (!(fChar >= '0' && fChar <= '9') && !(fChar >= 'a' && fChar <= 'z')) {
                front++;
            } else if (!(bChar >= '0' && bChar <= '1') && !(bChar >= 'a' && bChar <= 'z')) {
                back--;
            } else if (fChar != bChar) {
                return false;
            } else {
                front++; back--;
            }
        }

        return true;
    }

    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public String toHex(int num) {
        if(num == 0) return "0";
        String result = "";
        while(num != 0){
            int what = num & 15;
            result = map[what] + result;
            int huh = num >>> 4;
            num = (num >>> 4);
        }
        return result;
    }

}
