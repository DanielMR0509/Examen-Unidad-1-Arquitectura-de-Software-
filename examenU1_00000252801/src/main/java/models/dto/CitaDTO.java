package models.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Data Transfer Object (DTO) para la entidad Cita.
 *
 * Funcionalidad principal:
 * - Transporta información de una cita entre capas sin exponer la entidad completa.
 * - Contiene datos clave de la cita: paciente, médico, especialidad, consultorio, fecha/hora y motivo.
 *
 * Uso:
 *  - Mostrar citas en la interfaz de usuario.
 *  - Notificar la creación de nuevas citas a observadores.
 *  - Evitar manipular directamente la entidad Cita en vistas o controladores externos.
 * 
 * @author Daniel Miramontes Iribe (00000252801)
 */
public class CitaDTO {

    private String nombrePaciente;
    private String nombreMedico;
    private String especialidad;
    private String consultorio;
    private LocalDateTime fechaHora;
    private String motivo;

    public CitaDTO(String nombrePaciente, String nombreMedico, String especialidad,
            String consultorio, LocalDateTime fechaHora, String motivo) {
        this.nombrePaciente = nombrePaciente;
        this.nombreMedico = nombreMedico;
        this.especialidad = especialidad;
        this.consultorio = consultorio;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
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

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Retorna información completa de la cita en formato legible.
     */
    public String mostrarInfo() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Paciente: " + nombrePaciente
                + " | Medico: " + nombreMedico
                + " (" + especialidad + ")"
                + " | Consultorio: " + consultorio
                + " | Fecha/Hora: " + fechaHora.format(fmt)
                + " | Motivo: " + motivo;
    }
}
