package technokek.hw.listofnumbers.ui.fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import technokek.hw.listofnumbers.R;
import technokek.hw.listofnumbers.adapters.RecyclerViewListAdapter;
import technokek.hw.listofnumbers.adapters.RecyclerViewListAdapter.clickerInterface;
import technokek.hw.listofnumbers.datasource.DataSource;
import technokek.hw.listofnumbers.models.NumbersModel;

public class MainFragment extends Fragment {

    private List<NumbersModel> numbers;

    private RecyclerViewListAdapter.clickerInterface clicker;

    private RecyclerViewListAdapter adapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        numbers = DataSource.getInstance().getData();
        clicker = (clickerInterface) context;
        adapter = new RecyclerViewListAdapter(numbers, model -> clicker.onItemClick(model));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.list_items, container, false);
        final RecyclerView recyclerView = view.findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), getSpanCount(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        Button btn = view.findViewById(R.id.add_button);
        btn.setOnClickListener(v -> {
            int nextNumber = numbers.size() + 1;
            numbers.add(numbers.size(), new NumbersModel(nextNumber, DataSource.getColor(nextNumber)));
            adapter.notifyDataSetChanged();
        });
        return view;
    }

    private int getSpanCount() {
        return (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) ? getResources()
                .getInteger(R.integer.portrait_span_count)
                : getResources().getInteger(R.integer.landscape_span_count);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}