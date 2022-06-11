import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Calculator {
    public static Logger logger = Logger.getLogger(Calculator.class.getName());

    public static void main(String[] args) {
        setLoggerSetting();
        int choice;
        String continu;
        double num1, num2;
        Scanner inp = new Scanner(System.in); // to read input

        while (true) {
            logger.log(Level.INFO, "User Input");
            System.out.println("\nselect operation\n1. add\n2. subtract\n3. mutiply\n4. divide");
            System.out.println("Enter choice(1, 2, 3, 4): ");
            choice = inp.nextInt();
            logger.log(Level.INFO, "User have selected "+ choice);
            System.out.println("Enter first number: ");
            num1 = inp.nextDouble();
            System.out.println("Enter second number: ");
            num2 = inp.nextDouble();

            if (choice == 1) {
                logger.log(Level.INFO, "Calculator task " + num1 + " " + "add" + " " + num2);
                System.out.println(num1 + " + " + num2 + " = " + add(num1, num2));
            } else if (choice == 2) {
                logger.log(Level.INFO, "Calculator task " + num1 + " " + "subtract" + " " + num2);
                System.out.println(num1 + " - " + num2 + " = " + subtract(num1, num2));
            } else if (choice == 3) {
                logger.log(Level.INFO, "Calculator task " + num1 + " " + "multiply" + " " + num2);
                System.out.println(num1 + " * " + num2 + " = " + multiply(num1, num2));
            } else if (choice == 4) {
                logger.log(Level.INFO, "Calculator task " + num1 + " " + "divide" + " " + num2);
                System.out.println(num1 + " / " + num2 + " = " + divide(num1, num2));
            } else {
                System.out.println("invalid operation!");
                logger.warning("invalid operation!");
            }

            System.out.println("\nContinue? y/n");
            continu = inp.next();
            if (continu.equals("n")) {
                logger.log(Level.INFO, "Application Stopped");
                break;
            }
        }
    }

    public static double add(double n1, double n2) {
        return n1 + n2;
    }

    public static double subtract(double n1, double n2) {
        return n1 - n2;
    }

    public static double multiply(double n1, double n2) {
        return n1 * n2;
    }

    public static double divide(double n1, double n2) {
        if (n2 == 0) return 0;
        else return n1 / n2;
    }


    public static void setLoggerSetting() {
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
        } catch (SecurityException | IOException e1) {
            e1.printStackTrace();
        }
        logger.setLevel(Level.FINE);
        logger.addHandler(new ConsoleHandler());
        //adding custom handler
        logger.addHandler(new MyHandler());
        try {
            //FileHandler file name with max size and number of log files limit
            Handler fileHandler = new FileHandler("/Users/hetpatel/temp/logger.log", 20000, 1);
            fileHandler.setFormatter(new MyFormatter());
            //setting custom filter for FileHandler
            fileHandler.setFilter(new MyFilter());
            logger.addHandler(fileHandler);

            logger.log(Level.CONFIG, "Config data");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }
}
