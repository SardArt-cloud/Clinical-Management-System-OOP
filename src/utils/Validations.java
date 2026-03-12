/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;

/**
 * Class responsable for validating date entered by the user
 * Verifies names, IDs, ages and dates
 * Prevents errors in the system
 * 
 * @author Sara Daza
 */
public class Validations {
   //Name validation, must contains letters later
    public static boolean validName(String name){
        return name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }
    
    //ID validation, must contains numbers only
    public static boolean validId(String id){
        return id.matches("\\d+");
    }
    
    //Age validation, checks a logical age range
    public static boolean validAge(int age){
        return age >= 0 && age <= 105;
    }
    
    //Age validation, verifies correct format and a valid calendar date
    public static boolean validDate(String date){
        try{
            DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate.parse(date, form);
            return true;
        } catch(DateTimeException e){
            return false;
        }
    }
}
