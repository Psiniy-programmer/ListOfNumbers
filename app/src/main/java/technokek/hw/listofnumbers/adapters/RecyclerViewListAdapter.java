package technokek.hw.listofnumbers.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import technokek.hw.listofnumbers.R;
import technokek.hw.listofnumbers.holders.RecyclerViewHolder;
import technokek.hw.listofnumbers.models.NumbersModel;

public class RecyclerViewListAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<NumbersModel> mData;

    public RecyclerViewListAdapter(List<NumbersModel> data) {
        this.mData = data;
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.number_item;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        NumbersModel model = mData.get(position);
        holder.getView().setText(String.valueOf(model.getValue()));
        holder.getView().setTextColor(model.getColor());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}