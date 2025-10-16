package models.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

/**
 * Data Transfer Object (DTO) para la entidad Medico.
 * 
 * Funcionalidad principal:
 * - Permite transportar información del médico entre capas (modelo, controlador, vista)
 *   sin exponer la entidad completa.
 * - Contiene información básica como nombre, especialidad, consultorio y horarios.
 * - Incluye los días de consulta y el horario de atención (horaInicio - horaFin).
 * 
 * Uso:
 *  - Mostrar datos del médico en la interfaz.
 *  - Selección de médico al registrar una cita.
 *  - Evitar manipular directamente la entidad Medico en capas externas.
 * 
 * @author Daniel Miramontes Iribe (00000252801)
 */
public class MedicoDTO {

    private int id;
    private String nombre;
    private String especialidad;
    private String consultorio;
    private Set<DayOfWeek> diasConsulta;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public MedicoDTO() {
    }

    public MedicoDTO(int id, String nombre, String especialidad, String consultorio,
            Set<DayOfWeek> diasConsulta, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.consultorio = consultorio;
        this.diasConsulta = diasConsulta;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public Set<DayOfWeek> getDiasConsulta() {
        return diasConsulta;
    }

    public void setDiasConsulta(Set<DayOfWeek> diasConsulta) {
        this.diasConsulta = diasConsulta;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        // Representación simple para mostrar en listas o selección
        return nombre + " - " + especialidad;
    }
}
