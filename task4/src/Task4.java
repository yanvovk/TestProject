import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/*
       Опытным путем установлено, что задачу решать лучше с применением среднего геометрического
       и среднего арифметического, т.к. при разных наборах чисел минимальное число шагов до одного числа
       может быть наименьшим как к сред. геометрическому так и к сред. арифметическому
*/
public class Task4 {
    public static void main(String[] args) throws IOException {
        Path FilePath = Paths.get(args[0]);
        List<String> nums = Files.readAllLines(FilePath);

        int multi  = nums.stream().mapToInt(Integer::parseInt).reduce(1, (e, acc) -> (acc * e));

        double arithmeticAvg  = nums.stream().collect(Collectors.averagingDouble(Double::parseDouble));
        double geometricAvg = Math.pow(multi, 1 / (double)nums.size());

        int roundedArithmeticAvg = (int)Math.round(arithmeticAvg);
        int roundedGeometricAvg = (int)Math.round(geometricAvg);

        int resultViaGeometric = 0;
        int resultViaArithmetic = 0;

        for (int i = 0; i < nums.size(); i++) {
            resultViaGeometric += Math.abs(roundedGeometricAvg - Integer.parseInt(nums.get(i)));
        }
        for (int i = 0; i < nums.size(); i++) {
            resultViaArithmetic += Math.abs(roundedArithmeticAvg - Integer.parseInt(nums.get(i)));
        }

        System.out.println(Math.min(resultViaArithmetic, resultViaGeometric));
    }
}
