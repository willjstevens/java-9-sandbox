package chapter_3;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

import static java.util.Comparator.*;

@RunWith(MockitoJUnitRunner.class)
public class Quiz3_7Test {

    @Before
    public void setup() {
    }


    @Test
    public void itShouldTestPredicateFunctions() {
        Predicate<Apple> redApplePredicate = apple -> { return apple.color.equals("red"); };
        List<Apple> inventory = getLoadedInventory();
//        Consumer<Predicate<Apple>> toStringer = System.out::println;
        inventory.stream().forEach(a -> redApplePredicate.test(a));

        Predicate<Apple> notRedApplePredicate = redApplePredicate.negate();

//        Consumer<Apple> toStringer = a -> {
//            boolean result = notRedApplePredicate.test(a);
//            System.out.println(String.format("Predicate result: %b", result));
//        };
//        inventory.stream().forEach(toStringer);

        BiConsumer<Predicate<Apple>, Apple> biConsumer = (pred, a) -> {
            boolean result = pred.test(a);
            System.out.println(String.format("Predicate result: %b", result));
        };
        inventory.stream().forEach(a -> biConsumer.accept(notRedApplePredicate, a));

        Predicate<Apple> notRedAndHeavyPredicate = notRedApplePredicate.and(a -> a.weight > 10);
        inventory.stream().forEach(a -> biConsumer.accept(notRedAndHeavyPredicate, a));

    }

    @Test
    public void itShouldInstantiateTriNum() {

        TriFunction<Integer, Integer, Integer, TriNum> triFunction =
            TriNum::new;

        TriNum triNum = triFunction.apply(1, 2, 3);


    }

    @Test
    public void itShouldTestComparatorsOnLists() {


        List<Apple> inventory = getLoadedInventory();

        Consumer<Apple> toStringer = System.out::println;

        inventory.stream().forEach(toStringer);

        // now try to sort reverse
//        inventory.sort(comparing(Apple::getColor));
        inventory.sort(comparing(Apple::getColor)
            .thenComparing(Apple::getWeight)
            .reversed());

        System.out.println("\n");

        inventory.stream().forEach(toStringer);
    }

    private List<Apple> getLoadedInventory() {
        BiFunction<String, Integer, Apple> appleBiFunction = Apple::new;
        List<Apple> inventory = new ArrayList<>();
        inventory.add(appleBiFunction.apply("red", 6));
        inventory.add(appleBiFunction.apply("red", 12));
        inventory.add(appleBiFunction.apply("green", 5));
        inventory.add(appleBiFunction.apply("green", 15));
        inventory.add(appleBiFunction.apply("green", 10));
        return inventory;
    }


    public interface TriFunction<F, S, T, R> {
        R apply(F f, S s, T t);
    }

    public class TriNum {
        TriNum(int f, int s, int t) {
            System.out.println(String.format("f=%d, s=%d, t=%d", f, s, t));
        }
    }

    void scratch() {

        // create a no-args instance
        Supplier<Apple> supplier1 = Apple::new;
        Apple a1 = supplier1.get();

        Supplier<Apple> supplier2 = () -> new Apple();
        Apple a2 = supplier2.get();

        Function<Integer, Apple> supplier3 = Apple::new;
        Apple a3 = supplier3.apply(150);

        Function<Integer, Apple> supplier4 = (weight) -> new Apple(weight);
        Apple a4 = supplier4.apply(151);

        BiFunction<String, Integer, Apple> biFunction1 = Apple::new;
        Apple a5 = biFunction1.apply("green", 100);


        List<Apple>inventory = new ArrayList<>();
        inventory.sort((apple1, apple2) ->
            apple1.weight.compareTo(apple2.weight)
        );

        inventory.sort(Comparator.comparing(apple -> apple.weight));
        inventory.sort(comparing(apple -> apple.weight)); // with static
        inventory.sort(comparing(Apple::getWeight));


        // play around with lamdas and the list
        inventory.sort(comparing(Apple::getWeight).reversed());
        inventory.sort(comparing(Apple::getWeight)
            .reversed()
            .thenComparing(Apple::getColor));
    }


    class Apple {
        String color;
        Integer weight;

        public Apple() {}

        public Apple(int weight) {
            this.weight = weight;
        }

        public Apple(String color, int weight) {
            this.color = color;
            this.weight = weight;
        }

        int getWeight() {
            return weight;
        }

        String getColor() {
            return color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
