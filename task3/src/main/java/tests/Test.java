package tests;

import java.util.List;
import java.util.Optional;

public class Test {
    private int id;
    private String title;
    private String value;
    public Optional<List<Test>> values;

    public int getId() {
        return this.id;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
