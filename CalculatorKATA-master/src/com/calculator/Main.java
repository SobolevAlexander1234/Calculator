package com.calculator;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] calk) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] str = input.split(" ");
        String num1 = str[0];
        String num2 = str[2];
        String operation = str[1];

        // проверка кол-ва символов и знака операции
        int quantity = str.length;
        if (quantity != 3 || checkingOperation(operation)) {
            throw new IllegalArgumentException();
        }

        // проверка на арабские числа
        if (num1.matches("\\d+") && num2.matches("\\d+")) {
            int num1Arabic = Integer.parseInt(num1);
            int num2Arabic = Integer.parseInt(num2);

            if ((num1Arabic > 0 && num1Arabic < 11) && (num2Arabic > 0 && num2Arabic < 11)) {
                System.out.println(Operation.doingOperation(num1Arabic, num2Arabic, operation));
            } else {
                throw new IOException("Incorrect numbers");
            }

            // проверка на римские числа
        } else if (RomanNumbers.checkingRomanNum(num1) && RomanNumbers.checkingRomanNum(num2)) {
            int numRoman1 = RomanNumbers.romanToInt(num1);
            int numRoman2 = RomanNumbers.romanToInt(num2);
            int res = Operation.doingOperation(numRoman1, numRoman2, operation);
            if (res > 0) {
                System.out.println(RomanNumbers.intToRome(res));
            } else {
                throw new IOException("Римские числа не могут быть отрицательными");
            }
        } else {
            throw new IOException("Incorrect input");
        }

    }

     static boolean checkingOperation(String operation) {
        if (operation.equals("/") || operation.equals("*") || operation.equals("+") || operation.equals("-")) {
            return false;
        } else {
            return true;
        }
    }
}
class Operation {
    static int doingOperation(int number1, int number2, String operation){
        int result = 0;
        switch (operation) {
            case "+":
                result = (number1 + number2);
                break;
            case "-":
                result = (number1 - number2);
                break;
            case "*":
                result = (number1 * number2);
                break;
            case "/":
                result = (number1 / number2);
                break;
        } return result;
    }
}
class RomanNumbers {
    public static boolean checkingRomanNum (String romNum) {
        boolean checking = true;
        switch (romNum){
            case "I":
                break;
            case "II":
                break;
            case "III":
                break;
            case "IV":
                break;
            case "V":
                break;
            case "VI":
                break;
            case "VII":
                break;
            case "VIII":
                break;
            case "IX":
                break;
            case "X":
                break;
            default:
                checking = false;
        } return checking;
    }
    public static int romanToInt(String romanNum) {
        int result = 0;
        switch (romanNum) {
            case "I":
                result = 1;
                break;
            case "II":
                result = 2;
                break;
            case "III":
                result = 3;
                break;
            case "IV":
                result = 4;
                break;
            case "V":
                result = 5;
                break;
            case "VI":
                result = 6;
                break;
            case "VII":
                result = 7;
                break;
            case "VIII":
                result = 8;
                break;
            case "IX":
                result = 9;
                break;
            case "X":
                result = 10;
                break;
        } return result;
    }
    static String intToRome(int romanResult) {
        StringBuilder result = new StringBuilder();

        while (romanResult > 0) {
            if ((romanResult/100) >= 1) {
                result.append("C");
                romanResult = romanResult - 100;
            } else if ((romanResult/50) >= 1) {
                result.append("L");
                romanResult = romanResult - 50;
            } else if ((romanResult/10) >= 1) {
                result.append("X");
                romanResult = romanResult - 10;
            } else {
                switch ((romanResult)) {
                    case 9:
                        result.append("IX");
                        romanResult -= 9;
                        break;
                    case 8:
                        result.append("VIII");
                        romanResult -= 8;
                        break;
                    case 7:
                        result.append("VII");
                        romanResult -= 7;
                        break;
                    case 6:
                        result.append("VI");
                        romanResult -= 6;
                        break;
                    case 5:
                        result.append("V");
                        romanResult -= 5;
                        break;
                    case 4:
                        result.append("IV");
                        romanResult -= 4;
                        break;
                    case 3:
                        result.append("III");
                        romanResult -= 3;
                        break;
                    case 2:
                        result.append("II");
                        romanResult -= 2;
                        break;
                    case 1:
                        result.append("I");
                        romanResult -=  1;
                        break;
                }
            }
        }

        if (romanResult < 0) {
            throw new IllegalArgumentException("Wrong Input! Roman numbers cannot be negative");
        }
        return result.toString();
    }
}