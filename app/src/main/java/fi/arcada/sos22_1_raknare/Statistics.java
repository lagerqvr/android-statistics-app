package fi.arcada.sos22_1_raknare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;


public class Statistics {

    // Sorting method
    public static ArrayList<Double> getSorted(ArrayList<Double> dataSet) {
        ArrayList<Double> sortedList = new ArrayList<>(dataSet);
        Collections.sort(sortedList);
        return sortedList;
    }

    // Mean
    public static double calcMean(ArrayList<Double> dataset) {
        double sum = 0;
        for (int i = 0; i < dataset.size(); i++) {
            sum += dataset.get(i);
        }

        return sum / dataset.size();
    }

    // Median
    public static double calcMedian(ArrayList<Double> dataset) {
        ArrayList<Double> sorted = getSorted(dataset);
        int mid = sorted.size() / 2;
        double median;
        if (sorted.size() % 2 == 0) {
            median = sorted.get(mid-1) + sorted.get(mid) / 2;
        } else {
            median = sorted.get(mid);
        }
        return median;
    }

    // Standard deviation
    public static double calcSD(ArrayList<Double> dataset) {
        double sumDiff = 0;
        double avg = calcMean(dataset);

        for (double dataValue: dataset) {
            sumDiff += Math.pow(dataValue-avg, 2);
        }

        double variance = sumDiff / dataset.size();

        return Math.sqrt(variance);
    }

    // Max value in Arraylist
    public static double calcMax(ArrayList<Double> dataset) {
        double max = Collections.max(dataset);
        return max;
    }

    // Min value in Arraylist
    public static double calcMin(ArrayList<Double> dataset) {
        double min = Collections.min(dataset);
        return min;
    }

    // Mode
    public static double calcMode(ArrayList<Double> dataset) {
        HashMap arrayVals = new HashMap();
        int maxOccurences = 1;
        double mode = dataset.get(0);

        for(int i = 0; i<dataset.size(); i++)
        {
            double currentIndexVal = dataset.get(i);
            if(arrayVals.containsKey(currentIndexVal)){
                int currentOccurencesNum = (Integer) arrayVals.get(currentIndexVal);
                currentOccurencesNum++;
                arrayVals.put(currentIndexVal, currentOccurencesNum );
                if(currentOccurencesNum >= maxOccurences)
                {
                    mode = currentIndexVal;
                    maxOccurences = currentOccurencesNum;
                }
            }
            else{
                arrayVals.put(dataset.get(i), 1);
            }
        }

        return mode;
    }

    // Lower quartile (when more than four values)
    public static double calcLQ(ArrayList<Double> dataset) {
        Collections.sort(dataset);

        int length = dataset.size();
        double LQ = 0;

        if (length < 4) {
            LQ = 0;
        } else if(length % 2 != 0) {
            LQ = (dataset.get((length / 4) - 1) + dataset.get(length / 4)) / 2;
        } else {
            LQ = dataset.get((length / 4) - 1);
        }
        return LQ;
    }

    // Upper quartile (when more than four values)
    public static double calcUQ(ArrayList<Double> dataset) {
          double ans[] = new double[3];

        for (int quartileType = 1; quartileType < 4; quartileType++) {
            float length = dataset.size() + 1;
            double quartile;
            float newArraySize = (length * ((float) (quartileType) * 25 / 100)) - 1;
            Collections.sort(dataset);
            if (newArraySize % 1 == 0) {
                quartile = dataset.get((int) (newArraySize));
            } else {
                int newArraySize1 = (int) (newArraySize);
                quartile = (dataset.get(newArraySize1) + dataset.get(newArraySize1 + 1)) / 2;
            }
            ans[quartileType - 1] =  quartile;
        }
        return ans[2];
    }

    // Quartile range (when more than four values)
    public static double calcQR(ArrayList<Double> dataset) {
        double QR = Statistics.calcUQ(dataset) - Statistics.calcLQ(dataset);
        return QR;
    }
}