package tests;

import values.*;
import java.util.List;

public class Tests {
    private List<Test> tests;

    public <T> Tests(T fromJson) {
    }

    public List<Test> getTests() {
        return this.tests;
    }

    public static void setValues(List<Test> testsList, List<Value> valuesList) {
        for (Test test : testsList) {
            int testId = test.getId();
            if (test.values.isPresent()) {
                setValues(test.values.get(), valuesList);
            }
            for (Value value : valuesList) {
                if (value.getId() == testId) {
                    test.setValue(valuesList.get(test.getId()).getValue());
                }
            }
        }
    };

}