package chapter_3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

@RunWith(MockitoJUnitRunner.class)
public class Quiz3_6Test {

    @Before
    public void setup() {
    }


    @Test
    public void itShouldValidateMethodLambdas() {

        // question 1
        Function<String, Integer> stringToInteger =
                (String s) -> Integer.parseInt(s);
        int expectedInt = stringToInteger.apply("5");
        Function<String, Integer> stringToIntegerFunction = Integer::parseInt;
        int actualInt = stringToIntegerFunction.apply("5");
        Assert.assertEquals(expectedInt, actualInt);

        // question 2
        List<Integer> subjects = Arrays.asList(1, 2, 3, 4, 5);
        BiPredicate<List<Integer>, Integer> containsExpected =
                (list, element) -> list.contains(element);
        boolean expectedContains = containsExpected.test(subjects, 4);
        BiPredicate<List<Integer>, Integer> containsActual =
                List::contains;
        boolean actualContains = containsActual.test(subjects, 4);
        Assert.assertEquals(expectedContains, actualContains);

        // question 3
        Predicate<String> startsWithNumberPred = (String string) -> this.startsWithNumber("3");
        boolean expectedString = startsWithNumberPred.test("3");
        Predicate<String> startsWithNumberMethodReference = this::startsWithNumber;
        boolean actualString = startsWithNumberMethodReference.test("3");
        Assert.assertEquals(expectedString, actualString);



//        Quiz1.Apple redApple = new Quiz1.Apple(150, "red");
//        List<Quiz1.Apple> apples = new ArrayList<>();
//        apples.add(redApple);
//
//        String output = Quiz1.prettyPrintApple(apples, new Quiz1.SimpleAppleFormatter());
//
//        Assert.assertEquals("weight=150,color=red", output);
    }


    private boolean startsWithNumber(String string) {
        boolean retval = false;
        Optional<String> stringOp = Optional.ofNullable(string);
        if (stringOp.isPresent() && !string.isEmpty()) {
            char firstChar = string.charAt(0);
            retval = String.valueOf(firstChar).matches("-?\\d+(\\.\\d+)?");
        }
        return retval;
    }
}
