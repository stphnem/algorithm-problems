public class Solution {

    static class Pair{
        int first, second;
        int pick=0;
        public String toString(){
          return first + " " + second + " " + pick;
        }
    }

    public Pair[][] findMoves(int[] nums) {
        Pair[][] moves = new Pair[nums.length][nums.length];

        // Init matrix of pairs
        for (int i=0; i < moves.length; i++) {
            for (int j=0; j < moves[i].length; j++) {
                moves[i][j] = new Pair();
            }
        }

        // Add base cases
        for (int i=0; i < moves.length; i++) {
            moves[i][i].first = nums[i];
            moves[i][i].pick = i;
        }

        // l for length
        // i for iteration
        for (int l=2; l <= nums.length; l++) {
            for (int i=0; i <= nums.length-l; i++) {
                int j = i + l - 1;
                if (nums[i] + moves[i+1][j].second >=  moves[i][j-1].second + nums[j]) {
                    moves[i][j].first = nums[i] + moves[i+1][j].second;
                    moves[i][j].second = moves[i+1][j].first;
                    moves[i][j].pick = i;
                } else {
                    moves[i][j].first = nums[j] + moves[i][j-1].second;
                    moves[i][j].second = moves[i][j-1].first;
                    moves[i][j].pick = j;
                }
            }
        }

        return moves;
    }

    public boolean PredictTheWinner(int[] nums) {
        Pair[][] moves = findMoves(nums);
        Pair topRight = moves[0][nums.length-1];

        return topRight.first >= topRight.second;
    }
}
