package models.dao;

import exceptions.MedicoNoDisponibleException;
import exceptions.SinMedicosException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import models.Medico;

/**
 * Simula el acceso a datos de los médicos (DAO).
 * 
 * @author Daniel Miramontes Iribe (00000252801)
 */
public class MedicoDAO {

    // Lista estática que simula la base de datos de médicos
    private static final List<Medico> MEDICOS = new ArrayList<>();

    // Bloque estático: carga inicial de médicos con sus horarios y especialidades
    static {
        MEDICOS.add(new Medico(
                1, "Leonardo Garcia", "Cardiologia", "3",
                EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY),
                LocalTime.of(9, 0), LocalTime.of(14, 0)
        ));
        MEDICOS.add(new Medico(
                2, "Jonathan Iribe Acosta", "Dermatologia", "1",
                EnumSet.of(DayOfWeek.TUESDAY, DayOfWeek.THURSDAY),
                LocalTime.of(10, 0), LocalTime.of(16, 0)
        ));
    }

    /**
     * Devuelve la lista completa de médicos registrados.
     * @return Lista de objetos Medico
     * @throws SinMedicosException si no hay medicos registrados
     */
    public static List<Medico> obtenerMedicos() throws SinMedicosException {
        if(MEDICOS.isEmpty()) {
            throw new SinMedicosException("No hay medicos disponibles.");
        }
        return MEDICOS;
    }

    /**
     * Busca un médico por su ID.
     * 
     * @param id identificador único del médico
     * @return el objeto Medico si existe, o null si no se encuentra
     */
    public static Medico buscarPorId(int id) {
        return MEDICOS.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Verifica si un médico está disponible en una fecha y hora específicas.
     * 
     * @param medico médico a verificar
     * @param fechaHora fecha y hora deseadas
     * @throws MedicoNoDisponibleException si el médico no atiende ese día o fuera de horario
     */
    public static void verificarDisponibilidad(Medico medico, LocalDateTime fechaHora)
            throws MedicoNoDisponibleException {

        DayOfWeek dia = fechaHora.getDayOfWeek();
        LocalTime hora = fechaHora.toLocalTime();

        if (!medico.getDiasConsulta().contains(dia)) {
            throw new MedicoNoDisponibleException(
                    "El medico " + medico.getNombre() + " no atiende los " + dia + ".");
        }

        if (hora.isBefore(medico.getHoraInicio()) || hora.isAfter(medico.getHoraFin())) {
            throw new MedicoNoDisponibleException(
                    "El medico " + medico.getNombre() + " no atiende a las " + hora + ".");
        }
    }
}
