import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stephen on 11/17/2016.
 */
public class Weight {
    public Weight(){}

    public List<Integer> maximizePackage(int maxWeight, int[] weight) {
        int[] pkgCount = new int[maxWeight + 1];
        int[] pkgIndex = new int[maxWeight + 1];
        List<Integer> result = new ArrayList<>();
        for (int i=0; i <= maxWeight; i++) {
            pkgCount[i] = Integer.MIN_VALUE;
            pkgIndex[i] = -1;
        }
        pkgCount[0] = 0;

        for (int i=0; i < weight.length; i++) {
            for (int j=0; j <= maxWeight; j++) {
                if (j >= weight[i]) {
                    if (pkgCount[j - weight[i]] + 1 > pkgCount[j]) {
                        pkgCount[j] = pkgCount[j - weight[i]] + 1;
                        pkgIndex[j] = i;
                    }
                }
            }
        }

        int start = maxWeight;
        while (start != 0) {
            int pkgWeightIndex = pkgIndex[start];
            int weightToAdd = weight[pkgWeightIndex];
            result.add(weightToAdd);
            start -= weightToAdd;
        }
        return result;
    }
}
