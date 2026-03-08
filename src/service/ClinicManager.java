/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Patient;
import model.Doctor;
import model.Appointment;

import java.util.ArrayList;

/**
 *Class responsible for managing the main operations of the clínical system
 * Manages collections: Patients, doctors and apointments
 * Singleton: a single instance
 * 
 * 
 * @author Sara Daza
 */
public class ClinicManager {
    

    //Unique Instance (The Singleton pattern is applied)
    private static ClinicManager instance;
    
    
    //Collections that stored the system data
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;
    private ArrayList<Appointment> appointments;
    
    
    /**
     * Singleton Pattern
     * Private constructor, prevents direct objet creation
     */
    
    private ClinicManager(){
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
    }
    
    /**
     * @return Returns the unique instance ClinicManager
     */
    
    public static ClinicManager getInstance() {
        if(instance == null){
            instance = new ClinicManager();
        }
        return instance;
    }
    
    /**
     * Add a patient to the system
     * @param patient Registers the pacient in the system
     */
    
    public void addPatient(Patient patient) {
        patients.add(patient);
    }
    
    /**
     * Searches for a pacient by their ID
     * @param id
     * @return the patient if exists, null if not found
     */
    public Patient findPatientID(String id){
        for(Patient patient : patients){
            if(patient.getId().equals(id)){
                return patient;
            }
        }
        return null;
    }
    
    /**
     * Add the doctor in the system
     * @param doctor, registers the doctor in the system
     */
    
    public void addDoctor(Doctor doctor){
        doctors.add(doctor);
    }
    
    /**
     * Searches for a doctor by their ID
     * @param id
     * @return the doctor if it exists, null if not found
     * 
     */
    public Doctor findDoctorID(String id){
        for(Doctor doctor : doctors){
            if(doctor.getId().equals(id)){
                return doctor;
            }
        }
        return null;
    }
    
    /**
     * Adds a new medical appointment
     * @param appointment Appointmemt to be registered
     * 
     */
    
    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
    }
    
    /**
     * @return the list of patients
     */
    
    public ArrayList<Patient> getPatients(){
        return patients;
    }
    
    /**
     * @return Returns the list of registered doctors
     */
    
    public ArrayList<Doctor> getDoctors(){
        return doctors;
    }
    
    /**
     * @return Returns the list of registered appointments
     */
    
    public ArrayList<Appointment> getAppointments(){
        return appointments;
    }
}
