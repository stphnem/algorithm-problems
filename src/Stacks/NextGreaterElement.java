/**
 * 496. Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-i/#/description
 * 
 */
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i : nums) {
            while (!stack.isEmpty() && stack.peek() < i) {
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        
        for (int i=0; i < findNums.length; i++) {
            findNums[i] = map.getOrDefault(findNums[i], -1);
        }
        
        return findNums;
    }
}