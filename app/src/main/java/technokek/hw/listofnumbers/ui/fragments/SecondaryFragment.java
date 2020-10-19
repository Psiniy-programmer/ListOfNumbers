package technokek.hw.listofnumbers.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import technokek.hw.listofnumbers.R;
import technokek.hw.listofnumbers.models.NumbersModel;

public class SecondaryFragment extends Fragment {

    private NumbersModel model;

    public SecondaryFragment(NumbersModel model) {
        this.model = model;
    }

    public SecondaryFragment() {
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("numb", model.getValue());
        outState.putInt("color", model.getColor());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        if (model == null) {
            model = new NumbersModel(savedInstanceState.getInt("numb"), savedInstanceState.getInt("color"));
        }
        View view = inflater.inflate(R.layout.secondary_fragment, container, false);
        TextView textView = view.findViewById(R.id.secondary_fragment);
        textView.setText(String.valueOf(model.getValue()));
        textView.setTextColor(model.getColor());
        return view;
    }
}
