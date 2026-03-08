/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**Base class, use for Patient and Doctor
  * Contains common atributes shared by all people in the clinic
  * 
  * @author Sara Daza
  */
public abstract class Person {
    //id: unique identifier within the system
    protected String id;
    
    //Name of the person
    protected String name;
    
    //Age of the person
    protected int age;
    
    
    /*
    *Contructor of Person class
    *Initializes the atributes
    */
    public Person(String id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    /*
    *Retrives the attributes of the person
    */
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    
    /*
    *Abstract method, implemented by child classes
    *Displays the specific info of each type of person
    */
    
    public abstract String showInfo();
}
