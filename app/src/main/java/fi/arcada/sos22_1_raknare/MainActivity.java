package fi.arcada.sos22_1_raknare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textResult;
    EditText editValue, editDescription;
    RecyclerView recyclerView;

    ArrayList<Double> dataSet = new ArrayList<>();
    ArrayList<DataItem> dataItems = new ArrayList<>();

    ArrayList<String> textSet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = findViewById(R.id.textViewMean);
        editValue = findViewById(R.id.editTextName2);
        editDescription = findViewById(R.id.editTextName);
        recyclerView = findViewById(R.id.scrollText);

    }

    public void btnClick(View view) {
        try {
            double val = Integer.parseInt(editValue.getText().toString());
            dataSet.add(val);

            String txt = editDescription.getText().toString();
            textSet.add(txt);

            dataItems.add(new DataItem(txt, val));

            ViewAdapter adapter = new ViewAdapter(dataItems, this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            editValue.getText().clear();
            editDescription.getText().clear();

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    public void btnClear(View view) {
        try {
            dataItems.clear();
            dataSet.clear();
            textSet.clear();
            textResult.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void calculate(View view) {

        try {
            String meanStr = String.format("Min: %.2f\nMax: %.2f\nMean: %.2f\nMedian: %.2f\nStandard deviation: %.2f\nMode: %.2f\nLower quartile: %.2f\nUpper quartile: %.2f\nQuartile range: %.2f",
                    Statistics.calcMin(dataSet), Statistics.calcMax(dataSet), Statistics.calcMean(dataSet),
                    Statistics.calcMedian(dataSet), Statistics.calcSD(dataSet), Statistics.calcMode(dataSet),
                    Statistics.calcLQ(dataSet), Statistics.calcUQ(dataSet), Statistics.calcQR(dataSet)
            );
            textResult.setText(meanStr);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}