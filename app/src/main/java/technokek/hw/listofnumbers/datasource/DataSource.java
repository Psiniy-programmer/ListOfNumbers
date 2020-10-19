package technokek.hw.listofnumbers.datasource;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

import technokek.hw.listofnumbers.models.NumbersModel;

public class DataSource {

    private static DataSource ourInstance = new DataSource();

    private final List<NumbersModel> list;

    public DataSource() {
        list = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            list.add(new NumbersModel(i, getColor(i)));
        }
    }

    public static int getColor(int number) {
        return (number % 2 != 0) ? Color.BLUE : Color.RED;
    }

    public static DataSource getInstance() {
        if (ourInstance == null) {
            ourInstance = new DataSource();
        }
        return ourInstance;
    }

    public List<NumbersModel> getData() {
        return list;
    }
}
