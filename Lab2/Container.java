package com.company;

public class Container {
    static StringBuilder[] array_of_inp = new StringBuilder[30];

    static StringBuilder[] get_input(StringBuilder[] sentence){
        for(int i = 0; i < sentence.length; i++){
            array_of_inp[i] = sentence[i];
        }
        return array_of_inp;
    }

    static String toStr(){
        StringBuilder str_b_inp = new StringBuilder();
        for(int i = 0; i<array_of_inp.length; i++){
            if(array_of_inp[i] != null) {
                str_b_inp.append(array_of_inp[i]);
                str_b_inp.append(" ");
            }
            else if(array_of_inp[i] == null){
                break;
            }
        }
        String str_inp = str_b_inp.toString();
        return str_inp;
    }

    static void add(String string){

        StringBuilder string_b = new StringBuilder();
        string_b.append(string);

        for(int i = 0; i<array_of_inp.length; i++){
            if(array_of_inp[i] == null){
                array_of_inp[i] = string_b;
                break;
            }
        }
    }

    static void clear(){
        for(int i = 0; i<array_of_inp.length; i++){
            array_of_inp[i] = null;
        }
    }

    static void remove(String string){
        StringBuilder string_v = new StringBuilder(string);
        int counter = 0;
        for(int i = 0; i<array_of_inp.length; i++){
            if(array_of_inp[i].toString().equals(string_v.toString())){
                counter = i;
                break;
            }
        }
        for(int j = counter; j<array_of_inp.length-1; j++){
            array_of_inp[j] = array_of_inp[j+1];
        }
    }

    static StringBuilder[] toArray(){
        return array_of_inp;
    }

    static int size(){
        int counter = 0;
        for(int i = 0; i<array_of_inp.length; i++){
            if(array_of_inp[i] != null){
                counter ++;
            }
            else{
                break;
            }
        }
        return counter;
    }

    static boolean contains(String string){
        StringBuilder string_c = new StringBuilder(string);
        for(int i = 0; i<array_of_inp.length; i++){
            if(array_of_inp[i].toString().equals(string_c.toString())){
                return true;
            }
        }
        return false;
    }

}
