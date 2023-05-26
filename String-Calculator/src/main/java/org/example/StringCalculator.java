package org.example;

public class StringCalculator {


    public static int add(String numbers){

        if(numbers.length() == 0)
            return 0;

        String delimiter = ",";

        if(numbers.matches("//(.*)\n(.*)")){
            delimiter = Character.toString(numbers.charAt(2));
            numbers = numbers.substring(4);
        }

        String [] numberEntries = numbers.split(delimiter + "|\n");

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
}