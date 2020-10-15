package technokek.hw.listofnumbers.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import technokek.hw.listofnumbers.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView view;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView.findViewById(R.id.number_item);
    }

    public TextView getView() {
        return view;
    }
}
