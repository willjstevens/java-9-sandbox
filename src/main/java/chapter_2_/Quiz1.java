/*
 * Property of Will Stevens
 * All rights reserved.
 */
package chapter_2_;

import java.util.List;

/**
 * @author wstevens
 */
public class Quiz1
{


    public static String prettyPrintApple(List<Apple> inventory, AppleFormatter appleFormatter) {
        StringBuilder builder = new StringBuilder();
        for(Apple apple: inventory) {
            String output =  appleFormatter.accept(apple);
            builder.append(output);
        }
        return builder.toString();
    }

    public interface AppleFormatter {
        String accept(Apple apple);
    }

    class WeightAppleFormatter implements  AppleFormatter {
        @Override
        public String accept(Apple apple) {
            return String.format("weight=%d", apple.getWeight());
        }
    }

    static class SimpleAppleFormatter implements AppleFormatter {
        @Override
        public String accept(Apple apple) {
            return String.format("weight=%d,color=%s", apple.getWeight(), apple.getColor());
        }
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

}
