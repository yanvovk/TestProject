import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Thread;

public class Task1 {

    public static void main(String[] args) {
        int roundArrayInitiator = Integer.parseInt(args[0]);
        int intervalLength = Integer.parseInt(args[1]);
        int [] roundArray = new int [roundArrayInitiator];
        int [] tempStepArray = new int [intervalLength];
        LinkedList<Integer> resultRoute = new LinkedList<Integer>();

        //Заполнение изначального массива
        for(int i = 1; i <= roundArrayInitiator; i++){
            roundArray[i - 1] = i;
        }

        //Глобальная переменная для сохранения позиции при переборе массива
        //Индекс для результирующего массива
        int savedPosition = 0;
        int resultRouteIndex = 0;

        //Цикл записи первых значений из шагов, пока последнее значение шага не станет единицей
        while (tempStepArray[intervalLength - 1] != 1) {
            //Сами шаги
            for (int i = savedPosition, j = 0; j < intervalLength; j++) {
                tempStepArray[j] = roundArray[i];
                //Условие при котором эмулируется круговой массив
                if(i == roundArray.length - 1) {
                    savedPosition = i;
                    i = 0;
                    continue;
                }
                savedPosition = i;
                //Инкремент вынесен из for для отработки условия эмуляции кругового массива
                i++;
            }
            resultRoute.add(resultRouteIndex, tempStepArray[0]);
            resultRouteIndex++;

        }

        System.out.println(resultRoute.toString());
    }
}
