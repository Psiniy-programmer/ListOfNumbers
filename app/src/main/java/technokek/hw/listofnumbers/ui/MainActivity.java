package technokek.hw.listofnumbers.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import technokek.hw.listofnumbers.R;
import technokek.hw.listofnumbers.adapters.RecyclerViewListAdapter;
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
    public void onItemClick(final NumbersModel model) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new SecondaryFragment(model), "SF")
                .addToBackStack(null)
                .commit();
    }
}