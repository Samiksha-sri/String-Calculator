package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {


    public static int add(String numbers){
        
        String [] numberEntries = splitDigits(numbers);

        int answer = sum(numberEntries);

        return answer;
    }

    public static int sum(String[] numbers){

        int result = 0;

        for(String number : numbers){

            try {
                result += Integer.parseInt(number);
            }
            catch (NumberFormatException e){
                throw new RuntimeException("Digit not found.");
            }
        }
        
        return result;

    }

    public static String[] splitWithCommaAndNewLine(String numbers){
        String [] digits = numbers.split(",|\n");
        return digits;
    }

    public static boolean hasCustomDelimiter(String numbers){
        return numbers.startsWith("//");
    }

    public static String[] splitWithCustomDelimiter(String numbers){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
        m.matches();
        String customDelimiter = m.group(1);
        String digits = m.group(2);
        return digits.split(Pattern.quote(customDelimiter));
    }

    public static String[] splitDigits(String numbers){
        if(numbers.isEmpty()){
            return new String[0];
        }
        else if(hasCustomDelimiter(numbers)){
            return splitWithCustomDelimiter(numbers);
        }

        return splitWithCommaAndNewLine(numbers);

    }

}