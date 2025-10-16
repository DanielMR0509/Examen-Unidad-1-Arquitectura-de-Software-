/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author itsyu
 */
public class MedicoInexistenteException extends Exception {

    public MedicoInexistenteException() {
    }

    public MedicoInexistenteException(String message) {
        super(message);
    }

    public MedicoInexistenteException(String message, Throwable cause) {
        super(message, cause);
    }

}
