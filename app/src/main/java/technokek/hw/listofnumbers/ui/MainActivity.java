package technokek.hw.listofnumbers.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import technokek.hw.listofnumbers.R;
import technokek.hw.listofnumbers.adapters.RecyclerViewListAdapter;
import technokek.hw.listofnumbers.datasource.DataSource;
import technokek.hw.listofnumbers.models.NumbersModel;
import technokek.hw.listofnumbers.ui.fragments.MainFragment;
import technokek.hw.listofnumbers.ui.fragments.SecondaryFragment;

public class MainActivity extends AppCompatActivity implements RecyclerViewListAdapter.clickerInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportFragmentManager().findFragmentByTag("SF") == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new MainFragment())
                    .commit();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull final Bundle outState) {
        super.onSaveInstanceState(outState);
        final List<NumbersModel> numbers = DataSource.getInstance().getData();
        outState.putInt("dataSize", numbers.size());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        DataSource.getInstance().checkLost(savedInstanceState.getInt("dataSize"));
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