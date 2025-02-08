package org.example;

import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer previous_result = null;

        System.out.println("Добро пожаловать в калькулятор!");
        System.out.println("Для завершения программы введите 'Выход'.");

        while (true) {
            int num1;
            if (previous_result == null) {
                num1 = get_int_input(scanner, "Введите первое целое число:");
            } else {
                num1 = previous_result;
                System.out.println("Предыдущий результат: " + previous_result);
            }

            System.out.println("Введите операцию (Сложить, Вычесть, Умножить, Разделить, Остаток):");
            String operation = get_string(scanner);

            int num2 = get_int_input(scanner, "Введите второе целое число:");

            switch (operation) {
                case "сложить":
                    previous_result = num1 + num2;
                    System.out.println(num1 + " + " + num2 + " = " + previous_result);
                    break;
                case "вычесть":
                    previous_result = num1 - num2;
                    System.out.println(num1 + " - " + num2 + " = " + previous_result);
                    break;
                case "умножить":
                    previous_result = num1 * num2;
                    System.out.println(num1 + " * " + num2 + " = " + previous_result);
                    break;
                case "разделить":
                    if (num2 == 0) {
                        System.out.println("Ошибка: Деление на ноль невозможно.");
                        continue;
                    }
                    previous_result = num1 / num2;
                    System.out.println(num1 + " / " + num2 + " = " + previous_result);
                    break;
                case "остаток":
                    if (num2 == 0) {
                        System.out.println("Ошибка: Остаток от деления на ноль невозможен.");
                        continue;
                    }
                    previous_result = num1 % num2;
                    System.out.println(num1 + " % " + num2 + " = " + previous_result);
                    break;
                default:
                    System.out.println("Ошибка: Операция не распознана. Я не умею " + operation);
            }
        }
    }

    private static String get_string(Scanner scanner) {
        String operation = scanner.next().toLowerCase();

        if (operation.equals("выход")) {
            System.out.println("Программа завершена.");
            System.exit(0);
        }
        return operation;
    }

    private static int get_int_input(Scanner scanner, String prompt) {
        while (true) {
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                get_string(scanner);
                System.out.println("Ошибка: Введите корректное целое число.");
            }
        }
    }
}
