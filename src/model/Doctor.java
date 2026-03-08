/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *Class that represents a Doctor inside the system of the clinic
 * Inherits from the abstract Person, comparte los atributos de la clase:
 * name, id, age
 * 
 * The class includes a new attribute: Specialty of the doctor
 * 
 * Implements the abstract method showInfo() defined in Person
 * 
 * @author Sara Daza
 */
public class Doctor extends Person {
   
    //Medical specialty of the doctor
    private String specialty;
    
    /**
     *Constructor of the Doctor class
     * Initilize the inherited attributes from Person and the specialty
     * @param id
     * @param name
     * @param age
     * @param specialty
    **/
    
    public Doctor(String id, String name, int age, String specialty){
        super(id, name, age);
        this.specialty = specialty;
    }
    
    /**
    *
    * @return Returns specialty of the doctor 
    *
    **/
    public String getSpecialty(){
        return specialty;
    }
    
    
    /**
    *
    *Implements the abstract method showInfo defined in Person
    * Polymorphism
    * @return Returns the basic info of the doctor as a text String
    * 
    **/
    @Override
    public String showInfo(){
        return "Doctor: " + name +
                " | Especialidad: " + specialty +
                " | ID: " + id;
    }
}
