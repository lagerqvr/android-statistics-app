package fi.arcada.sos22_1_raknare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    ArrayList<DataItem> dataset;
    Context context;

    public ViewAdapter(ArrayList<DataItem> dataset, Context context) {
        this.dataset = dataset;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataItem item = dataset.get(position);

        holder.dataName.setText(item.getName());
        holder.dataValue.setText(String.format("%.2f", item.getValue()));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dataName;
        TextView dataValue;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dataName = itemView.findViewById(R.id.dataName);
            dataValue = itemView.findViewById(R.id.dataValue);

        }
    }
}
