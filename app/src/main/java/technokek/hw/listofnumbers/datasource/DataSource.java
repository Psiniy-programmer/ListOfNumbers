package technokek.hw.listofnumbers.datasource;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

import technokek.hw.listofnumbers.models.NumbersModel;

public class DataSource {
    private static final DataSource ourInstance = new DataSource();
    private final List<NumbersModel> list;


    public DataSource() {
        list = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            list.add(new NumbersModel(i, getColor(i)));
        }
    }

    public int getColor(int number) {
        if (number % 2 == 0) return Color.BLUE;
        else return Color.RED;
    }

    public static DataSource getInstance() {
        return ourInstance;
    }

    public List<NumbersModel> getData() {
        return list;
    }
}
