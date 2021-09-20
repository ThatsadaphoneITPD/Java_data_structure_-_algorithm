package com.bee;

// the Dog class
// Implementing the dog class
class Dog {//parent dog class will be inherited to Dogs
    // Few properties which
    // define the bird
    String color;
    int legs;

    // Implementing the getters and
    // setters for the color and legs.
    /*
    * encapsulation in Java −
    Declare the variables of a class as private.
    Provide public setter and getter methods to modify and view the variables values */

    public void setColor(String color) { this.color = color; }

    public String getColor() { return this.color; }

    public void setLegs(int legs) { this.legs = legs; }

    public int getLegs() { return this.legs; }

    // Few operations which the dog performs
    public void eat() {
        System.out.println(
                "Parent:\nThis Dog has eaten");
    }
    public void Kill() {
        System.out.println(
                "This Dog is so Bad-boy, he kill robber");
    }
}
// Creating the Husky class which
// extends the Dog class
class Husky extends Dog{//override by extend Dog class to Dogs
    // Overriding the fly method
    // which makes this Dogs fly
    @Override
    public void Kill() {
        System.out.println(
                "Child: \nEh...Eh..Eh. it's Killed!! MTF");
        Dog D = new Dog();
        D.setColor("Black & white");
        D.setLegs(4);

        //System.out.print("Color : " + D.getColor() + " Leg : " + D.getLegs());
    }
}
public class Dogs {
    public static void main(String[] args)
    {
        // If a Parent type reference refers
        // to a Parent object, then Parent's eat or Kill show is called
        Dog obj1 = new Dog();
        obj1.eat();
        obj1.Kill();
        System.out.println("---Call child method---");
        // If a Parent type reference refers to a Child object Child's Kill() is called.
        // This is called RUN TIME
        // POLYMORPHISM.
        Husky obj2 = new Husky();
        obj2.Kill();
        //obj2.setColor("Black & white");
        //obj2.setLegs(4);
        //System.out.print("Color : " + obj2.getColor() + " Leg : " + obj2.getLegs());
    }

}
