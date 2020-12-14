package in.algo.random;

import java.util.*;
import java.util.stream.Collectors;

//Find the next highest even number from the digits of a given number. -1 if it is not possible.
public class NextHighestEvenNumber {
    public static void main(String[] args) {
        System.out.println(findNextHighestEvenNumber("345"));
        System.out.println(findNextHighestEvenNumber("1234"));
        System.out.println(findNextHighestEvenNumber("4321"));
    }

    private static int findNextHighestEvenNumber(String inputNumber) {

        //Find the even digits.
        List<Integer> evenDigits = new ArrayList<>();
        for (char digit : inputNumber.toCharArray()) {
            int digitNum = Integer.parseInt(String.valueOf(digit));
            if(digitNum%2==0) {
                evenDigits.add(digitNum);
            }
        }

        Set<Integer> setOfUniqueNumbers = new HashSet<>();

        //Keep every even digit at different index in the string.
        //e.g. in 1342, we take 4 and keep it at every index to create 4132, 1432, 1342, 1324
        for (Integer digit : evenDigits) {
            for (int index = 0; index<inputNumber.length(); index++) {
                //Get the index of the digit
                int digitIndex = inputNumber.indexOf(""+digit);

                //Create a string without this digit. e.g. for 1342 make 132
                StringBuilder sbr = new StringBuilder(inputNumber);
                sbr.deleteCharAt(digitIndex);

                //Create the new number by inserting digit at proper index.
                //e.g. from 132, insert 4 at 0th index to make 4132
                sbr.insert(index, digit);
                Integer num = Integer.parseInt(sbr.toString());

                //Add only even numbers to our set
                if (num%2==0) {
                    setOfUniqueNumbers.add(num);
                }
            }
        }

        //Filter the set, for only numbers that are greater than input number.
        List<Integer> list = setOfUniqueNumbers.stream().filter(c-> c>Integer.parseInt(inputNumber)).collect(Collectors.toList());

        //Next highest than input number will be first in the list.
        return list.isEmpty()?-1:list.get(0);
    }
}
