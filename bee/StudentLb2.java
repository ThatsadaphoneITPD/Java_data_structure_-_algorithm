package com.bee;

import java.util.*;//import every necessary libary

class Student { //ADT student DLL // will be call other as Link list
    int ID; // there below are Reference Variable //Sll
    String Name;
    int Age;
    String Sex;

    Student(){}//reference
    //create constructor
    Student(int id, String name, int age, String sex ){
        this.ID = id;
        this.Name = name;
        this.Age = age;
        this.Sex = sex;
    }
    //create reference Get and Set
    public int getId() {
        return ID;
    }// get id for ech of all in SL database,
    //if not have this, we must declare getting line of each info

    public void setId(int id) {
        this.ID = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        this.Sex = sex;
    }

}

public class StudentLb2{// LL // link with class Student
    ArrayList<Student> SL = new ArrayList<Student>();
    void Add(){//Add or insert function of SLL
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of students:");
        int N = input.nextInt();
        Student[] students = new Student[N];
        for (int i = 0; i < students.length; i++) {
            int id;
            String name;
            int age;
            String sex;
            Scanner sc = new Scanner(System.in);
            //System.out.println("Please enter the student int id (interger):");
            System.out.println("Please enter the student in oder => int id, name, int age, gender:");
            id = sc.nextInt();
            //System.out.println("Please enter the student name:");
            name = sc.next();
            //System.out.println("Please enter the student age (integer):");
            age = sc.nextInt();
            //System.out.println("Please enter student gender:");
            sex = sc.next();
            SL.add(new Student(id, name, age, sex));// SL append or use add method
        }
    }
    void output(){
        System.out.println("***Student list**");
        System.out.println("ID   Name \t age \t gender");
        for(int i =0; i<SL.size(); i++)
        {
            Student S = SL.get(i);
            System.out.printf("%1s %5s %5s %11s \n", S.ID, S.Name, S.Age, S.Sex);
        }
    }
    void Age20(){
        int i;
        if (SL.size() != 0) {
            System.out.println("Please enter student age!");
            Scanner sc = new Scanner(System.in);
            int age = sc.nextInt();
            for (i = 0; i < SL.size(); i++) {
                if (SL.get(i).getAge() > age) {
                    System.out.println("student age more 20:\n " + SL.get(i).getId() + " is: \n--\n"
                            + "Name:" + SL.get(i).getName() + "\nage is:" + SL.get(i).getAge() + "\ngender is:"
                            + SL.get(i).getSex() + "\n---\n\n");
                }
            }
        }
    }
    void FindId() {//Search ID student function of SLL
        int i;
        if (SL.size() != 0) {// item of SL arr is not empty
            int j = 0;// SL's is 0 or empty
            System.out.println("Please enter student id!");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (i = 0; i < SL.size(); i++) {
                if (SL.get(i).getId() == id) {// if get id return the same input id
                    j++;//increase or pop That SL info's id alone
                    System.out.println("student number: " + SL.get(i).getId() + " is: \n--\n"
                            + "Name: " + SL.get(i).getName() + "\nage is: " + SL.get(i).getAge() + "\ngender is: "
                            + SL.get(i).getSex() + "\n---\n");
                    break;
                }
            }
            if (j == 0) {// SL's Item not see
                System.out.println("This system temporarily has no such id student information!");
            }
        } else {
            System.out.println("This system has no student information temporarily!");
        }
    }

    void delete() {//Delete from ID student function of SLL
        if (SL.size() != 0) {
            System.out.println("Please enter id to Delete");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            for (int i = 0; i < SL.size(); i++) {
                if (SL.get(i).getId() == id) {//if get id return the same input id
                    int oid = SL.get(i).getId();
                    SL.remove(i);// SL use method remove () to delete
                    System.out.println("Student ID: " + oid + " Info is deleted successfully!");
                    break;
                }
            }
        }
    }

    public static void main (String[]args){
        StudentLb2 L = new StudentLb2();
        L.Add();//enter student
        L.output();//print
        System.out.println("");
        //L.Age20();//find age
        L.FindId();//find ID
        L.delete();//delete from ID
        L.output();
    }
}
