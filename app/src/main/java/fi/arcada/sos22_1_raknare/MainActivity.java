package fi.arcada.sos22_1_raknare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textRow, textMean, textDataOut, textSD;
    EditText editValue, editDescription;

    ArrayList<Double> dataSet = new ArrayList<>();
    ArrayList<DataItem> dataItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textRow = findViewById(R.id.helloText);
        textMean = findViewById(R.id.textViewMean);

        editValue = findViewById(R.id.editTextName2);
        editDescription = findViewById(R.id.editTextName);

        /* dataItems = Statistics.getSampleDataset(); // ArrayList med testdata (flera DataItem-objekt)
        dataSet = Statistics.getDataValues(dataItems); */// ArrayList med DataItem-objektens värden

    }

    public void btnClick(View view) {
        double val = Integer.parseInt(editValue.getText().toString());
        dataSet.add(val);

        // Number input
        String dataOut = "";
        for (double number: dataSet) {
                dataOut += ", " + number;
        }
        dataOut += "\n";
        for (DataItem item: dataItems) {
            dataOut += item.getName() + ":" + item.getValue() + " ";
        }
        textRow.setText(dataOut.substring(2));
        editValue.getText().clear();
    }

    public void btnClear(View view) {
        textRow.setText("");
        dataSet.clear();
    }

    public void calculate(View view) {

        String meanStr = String.format("Min: %.2f\nMax: %.2f\nMean: %.2f\nMedian: %.2f\nStandard deviation: %.2f\nMode: %.2f\nLower quartile: %.2f\nUpper quartile: %.2f\nInterquartile distance: %.2f",
                Statistics.calcMin(dataSet), Statistics.calcMax(dataSet), Statistics.calcMean(dataSet),
                Statistics.calcMedian(dataSet), Statistics.calcSD(dataSet), Statistics.calcMode(dataSet),
                Statistics.calcLQ(dataSet), Statistics.calcUQ(dataSet), Statistics.calcQD(dataSet)
        );
        textMean.setText(meanStr);
    }
}