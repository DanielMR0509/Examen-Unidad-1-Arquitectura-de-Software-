/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package views;

import controllers.ControlRegistrarCita;
import models.dao.CitaDAO;

/**
 *
 * @author itsyu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControlRegistrarCita control = new ControlRegistrarCita(new CitaDAO());
        VistaConsola vista = new VistaConsola(control);
        vista.iniciar();
    }

}
