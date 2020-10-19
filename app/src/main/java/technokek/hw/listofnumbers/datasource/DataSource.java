package technokek.hw.listofnumbers.datasource;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

import technokek.hw.listofnumbers.models.NumbersModel;

public class DataSource {

    private final List<NumbersModel> list;

    public static class DataSourceHolder {
        private final static DataSource instance = new DataSource();
    }

    public DataSource() {
        list = new ArrayList<>();
        final int countElements = 100;
        for (int i = 1; i < countElements + 1; i++) {
            list.add(new NumbersModel(i, getColor(i)));
        }
    }

    public static int getColor(int number) {
        return (number % 2 != 0) ? Color.BLUE : Color.RED;
    }

    public static DataSource getInstance() {
        return DataSourceHolder.instance;
    }

    public List<NumbersModel> getData() {
        return list;
    }
}
