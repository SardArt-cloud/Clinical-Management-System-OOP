/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clinicmanagement;


import service.ClinicManager;
import model.Patient;
import model.Doctor;
import model.Appointment;

import java.util.Scanner;



/**
 *Principal class of the system.
 * User interactions through the console menu
 * 
 * 
 * @author Sara Daza
 */
public class ClinicManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        ClinicManager manager = ClinicManager.getInstance();
        
        int option;
        //System menu
        do{
            System.out.println("\n========== SISTEMA DE GESTION CLINICA ==========");
            
            System.out.println("Menu");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Registrar doctor");
            System.out.println("3. Agendar cita");
            System.out.println("4. Ver citas");
            System.out.println("5. Salir");
            
            //Allows the user to select an option from the menu
            System.out.println("Seleccione una opcion: ");
            
            option = scanner.nextInt();
            scanner.nextLine();
            
            try{
                
                switch(option){
                    
                    case 1: 
                        System.out.println("ID del paciente: ");
                        String pId = scanner.nextLine();
                        //Ensures the same ID does not exist twice
                        if(manager.findPatientID(pId) != null){
                            System.out.println("Error. ya existe este ID");
                        } else{
                            System.out.println("Nombre del paciente: ");
                            String pName = scanner.nextLine();
                        
                            System.out.println("Edad: ");
                            int pAge = scanner.nextInt();
                            scanner.nextLine();
                            
                            //New variable: pGuardian, default value: N/A
                            String pGuardian = "N/A";
                            //If the patient is a minor, they must have a guardian for the appointment
                            if(pAge < 18){
                                System.out.println("Menor de edad. Digite el nombre del acudiente: ");
                                pGuardian = scanner.nextLine();
                            } 
                            //The registered patient is stored in these data
                            Patient patient = new Patient(pId, pName, pAge, pGuardian);
                            //Saves the patient in the ArrayList<>
                            manager.addPatient(patient);
                        
                            System.out.println("Paciente registrado correctamente.");
                        }
                                                
                        break;
                        
                    case 2:
                        System.out.println("ID del medico");
                        String dId = scanner.nextLine();
                        //Ensures the same ID does not exist twice
                        if(manager.findDoctorID(dId) != null){
                            System.out.println("Error, ya existe este ID");
                        } else{
                            System.out.println("Nombre del medico");
                            String dName = scanner.nextLine();
                        
                            System.out.println("Edad: ");
                            int dAge = scanner.nextInt();
                            scanner.nextLine();
                        
                            //List of specialies
                            String[] dSpecialties = {
                                "Medicina General",
                                "Odontologia",
                                "Dermatologia",
                                "Pediatria",
                                "Oftalmologia",
                                "Laboratorio",
                                "Radiologia",
                                "Cardiologia",
                                "Neurologia",
                                "Psicologia",
                                "Psiquiatria",
                                "Ortopedia y Traumatologia",
                                "Nutricion",
                                "Ginecologia",
                                "Medicina Familiar"
                            };
                            System.out.println("Seleccione la especialidad: ");
                            
                            for(int i = 0; i < dSpecialties.length; i++){
                                System.out.println((i + 1) + "- " + dSpecialties[i]);
                           
                            } 
                            int opt = scanner.nextInt();
                            scanner.nextLine();
                           
                            if(opt < 1 || opt > dSpecialties.length){
                                System.out.println("Especialidad invalida");
                                break;
                            }
                            //Prevents misaligments between the user's option and the array index
                            String dSpecialty = dSpecialties[opt - 1];
                            
                            Doctor doctor = new Doctor(dId, dName, dAge, dSpecialty);
                        
                            manager.addDoctor(doctor);
                        
                            System.out.println("Medico registrado correctamente");
                        }
                                                
                        break;
                        
                    case 3:
                        //If no patients or doctors are registered, an appointment cannot be scheduled
                        if(manager.getPatients().isEmpty() || manager.getDoctors().isEmpty()){
                            System.out.println("Debe registrar pacientes y medicos primero.");
                            break;
                        }
                        
                        
                        System.out.println("Seleccione el paciente: ");
                        //Returns the list of registered patients
                        for(int i = 0; i < manager.getPatients().size(); i++){
                            
                            System.out.println(i + " - " + manager.getPatients().get(i).showInfo());
                        }
                        
                        //Stores the option chosen by the user in the variable pIndex
                        int pIndex = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.println("Seleccione el medico: ");
                        for(int i = 0; i < manager.getDoctors().size(); i++){
                            
                            System.out.println(i + " - " + manager.getDoctors().get(i).showInfo());
                        }
                        
                        int dIndex = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.println("Fecha de la cita (DIA/MES/AÑO): ");
                        String date = scanner.nextLine();
                        
                        //Creates the appointment with the respective patient and doctor on the entered date
                        Appointment appointment = new Appointment(manager.getPatients().get(pIndex),
                        manager.getDoctors().get(dIndex), date);
                        
                        manager.addAppointment(appointment);
                        
                        System.out.println("Cita agendada correctamente.");
                        break;
                        
                    case 4: 
                        //Checks that the list is not empty
                        if(manager.getAppointments().isEmpty()){
                            System.out.println("No hay citas registradas.");
                        } else {
                            //Returns the appointments that have been registered
                            for(Appointment a : manager.getAppointments()){
                                
                                //Returns all the information of the appointment
                                System.out.println("\n" + a.getAppointmentInfo());
                            }
                        }
                        break;
                    
                    case 5:
                        //Exit the system
                        System.out.println("Saliendo del sistema...");
                        break;
                    
                    default:
                        System.out.println("Opcion invalida.");
                }
                //Captures any error in data input
            } catch(Exception e){
                System.out.println("Error en la entrada de datos.");
                scanner.nextLine();
            }
            
        } while(option != 5);
        
        scanner.close();
   }
}
