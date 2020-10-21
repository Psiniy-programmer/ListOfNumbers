package technokek.hw.listofnumbers.ui;

import android.os.Bundle;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.List;
import technokek.hw.listofnumbers.R;
import technokek.hw.listofnumbers.adapters.RecyclerViewListAdapter;
import technokek.hw.listofnumbers.datasource.DataSource;
import technokek.hw.listofnumbers.models.NumbersModel;
import technokek.hw.listofnumbers.ui.fragments.MainFragment;
import technokek.hw.listofnumbers.ui.fragments.SecondaryFragment;

public class MainActivity extends AppCompatActivity implements RecyclerViewListAdapter.clickerInterface {

    private List<NumbersModel> numbers = DataSource.getInstance().getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainFragment mainFragment = (savedInstanceState == null) ? new MainFragment() : new MainFragment(savedInstanceState.getInt("lastNumber"));
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, mainFragment)
                .commit();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("lastNumber", numbers.size());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int kek = savedInstanceState.getInt("lastNumber");
        Log.d("TAG", String.valueOf(kek));
    }

    @Override
    public void onItemClick(final NumbersModel model) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new SecondaryFragment(model), "SF")
                .addToBackStack(null)
                .commit();
    }
}