/*
 * Property of Will Stevens
 * All rights reserved.
 */
package chapter_2_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wstevens
 */
public class FilterScratch {

    interface Predicate<T> {
        boolean test(T subject);
    }

    public static <T> List<T> filter(List<T> subjects, Predicate<T> test) {
        List<T> filteredList = new ArrayList<>();
        for (T subject : subjects) {
            if (test.test(subject)) {
                filteredList.add(subject);
            }
        }
        return filteredList;
    }


}
