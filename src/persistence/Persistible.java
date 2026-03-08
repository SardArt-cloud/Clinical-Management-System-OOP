/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistence;

//Exception handling
import java.io.IOException;

/**
 *Interface that defines basic operations for data persistence in the system
 * 
 * Classes that implement this interface will provide functionality to save and load info
 * Data will be stored in some type of storage
 * 
 * Ensures that data will not be lost
 * @author Sara Daza
 */
public interface Persistible {
    
    /**
     * Method that saves the system info
     * 
     * @throws IOException, in case that an error occurs
     */
    
    void saveData() throws IOException;
    
    /**
     * Methos that load the system info
     * 
     * @throws IOException, in case an error occurs
     * 
     */
    
    void loadData() throws IOException;
    
}
