/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author itsyu
 */
public class CitaExistenteException extends Exception {

    public CitaExistenteException() {
    }

    public CitaExistenteException(String message) {
        super(message);
    }

    public CitaExistenteException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
