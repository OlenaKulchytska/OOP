package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ініціалізація всіх початкових змінних
        Scanner in = new Scanner(System.in);
        String input = null;
        String output = null;
        String command;
        int lengthToDelete = 0;
        boolean debug = false;

        // перевірка аргументів командного рядка
        if(args != null && args.length == 1){
            if(args[0].equals("-h")){
                System.out.println("Кульчицька Олена.Ввести текст. З тексту видалити всі слова заданої довжини, що\n" +
                        "починаються на приголосну літеру. Вивести початковий текст та\n" +
                        "результат.\n");
            }
            if(args[0].equals("-d")){
                debug = true;
            }
        }

        // вивід текстового меню для користувача
        System.out.println(
                "a. введення даних\n" +
                        "b. перегляд даних\n" +
                        "c. обробка даних\n" +
                        "d. відображення результату\n" +
                        "e. завершення програми");

        // обробка команд
        do{
            command = in.nextLine();

            if(command.equals("a")){
                System.out.print("Введіть вхідні дані: ");
                input = in.nextLine();
                lengthToDelete = in.nextInt();
            }

            if(command.equals("b")){
                if(input != null){
                    System.out.println("Ви ввели:");
                    System.out.println(input + "\n" + lengthToDelete);
                }
                else{
                    System.out.println("Відсутні вхідні дані");
                }
            }

            if(command.equals("c")){
                if(input != null){
                    System.out.println("Обробка...");
                    output = StringEditor.edit(input, lengthToDelete, debug);
                }
                else{
                    System.out.println("Відсутні вхідні дані");
                }
            }

            if(command.equals("d")){
                if(output != null){
                    System.out.println("Результат: ");
                    System.out.println(output);
                    input = null;
                    output = null;
                }
                else {
                    System.out.println("Відсутні вихідні дані");
                }
            }
        }while (!command.equals("e"));

        System.exit(0);
    }
}
class StringEditor {

    static String edit(String text, int deleteLength, boolean debug){

        StringBuilder editedText = new StringBuilder();
        // відредагувати задану стрічку згідно з умовою
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == ' '){
                continue;
            }

            int counter = 0;
            // підрахунок довжини слова
            for(int j = i; j < text.length(); j++){
                if(text.charAt(j) == ' '){
                    break;
                }
                counter++;
            }

            String word = text.substring(i, i + counter);
            if(debug) System.out.println("Слово, що перевіряється: " + word);
            // додати слово, якщо воно не задовільняє умову видалення
            if(counter != deleteLength || f(word)){
                editedText.append(word);
                editedText.append(' ');
            }
            i += counter;
            if(debug) System.out.println(editedText.toString());
        }


        return editedText.toString();
    }

    // функція для перевірки чи починається слово з голосної букви
    private static boolean f(String  word){
        word = word.toLowerCase();
        char c = word.charAt(0);
        char[] chars = {'a', 'o', 'i','e','u'};
        for(char a: chars){
            if(a == c){
                return true;
            }
        }
        return false;
    }
}
