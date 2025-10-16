package models.dao;

import exceptions.CitaExistenteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import models.Cita;
import models.Medico;

/**
 * Simula el acceso a datos de las citas médicas (DAO).
 * 
 * @author Daniel Miramontes Iribe (00000252801)
 */
public class CitaDAO {

    // Lista que simula la base de datos de citas
    private List<Cita> citas;

    // Constructor: inicializa la lista vacía
    public CitaDAO() {
        this.citas = new ArrayList<>();
    }

    /**
     * Agrega una nueva cita a la lista.
     * @param cita objeto Cita a registrar
     */
    public void crearCita(Cita cita) {
        citas.add(cita);
    }

    /**
     * Obtiene todas las citas registradas.
     * @return Lista completa de objetos Cita
     */
    public List<Cita> obtenerTodas() {
        return citas;
    }

    /**
     * Obtiene las citas asociadas a un paciente específico.
     * 
     * @param numeroSeguridadSocial número de seguridad social del paciente
     * @return Lista de citas del paciente
     */
    public List<Cita> obtenerCitasPorPaciente(int numeroSeguridadSocial) {
        List<Cita> resultado = new ArrayList<>();
        for (Cita c : citas) {
            if (c.getPaciente().getNumeroSeguridadSocial() == numeroSeguridadSocial) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    /**
     * Obtiene las citas asociadas a un médico específico.
     * 
     * @param idMedico ID del médico
     * @return Lista de citas del médico
     */
    public List<Cita> obtenerPorMedico(int idMedico) {
        List<Cita> resultado = new ArrayList<>();
        for (Cita c : citas) {
            if (c.getMedico().getId() == idMedico) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    /**
     * Verifica si ya existe una cita para el mismo médico en la misma fecha y hora.
     * 
     * @param medico médico a consultar
     * @param fechaHora fecha y hora de la cita
     * @throws CitaExistenteException si ya existe una cita para ese médico en ese horario
     */
    public void verificarCitaExistente(Medico medico, LocalDateTime fechaHora) throws CitaExistenteException {
        for (Cita c : citas) {
            if (c.getMedico().getId() == medico.getId() && c.getFechaHora().equals(fechaHora)) {
                throw new CitaExistenteException(
                        "Ya existe una cita para el medico " + medico.getNombre() + " a las " + fechaHora);
            }
        }
    }
}
