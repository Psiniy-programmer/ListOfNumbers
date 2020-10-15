package technokek.hw.listofnumbers.models;

public class NumbersModel {
    private int mColor;
    private int mValue;

    public NumbersModel(int value, int color) {
        mValue = value;
        mColor = color;
    }

    public int getColor() {
        return mColor;
    }

    public int getValue() {
        return mValue;
    }
}
