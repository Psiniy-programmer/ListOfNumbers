package technokek.hw.listofnumbers.ui.fragments;

import android.app.Activity;
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
import technokek.hw.listofnumbers.datasource.DataSource;
import technokek.hw.listofnumbers.models.NumbersModel;
import technokek.hw.listofnumbers.ui.MainActivity;

public class MainFragment extends Fragment {

    private List<NumbersModel> numbers;

    private RecyclerViewListAdapter adapter;

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        numbers = DataSource.getInstance().getData();
        adapter = new RecyclerViewListAdapter(numbers, ((MainActivity) activity)::openFragment);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putAll(outState);
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
        return (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) ? 3 : 4;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}