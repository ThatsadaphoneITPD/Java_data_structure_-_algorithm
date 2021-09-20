package com.bee;
/* File name : Animal.java */
interface Ani {
    // Any number of final, static fields
    // Any number of abstract method declarations\
    public void eat();// interface method (does not have a body)
    public void travel();// interface method (does not have a body)
}
/*When a class implements an interface, the class as signing a contract
 agreeing to perform the specific behaviors of the interface.
.*/
class Dogoy implements Ani {
    @Override
    public void eat() { System.out.println("Dogs: \n it eat Luxury meal");}
    @Override
    public void travel() { System.out.println("Dogs: travels for his ture lover"); }
    public void noOfLegs() { }
}
public class InterfaceAni {
    public static void main(String[] args) {
        Dogoy Ani = new Dogoy();
        Ani.eat();
        Ani.travel();
        Ani.noOfLegs();
    }
}
