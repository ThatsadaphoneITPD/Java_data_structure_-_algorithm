package com.bee;

class Persons {//reference
    int id;
    String name;

    public Persons(int id, String name) { //create constructor
        this.id = id;
        this.name = name;
    }
}

public class Person {//method generate person
    private static Persons buildPerson(int id, String name) {
        return new Persons(id, name);
    }

    public static void main(String[] args) {
        int id = 21;
        String name = "Bee";
        Persons persons = null;
        persons = buildPerson(id, name);
        //create printing line for each person
        // to return input info from constructor or data base
        System.out.println("Person: \n"+ "ID: " + persons.id + "\nName: " + persons.name );
    }
}
