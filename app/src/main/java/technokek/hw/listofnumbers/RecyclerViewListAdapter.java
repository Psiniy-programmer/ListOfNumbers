package technokek.hw.listofnumbers;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewListAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private Integer countItems;

    public RecyclerViewListAdapter(int mCountItems) {
        this.countItems = mCountItems;
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
        holder.getView().setText(String.valueOf(position+1));
        if (position % 2 == 0) {
            holder.getView().setTextColor(Color.RED);
        } else {
            holder.getView().setTextColor(Color.BLUE);
        }
    }

    @Override
    public int getItemCount() {
        return countItems;
    }
}