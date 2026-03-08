/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *Patient class, represents a patient inside the clinic system
 * Inherits from the abstract method showInfo() from Person
 * (id, name, age)
 * Implements the abstract method showInfo() from Person
 * 
 * @author Sara Daza
 *
 */
public class Patient extends Person{
    
    
    private String guardian;
    
    /**
    *Constructor of the Patient class
    *Initializes the inherited attributes: name, age, id
    * @param  id
    * @param name
    * @param age
    * @param guardian
    **/
    public Patient(String id, String name, int age, String guardian){
        
        //Calls the Person constructor
        super(id, name, age);
        this.guardian = guardian;
    }
    
    public String getGuardian(){
        return guardian;
    }
    
    public void setGuardian(String guardian){
        this.guardian = guardian;
    }

       
    /**
    *Implements the abstract method showInfo definied in Person
    *@return Returns the basic info of the patient as a text String
    *Polymorphism
    **/
    @Override
    public String showInfo(){
        return "Paciente: " + name +
                " | Edad: " + age +
                " | Acudiente: " + guardian +
                " | ID: " + id;
    }
}
