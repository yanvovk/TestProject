import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        Path circleCenterAndRadiusFilePath = Paths.get(args[0]);
        Path pointsToResolveFilePath = Paths.get(args[1]);
        List<String> circleCenterAndRadius = new LinkedList<String>();
        List<String> pointsToResolve = new LinkedList<String>();
        try {
            circleCenterAndRadius = Files.readAllLines(circleCenterAndRadiusFilePath);
            pointsToResolve = Files.readAllLines(pointsToResolveFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String [] centerOfCircleString = circleCenterAndRadius.get(0).split(" ");
        int centerOfCircleX = Integer.parseInt(centerOfCircleString[0]);
        int centerOfCircleY = Integer.parseInt(centerOfCircleString[1]);
        int radius = Integer.parseInt(circleCenterAndRadius.get(1));

        int [][] points= new int[pointsToResolve.size()][2];
        for (int i = 0; i < pointsToResolve.size(); i++) {
          points[i][0] = Integer.parseInt((pointsToResolve.get(i).split(" ")[0]));
          points[i][1] = Integer.parseInt((pointsToResolve.get(i).split(" ")[1]));
        }

        int i = 0;
        while (i < points.length) {
            double pointX = points[i][0];
            double pointY = points[i][1];
            double leftSideOfInequality = Math.pow((pointX - (double)centerOfCircleX), 2) + Math.pow((pointY - (double)centerOfCircleY), 2);
            double squaredRadius = (double) (radius * radius);
            if(leftSideOfInequality == squaredRadius) {
                System.out.println(0);
            } else if(leftSideOfInequality < squaredRadius) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
            i++;
        }
    }
}
