package chapter_2_;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FilterScratchTest {

    @Before
    public void setup() {
    }


    @Test
    public void itShouldValidateFilter() {

        List<Integer> subjects = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        List<Integer> filteredList = chapter_2_.FilterScratch.filter(subjects,
                (Integer i) -> i % 2 == 0 );

        assertEquals(3, filteredList.size());

    }


}
