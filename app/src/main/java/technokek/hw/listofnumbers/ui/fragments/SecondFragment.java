package technokek.hw.listofnumbers.ui.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class SecondFragment extends Fragment {
    private List<NumbersModel> numbers;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        numbers = DataSource.getInstance().getData();
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.list_items, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), getSpanCount(), RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(new RecyclerViewListAdapter(numbers));
        return view;
    }

    private int getSpanCount() {
        int spanCount;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            spanCount = 3;
        else spanCount = 4;
        return spanCount;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}