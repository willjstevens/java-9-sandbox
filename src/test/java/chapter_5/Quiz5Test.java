package chapter_5;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@RunWith(MockitoJUnitRunner.class)
public class Quiz5Test {

    @Before
    public void setup() {
    }


    @Test
    public void itShouldTestQuiz1() {

        List<Dish> dishes = generateDishes();

        List<Dish> filteredDishes = dishes.stream()
                .filter(d -> d.type == Dish.Type.OTHER)
                .limit(2)
                .collect(toList());

        filteredDishes.stream()
                .map(n -> n.getTitle())
                .forEach(System.out::println);
    }


    @Test
    public void itShouldTestQuiz2() {
        // question 1
        int[] nums = {1, 2, 3, 4, 5};

        Arrays.stream(nums)
                .map(i -> i*i)
                .forEach(System.out::println);

    }

    @Test
    public void itShouldTestQuiz3() {
        int totalCalories =
                generateDishes().stream()
                    .mapToInt(d -> d.calories)
                    .reduce(0, (a, b) -> a + b);
        System.out.println(String.format("totalCalories = %d", totalCalories));

    }

    @Test
    public void itShouldPutItIntoPractice() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

//        1.   Find all transactions in the year 2011 and sort them by value (small to high).

        System.out.println("\nResults for: Find all transactions in the year 2011 and sort them by value (small to high).");
        List<Transaction> results1 =
                transactions.stream()
                    .filter(t -> t.getYear() == 2011)
                    .sorted(Comparator.comparing(Transaction::getValue))
                    .collect(toList());
        System.out.println(String.format("\nResults of #1: %s", results1));


//        2.  What are all the unique cities where the traders work?

        System.out.println("\nResults for: What are all the unique cities where the traders work?");
        traders.stream()
            .map(t -> t.getCity())
            .distinct()
            .forEach(System.out::println);

//        3.  Find all traders from Cambridge and sort them by name.

        System.out.println("\nFind all traders from Cambridge and sort them by name.");
        traders.stream()
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);


//        4.  Return a string of all traders’ names sorted alphabetically.

        System.out.println("\nReturn a string of all traders’ names sorted alphabetically.");
        String results4 = traders.stream()
                .sorted(Comparator.comparing(Trader::getName))
                .map(t -> t.getName())
                .reduce("", (f, s) -> f + " " + s);
        System.out.println("\nResult: " + results4);

//        5.  Are any traders based in Milan?

        System.out.println("\nAre any traders based in Milan?");
        boolean results5 = traders.stream()
                .anyMatch(t -> t.getCity().equals("Milan"));
        System.out.println("\nResult: " + results5);


//        6.  Print all transactions’ values from the traders living in Cambridge.

        System.out.println("\nPrint all transactions’ values from the traders living in Cambridge.");
        transactions.stream()
                .filter(tx -> tx.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getValue())
                .forEach(System.out::println);


//        7.  What’s the highest value of all the transactions?

        System.out.println("\nWhat’s the highest value of all the transactions?");
        int results7 = transactions.stream()
                .map(t -> t.getValue())
                .reduce(0, (e, s) -> s > e ? s : e);
        System.out.println("\nResult 7: " + results7);

//        8.  Find the transaction with the smallest value.

        System.out.println("\nFind the transaction with the smallest value.");
        int results8 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(2000, (e, s) -> s < e ? s : e);
        System.out.println("\nResult 8: " + results8);
//        int results8_2 = transactions.stream()
//                .min(Comparator.comparing(Transaction::getValue)).orElseGet();
//        System.out.println("\nResult 8 part 2: " + results8_2);



    }

    List<Dish> generateDishes() {
        List<Dish> specialMenu = Arrays.asList(new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));
        return specialMenu;
    }


}
