package utils;

import models.Cita;
import models.Medico;
import models.Paciente;
import models.dto.CitaDTO;
import models.dto.MedicoDTO;
import models.dto.PacienteDTO;

/**
 * MapperDTO
 *
 * Funcionalidad principal:
 * - Convierte entidades (Cita, Medico, Paciente) a sus correspondientes DTOs.
 * - Convierte DTOs a sus entidades correspondientes.
 * - Facilita el transporte de información entre la capa de datos y la capa de presentación
 *   sin exponer directamente las entidades.
 *
 * Métodos clave:
 * - toDTO(Cita/Medico/Paciente): devuelve un DTO correspondiente a la entidad.
 * - toEntity(CitaDTO/MedicoDTO/PacienteDTO): devuelve la entidad correspondiente a un DTO.
 * 
 * @author Daniel Miramontes Iribe (00000252801)
 */
public class MapperDTO {

    public static CitaDTO toDTO(Cita cita) {
        return new CitaDTO(
                cita.getPaciente().getNombre(),
                cita.getMedico().getNombre(),
                cita.getMedico().getEspecialidad(),
                cita.getMedico().getConsultorio(),
                cita.getFechaHora(),
                cita.getMotivo()
        );
    }

    public static MedicoDTO toDTO(Medico medico) {
        return new MedicoDTO(
                medico.getId(),
                medico.getNombre(),
                medico.getEspecialidad(),
                medico.getConsultorio(),
                medico.getDiasConsulta(),
                medico.getHoraInicio(),
                medico.getHoraFin()
        );
    }

    public static PacienteDTO toDTO(Paciente paciente) {
        return new PacienteDTO(
                paciente.getNumeroSeguridadSocial(),
                paciente.getNombre(),
                paciente.getTelefono(),
                paciente.getDireccion()
        );
    }

    public static Cita toEntity(CitaDTO dto, Paciente paciente, Medico medico) {
        return new Cita(
                paciente, // objeto Paciente
                medico, // objeto Medico
                dto.getFechaHora(),
                dto.getMotivo()
        );
    }

    public static Medico toEntity(MedicoDTO dto) {
        return new Medico(
                dto.getId(),
                dto.getNombre(),
                dto.getEspecialidad(),
                dto.getConsultorio(),
                dto.getDiasConsulta(),
                dto.getHoraInicio(),
                dto.getHoraFin()
        );
    }

    public static Paciente toEntity(PacienteDTO dto) {
        return new Paciente(
                dto.getNumeroSeguridadSocial(),
                dto.getNombre(),
                dto.getTelefono(),
                dto.getDireccion()
        );
    }

}
