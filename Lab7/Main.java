package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static Aboutme meFind(int id,List<Aboutme> me){
        Iterator<Aboutme> myItr = me.iterator();
        while(myItr.hasNext()){
            Aboutme t = myItr.next();
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        boolean autoMode = false;
        for(int i = 0;i < args.length;i++){
            if(args[i].equals("-auto")){
                autoMode = true;
                System.out.println("Автоматичний режим запущено");
            }
        }
        List<Aboutme> aboutmeList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        if(autoMode){
            try {
                scan = new Scanner(new BufferedInputStream(new FileInputStream("automode.txt")));
            }catch(FileNotFoundException ex){
                System.err.println("Автоматичний режим не запущено!");
                scan = new Scanner(System.in);
            }
        }
        int command,id;
        while(true){
            if(autoMode){
                try {
                    TimeUnit.SECONDS.sleep(1);
                }
                catch(InterruptedException e){

                }
            }
            System.out.println("^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_");
            System.out.println("1 - додати клієнта");
            System.out.println("2 - видалити клієнта");
            System.out.println("3 - переглянути список клієнтів");
            System.out.println("4 - опис клієнта");
            System.out.println("5 - записати клієнтів в XML-файл");
            System.out.println("6 - витягти клієнтів з XML-файлу");
            System.out.println("7 - записати клієнтів в файл(TXT)");
            System.out.println("8 - витягти клієнтів з TXT-файлу");
            System.out.println("9 - вийти");
            System.out.println("^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_");
            command = scan.nextInt();
            switch(command){
                case 1:
                    System.out.println("Введіть назву клієнта:");
                    scan.nextLine();
                    Aboutme me = new Aboutme();
                    me.setName(scan.nextLine());
                    aboutmeList.add(me);
                    System.out.println("Клієнта '"+me.getName()+"' додано з ідентифікатором: "+me.getId());
                    break;
                case 2:
                    System.out.println("Введіть ідентифікатор клієнта, щоб видалити:");
                    id = scan.nextInt();
                    Iterator<Aboutme> myItr = aboutmeList.iterator();
                    boolean isFound = false;
                    while(myItr.hasNext()){
                        Aboutme t = myItr.next();
                        if(t.getId() == id){
                            myItr.remove();
                            isFound = true;
                            break;
                        }
                    }
                    if(!isFound){
                        System.err.println("Такого елемента не знайдено!");
                    }
                    else{
                        System.out.println("Елемент видалено!");
                    }
                    break;
                case 3:
                    Iterator<Aboutme> myItr1 = aboutmeList.iterator();
                    while(myItr1.hasNext()){
                        Aboutme t = myItr1.next();
                        System.out.println(t.toString());
                    }
                    break;
                case 4:
                    System.out.println("Введіть ID клієнта, щоб її редагувати: ");
                    id = scan.nextInt();
                    Aboutme temp = meFind(id,aboutmeList);
                    if(temp != null){
                        System.out.println("Клієнта знайдено!");
                        boolean exit = false;
                        while(!exit) {
                            if(autoMode){
                                try {
                                    TimeUnit.SECONDS.sleep(1);
                                }catch(InterruptedException e){

                                }
                            }
                            System.out.println(temp.toString());
                            System.out.println("^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_");
                            System.out.println("1 - Змінити ім'я");
                            System.out.println("2 - Змінити хобі");
                            System.out.println("3 - Змінити колір очей");
                            System.out.println("4 - Змінити вік");
                            System.out.println("5 - Змінити стать");
                            System.out.println("6 - Додати вимоги до партнера");
                            System.out.println("7 - Повернутись до гол. меню");
                            System.out.println("^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_^_");
                            command  = scan.nextInt();
                            switch(command){
                                case 1:
                                    System.out.println("Введіть нове ім'я:");
                                    scan.nextLine();
                                    temp.setName(scan.nextLine());
                                    System.out.println("Успішно змінено!");
                                    break;
                                case 2:
                                    System.out.println("Введіть нове хобі:");
                                    scan.nextLine();
                                    temp.setHobby(scan.nextLine());
                                    System.out.println("Успішно змінено!");
                                    break;
                                case 3:
                                    System.out.println("Введіть новий колір очей:");
                                    scan.nextLine();
                                    temp.setEyes(scan.nextLine());
                                    System.out.println("Успішно змінено!");
                                    break;
                                case 4:
                                    System.out.println("Введіть новий вік:");
                                    temp.setAge(scan.nextInt());
                                    System.out.println("Успішно змінено!");
                                    break;
                                case 5:
                                    System.out.println("Введіть нову стать:");
                                    scan.nextLine();
                                    temp.setStat(scan.nextLine());
                                    System.out.println("Успішно змінено!");
                                    break;
                                case 6:
                                    System.out.println("Додавання нових вимог до пратнера:");
                                    scan.nextLine();
                                    Partner part = new Partner();
                                    System.out.println("Хобі:");
                                    part.setHobby(scan.nextLine());
                                    System.out.println("Вік:");
                                    part.setAge(scan.nextInt());
                                    System.out.println("Колір очей:");
                                    scan.nextLine();
                                    part.setEyes(scan.nextLine());
                                    temp.addPartner(part);
                                    System.out.println("Успішно додано!");
                                    break;
                                case 7:
                                    exit = true;
                                    break;
                            }
                        }
                    }
                    else{
                        System.out.println("Клієнта не знайдено!");
                    }
                    break;
                case 5: {
                    FileOutputStream fos;
                    System.out.println("----Введіть назву файлу:");
                    scan.nextLine();
                    String file_name = scan.nextLine();
                    System.out.println("----Виберіть потрібну директорію, щоб зберегти файл:");
                    String path = FileManager.selectDir(scan) + "\\" + file_name;
                    if (!(new File(path)).exists()) {
                        File newFile = new File(path);
                        try {
                            if (newFile.createNewFile())
                                System.out.println("***Файл '" + file_name + "' було створено!");
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                            break;
                        }
                    }
                    try {
                        fos = new FileOutputStream(path);
                    } catch (FileNotFoundException ex) {
                        System.err.println("Файл не знайдено!");
                        break;
                    }
                    XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(fos));
                    encoder.writeObject(aboutmeList.size());
                    for (Aboutme one : aboutmeList) {
                        encoder.writeObject(one);
                    }
                    encoder.close();
                    System.out.println("Успішно записано!");
                }
                break;
                case 6: {
                    System.out.println("1 - Створити новий список(не зберігається попередній)");
                    System.out.println("2 - Додати до поточного списку");
                    command = scan.nextInt();
                    switch (command) {
                        case 1:
                            System.out.println("----Виберіть файл:");
                            scan.nextLine();
                            String path_ = FileManager.selectFile(scan);
                            FileInputStream fis;
                            try {
                                fis = new FileInputStream(path_);
                            } catch (FileNotFoundException ex) {
                                System.err.println("FileNotFound");
                                break;
                            }
                            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(fis));
                            Integer size = (Integer) decoder.readObject();
                            aboutmeList = new ArrayList<>();
                            Aboutme.cleanAboutme();
                            for (int i = 0; i < size; i++) {
                                aboutmeList.add((Aboutme) decoder.readObject());
                            }
                            decoder.close();

                            break;
                        case 2:
                            System.out.println("----Виберіть файл:");
                            scan.nextLine();
                            String path__ = FileManager.selectFile(scan);
                            FileInputStream fis_;
                            try {
                                fis_ = new FileInputStream(path__);
                            } catch (FileNotFoundException ex) {
                                System.err.println("FileNotFound");
                                break;
                            }
                            XMLDecoder decoder_ = new XMLDecoder(new BufferedInputStream(fis_));
                            Integer size_ = (Integer) decoder_.readObject();
                            for (int i = 0; i < size_; i++) {
                                aboutmeList.add((Aboutme) decoder_.readObject());
                            }
                            decoder_.close();
                            break;
                    }
                }
                break;
                case 7: {
                    FileOutputStream fos;
                    System.out.println("----Введіть назву файлу(TXT):");
                    scan.nextLine();
                    String file_name = scan.nextLine();
                    System.out.println("----Виберіть потрібну директорію, щоб зберегти файл:");
                    String file = FileManager.selectDir(scan) + "\\" + file_name;
                    if (!(new File(file)).exists()) {
                        File newFile = new File(file);
                        try {
                            if (newFile.createNewFile())
                                System.out.println("New file '" + file_name + "' has been created");
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                            break;
                        }
                    }
                    try {
                        fos = new FileOutputStream(file);
                    } catch (FileNotFoundException e) {
                        break;
                    }
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(aboutmeList.size());
                        for (Aboutme one : aboutmeList) {
                            oos.writeObject(one);
                        }
                        oos.flush();
                        oos.close();
                        fos.close();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                        break;
                    }
                }
                break;
                case 8:
                {
                    System.out.println("----Виберіть файл:");
                    scan.nextLine();
                    String path = FileManager.selectFile(scan);
                    FileInputStream fis;
                    try {
                        fis = new FileInputStream(path);
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found!");
                        break;
                    }
                    try {
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        Integer count = (Integer) ois.readObject();
                        for (int i = 0; i < count; i++) {
                            aboutmeList.add((Aboutme) ois.readObject());
                        }
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage() + "dsds");
                        break;
                    } catch (ClassNotFoundException e) {
                        System.out.println("Not Found!");
                        break;
                    }
                }break;
                case 9:
                    System.exit(0);
                    break;

            }
        }
    }

}
