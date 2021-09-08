package values;

import java.util.List;

public class Values {
    private List<Value> values;

    public <T> Values(T fromJson) {
    }

    public List<Value> getValues() {
        return this.values;
    }
}
