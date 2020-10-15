package technokek.hw.listofnumbers.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import technokek.hw.listofnumbers.R;
import technokek.hw.listofnumbers.ui.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new SecondFragment())
                .commit();
    }
}