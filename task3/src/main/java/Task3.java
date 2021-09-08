import tests.Tests;
import values.Values;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task3 {

    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        FileReader testsReader = new FileReader(args[0]);
        Tests testsObj = new Tests(gson.fromJson(testsReader, Tests.class));
        FileReader valuesReader = new FileReader(args[0]);
        Values valuesObj = new Values(gson.fromJson(valuesReader, Values.class));

        Tests.setValues(testsObj.getTests(), valuesObj.getValues());

        Path reportFile = Files.createFile(Path.of("report.json"));
        String result = gson.toJson(testsObj);
        Files.writeString(reportFile, result);
    }
}