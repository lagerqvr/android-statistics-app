package fi.arcada.sos22_1_raknare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;

public class Statistics {

    // Metod för att generera en datamängd att testa med
    public static ArrayList<DataItem> getSampleDataset() {
        Random rnd = new Random();

        ArrayList<DataItem> sampleData = new ArrayList<>();
        String[] names = { "Fili", "Kili", "Balin", "Dwalin", "Ori", "Nori", "Dori", "Gloin", "Oin", "Bifur", "Bofur", "Bombur", "Thorin" };
        for (String name: names) {
            sampleData.add(new DataItem(name, rnd.nextInt(300)+100));
        }
        return sampleData;
    }

    // Metod för att skapa skild ArrayList med endast värdena från DataItems
    public static ArrayList<Double> getDataValues(ArrayList<DataItem> dataItems) {
        // Skapa ny arraylist för Double-värden
        ArrayList<Double> dataValues = new ArrayList<>();
        // Loopa igenom dataItems och spara endast värdena i den nya arrayListen
        for (DataItem item: dataItems) {
            dataValues.add(item.getValue());
        }
        return dataValues;
    }

    public static ArrayList<Double> getSorted(ArrayList<Double> dataSet) {
        ArrayList<Double> sortedList = new ArrayList<>(dataSet);
        Collections.sort(sortedList);
        return sortedList;
    }

    // Average
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

    // Lower quartile
    public static double calcLQ(ArrayList<Double> dataset) {
        return 5.0;
    }

    // Upper quartile
    public static double calcUQ(ArrayList<Double> dataset) {
        return 5.0;
    }

    // Interquartile distance
    public static double calcQD(ArrayList<Double> dataset) { return 5.0; }
}