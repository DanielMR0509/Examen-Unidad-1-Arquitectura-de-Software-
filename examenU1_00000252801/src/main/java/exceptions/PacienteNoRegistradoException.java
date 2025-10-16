/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author itsyu
 */
public class PacienteNoRegistradoException extends Exception {

    public PacienteNoRegistradoException() {
    }
    
    public PacienteNoRegistradoException(String message) {
        super(message);
    }

    public PacienteNoRegistradoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
