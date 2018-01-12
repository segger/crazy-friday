
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PizzaCalc {

    public static void main(String[] args) {
        System.out.println("PizzaCalc");

        String input = args[0];
        switch (input) {
            case "v1": v1();break;
            case "v2": v2();break;
        }
    }
        private static void v1 (){
        int nbrOfPeople = 0;
        int nbrOfPizzas = 0;
        int nbrOfSlizesPerPizza = 0;

        Scanner reader = new Scanner(System.in);
        while (nbrOfPeople <= 0 ){
            try {
                System.out.println("How many people?");
                nbrOfPeople = reader.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
            }
            reader.nextLine();
        }
        //System.out.println("nbrOfPeople="+nbrOfPeople);
        while (nbrOfPizzas <= 0 ) {
            try {
                System.out.println("How many pizzas?");
                nbrOfPizzas = reader.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
            }
            reader.nextLine();

        }
        //System.out.println("nbrOfPizzas="+nbrOfPizzas);
        while (nbrOfSlizesPerPizza <= 0 ) {
            try {
                System.out.println("How many slizes per pizza?");
                nbrOfSlizesPerPizza = reader.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
            }
            reader.nextLine();

        }
        int nbrOfSlizes = nbrOfSlizesPerPizza * nbrOfPizzas;

        int nbrOfSlizesPerPerson = nbrOfSlizes / nbrOfPeople;
        int nbrOfLeftOvers = nbrOfSlizes % nbrOfPeople;

        String pieces = nbrOfSlizesPerPerson == 1 ? "piece" : "pieces";
        String leftover = nbrOfLeftOvers == 1 ? "There is " + nbrOfLeftOvers + " leftover piece" : "There are " + nbrOfLeftOvers + " leftover pieces";

        System.out.println("Each person gets " + nbrOfSlizesPerPerson + " " + pieces +" of pizza");
        System.out.println(leftover);

        reader.close();
    }
    private static void v2 (){
        int nbrOfPeople = 0;
        int nbrOfSlizesPerPizza = 0;

        Scanner reader = new Scanner(System.in);
        while (nbrOfPeople <= 0 ){
            try {
                System.out.println("How many people?");
                nbrOfPeople = reader.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
            }
            reader.nextLine();
        }

        while (nbrOfSlizesPerPizza <= 0 ) {
            try {
                System.out.println("How many slizes per pizza?");
                nbrOfSlizesPerPizza = reader.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
            }
            reader.nextLine();
        }

        int[] nbrOfSlizesPerPerson = new int[nbrOfPeople];
        for(int i = 0; i < nbrOfPeople; i++) {

        }

        reader.close();
    }
}
