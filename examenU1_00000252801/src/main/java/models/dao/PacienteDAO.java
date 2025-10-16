package models.dao;

import exceptions.PacienteNoRegistradoException;
import java.util.ArrayList;
import java.util.List;
import models.Paciente;

/**
 * Simula el acceso a datos de pacientes (DAO).
 * 
 * @author Daniel Miramontes Iribe (00000252801)
 */
public class PacienteDAO {

    // Lista estática que simula la base de datos de pacientes
    private static final List<Paciente> PACIENTES = new ArrayList<>();

    // Bloque estático: carga inicial de pacientes de prueba
    static {
        PACIENTES.add(new Paciente(101, "Daniel Miribe", "6441234567", "Navojoa, Sonora"));
        PACIENTES.add(new Paciente(102, "Leo Lopez", "6447654321", "Cd. Obregon, Sonora"));
    }

    /**
     * Devuelve la lista completa de pacientes registrados.
     * @return Lista de objetos Paciente
     */
    public static List<Paciente> obtenerPacientes() {
        return PACIENTES;
    }

    /**
     * Busca un paciente por su número de seguridad social.
     * 
     * @param numeroSeguridadSocial número NSS del paciente
     * @return Paciente encontrado
     * @throws PacienteNoRegistradoException si no existe un paciente con ese NSS
     */
    public static Paciente buscarPorNumeroSeguridadSocial(int numeroSeguridadSocial)
            throws PacienteNoRegistradoException {
        return PACIENTES.stream()
                .filter(p -> p.getNumeroSeguridadSocial() == numeroSeguridadSocial)
                .findFirst()
                .orElseThrow(() -> new PacienteNoRegistradoException(
                        "Paciente con NSS " + numeroSeguridadSocial + " no esta registrado."));
    }
}
