/**
 * 390. Elimination Game
 * https://leetcode.com/problems/elimination-game/
 *
 */
public class Solution {
    public int lastRemaining(int n) {
        int head = 1, nums = n, step = 1;
        boolean left = true;

        while (nums > 1) {
            if (left || nums % 2 == 1)
                head += step;
            nums /= 2;
            step *= 2;
            left = !left;
        }

        return head;
    }
}
