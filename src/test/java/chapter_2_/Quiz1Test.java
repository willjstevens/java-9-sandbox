package chapter_2_;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class Quiz1Test {

    @Before
    public void setup() {
    }


    @Test
    public void itShouldValidateQuiz1() {

        chapter_2_.Quiz1.Apple redApple = new Quiz1.Apple(150, "red");
        List<Quiz1.Apple> apples = new ArrayList<>();
        apples.add(redApple);

        String output = Quiz1.prettyPrintApple(apples, new Quiz1.SimpleAppleFormatter());

        Assert.assertEquals("weight=150,color=red", output);
    }


}
