package controllers;

import exceptions.CitaExistenteException;
import exceptions.MedicoNoDisponibleException;
import exceptions.PacienteNoRegistradoException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import models.Cita;
import models.IObserver;
import models.ISubject;
import models.Medico;
import models.Paciente;
import models.dao.CitaDAO;
import models.dao.MedicoDAO;
import models.dao.PacienteDAO;
import models.dto.CitaDTO;
import models.dto.MedicoDTO;
import models.dto.PacienteDTO;
import utils.MapperDTO;

/**
 * ControlRegistrarCita
 *
 * Funcionalidad principal:
 * - Gestiona el registro de citas médicas.
 * - Valida disponibilidad de médicos y evita citas duplicadas.
 * - Convierte entidades a DTOs y notifica observadores de cambios.
 *
 * Patrón Observer:
 * - Permite notificar cambios a la vista o cualquier observer registrado.
 * - Métodos: agregarObservador, eliminarObservador, notificarObservadores.
 *
 * @author Daniel Miramontes Iribe (00000252801)
 */
public class ControlRegistrarCita implements ISubject {

    private List<IObserver> observadores = new ArrayList<>();

    private CitaDAO citaDAO;

    public ControlRegistrarCita(CitaDAO citaDAO) {
        this.citaDAO = citaDAO;
    }

    /**
     * Registra una cita si el médico está disponible y no tiene otra cita en el
     * mismo horario.
     *
     * @param pacienteDTO Paciente que solicita la cita
     * @param medicoDTO Médico a consultar
     * @param fechaHora Fecha y hora deseada
     * @param motivo Motivo de la cita
     * @return CitaDTO si se registró, null si hubo algún conflicto
     * @throws MedicoNoDisponibleException
     * @throws CitaExistenteException
     */
    public CitaDTO registrarCita(PacienteDTO pacienteDTO, MedicoDTO medicoDTO, LocalDateTime fechaHora, String motivo)
            throws MedicoNoDisponibleException, CitaExistenteException {

        // Validar disponibilidad general del médico
        Medico medico = MapperDTO.toEntity(medicoDTO);
        MedicoDAO.verificarDisponibilidad(medico, fechaHora);

        // Validar si ya existe otra cita para el mismo médico en ese horario
        citaDAO.verificarCitaExistente(medico, fechaHora);

        // Crear y guardar la cita
        Paciente paciente = MapperDTO.toEntity(pacienteDTO);
        Cita nuevaCita = new Cita(paciente, medico, fechaHora, motivo);
        citaDAO.crearCita(nuevaCita);

        // Convertir a DTO y notificar observers
        CitaDTO citaDTO = MapperDTO.toDTO(nuevaCita);
        notificarObservadores(citaDTO);

        return citaDTO;
    }

    /**
     * Obtiene todas las citas registradas como DTOs.
     *
     * @return
     */
    public List<CitaDTO> obtenerCitasDTO() {
        return citaDAO.obtenerTodas().stream()
                .map(MapperDTO::toDTO)
                .toList();
    }

    public List<CitaDTO> obtenerCitasPorPaciente(PacienteDTO pacienteDTO) {
        return citaDAO.obtenerCitasPorPaciente(pacienteDTO.getNumeroSeguridadSocial()).stream()
                .map(MapperDTO::toDTO)
                .toList();
    }

    /**
     * Lista todos los médicos disponibles
     *
     * @return
     */
    public List<MedicoDTO> obtenerMedicosDTO() {
        return MedicoDAO.obtenerMedicos().stream()
                .map(MapperDTO::toDTO)
                .toList();
    }

    /**
     * Busca un paciente por número de seguridad social
     *
     * @param numeroSS
     * @return
     * @throws exceptions.PacienteNoRegistradoException
     */
    public PacienteDTO buscarPacienteDTO(int numeroSS) throws PacienteNoRegistradoException {
        Paciente paciente = PacienteDAO.buscarPorNumeroSeguridadSocial(numeroSS);
        return MapperDTO.toDTO(paciente);
    }

    /**
     * Busca un médico por ID
     *
     * @param id
     * @return
     */
    public MedicoDTO buscarMedicoDTO(int id) {
        Medico medico = MedicoDAO.buscarPorId(id);
        return MapperDTO.toDTO(medico);
    }

    @Override
    public void agregarObservador(IObserver o) {
        observadores.add(o);
    }

    @Override
    public void eliminarObservador(IObserver o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores(CitaDTO citaDTO) {
        for (IObserver o : observadores) {
            o.notificar(citaDTO);
        }
    }

}
