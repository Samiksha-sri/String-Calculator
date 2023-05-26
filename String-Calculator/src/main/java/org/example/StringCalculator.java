package org.example;

public class StringCalculator {


    public static int add(String numbers){

        if(numbers.length() == 0)
            return 0;

        String [] numberEntries = numbers.split(",");

        int answer = sum(numberEntries);

        return answer;
    }

    public static int sum(String[] numbers){

        int result = 0;

        for(String entry : numbers){
            result += Integer.parseInt(entry);
        }

        return result;
    }
}