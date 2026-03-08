/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import service.ClinicManager;
import model.Appointment;
import model.Doctor;
import model.Patient;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *Class responsable for handling data persistence in the system
 * Implements the Persistible interface
 * Defines the methods to save and load system info
 * 
 * @author Sara Daza
 */
public class FilePersistence implements Persistible {
    
    private ClinicManager manager;
    
    /**
     * Constructor of the class
     * Obtains the single instance of ClinicManager
     * 
     */
    
    public FilePersistence(){
        manager = ClinicManager.getInstance();
    }
    
    
    /**
     * Saves the system data into text files
     * 
     */
    
    @Override
    public void saveData() throws IOException{
        try {
            //Save patients
            FileWriter patientWriter = new FileWriter("Patients.txt");
            
            for(Patient p : manager.getPatients()){
                patientWriter.write(p.getId() + "," + p.getName() + "," + p.getAge() + "\n");
            }
            
            patientWriter.close();
            
            //Save doctors
            FileWriter doctorWriter = new FileWriter("Doctors.txt");
            
            for(Doctor d: manager.getDoctors()){
                doctorWriter.write(d.getId() + "," + d.getName() + "," + d.getAge() + "," + 
                        d.getSpecialty() + "\n");
            }
            
            doctorWriter.close();
        } catch(IOException e){
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }
    
    /**
     * Loads the system data from the file
     */
    @Override
    public void loadData() throws IOException{
        try {
            BufferedReader patientReader = new BufferedReader(new FileReader("patients.txt"));
            String line;
            
            while ((line = patientReader.readLine()) != null){
                String[] data = line.split(",");
                
                Patient patient = new Patient(data[0], data[1], Integer.parseInt(data[2]), data[3]);
                
                manager.addPatient(patient);
            }
            
            patientReader.close();
        } catch (IOException e){
            System.out.println("No se encontraron archivos de pacientes aún.");
        }
    }
}
