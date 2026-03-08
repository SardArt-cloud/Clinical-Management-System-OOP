/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *Class that represents a medical appointment inside the clínic system
 * Conects the patient with the doctor in a specífic date
 * Manages medical appointments
 * Connection between classes
 *  
 * @author Sara Daza
 */
public class Appointment {
    
    private static int counter = 1;
    
    private String appointmentID;
    
    private Patient patient; //Pacient
    
    private Doctor doctor; //Doctor
    
    private String date; //Appointment date
    
    /**
     * 
     * Constructor of the Appointment class
     * Initialize the dates of the medical appointment
     * 
     *
     * @param patient
     * @param doctor
     * @param date
     * 
    **/
    
    public Appointment(Patient patient, Doctor doctor, String date){
        this.appointmentID = "AAA-" +  counter++;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }
    
    /**
    *
    * @return Returns the info of the appointment as a text String
    * 
    **/
    
    public String getAppointmentInfo(){
        String info = "Cita: " + appointmentID +
               " \nPaciente: " + patient.getName() +
               " \nDoctor: " + doctor.getName() +
               " \nEspecialidad: " + doctor.getSpecialty() +
               " \nFecha: " + date;
        
        if(patient.getAge() < 18 && patient.getGuardian() != null && ! patient.getGuardian().isEmpty()){
            info += "\nAcudiente: " + patient.getGuardian();
        }
        return info;
    }
    
    //Basic Getters
    
    public String getAppointmentID(){
        return appointmentID;
    }
    
    public Patient getPatient(){
        return patient;
    }
    
    public Doctor getDoctor(){
        return doctor;
    }
    
    public String getDate(){
        return date;
    }
}
