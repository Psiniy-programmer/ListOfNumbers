package technokek.hw.listofnumbers.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import technokek.hw.listofnumbers.R;
import technokek.hw.listofnumbers.adapters.RecyclerViewListAdapter;
import technokek.hw.listofnumbers.models.NumbersModel;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView view;
    private final RecyclerViewListAdapter.clickerInterface clickAction;

    public RecyclerViewHolder(@NonNull View itemView, RecyclerViewListAdapter.clickerInterface clickAction) {
        super(itemView);
        view = itemView.findViewById(R.id.number_item);
        this.clickAction = clickAction;
    }

    public TextView getView() {
        return view;
    }

    public void onBind(NumbersModel model) {
        view.setOnClickListener(v -> clickAction.onItemClick(model));
    }
}
