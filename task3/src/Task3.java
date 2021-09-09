import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task31 {
    public static void main(String[] args) throws IOException {

        Path testsFilePath = Paths.get(args[0]);
        List<String> testsStrings = Files.readAllLines(testsFilePath);
        Path valuesFilePath = Paths.get(args[1]);
        String valuesStrings = Files.readString(valuesFilePath);

        String regExForIdInValues = "[0-9]+";
        String regExForValuesInValues = "(passed|failed)";
        Matcher matcherId = Pattern.compile(regExForIdInValues).matcher(valuesStrings);
        Matcher matcherVal = Pattern.compile(regExForValuesInValues).matcher(valuesStrings);

        List<Value> values = new ArrayList<>();
        while (matcherId.find() && matcherVal.find()) {
            values.add(new Value(Integer.parseInt(matcherId.group()), matcherVal.group()));
        }

        String result = "";
        boolean automate = false;
        String valueVar = "";

        for(String str : testsStrings) {
            String regExTestId = "\"id\": (?<id>[0-9]+)";
            String regExPlaceForValue =  "\"value\": \"\"?";
            Matcher matcherTestId = Pattern.compile(regExTestId).matcher(str);
            Matcher matcherPlaceForValue = Pattern.compile(regExPlaceForValue).matcher(str);
            automate = matcherTestId.find();
            if (automate) {
                int idInTests = Integer.parseInt(matcherTestId.group("id"));
                for (Value value : values) {
                    if (value.getId() == idInTests) {
                        valueVar = value.getValue();
                        break;
                    }

                }
                result += str + "\n";
                automate = false;
                continue;
            }
            if(matcherPlaceForValue.find()) {
                str = matcherPlaceForValue.group().replaceFirst("\"value\": \"\"?", "\t" + "\"value\": \""+ valueVar +"\",");
            }
            result += str + "\n";
        }

        Path reportFile = Files.createFile(Path.of("report.json"));
        Files.writeString(reportFile, result);
    }
}
