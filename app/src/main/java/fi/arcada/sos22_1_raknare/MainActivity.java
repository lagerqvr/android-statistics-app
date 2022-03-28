package fi.arcada.sos22_1_raknare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textRow, textMean, textDataOut, textSD;
    EditText editTextName;

    ArrayList<Double> dataSet = new ArrayList<>();
    ArrayList<DataItem> dataItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textRow = findViewById(R.id.helloText);
        textMean = findViewById(R.id.textViewMean);

        editTextName = findViewById(R.id.editTextName);

        dataItems = Statistics.getSampleDataset(); // ArrayList med testdata (flera DataItem-objekt)
        dataSet = Statistics.getDataValues(dataItems); // ArrayList med DataItem-objektens värden


        /* for (int i = 0; i < testData.length; i++) {
            dataSet.add(testData[i]);
        } */

        String dataOut = "";
        for (double number: dataSet) {
            dataOut += number + " ";
        }
        textRow.setText(dataOut);
        // Vi skriver ut DataItem-datamängden
        dataOut += "\n----\n";
        for (DataItem item: dataItems) {
            dataOut += item.getName() + ":" + item.getValue() + " ";
        }
        textRow.setText(dataOut);
    }

    public void btnClick(View view) {

        textRow.setText("");
}

    public void calculate(View view) {

        String meanStr = String.format("Min: %.2f\nMax: %.2f\nAverage: %.2f\nMedian: %.2f\nStandard deviation: %.2f\nMode: \nLower quartile: \nUpper quartile: \nQuartile distance: ",
                Statistics.calcMean(dataSet),
                Statistics.calcMedian(dataSet),
                Statistics.calcSD(dataSet),
                Statistics.calcMin(dataSet),
                Statistics.calcMax(dataSet)
        );
        textMean.setText(meanStr);
    }
}