package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        new Menu().execute();

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String sentence = "";
        while (!"4".equals(s)) {

            if ("-h".equals(s) || "help".equals(s)) {
                new Help().execute();
            }
            else if ("-d".equals(s) || "debug".equals(s)) {
                new Debug().execute();
            }
            else if("1".equals(s)){
                System.out.println("Enter your sentence: ");
                Scanner scaner = new Scanner(System.in);
                sentence = scaner.nextLine();
                get_sentence(sentence);

                //

                Container kont = new Container();
                kont.get_input(get_sentence(sentence));

                System.out.println(kont.toStr());

                kont.add("lala");
                System.out.println(kont.toStr());

                kont.remove("lala");
                System.out.println(kont.toStr());
                //


                System.out.println("Sentence was gotten\n");
                new Menu().execute();
            }
            else if("2".equals(s)){
                System.out.println("All the inputed words");
                print(sentence);
                new Menu().execute();
            }
            else if("3".equals(s)){
                System.out.println("Words with same start and end");
                same_first_and_last(sentence);
                new Menu().execute();
            }
            else if("5".equals(s)){
                System.out.println("Iteration words");
                iter(sentence);
                new Menu().execute();
            }
            else if("6".equals(s)){
                System.out.println("Cleaning");
                Container kont = new Container();
                kont.get_input(get_sentence(sentence));
                kont.clear();
                System.out.println("Container is clear");
                new Menu().execute();
            }
            else{
                System.out.println("Please repeat");
            }
            s = scan.nextLine();

            if("4".equals(s)){//if 4 - finish and print "good buy"
                new Exit().execute();
                break;
            }
        }
    }
    private static StringBuilder[] get_sentence(String sentence){


        StringBuilder[] str_array = new StringBuilder[15];
        StringBuilder strbuilder = new StringBuilder();

        int counter = 0;

        for(int i = 0; i<sentence.length(); i++){
            if(' ' != sentence.charAt(i)) {
                strbuilder.append(sentence.charAt(i));
            }
            else{
                str_array[counter] = strbuilder;
                counter += 1;
                strbuilder = new StringBuilder();
            }
        }
        return str_array;
    }
    private static void print(String sentence){
        for(int i=0; i<5; i++){
            if(get_sentence(sentence)[i] != null) {
                System.out.println(get_sentence(sentence)[i]);
            }
        }
    }

    private static void iter(String sentence){
        for(int i=0; i<5; i++){
            if(get_sentence(sentence)[i] != null) {
                System.out.println("Item: " + get_sentence(sentence)[i]);
            }
        }
    }

    private static void same_first_and_last(String sentence){
        for(int i=0; i<5; i++){
            if(get_sentence(sentence)[i] != null) {
                //System.out.println(get_sentence(sentence)[i].charAt(0));
                //System.out.println(get_sentence(sentence)[i].charAt(get_sentence(sentence)[i].length() - 1));
                if (get_sentence(sentence)[i].charAt(0) == get_sentence(sentence)[i].charAt(get_sentence(sentence)[i].length() - 1)) {
                    System.out.println(get_sentence(sentence)[i]);
                }
            }
        }
    }
}


class Help implements Command {
    @Override
    public void execute() {
        System.out.println("1) Enter words using spaces. In the end too!");
        System.out.println("2) Show your inputed sentences spliting them into new lines");
        System.out.println("3) Run the printer (print all the words which 1-st and last letter the same)");
        System.out.println("4) Finish program");
    }
}

class Debug implements Command {
    @Override
    public void execute() {
        System.out.println("1) Don`t use ,?! etc. Finish the sentence with space");
        System.out.println("2) New line = new sentence");
        System.out.println("3) show all word from one sentence in one line");
        System.out.println("4) Finish program");
    }
}

class Exit implements Command{
    @Override
    public void execute() {
        System.out.println("Goodbye!");
    }
}

class Menu implements Command {
    @Override
    public void execute() {
        System.out.println("1) Enter sentences");
        System.out.println("2) Show input");
        System.out.println("3) Run the printer");
        System.out.println("4) Exit");
        System.out.println("5) Iterate");
        System.out.println("6) Clear container");
    }
}
